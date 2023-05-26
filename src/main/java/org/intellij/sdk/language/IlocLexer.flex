package org.intellij.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.sdk.language.psi.IlocTypes.*;

%%

%{
  public IlocLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class IlocLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

NL=[\r\n]
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
COMMENT=("//".*)
INTEGER=[0-9]+
ID=[a-zA-Z_0-9]+
WHITE_SPACE=[\t ]+

%%
<YYINITIAL> {
  ":"                { return COLON; }
  ","                { return COMMA; }
  "=>"               { return DARROW; }
  "->"               { return ARROW; }
  ";"                { return SEMI; }
  "["                { return LSQ; }
  "]"                { return RSQ; }
  "<-"               { return ASS; }
  "-"                { return MINUS; }
  "@"                { return VAR; }
  "#"                { return LAB; }

  {NL}               { return NL; }
  {STRING}           { return STRING; }
  {COMMENT}          { return COMMENT; }
  {INTEGER}          { return INTEGER; }
  {ID}               { return ID; }
  {WHITE_SPACE}      { return WHITE_SPACE; }

}

[^] { return BAD_CHARACTER; }
