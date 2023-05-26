// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class IlocVisitor extends PsiElementVisitor {

  public void visitFunction(@NotNull IlocFunction o) {
    visitNamedElement(o);
  }

  public void visitLabel(@NotNull IlocLabel o) {
    visitNamedElement(o);
  }

  public void visitLabelRef(@NotNull IlocLabelRef o) {
    visitPsiElement(o);
  }

  public void visitRegister(@NotNull IlocRegister o) {
    visitNamedElement(o);
  }

  public void visitRegisterRef(@NotNull IlocRegisterRef o) {
    visitPsiElement(o);
  }

  public void visitVariable(@NotNull IlocVariable o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull IlocNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
