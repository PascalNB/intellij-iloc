package org.intellij.sdk.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class IlocFileType extends LanguageFileType {

    public static final IlocFileType INSTANCE = new IlocFileType();

    private IlocFileType() {
        super(IlocLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "ILOC";
    }

    @Override
    public @NotNull String getDescription() {
        return "ILOC instruction file";
    }

    @Override
    public @NotNull String getDefaultExtension() {
        return "iloc";
    }

    @Override
    public Icon getIcon() {
        return IlocIcons.FILE;
    }

}
