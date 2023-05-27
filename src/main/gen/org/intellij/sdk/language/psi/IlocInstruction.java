// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface IlocInstruction extends PsiElement {

  @NotNull
  List<IlocFunction> getFunctionList();

  @NotNull
  List<IlocLabelRef> getLabelRefList();

  @NotNull
  List<IlocRegister> getRegisterList();

  @NotNull
  List<IlocRegisterRef> getRegisterRefList();

  @NotNull
  List<IlocVariableRef> getVariableRefList();

}
