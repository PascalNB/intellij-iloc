// This is a generated file. Not intended for manual editing.
package com.pascalnb.iloc.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class IlocVisitor extends PsiElementVisitor {

  public void visitBlock(@NotNull IlocBlock o) {
    visitPsiElement(o);
  }

  public void visitDecl(@NotNull IlocDecl o) {
    visitPsiElement(o);
  }

  public void visitFunction(@NotNull IlocFunction o) {
    visitNamedElement(o);
  }

  public void visitInArg(@NotNull IlocInArg o) {
    visitPsiElement(o);
  }

  public void visitInstruction(@NotNull IlocInstruction o) {
    visitPsiElement(o);
  }

  public void visitLabel(@NotNull IlocLabel o) {
    visitNamedElement(o);
  }

  public void visitLabelRef(@NotNull IlocLabelRef o) {
    visitPsiElement(o);
  }

  public void visitLabeledBlock(@NotNull IlocLabeledBlock o) {
    visitPsiElement(o);
  }

  public void visitOperation(@NotNull IlocOperation o) {
    visitPsiElement(o);
  }

  public void visitOutArg(@NotNull IlocOutArg o) {
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

  public void visitVariableRef(@NotNull IlocVariableRef o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull IlocNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
