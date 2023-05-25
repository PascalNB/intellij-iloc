package org.intellij.sdk.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.psi.IlocFile;
import org.intellij.sdk.language.psi.IlocNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class IlocReference extends PsiReferenceBase<IlocNamedElement> implements PsiPolyVariantReference {

    private final String key;

    public IlocReference(@NotNull IlocNamedElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
        key = element.getText().substring(rangeInElement.getStartOffset(), rangeInElement.getEndOffset());
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        List<ResolveResult> results = new ArrayList<>();

        IlocFile file;
        if (getElement().getContainingFile() instanceof IlocFile f) {
            file = f;
        } else {
            return results.toArray(new ResolveResult[0]);
        }

        final List<? extends IlocNamedElement> found =
            IlocUtil.find(file, getElement().getType(), IlocNamedElement::getName, key);

        for (IlocNamedElement element : found) {
            results.add(new PsiElementResolveResult(element));
        }

        return results.toArray(new ResolveResult[0]);
    }

    @Override
    public @Nullable PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        List<LookupElement> variants = new ArrayList<>();

        IlocFile file;
        if (getElement().getContainingFile() instanceof IlocFile f) {
            file = f;
        } else {
            return variants.toArray();
        }

        List<? extends IlocNamedElement> elements = IlocUtil.find(file, getElement().getType());

        for (final IlocNamedElement element : elements) {
            if (element.getText() != null && element.getText().length() > 0) {
                variants.add(LookupElementBuilder.create(element)
                    .withIcon(IlocIcons.FILE)
                    .withTypeText(element.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }

    @Override
    public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
        return getElement().setName(newElementName);
    }

}
