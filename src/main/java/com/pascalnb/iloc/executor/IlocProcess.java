package com.pascalnb.iloc.executor;

import com.intellij.openapi.vfs.VirtualFile;

import java.io.*;

public class IlocProcess extends Process {

    private final PipedInputStream inputStream;
    private final OutputStream output;
    private final PipedOutputStream outputStream;
    private final PipedInputStream input;
    private final PipedInputStream errorStream;
    private final PipedOutputStream error;

    public IlocProcess(VirtualFile file) {
        inputStream = new PipedInputStream();
        input = new PipedInputStream();
        errorStream = new PipedInputStream();
        try {
            outputStream = new PipedOutputStream(input);
            output = new PipedOutputStream(inputStream);
            error = new PipedOutputStream(errorStream);
            file.getInputStream().transferTo(output);
            file.getInputStream().transferTo(System.out);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
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
        closeAll();
        return 0;
    }

    @Override
    public int exitValue() {
        return 0;
    }

    @Override
    public void destroy() {
        closeAll();
    }

}
