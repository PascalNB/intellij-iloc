package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.TokenSet;

public interface IlocTokenSets {

    TokenSet OPERATORS = TokenSet.create(IlocTypes.DARROW, IlocTypes.ARROW, IlocTypes.ASS);
    TokenSet BLOCKS = TokenSet.create(IlocTypes.BLOCK, IlocTypes.DECL);
    TokenSet STRINGS = TokenSet.create(IlocTypes.STRING);
    TokenSet SYNTAX = TokenSet.create(IlocTypes.COLON, IlocTypes.COMMA, IlocTypes.LSQ, IlocTypes.RSQ, IlocTypes.SEMI);

}
