// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface IlocDecl extends PsiElement {

  @NotNull
  IlocVariable getVariable();

  @Nullable
  PsiElement getComment();

  @NotNull
  PsiElement getInteger();

}