// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface IlocInArg extends PsiElement {

  @Nullable
  IlocLabelRef getLabelRef();

  @Nullable
  IlocRegisterRef getRegisterRef();

  @Nullable
  IlocVariableRef getVariableRef();

  @Nullable
  PsiElement getInteger();

  @Nullable
  PsiElement getString();

}
