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
    return program(b, l + 1);
  }

  /* ********************************************************** */
  // label instruction (linebreak+ instruction)*
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, LABELDECL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = label(b, l + 1);
    r = r && instruction(b, l + 1);
    r = r && block_2(b, l + 1);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // (linebreak+ instruction)*
  private static boolean block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_2", c)) break;
    }
    return true;
  }

  // linebreak+ instruction
  private static boolean block_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block_2_0_0(b, l + 1);
    r = r && instruction(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // linebreak+
  private static boolean block_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINEBREAK);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, LINEBREAK)) break;
      if (!empty_element_parsed_guard_(b, "block_2_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // variable ASS integer comment?
  public static boolean decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable(b, l + 1);
    r = r && consumeTokens(b, 0, ASS, INTEGER);
    r = r && decl_3(b, l + 1);
    exit_section_(b, m, DECL, r);
    return r;
  }

  // comment?
  private static boolean decl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_3")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // decl (linebreak+ decl)*
  static boolean decls(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decls")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = decl(b, l + 1);
    r = r && decls_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (linebreak+ decl)*
  private static boolean decls_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decls_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!decls_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "decls_1", c)) break;
    }
    return true;
  }

  // linebreak+ decl
  private static boolean decls_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decls_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = decls_1_0_0(b, l + 1);
    r = r && decl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // linebreak+
  private static boolean decls_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decls_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINEBREAK);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, LINEBREAK)) break;
      if (!empty_element_parsed_guard_(b, "decls_1_0_0", c)) break;
    }
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
  // integer | string | variableRef | LAB labelRef | registerRef
  static boolean inArg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inArg")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = variableRef(b, l + 1);
    if (!r) r = inArg_3(b, l + 1);
    if (!r) r = registerRef(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAB labelRef
  private static boolean inArg_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inArg_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAB);
    r = r && labelRef(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // inArg (COMMA inArg)*
  static boolean inArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inArgs")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inArg(b, l + 1);
    r = r && inArgs_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA inArg)*
  private static boolean inArgs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inArgs_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inArgs_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inArgs_1", c)) break;
    }
    return true;
  }

  // COMMA inArg
  private static boolean inArgs_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inArgs_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && inArg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // operation | LSQ linebreak* operation (linebreak+ operation)* linebreak* RSQ
  public static boolean instruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction")) return false;
    if (!nextTokenIs(b, "<instruction>", ID, LSQ)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INSTRUCTION, "<instruction>");
    r = operation(b, l + 1);
    if (!r) r = instruction_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LSQ linebreak* operation (linebreak+ operation)* linebreak* RSQ
  private static boolean instruction_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LSQ);
    r = r && instruction_1_1(b, l + 1);
    r = r && operation(b, l + 1);
    r = r && instruction_1_3(b, l + 1);
    r = r && instruction_1_4(b, l + 1);
    r = r && consumeToken(b, RSQ);
    exit_section_(b, m, null, r);
    return r;
  }

  // linebreak*
  private static boolean instruction_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINEBREAK)) break;
      if (!empty_element_parsed_guard_(b, "instruction_1_1", c)) break;
    }
    return true;
  }

  // (linebreak+ operation)*
  private static boolean instruction_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_1_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instruction_1_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "instruction_1_3", c)) break;
    }
    return true;
  }

  // linebreak+ operation
  private static boolean instruction_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = instruction_1_3_0_0(b, l + 1);
    r = r && operation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // linebreak+
  private static boolean instruction_1_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_1_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINEBREAK);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, LINEBREAK)) break;
      if (!empty_element_parsed_guard_(b, "instruction_1_3_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // linebreak*
  private static boolean instruction_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_1_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINEBREAK)) break;
      if (!empty_element_parsed_guard_(b, "instruction_1_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // labeldecl
  public static boolean label(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label")) return false;
    if (!nextTokenIs(b, LABELDECL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LABELDECL);
    exit_section_(b, m, LABEL, r);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean labelRef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labelRef")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, LABEL_REF, r);
    return r;
  }

  /* ********************************************************** */
  // labelRef (COMMA labelRef)*
  static boolean labels(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labels")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = labelRef(b, l + 1);
    r = r && labels_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA labelRef)*
  private static boolean labels_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labels_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!labels_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "labels_1", c)) break;
    }
    return true;
  }

  // COMMA labelRef
  private static boolean labels_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labels_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && labelRef(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // function inArgs? ((DARROW outArgs) | (ARROW labels))? SEMI? comment?
  static boolean operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function(b, l + 1);
    r = r && operation_1(b, l + 1);
    r = r && operation_2(b, l + 1);
    r = r && operation_3(b, l + 1);
    r = r && operation_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // inArgs?
  private static boolean operation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_1")) return false;
    inArgs(b, l + 1);
    return true;
  }

  // ((DARROW outArgs) | (ARROW labels))?
  private static boolean operation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_2")) return false;
    operation_2_0(b, l + 1);
    return true;
  }

  // (DARROW outArgs) | (ARROW labels)
  private static boolean operation_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = operation_2_0_0(b, l + 1);
    if (!r) r = operation_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DARROW outArgs
  private static boolean operation_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DARROW);
    r = r && outArgs(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ARROW labels
  private static boolean operation_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARROW);
    r = r && labels(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEMI?
  private static boolean operation_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_3")) return false;
    consumeToken(b, SEMI);
    return true;
  }

  // comment?
  private static boolean operation_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_4")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // integer | string | variableRef | LAB labelRef | register
  static boolean outArg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outArg")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = variableRef(b, l + 1);
    if (!r) r = outArg_3(b, l + 1);
    if (!r) r = register(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAB labelRef
  private static boolean outArg_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outArg_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAB);
    r = r && labelRef(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // outArg (COMMA outArg)*
  static boolean outArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outArgs")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = outArg(b, l + 1);
    r = r && outArgs_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA outArg)*
  private static boolean outArgs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outArgs_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!outArgs_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "outArgs_1", c)) break;
    }
    return true;
  }

  // COMMA outArg
  private static boolean outArgs_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outArgs_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && outArg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // linebreak* (decls linebreak+ sections | decls | sections) linebreak* <<eof>>
  static boolean program(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = program_0(b, l + 1);
    r = r && program_1(b, l + 1);
    r = r && program_2(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // linebreak*
  private static boolean program_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINEBREAK)) break;
      if (!empty_element_parsed_guard_(b, "program_0", c)) break;
    }
    return true;
  }

  // decls linebreak+ sections | decls | sections
  private static boolean program_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = program_1_0(b, l + 1);
    if (!r) r = decls(b, l + 1);
    if (!r) r = sections(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // decls linebreak+ sections
  private static boolean program_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = decls(b, l + 1);
    r = r && program_1_0_1(b, l + 1);
    r = r && sections(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // linebreak+
  private static boolean program_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINEBREAK);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, LINEBREAK)) break;
      if (!empty_element_parsed_guard_(b, "program_1_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // linebreak*
  private static boolean program_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINEBREAK)) break;
      if (!empty_element_parsed_guard_(b, "program_2", c)) break;
    }
    return true;
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
  // id
  public static boolean registerRef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "registerRef")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, REGISTER_REF, r);
    return r;
  }

  /* ********************************************************** */
  // comment | block | instruction
  static boolean section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = block(b, l + 1);
    if (!r) r = instruction(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // section (linebreak+ section)*
  static boolean sections(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sections")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = section(b, l + 1);
    r = r && sections_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (linebreak+ section)*
  private static boolean sections_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sections_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sections_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sections_1", c)) break;
    }
    return true;
  }

  // linebreak+ section
  private static boolean sections_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sections_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sections_1_0_0(b, l + 1);
    r = r && section(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // linebreak+
  private static boolean sections_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sections_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINEBREAK);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, LINEBREAK)) break;
      if (!empty_element_parsed_guard_(b, "sections_1_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, VARIABLE, r);
    return r;
  }

  /* ********************************************************** */
  // VAR id
  public static boolean variableRef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableRef")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VAR, ID);
    exit_section_(b, m, VARIABLE_REF, r);
    return r;
  }

}
