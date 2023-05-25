package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.IlocNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class IlocNamedElementImpl extends ASTWrapperPsiElement implements IlocNamedElement {

    public IlocNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}
