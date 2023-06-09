// This is a generated file. Not intended for manual editing.
package com.pascalnb.iloc.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.pascalnb.iloc.language.psi.impl.*;

public interface IlocTypes {

  IElementType BLOCK = new IlocElementType("BLOCK");
  IElementType DECL = new IlocElementType("DECL");
  IElementType FUNCTION = new IlocElementType("FUNCTION");
  IElementType INSTRUCTION = new IlocElementType("INSTRUCTION");
  IElementType IN_ARG = new IlocElementType("IN_ARG");
  IElementType LABEL = new IlocElementType("LABEL");
  IElementType LABELED_BLOCK = new IlocElementType("LABELED_BLOCK");
  IElementType LABEL_REF = new IlocElementType("LABEL_REF");
  IElementType OPERATION = new IlocElementType("OPERATION");
  IElementType OUT_ARG = new IlocElementType("OUT_ARG");
  IElementType REGISTER = new IlocElementType("REGISTER");
  IElementType REGISTER_REF = new IlocElementType("REGISTER_REF");
  IElementType VARIABLE = new IlocElementType("VARIABLE");
  IElementType VARIABLE_REF = new IlocElementType("VARIABLE_REF");

  IElementType ARROW = new IlocTokenType("->");
  IElementType ASS = new IlocTokenType("<-");
  IElementType COLON = new IlocTokenType(":");
  IElementType COMMA = new IlocTokenType(",");
  IElementType COMMENT = new IlocTokenType("comment");
  IElementType DARROW = new IlocTokenType("=>");
  IElementType ID = new IlocTokenType("id");
  IElementType INTEGER = new IlocTokenType("integer");
  IElementType LAB = new IlocTokenType("#");
  IElementType LABELDECL = new IlocTokenType("labeldecl");
  IElementType LINEBREAK = new IlocTokenType("linebreak");
  IElementType LSQ = new IlocTokenType("[");
  IElementType RSQ = new IlocTokenType("]");
  IElementType SEMI = new IlocTokenType(";");
  IElementType STRING = new IlocTokenType("string");
  IElementType VAR = new IlocTokenType("@");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BLOCK) {
        return new IlocBlockImpl(node);
      }
      else if (type == DECL) {
        return new IlocDeclImpl(node);
      }
      else if (type == FUNCTION) {
        return new IlocFunctionImpl(node);
      }
      else if (type == INSTRUCTION) {
        return new IlocInstructionImpl(node);
      }
      else if (type == IN_ARG) {
        return new IlocInArgImpl(node);
      }
      else if (type == LABEL) {
        return new IlocLabelImpl(node);
      }
      else if (type == LABELED_BLOCK) {
        return new IlocLabeledBlockImpl(node);
      }
      else if (type == LABEL_REF) {
        return new IlocLabelRefImpl(node);
      }
      else if (type == OPERATION) {
        return new IlocOperationImpl(node);
      }
      else if (type == OUT_ARG) {
        return new IlocOutArgImpl(node);
      }
      else if (type == REGISTER) {
        return new IlocRegisterImpl(node);
      }
      else if (type == REGISTER_REF) {
        return new IlocRegisterRefImpl(node);
      }
      else if (type == VARIABLE) {
        return new IlocVariableImpl(node);
      }
      else if (type == VARIABLE_REF) {
        return new IlocVariableRefImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
