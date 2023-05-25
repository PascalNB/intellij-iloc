package org.intellij.sdk.language.psi;

import com.intellij.psi.PsiNameIdentifierOwner;

public interface IlocNamedElement extends PsiNameIdentifierOwner {

    Class<? extends IlocNamedElement> getType();

}
