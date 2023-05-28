// This is a generated file. Not intended for manual editing.
package com.pascalnb.iloc.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.pascalnb.iloc.language.psi.IlocTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.pascalnb.iloc.language.psi.*;

public class IlocOutArgImpl extends ASTWrapperPsiElement implements IlocOutArg {

  public IlocOutArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IlocVisitor visitor) {
    visitor.visitOutArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof IlocVisitor) accept((IlocVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public IlocLabelRef getLabelRef() {
    return findChildByClass(IlocLabelRef.class);
  }

  @Override
  @Nullable
  public IlocRegister getRegister() {
    return findChildByClass(IlocRegister.class);
  }

  @Override
  @Nullable
  public IlocVariableRef getVariableRef() {
    return findChildByClass(IlocVariableRef.class);
  }

  @Override
  @Nullable
  public PsiElement getInteger() {
    return findChildByType(INTEGER);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

}
