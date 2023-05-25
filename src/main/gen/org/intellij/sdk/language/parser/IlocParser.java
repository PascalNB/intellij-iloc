// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.intellij.sdk.language.psi.IlocTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class IlocParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // integer | string | variable | register
  static boolean arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg")) return false;
    boolean r;
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = variable(b, l + 1);
    if (!r) r = register(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // arg (COMMA arg)*
  static boolean args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arg(b, l + 1);
    r = r && args_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA arg)*
  private static boolean args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!args_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "args_1", c)) break;
    }
    return true;
  }

  // COMMA arg
  private static boolean args_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, FUNCTION, r);
    return r;
  }

  /* ********************************************************** */
  // (label COLON)? operation
  static boolean instruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = instruction_0(b, l + 1);
    r = r && operation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (label COLON)?
  private static boolean instruction_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_0")) return false;
    instruction_0_0(b, l + 1);
    return true;
  }

  // label COLON
  private static boolean instruction_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = label(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean label(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, LABEL, r);
    return r;
  }

  /* ********************************************************** */
  // label (COMMA label)*
  static boolean labels(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labels")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = label(b, l + 1);
    r = r && labels_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA label)*
  private static boolean labels_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labels_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!labels_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "labels_1", c)) break;
    }
    return true;
  }

  // COMMA label
  private static boolean labels_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labels_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && label(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // function args? ((OP_1 args) | (OP_2 labels))?
  static boolean operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function(b, l + 1);
    r = r && operation_1(b, l + 1);
    r = r && operation_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // args?
  private static boolean operation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_1")) return false;
    args(b, l + 1);
    return true;
  }

  // ((OP_1 args) | (OP_2 labels))?
  private static boolean operation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_2")) return false;
    operation_2_0(b, l + 1);
    return true;
  }

  // (OP_1 args) | (OP_2 labels)
  private static boolean operation_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = operation_2_0_0(b, l + 1);
    if (!r) r = operation_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_1 args
  private static boolean operation_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_1);
    r = r && args(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_2 labels
  private static boolean operation_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_2);
    r = r && labels(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean register(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "register")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, REGISTER, r);
    return r;
  }

  /* ********************************************************** */
  // NL* instruction? (NL+ instruction)* NL*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = root_0(b, l + 1);
    r = r && root_1(b, l + 1);
    r = r && root_2(b, l + 1);
    r = r && root_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NL*
  private static boolean root_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NL)) break;
      if (!empty_element_parsed_guard_(b, "root_0", c)) break;
    }
    return true;
  }

  // instruction?
  private static boolean root_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_1")) return false;
    instruction(b, l + 1);
    return true;
  }

  // (NL+ instruction)*
  private static boolean root_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!root_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root_2", c)) break;
    }
    return true;
  }

  // NL+ instruction
  private static boolean root_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = root_2_0_0(b, l + 1);
    r = r && instruction(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NL+
  private static boolean root_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NL);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, NL)) break;
      if (!empty_element_parsed_guard_(b, "root_2_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // NL*
  private static boolean root_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NL)) break;
      if (!empty_element_parsed_guard_(b, "root_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // var
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR);
    exit_section_(b, m, VARIABLE, r);
    return r;
  }

}
