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

public class IlocInArgImpl extends ASTWrapperPsiElement implements IlocInArg {

  public IlocInArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IlocVisitor visitor) {
    visitor.visitInArg(this);
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
  public IlocRegisterRef getRegisterRef() {
    return findChildByClass(IlocRegisterRef.class);
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
