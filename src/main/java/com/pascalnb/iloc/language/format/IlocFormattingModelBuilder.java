package com.pascalnb.iloc.language.format;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.pascalnb.iloc.language.IlocLanguage;
import com.pascalnb.iloc.language.psi.IlocTypes;
import org.jetbrains.annotations.NotNull;

public class IlocFormattingModelBuilder implements FormattingModelBuilder {

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, IlocLanguage.INSTANCE)
            .before(IlocTypes.LINEBREAK).none();
    }

    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext context) {
        CodeStyleSettings settings = context.getCodeStyleSettings();
        IlocBlock block = new IlocBlock(
            context.getNode(),
            null,
            Indent.getNoneIndent(),
            null,
            createSpaceBuilder(settings)
        );
        return FormattingModelProvider.createFormattingModelForPsiFile(context.getContainingFile(), block, settings);
    }

}
