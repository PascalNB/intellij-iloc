package com.pascalnb.iloc.language;

import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;

%%

%{
  public _IlocLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _IlocLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

LABELDECL=[a-zA-Z][a-zA-Z_0-9]*:
COMMENT=("//".*)
INTEGER=-?[0-9]+
ID=[a-zA-Z][a-zA-Z_0-9]*
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
WHITE_SPACE=[ \t]+
LINEBREAK=[\r\n]+

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
  "@"                { return VAR; }
  "#"                { return LAB; }

  {LABELDECL}        { return LABELDECL; }
  {COMMENT}          { return COMMENT; }
  {INTEGER}          { return INTEGER; }
  {ID}               { return ID; }
  {STRING}           { return STRING; }
  {WHITE_SPACE}      { return WHITE_SPACE; }
  {LINEBREAK}        { return LINEBREAK; }

}

[^] { return BAD_CHARACTER; }
