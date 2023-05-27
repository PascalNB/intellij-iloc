package org.intellij.sdk.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.intellij.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.*;

public class IlocReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String key;

    public IlocReference(@NotNull PsiElement element, TextRange rangeInElement, String key) {
        super(element, rangeInElement);
        this.key = key;
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        IlocFile file;
        if (getElement().getContainingFile() instanceof IlocFile f) {
            file = f;
        } else {
            return ResolveResult.EMPTY_ARRAY;
        }

        List<PsiElement> found;

        if (getElement() instanceof IlocLabelRef) {
            found = IlocUtil.find(file, IlocLabel.class, i -> ((IlocLabel) i).getName(), key);
        } else if (getElement() instanceof IlocRegisterRef) {
            found = IlocUtil.find(file, IlocRegister.class, i -> ((IlocRegister) i).getName(), key);
        } else if (getElement() instanceof IlocRegister) {
            found = IlocUtil.find(file, IlocRegister.class, i -> ((IlocRegister) i).getName(), key);
        } else if (getElement() instanceof IlocVariableRef) {
            found = IlocUtil.find(file, IlocVariable.class, i -> ((IlocVariable) i).getName(), key);
        } else {
            return ResolveResult.EMPTY_ARRAY;
        }

        if (found.isEmpty()) {
            return ResolveResult.EMPTY_ARRAY;
        }

        List<ResolveResult> result = new ArrayList<>();

        for (PsiElement element : found) {
            result.add(new PsiElementResolveResult(element));
        }

        return result.toArray(new ResolveResult[0]);
    }

    @Override
    public @Nullable PsiElement resolve() {
        ResolveResult[] result = multiResolve(false);
        if (result.length == 0) {
            return null;
        }
        return result[0].getElement();
    }

    @Override
    public Object @NotNull [] getVariants() {
        IlocFile file;
        if (getElement().getContainingFile() instanceof IlocFile f) {
            file = f;
        } else {
            return new Object[0];
        }

        Collection<PsiElement> found;
        Icon icon;

        if (getElement() instanceof IlocLabelRef) {
            icon = IlocIcons.LABEL;

            Map<String, LookupElement> result = new HashMap<>();

            for (PsiElement element : IlocUtil.find(file, IlocLabel.class)) {
                String text = ((IlocLabel) element).getName();
                LookupElement lookupElement = LookupElementBuilder.create(text).withIcon(icon);
                result.put(text, lookupElement);
            }

            return result.values().toArray();

        } else if (getElement() instanceof IlocVariableRef) {
            icon = IlocIcons.VARIABLE;

            Map<String, LookupElement> result = new HashMap<>();

            for (PsiElement element : IlocUtil.find(file, IlocVariable.class)) {
                String text = element.getText();
                LookupElement lookupElement = LookupElementBuilder.create(text).withIcon(icon);
                result.put(text, lookupElement);
            }

            for (PsiElement element : IlocUtil.find(file, IlocVariableRef.class)) {
                String text = ((IlocVariableRef) element).getId().getText();
                LookupElement lookupElement = LookupElementBuilder.create(text).withIcon(icon);
                result.put(text, lookupElement);
            }

            return result.values().toArray();

        } else if (getElement() instanceof IlocRegisterRef) {
            found = IlocUtil.find(file, IlocRegister.class);
            icon = IlocIcons.REGISTER;

        } else if (getElement() instanceof IlocRegister) {
            found = IlocUtil.find(file, IlocRegister.class);
            icon = IlocIcons.REGISTER;

        } else {
            return new Object[0];
        }

        if (found.isEmpty()) {
            return new Object[0];
        }

        Map<String, LookupElement> result = new HashMap<>();

        for (PsiElement element : found) {
            String text = element.getText();
            LookupElement lookupElement = LookupElementBuilder.create(text).withIcon(icon);
            result.put(text, lookupElement);
        }

        return result.values().toArray();
    }

}
