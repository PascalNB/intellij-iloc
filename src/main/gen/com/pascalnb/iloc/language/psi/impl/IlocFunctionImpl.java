// This is a generated file. Not intended for manual editing.
package com.pascalnb.iloc.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.pascalnb.iloc.language.psi.IlocTypes.*;
import com.pascalnb.iloc.language.psi.*;
import com.intellij.psi.PsiReference;

public class IlocFunctionImpl extends IlocNamedElementImpl implements IlocFunction {

  public IlocFunctionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IlocVisitor visitor) {
    visitor.visitFunction(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof IlocVisitor) accept((IlocVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

  @Override
  public @NotNull String getName() {
    return IlocPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return IlocPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return IlocPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public PsiReference getReference() {
    return IlocPsiImplUtil.getReference(this);
  }

}
