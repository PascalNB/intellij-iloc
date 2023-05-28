package com.pascalnb.iloc.language.reference;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import com.pascalnb.iloc.language.IlocIcons;
import com.pascalnb.iloc.language.functions.IlocDefaultFunctions;
import com.pascalnb.iloc.language.psi.IlocFunction;
import com.pascalnb.iloc.language.psi.IlocTypes;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

import static com.intellij.patterns.PlatformPatterns.psiElement;

public class IlocCompletionContributor extends CompletionContributor {

    private static final Collection<? extends LookupElement> FUNCTION_ELEMENTS;

    static {
        FUNCTION_ELEMENTS = IlocDefaultFunctions.all().stream()
            .map(f -> LookupElementBuilder.create(f.getName())
                .withTypeText(f.getSignature())
                .withIcon(IlocIcons.FUNCTION)
            )
            .toList();
    }

    public IlocCompletionContributor() {
        extend(CompletionType.BASIC, psiElement(IlocTypes.ID), new IlocCompletionProvider());
    }

    private static class IlocCompletionProvider extends CompletionProvider<CompletionParameters> {

        @Override
        protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context,
            @NotNull CompletionResultSet result) {

            PsiElement element = parameters.getPosition();
            PsiElement parent = element.getParent();

            if (parent instanceof IlocFunction function && function.getId() == element) {
                result.addAllElements(FUNCTION_ELEMENTS);
            }
        }

    }

}
