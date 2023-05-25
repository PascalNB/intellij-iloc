package org.intellij.sdk.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.IlocTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class IlocSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey OPERATOR =
        createTextAttributesKey("ILOC_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey STRING =
        createTextAttributesKey("ILOC_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
        createTextAttributesKey("ILOC_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey LABEL =
        createTextAttributesKey("ILOC_LABEL", DefaultLanguageHighlighterColors.LABEL);
    public static final TextAttributesKey FUNCTION =
        createTextAttributesKey("ILOC_FUNCTION", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey REGISTER =
        createTextAttributesKey("ILOC_REGISTER", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey VAR =
        createTextAttributesKey("ILOC_VAR", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey INTEGER =
        createTextAttributesKey("ILOC_INTEGER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey SYNTAX =
        createTextAttributesKey("ILOC_SYNTAX", DefaultLanguageHighlighterColors.COMMA);

    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] LABEL_KEYS = new TextAttributesKey[]{LABEL};
    private static final TextAttributesKey[] FUNCTION_KEYS = new TextAttributesKey[]{FUNCTION};
    private static final TextAttributesKey[] REGISTER_KEYS = new TextAttributesKey[]{REGISTER};
    private static final TextAttributesKey[] VAR_KEYS = new TextAttributesKey[]{VAR};
    private static final TextAttributesKey[] INTEGER_KEYS = new TextAttributesKey[]{INTEGER};
    private static final TextAttributesKey[] SYNTAX_KEYS = new TextAttributesKey[]{SYNTAX};

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new IlocLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(IlocTypes.REGISTER)) {
            return REGISTER_KEYS;
        }
        if (tokenType.equals(IlocTypes.INTEGER)) {
            return INTEGER_KEYS;
        }
        if (tokenType.equals(IlocTypes.COMMA) || tokenType.equals(IlocTypes.COLON)) {
            return SYNTAX_KEYS;
        }
        if (tokenType.equals(IlocTypes.VAR)) {
            return VAR_KEYS;
        }
        if (tokenType.equals(IlocTypes.OPERATOR)) {
            return OPERATOR_KEYS;
        }
        if (tokenType.equals(IlocTypes.FUNCTION)) {
            return FUNCTION_KEYS;
        }
        if (tokenType.equals(IlocTypes.COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(IlocTypes.LABEL)) {
            return LABEL_KEYS;
        }
        if (tokenType.equals(IlocTypes.STRING)) {
            return STRING_KEYS;
        }

        return TextAttributesKey.EMPTY_ARRAY;
    }

}
