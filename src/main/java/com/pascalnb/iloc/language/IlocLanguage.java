package com.pascalnb.iloc.language;

import com.intellij.lang.Language;

public class IlocLanguage extends Language {

    public static final IlocLanguage INSTANCE = new IlocLanguage();

    private IlocLanguage() {
        super("ILOC");
    }

}
