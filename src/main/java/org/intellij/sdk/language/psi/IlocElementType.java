package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.IlocLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class IlocElementType extends IElementType {

    public IlocElementType(@NotNull @NonNls String debugName) {
        super(debugName, IlocLanguage.INSTANCE);
    }

}
