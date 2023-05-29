package com.pascalnb.iloc.run;

import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.actions.LazyRunConfigurationProducer;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.pascalnb.iloc.language.psi.IlocFile;
import org.jetbrains.annotations.NotNull;

public class IlocConfigurationProducer extends LazyRunConfigurationProducer<IlocRunConfiguration> {

    @Override
    protected boolean setupConfigurationFromContext(@NotNull IlocRunConfiguration configuration,
        @NotNull ConfigurationContext context, @NotNull Ref<PsiElement> sourceElement) {

        PsiFile file = sourceElement.get().getContainingFile();

        if (file instanceof IlocFile) {
            configuration.setName(file.getName());
            configuration.setFileName(file.getVirtualFile().getPath());
            return true;
        }

        return false;
    }

    @Override
    public boolean isConfigurationFromContext(@NotNull IlocRunConfiguration configuration,
        @NotNull ConfigurationContext context) {

        PsiElement location = context.getPsiLocation();
        if (location == null) {
            return false;
        }
        PsiFile file = location.getContainingFile();

        return file instanceof IlocFile && configuration.getFileName().equals(file.getVirtualFile().getPath());
    }

    @NotNull
    @Override
    public ConfigurationFactory getConfigurationFactory() {
        return IlocConfigurationFactory.getInstance();
    }

}
