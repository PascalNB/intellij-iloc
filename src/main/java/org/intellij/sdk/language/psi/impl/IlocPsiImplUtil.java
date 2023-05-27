package org.intellij.sdk.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.intellij.sdk.language.psi.*;
import org.intellij.sdk.language.reference.IlocReference;
import org.jetbrains.annotations.NotNull;

public class IlocPsiImplUtil {

    public static @NotNull String getName(IlocFunction element) {
        return element.getId().getText();
    }

    public static @NotNull String getName(IlocLabel element) {
        String text = element.getLabeldecl().getText();
        return text.substring(0, text.length() - 1);
    }

    public static @NotNull String getName(IlocRegister element) {
        return element.getId().getText();
    }

    public static @NotNull String getName(IlocVariable element) {
        return element.getId().getText();
    }
    
    public static @NotNull String getName(IlocVariableRef element) {
        return element.getText().substring(1);
    }

    public static PsiElement setName(IlocNamedElement element, String newName) {
        ASTNode keyNode = element.getFirstChild().getNode();
        if (keyNode != null) {
            IlocNamedElement newElement = IlocElementFactory.create(element.getProject(), newName);
            element.getNode().replaceChild(keyNode, newElement.getFirstChild().getNode());
        }
        return element;
    }

    public static PsiElement getNameIdentifier(IlocNamedElement element) {
        ASTNode keyNode = element.getNode().getFirstChildNode();
        return keyNode != null ? keyNode.getPsi() : null;
    }

    public static PsiReference getReference(IlocVariableRef variableRef) {
        TextRange range = variableRef.getId().getTextRangeInParent();
        String key = variableRef.getId().getText();
        return new IlocReference(variableRef, range, key);
    }

    public static PsiReference getReference(PsiElement element) {
        TextRange range = element.getFirstChild().getTextRangeInParent();
        String key = element.getText().substring(range.getStartOffset(), range.getEndOffset());
        return new IlocReference(element, range, key);
    }

}
