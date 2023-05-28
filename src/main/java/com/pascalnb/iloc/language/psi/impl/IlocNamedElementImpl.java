package com.pascalnb.iloc.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.pascalnb.iloc.language.psi.IlocNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class IlocNamedElementImpl extends ASTWrapperPsiElement implements IlocNamedElement {

    public IlocNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}
