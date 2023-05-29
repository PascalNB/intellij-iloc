package com.pascalnb.iloc.executor;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.configurations.RunnerSettings;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ProgramRunner;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class IlocProgramRunner implements ProgramRunner<RunnerSettings> {

    @Override
    public @NotNull @NonNls String getRunnerId() {
        return "iloc-runner";
    }

    @Override
    public boolean canRun(@NotNull String executorId, @NotNull RunProfile profile) {
        return profile instanceof IlocRunConfiguration;
    }

    @Override
    public void execute(@NotNull ExecutionEnvironment environment) throws ExecutionException {
        RunProfileState state = environment.getState();
        if (state == null) {
            return;
        }
        state.execute(DefaultRunExecutor.getRunExecutorInstance(), this);
    }

}
