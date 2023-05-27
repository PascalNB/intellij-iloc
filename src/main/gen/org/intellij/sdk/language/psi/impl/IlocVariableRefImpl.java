// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.psi.IlocTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.sdk.language.psi.*;
import com.intellij.psi.PsiReference;

public class IlocVariableRefImpl extends ASTWrapperPsiElement implements IlocVariableRef {

  public IlocVariableRefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IlocVisitor visitor) {
    visitor.visitVariableRef(this);
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
  public PsiReference getReference() {
    return IlocPsiImplUtil.getReference(this);
  }

}
