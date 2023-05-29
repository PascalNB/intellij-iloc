package com.pascalnb.iloc.executor;

import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class IlocProcessHandler extends ProcessHandler {

    private final Process process;
    private final Thread listener;

    public IlocProcessHandler(Process process, ConsoleView console) {
        this.process = process;
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        listener = new Thread(() -> {
            try {
                while (true) {
                    if (!reader.ready()) {
                        continue;
                    }
                    String line = reader.readLine();
                    console.print(line + System.lineSeparator(), ConsoleViewContentType.NORMAL_OUTPUT);
                }
            } catch (IOException ignore) {
                notifyProcessDetached();
            }
        });
    }

    @Override
    public void startNotify() {
        super.startNotify();
        listener.start();
    }

    @Override
    protected void destroyProcessImpl() {
        process.destroy();
        notifyProcessTerminated(process.exitValue());
    }

    @Override
    protected void detachProcessImpl() {
        try {
            process.waitFor();
            notifyProcessDetached();
        } catch (InterruptedException ignore) {
        }
    }

    @Override
    public boolean detachIsDefault() {
        return false;
    }

    @Override
    public @Nullable OutputStream getProcessInput() {
        return process.getOutputStream();
    }

}
