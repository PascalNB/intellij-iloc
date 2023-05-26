package org.intellij.sdk.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.intellij.sdk.language.IlocReference;
import org.intellij.sdk.language.psi.*;

public class IlocPsiImplUtil {

    public static String getName(IlocFunction element) {
        return element.getId().getText();
    }

    public static String getName(IlocLabel element) {
        return element.getId().getText();
    }

    public static String getName(IlocRegister element) {
        return element.getId().getText();
    }

    public static String getName(IlocVariable element) {
        return element.getId().getText();
    }

    public static Class<IlocFunction> getType(IlocFunction element) {
        return IlocFunction.class;
    }

    public static Class<IlocLabel> getType(IlocLabel element) {
        return IlocLabel.class;
    }

    public static Class<IlocRegister> getType(IlocRegister element) {
        return IlocRegister.class;
    }

    public static Class<IlocVariable> getType(IlocVariable element) {
        return IlocVariable.class;
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

    public static PsiReference getReference(PsiElement element) {
        return new IlocReference(element, element.getFirstChild().getTextRangeInParent());
    }

}
