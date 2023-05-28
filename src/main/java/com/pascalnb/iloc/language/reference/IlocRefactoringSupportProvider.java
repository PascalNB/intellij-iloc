package com.pascalnb.iloc.language.reference;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.pascalnb.iloc.language.psi.IlocFunction;
import com.pascalnb.iloc.language.psi.IlocNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IlocRefactoringSupportProvider extends RefactoringSupportProvider {

    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, @Nullable PsiElement context) {
        return element instanceof IlocNamedElement && (!(element instanceof IlocFunction));
    }

}
