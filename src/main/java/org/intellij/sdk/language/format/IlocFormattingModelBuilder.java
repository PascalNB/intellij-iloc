package org.intellij.sdk.language.format;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import org.intellij.sdk.language.IlocLanguage;
import org.intellij.sdk.language.psi.IlocTokenSets;
import org.intellij.sdk.language.psi.IlocTypes;
import org.jetbrains.annotations.NotNull;

public class IlocFormattingModelBuilder implements FormattingModelBuilder {

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        CommonCodeStyleSettings common = settings.getCommonSettings(IlocLanguage.INSTANCE.getID());

        return new SpacingBuilder(settings, IlocLanguage.INSTANCE)
            .around(IlocTokenSets.OPERATORS).spaceIf(common.SPACE_AROUND_ASSIGNMENT_OPERATORS)
            .after(IlocTypes.COMMA).spaceIf(common.SPACE_AFTER_COMMA)
            .after(IlocTypes.LABEL).spaceIf(common.SPACE_AFTER_COLON)
            .around(IlocTypes.ID).none()
            .before(IlocTokenSets.BLOCKS).none()
            .before(IlocTypes.LINEBREAK).none()
            ;
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
