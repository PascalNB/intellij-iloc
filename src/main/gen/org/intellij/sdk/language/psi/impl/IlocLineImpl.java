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

public class IlocLineImpl extends ASTWrapperPsiElement implements IlocLine {

  public IlocLineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IlocVisitor visitor) {
    visitor.visitLine(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof IlocVisitor) accept((IlocVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<IlocArg> getArgList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IlocArg.class);
  }

  @Override
  @NotNull
  public IlocFunction getFunction() {
    return findNotNullChildByClass(IlocFunction.class);
  }

  @Override
  @Nullable
  public IlocLabel getLabel() {
    return findChildByClass(IlocLabel.class);
  }

}
