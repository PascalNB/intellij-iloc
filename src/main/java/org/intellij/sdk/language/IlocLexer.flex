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

NL=(\r\n|\n|\r)
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
COMMENT=("//".*)
VAR=@[a-zA-Z_0-9]+
INTEGER=[0-9]+
ID=[a-zA-Z_0-9]+
WHITE_SPACE=[\t ]+

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  ":"                { return COLON; }
  ","                { return COMMA; }
  "=>"               { return OP_1; }
  "->"               { return OP_2; }

  {NL}               { return NL; }
  {STRING}           { return STRING; }
  {COMMENT}          { return COMMENT; }
  {VAR}              { return VAR; }
  {INTEGER}          { return INTEGER; }
  {ID}               { return ID; }

}

[^] { return BAD_CHARACTER; }
