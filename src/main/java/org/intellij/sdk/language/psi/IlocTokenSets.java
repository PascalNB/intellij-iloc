package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.TokenSet;

public interface IlocTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(IlocTypes.ID);
    TokenSet OPERATORS = TokenSet.create(IlocTypes.DARROW, IlocTypes.ARROW, IlocTypes.ASS);
    TokenSet TOKENS = TokenSet.create(IlocTypes.COMMA, IlocTypes.COLON);
    TokenSet STRINGS = TokenSet.create(IlocTypes.STRING);
    TokenSet COMMENTS = TokenSet.create(IlocTypes.COMMENT);

}
