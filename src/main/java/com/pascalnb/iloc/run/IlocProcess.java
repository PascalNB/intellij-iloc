package com.pascalnb.iloc.run;

import com.intellij.openapi.vfs.VirtualFile;

import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class IlocProcess extends Process {

    private final PipedInputStream inputStream;
    private final PipedOutputStream outputStream;
    private final PipedInputStream errorStream;
    private final Thread thread;
    private final AtomicBoolean finished;
    private final AtomicReference<String> result;

    public IlocProcess(VirtualFile file) {
        inputStream = new PipedInputStream();
        PipedInputStream input = new PipedInputStream();
        errorStream = new PipedInputStream();
        finished = new AtomicBoolean(false);
        result = new AtomicReference<>(null);

        try {
            outputStream = new PipedOutputStream(input);
            OutputStream output = new PipedOutputStream(inputStream);
            PipedOutputStream error = new PipedOutputStream(errorStream);

            InputStream fileStream = file.getInputStream();

            thread = new Thread(() -> {
                String result = new IlocProgramExecutor(fileStream, input, output, error).call();
                finished.set(true);
                IlocProcess.this.result.set(result);
            });
            thread.start();

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public boolean isFinished() {
        return finished.get();
    }

    public String getResult() {
        return result.get();
    }

    @Override
    public OutputStream getOutputStream() {
        return outputStream;
    }

    @Override
    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public InputStream getErrorStream() {
        return errorStream;
    }

    private void closeAll() {
        try {
            outputStream.close();
        } catch (IOException ignore) {
        }
        try {
            inputStream.close();
        } catch (IOException ignore) {
        }
        try {
            errorStream.close();
        } catch (IOException ignore) {
        }
    }

    @Override
    public int waitFor() throws InterruptedException {
        thread.join();
        closeAll();
        return 0;
    }

    @Override
    public int exitValue() {
        return 0;
    }

    @Override
    public void destroy() {
        thread.interrupt();
        closeAll();
    }

}
