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

public class IlocOperationImpl extends ASTWrapperPsiElement implements IlocOperation {

  public IlocOperationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IlocVisitor visitor) {
    visitor.visitOperation(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof IlocVisitor) accept((IlocVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public IlocFunction getFunction() {
    return findNotNullChildByClass(IlocFunction.class);
  }

  @Override
  @NotNull
  public List<IlocInArg> getInArgList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IlocInArg.class);
  }

  @Override
  @NotNull
  public List<IlocLabelRef> getLabelRefList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IlocLabelRef.class);
  }

  @Override
  @NotNull
  public List<IlocOutArg> getOutArgList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IlocOutArg.class);
  }

  @Override
  @Nullable
  public PsiElement getComment() {
    return findChildByType(COMMENT);
  }

  @Override
  public boolean isControlOperation() {
    return IlocPsiImplUtil.isControlOperation(this);
  }

}
