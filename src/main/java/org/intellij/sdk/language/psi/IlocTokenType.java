package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.IlocLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class IlocTokenType extends IElementType {

    public IlocTokenType(@NotNull @NonNls String debugName) {
        super(debugName, IlocLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "ILOCTokenType." + super.toString();
    }

}
