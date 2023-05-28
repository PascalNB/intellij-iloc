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

public class IlocBlockImpl extends ASTWrapperPsiElement implements IlocBlock {

  public IlocBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IlocVisitor visitor) {
    visitor.visitBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof IlocVisitor) accept((IlocVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<IlocInstruction> getInstructionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IlocInstruction.class);
  }

}
