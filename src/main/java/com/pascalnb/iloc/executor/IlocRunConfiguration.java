package com.pascalnb.iloc.executor;

import com.intellij.execution.DefaultExecutionResult;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.LocatableConfigurationBase;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class IlocRunConfiguration extends LocatableConfigurationBase<IlocConfigurationOptions> {

    protected IlocRunConfiguration(@NotNull Project project, @NotNull ConfigurationFactory factory,
        @Nullable String name) {
        super(project, factory, name);
    }

    @Override
    public @NotNull SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new IlocRunForm();
    }

    public String getFileName() {
        return getOptions().getFileName();
    }

    public void setFileName(String name) {
        getOptions().setFileName(name);
    }

    @Override
    protected @NotNull IlocConfigurationOptions getOptions() {
        return (IlocConfigurationOptions) super.getOptions();
    }

    @Override
    public @Nullable RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) {
        return (executor1, runner) -> {
            ConsoleView console = TextConsoleBuilderFactory.getInstance().createBuilder(getProject()).getConsole();

            String file = getFileName();
            VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByPath(file);
            if (virtualFile == null) {
                System.err.println("File not found");
                return null;
            }

            Process process = new IlocProcess(virtualFile);
            ProcessHandler handler = new IlocProcessHandler(process, console);
            console.attachToProcess(handler);
            handler.startNotify();

            ProcessTerminatedListener.attach(handler);
            return new DefaultExecutionResult(console, handler);
        };
    }

}
