package com.pascalnb.iloc.run;

import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class IlocProcessHandler extends ProcessHandler {

    private final IlocProcess process;
    private final Thread listener;

    public IlocProcessHandler(IlocProcess process, ConsoleView console) {
        this.process = process;
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        listener = new Thread(() -> {
            try {
                while (!process.isFinished()) {
                    while (inputReader.ready()) {
                        String line = inputReader.readLine();
                        console.print(line + System.lineSeparator(), ConsoleViewContentType.NORMAL_OUTPUT);
                    }
                    while (errorReader.ready()) {
                        String line = errorReader.readLine();
                        console.print(line + System.lineSeparator(), ConsoleViewContentType.ERROR_OUTPUT);
                    }
                }
                String result = process.getResult();
                console.print(result, ConsoleViewContentType.SYSTEM_OUTPUT);
            } catch (IOException ignore) {
                try {
                    inputReader.close();
                } catch (IOException ignore1) {
                }
                try {
                    errorReader.close();
                } catch (IOException ignore2) {
                }
            }
            notifyProcessDetached();
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
