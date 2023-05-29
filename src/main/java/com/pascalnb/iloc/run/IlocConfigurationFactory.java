package com.pascalnb.iloc.run;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.components.BaseState;
import com.intellij.openapi.project.Project;
import com.pascalnb.iloc.language.IlocIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class IlocConfigurationFactory extends ConfigurationFactory {

    private static IlocConfigurationFactory instance = null;

    private IlocConfigurationFactory(IlocConfigurationType type) {
        super(type);
    }

    public static void setType(IlocConfigurationType type) {
        instance = new IlocConfigurationFactory(type);
    }

    public static IlocConfigurationFactory getInstance() {
        return instance;
    }

    @Override
    public @NotNull @NonNls String getId() {
        return "iloc-executor";
    }

    @Override
    public Icon getIcon() {
        return IlocIcons.FILE;
    }

    @Override
    public @NotNull RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new IlocRunConfiguration(project, this, "Run ILOC");
    }

    @Override
    public @Nullable Class<? extends BaseState> getOptionsClass() {
        return IlocConfigurationOptions.class;
    }

}
