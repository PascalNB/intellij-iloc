// This is a generated file. Not intended for manual editing.
package com.pascalnb.iloc.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface IlocOutArg extends PsiElement {

  @Nullable
  IlocLabelRef getLabelRef();

  @Nullable
  IlocRegister getRegister();

  @Nullable
  IlocVariableRef getVariableRef();

  @Nullable
  PsiElement getInteger();

  @Nullable
  PsiElement getString();

}
