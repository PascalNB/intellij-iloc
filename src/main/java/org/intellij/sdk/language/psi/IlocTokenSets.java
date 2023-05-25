package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.TokenSet;

public interface IlocTokenSets {

    TokenSet STRINGS = TokenSet.create(IlocTypes.STRING);
    TokenSet COMMENTS = TokenSet.create(IlocTypes.COMMENT);

}
