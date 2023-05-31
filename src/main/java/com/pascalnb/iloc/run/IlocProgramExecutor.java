package com.pascalnb.iloc.run;

import com.pascalnb.iloc.executor.Assembler;
import com.pascalnb.iloc.executor.Simulator;
import com.pascalnb.iloc.executor.eval.Machine;
import com.pascalnb.iloc.executor.model.Program;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.concurrent.Callable;

public class IlocProgramExecutor implements Callable<String> {

    private final InputStream file;
    private final InputStream input;
    private final OutputStream output;
    private final PrintWriter error;

    public IlocProgramExecutor(InputStream file, InputStream input, OutputStream output, OutputStream error) {
        this.file = file;
        this.input = input;
        this.output = output;
        this.error = new PrintWriter(error);
    }

    @Override
    public String call() {
        String result = null;
        try {
            Program program = Assembler.instance().assemble(CharStreams.fromStream(file));
            file.close();
            Machine machine = new Machine();
            Simulator simulator = new Simulator(program, machine);
            simulator.setIn(input);
            simulator.setOut(output);
            simulator.run();

            result = machine.toString();
        } catch (Exception e) {
            error.println(e);
        }
        try {
            input.close();
        } catch (IOException ignore) {
        }
        try {
            output.close();
        } catch (IOException ignore) {
        }
        error.close();
        return result;
    }

}
