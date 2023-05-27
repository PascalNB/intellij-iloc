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

public class IlocInstructionImpl extends ASTWrapperPsiElement implements IlocInstruction {

  public IlocInstructionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IlocVisitor visitor) {
    visitor.visitInstruction(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof IlocVisitor) accept((IlocVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<IlocFunction> getFunctionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IlocFunction.class);
  }

  @Override
  @NotNull
  public List<IlocLabelRef> getLabelRefList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IlocLabelRef.class);
  }

  @Override
  @NotNull
  public List<IlocRegister> getRegisterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IlocRegister.class);
  }

  @Override
  @NotNull
  public List<IlocRegisterRef> getRegisterRefList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IlocRegisterRef.class);
  }

  @Override
  @NotNull
  public List<IlocVariableRef> getVariableRefList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IlocVariableRef.class);
  }

}
