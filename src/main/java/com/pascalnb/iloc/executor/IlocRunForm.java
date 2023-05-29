package com.pascalnb.iloc.executor;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class IlocRunForm extends SettingsEditor<IlocRunConfiguration> {

    private JPanel panel;
    private LabeledComponent<TextFieldWithBrowseButton> fileName;

    @Override
    protected void resetEditorFrom(@NotNull IlocRunConfiguration s) {
        fileName.getComponent().setText(s.getFileName());
    }

    @Override
    protected void applyEditorTo(@NotNull IlocRunConfiguration s) throws ConfigurationException {
        s.setFileName(fileName.getComponent().getText());
    }

    @Override
    protected @NotNull JComponent createEditor() {
        return panel;
    }

    private void createUIComponents() {
        fileName = new LabeledComponent<>();
        fileName.setComponent(new TextFieldWithBrowseButton());
    }

}
