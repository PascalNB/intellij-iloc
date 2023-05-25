// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class IlocVisitor extends PsiElementVisitor {

  public void visitArg(@NotNull IlocArg o) {
    visitPsiElement(o);
  }

  public void visitFunction(@NotNull IlocFunction o) {
    visitPsiElement(o);
  }

  public void visitLabel(@NotNull IlocLabel o) {
    visitPsiElement(o);
  }

  public void visitLine(@NotNull IlocLine o) {
    visitPsiElement(o);
  }

  public void visitRegister(@NotNull IlocRegister o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
