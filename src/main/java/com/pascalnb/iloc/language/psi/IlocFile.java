package com.pascalnb.iloc.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.pascalnb.iloc.language.IlocFileType;
import com.pascalnb.iloc.language.IlocLanguage;
import org.jetbrains.annotations.NotNull;

public class IlocFile extends PsiFileBase {

    public IlocFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, IlocLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return IlocFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "ILOC File";
    }

}
