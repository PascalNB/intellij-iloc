package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.TokenSet;

public interface IlocTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(IlocTypes.FUNCTION);
    TokenSet STRINGS = TokenSet.create(IlocTypes.STRING);
    TokenSet COMMENTS = TokenSet.create(IlocTypes.COMMENT);

}
