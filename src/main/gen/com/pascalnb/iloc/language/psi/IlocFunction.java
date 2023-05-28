// This is a generated file. Not intended for manual editing.
package com.pascalnb.iloc.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface IlocFunction extends IlocNamedElement {

  @NotNull
  PsiElement getId();

  @NotNull String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  PsiReference getReference();

}
