package com.pascalnb.iloc.language;

import com.intellij.lexer.FlexAdapter;

public class IlocLexerAdapter extends FlexAdapter {

    public IlocLexerAdapter() {
        super(new _IlocLexer(null));
    }

}
