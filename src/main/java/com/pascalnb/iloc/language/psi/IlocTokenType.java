package com.pascalnb.iloc.language.psi;

import com.intellij.psi.tree.IElementType;
import com.pascalnb.iloc.language.IlocLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class IlocTokenType extends IElementType {

    public IlocTokenType(@NotNull @NonNls String debugName) {
        super(debugName, IlocLanguage.INSTANCE);
    }

}
