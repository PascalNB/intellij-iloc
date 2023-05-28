package com.pascalnb.iloc.language.functions;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum IlocDefaultFunctions implements IlocFunctionDeclaration {
    NOP("nop", "-", "No operation"),
    ADD("add", "reg0 + reg1 => reg2", "Addition"),
    SUB("sub", "reg0 - reg1 => reg2", "Subtraction"),
    MULT("mult", "reg0 * reg1 => reg2", "Multiplication"),
    DIV("div", "reg0 / reg1 => reg2", "Division"),
    ADDI("addI", "reg0 + num1 => reg2", "Addition of immediate value"),
    SUBI("subI", "reg0 - num1 => reg2", "Subtraction of immediate value"),
    RSUBI("rsubI", "num1 - reg0 => reg2", "Subtraction from immediate value"),
    MULTI("multI", "reg0 * num1 => reg2", "Multiplication by immediate value"),
    DIVI("divI", "reg0 / num1 => reg2", "Division by immediate value"),
    RDIVI("rdivI", "num1 / reg0 => reg2", "Division of immediate value"),
    LSHIFT("lshift", "reg0 << reg1 => reg2", "Left-shift"),
    LSHIFTI("lshiftI", "reg0 << num1 => reg2", "Left-shift immediate value"),
    RSHIFT("rshift", "reg0 >> reg1 => reg2", "Right-shift"),
    RSHIFTI("rshiftI", "reg0 >> num1 => reg2", "Right-shift immediate value"),
    OR("or", "reg0 | reg1 => reg2", "Bitwise OR"),
    ORI("orI", "reg0 | num1 => reg2", "Bitwise OR with immediate value"),
    AND("and", "reg0 & reg1 => reg2", "Bitwise AND"),
    ANDI("andI", "reg0 & num1 => reg2", "Bitwise AND with immediate value"),
    XOR("xor", "reg0 ^ reg1 => reg2", "Bitwise XOR"),
    XORI("xorI", "reg0 ^ num1 => reg2", "Bitwise XOR with immediate value"),
    LOADI("loadI", "num0 => reg1", "Load immediate"),
    LOAD("load", "mem(reg0) => reg1", "Load"),
    LOADAI("loadAI", "mem(reg0 + num1) => reg2", "Load address + immediate"),
    LOADAO("loadAO", "mem(reg0 + reg1) => reg2", "Load address + offset"),
    CLOAD("cload", "mem(reg0) => reg1", "Character load"),
    CLOADAI("cloadAI", "mem(reg0 + num1) => reg1", "Character load address + immediate"),
    CLOADAO("cloadAO", "mem(reg0 + reg1) => reg2", "Character load address + offset"),
    STORE("store", "reg0 => mem(reg1)", "Store at address"),
    STOREAI("storeAI", "reg0 => mem(reg1 + num2)", "Store at address + immediate"),
    STOREAO("storeAO", "reg0 => mem(reg1 + reg2)", "Store at address + offset"),
    CSTORE("cstore", "reg0 => mem(reg)", "Character store at address"),
    CSTOREAI("cstoreAI", "reg0 => mem(reg1 + num2)", "Character store at address + immediate"),
    CSTOREAO("cstoreAO", "reg0 => mem(reg1 + reg2)", "Character store at address + offset"),
    I2I("i2i", "reg0 => reg1", "Integer-to-integer copy"),
    C2C("c2c", "reg0 => reg1", "Character-to-character copy"),
    C2I("c2i", "reg0 => reg1", "Character-to-integer copy"),
    I2C("i2c", "reg0 => reg1", "Integer-to-character copy"),
    CMP_LT("cmp_LT", "reg0 < reg1 => reg2", "Less-than comparison"),
    CMP_LE("cmp_LE", "reg0 <= reg1 => reg2", "Less-or-equal comparison"),
    CMP_EQ("cmp_EQ", "reg0 == reg1 => reg2", "Equals comparison"),
    CMP_GE("cmp_GE", "reg0 >= reg1 => reg2", "Greater-or-equal comparison"),
    CMP_GT("cmp_GT", "reg0 > reg1 => reg2", "Greater-then comparison"),
    CMP_NE("cmp_NE", "reg0 != reg1 => reg2", "Not-equals comparison"),
    CBR("cbr", "reg0 ? -> label0 : label1", "Conditional branch"),
    JUMPI("jumpI", "-> label0", "Immediate jump"),
    JUMP("jump", "-> reg0", "Register jump"),
    TBL("tbl", "", "Pseudo-op to record labels of a register jump"),
    PUSH("push", "reg0", "Push the (4-byte integer) value of a register onto the stack", true),
    POP("pop", "reg0", "Pop the (4-byte integer) stack top into a register", true),
    CPUSH("cpush", "reg0", "Push the (1-byte character) value of a register onto the stack", true),
    CPOP("cpop", "reg0", "Pop the (1-byte character) stack top into a register", true),
    IN("in", "str0 => stdout and stdin => reg1", "Value input", true),
    OUT("out", "str0 + reg1 => stdout", "Value output", true),
    CIN("cin", "str0 => stdout and stdin => stack", "String input. " +
        "The string is represented as length + chars (first char on top)", true),
    COUT("cout", "str0 + stack => stdout", "String output. " +
        "The string is represented as length + chars (first char on top)", true);

    private static final Map<String, IlocFunctionDeclaration> map;

    static {
        map = new HashMap<>();
        for (IlocFunctionDeclaration function : all()) {
            map.put(function.getName(), function);
        }
    }

    private final String name;
    private final String signature;
    private final String documentation;
    private final boolean unofficial;

    IlocDefaultFunctions(String name, String signature, String documentation) {
        this(name, signature, documentation, false);
    }

    IlocDefaultFunctions(String name, String signature, String documentation, boolean unofficial) {
        this.name = name;
        this.signature = signature;
        this.documentation = documentation;
        this.unofficial = unofficial;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSignature() {
        return signature;
    }

    @Override
    public String getDocumentation() {
        return documentation;
    }

    @Override
    public boolean isUnofficial() {
        return unofficial;
    }

    public static List<IlocFunctionDeclaration> all() {
        return Arrays.asList(values());
    }

    @Nullable
    public static IlocFunctionDeclaration get(String name) {
        return map.get(name);
    }

    public static boolean exists(String name) {
        return map.containsKey(name);
    }
}
