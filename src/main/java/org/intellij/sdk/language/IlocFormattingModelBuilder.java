package org.intellij.sdk.language;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.intellij.sdk.language.psi.IlocTokenSets;
import org.intellij.sdk.language.psi.IlocTypes;
import org.jetbrains.annotations.NotNull;

public class IlocFormattingModelBuilder implements FormattingModelBuilder {

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, IlocLanguage.INSTANCE)
            .around(IlocTokenSets.OPERATORS)
            .spaceIf(settings.getCommonSettings(IlocLanguage.INSTANCE.getID()).SPACE_AROUND_ASSIGNMENT_OPERATORS)
            .after(IlocTypes.COMMA)
            .spaceIf(settings.getCommonSettings(IlocLanguage.INSTANCE.getID()).SPACE_AFTER_COMMA)
            ;
    }

    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.getContainingFile(),
            new IlocBlock(formattingContext.getNode(),
                Wrap.createWrap(WrapType.NONE, false),
                Alignment.createAlignment(),
                createSpaceBuilder(codeStyleSettings)),
            codeStyleSettings
        );
    }

}
