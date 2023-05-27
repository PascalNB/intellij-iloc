package org.intellij.sdk.language.format;

import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import org.intellij.sdk.language.IlocLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IlocLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {

    @Override
    public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
        if (settingsType == SettingsType.SPACING_SETTINGS) {
            consumer.showStandardOptions(
                "SPACE_AROUND_ASSIGNMENT_OPERATORS",
                "SPACE_AFTER_COMMA",
                "SPACE_AFTER_COLON"
            );

            consumer.renameStandardOption("SPACE_AROUND_ASSIGNMENT_OPERATORS", "Operator");
            consumer.renameStandardOption("SPACE_AFTER_COLON", "After label");
        }
    }

    @Override
    public @Nullable String getCodeSample(@NotNull SettingsType settingsType) {
        return """      
            cin "Input? "          // read string and push on stack
            pop => r_len           // get string length from stack
            i2i r_len => r_off     // calculate offset of next char from sp
            subI r_off, 1 => r_off
            multI r_off, 4 => r_off
            i2i r_len => r_count   // initialise loop counter
            loadI 1 => r_one      // fixed value
            loop: cmp_GT r_one, r_count => r_cmp
                cbr r_cmp -> done, cont // while r_count >= 1
            cont: cloadAO sp, r_off => r_char
                cpush r_char           // push mem[sp+len-1] onto stack
                subI r_count, 1 => r_count
                jumpI -> loop          // back to while test
            done: add r_len, r_len => r_len // adjust length to 2* original
                push r_len             // push length
                cout "Doubled: "       // string on stack is now double of original
            """;
    }

    @Override
    public @NotNull Language getLanguage() {
        return IlocLanguage.INSTANCE;
    }

}
