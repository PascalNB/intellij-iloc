// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface IlocTypes {

  IElementType ARG = new IlocElementType("ARG");
  IElementType FUNCTION = new IlocElementType("FUNCTION");
  IElementType LABEL = new IlocElementType("LABEL");
  IElementType LINE = new IlocElementType("LINE");
  IElementType REGISTER = new IlocElementType("REGISTER");

  IElementType COLON = new IlocTokenType(":");
  IElementType COMMA = new IlocTokenType(",");
  IElementType COMMENT = new IlocTokenType("comment");
  IElementType ID = new IlocTokenType("id");
  IElementType INTEGER = new IlocTokenType("integer");
  IElementType OP_1 = new IlocTokenType("=>");
  IElementType OP_2 = new IlocTokenType("->");
  IElementType STRING = new IlocTokenType("string");
  IElementType VAR = new IlocTokenType("var");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARG) {
        return new IlocArgImpl(node);
      }
      else if (type == FUNCTION) {
        return new IlocFunctionImpl(node);
      }
      else if (type == LABEL) {
        return new IlocLabelImpl(node);
      }
      else if (type == LINE) {
        return new IlocLineImpl(node);
      }
      else if (type == REGISTER) {
        return new IlocRegisterImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
