// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface IlocLine extends PsiElement {

  @NotNull
  IlocFunction getFunction();

  @Nullable
  IlocLabel getLabel();

  @Nullable
  IlocLabels getLabels();

  @NotNull
  List<IlocRegister> getRegisterList();

}
