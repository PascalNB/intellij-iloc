package com.pascalnb.iloc.language.format;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleConfigurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import com.pascalnb.iloc.language.IlocLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IlocCodeStyleSettingsProvider extends CodeStyleSettingsProvider {

    @Override
    public @Nullable CustomCodeStyleSettings createCustomSettings(CodeStyleSettings settings) {
        return new IlocCodeStyleSettings(settings);
    }

    @Override
    public @Nullable String getConfigurableDisplayName() {
        return "ILOC";
    }

    @Override
    public @NotNull CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings settings,
        @NotNull CodeStyleSettings modelSettings) {

        return new CodeStyleAbstractConfigurable(settings, modelSettings, this.getConfigurableDisplayName()) {

            @Override
            protected CodeStyleAbstractPanel createPanel(CodeStyleSettings settings) {
                return new IlocCodeStyleMainPanel(getCurrentSettings(), settings);
            }

        };
    }

    private static class IlocCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {

        protected IlocCodeStyleMainPanel(CodeStyleSettings currentSettings, @NotNull CodeStyleSettings settings) {
            super(IlocLanguage.INSTANCE, currentSettings, settings);
        }

    }

}
