// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface IlocOperation extends PsiElement {

  @NotNull
  IlocFunction getFunction();

  @NotNull
  List<IlocInArg> getInArgList();

  @NotNull
  List<IlocLabelRef> getLabelRefList();

  @NotNull
  List<IlocOutArg> getOutArgList();

  @Nullable
  PsiElement getComment();

  boolean isControlOperation();

}
