package org.intellij.sdk.language.functions;

public enum IlocDefaultFunctions implements IlocFunctionDeclaration {
    NOP("nop", ""),
    ADD("add", "reg0 + reg1 => reg2"),
    SUB("sub", "reg0 - reg1 => reg2"),
    MULT("mult", "reg0 * reg1 => reg2"),
    DIV("div", "reg0 / reg1 => reg2"),
    ADDI("addI", "reg0 + num1 => reg2"),
    SUBI("subI", "reg0 - num1 => reg2"),
    RSUBI("rsubI", "num1 - reg0 => reg2"),
    MULTI("multI", "reg0 * num1 => reg2"),
    DIVI("divI", "reg0 / num1 => reg2"),
    RDIVI("rdivI", "num1 / reg0 => reg2"),
    LSHIFT("lshift", "reg0 << reg1 => reg2"),
    LSHIFTI("lshiftI", "reg0 << num1 => reg2"),
    RSHIFT("rshift", "reg0 >> reg1 => reg2"),
    RSHIFTI("rshiftI", "reg0 >> num1 => reg2"),
    OR("or", "reg0 | reg1 => reg2"),
    ORI("orI", "reg0 | num1 => reg2"),
    AND("and", "reg0 & reg1 => reg2"),
    ANDI("andI", "reg0 & num1 => reg2"),
    XOR("xor", "reg0 ^ reg1 => reg2"),
    XORI("xorI", "reg0 ^ num1 => reg2"),
    LOADI("loadI", "num0 => reg1"),
    LOAD("load", "mem(reg0) => reg1"),
    LOADAI("loadAI", "mem(reg0 + num1) => reg2"),
    LOADAO("loadAO", "mem(reg0 + reg1) => reg2"),
    CLOAD("cload", "mem(reg0) => reg1"),
    CLOADAI("cloadAI", "mem(reg0 + num1) => reg1"),
    CLOADAO("cloadAO", "mem(reg0 + reg1) => reg2"),
    STORE("store", "reg0 => mem(reg1)"),
    STOREAI("storeAI", "reg0 => mem(reg1 + num2)"),
    STOREAO("storeAO", "reg0 => mem(reg1 + reg2)"),
    CSTORE("cstore", "reg0 => mem(reg)"),
    CSTOREAI("cstoreAI", "reg0 => mem(reg1 + num2)"),
    CSTOREAO("cstoreAO", "reg0 => mem(reg1 + reg2)"),
    I2I("i2i", "reg0 => reg1"),
    C2C("c2c", "reg0 => reg1"),
    C2I("c2i", "reg0 => reg1"),
    I2C("i2c", "reg0 => reg1"),
    CMP_LT("cmp_LT", "reg0 < reg1 => reg2"),
    CMP_LE("cmp_LE", "reg0 <= reg1 => reg2"),
    CMP_EQ("cmp_EQ", "reg0 == reg1 => reg2"),
    CMP_GE("cmp_GE", "reg0 >= reg1 => reg2"),
    CMP_GT("cmp_GT", "reg0 > reg1 => reg2"),
    CMP_NE("cmp_NE", "reg0 != reg1 => reg2"),
    CBR("cbr", "reg0 != 0 ? #label0 : #label1 => pc"),
    JUMPI("jumpI", "#label0 => pc"),
    JUMP("jump", "reg0 => pc"),
    TBL("tbl", ""),
    PUSH("push", "reg0"),
    POP("pop", "reg0"),
    CPUSH("cpush", "reg0"),
    CPOP("cpop", "reg0"),
    IN("in", "str0 => stdout and stdin => reg1"),
    OUT("out", "str0 + reg1 => stdout"),
    CIN("cin", "str0 => stdout and stdin => stack"),
    COUT("cout", "str0 + stack => stdout");

    private final String name;
    private final String signature;

    IlocDefaultFunctions(String name, String signature) {
        this.name = name;
        this.signature = signature;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSignature() {
        return signature;
    }
}
