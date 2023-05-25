package org.intellij.sdk.language.editor;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.IlocLexerAdapter;
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
    public static final TextAttributesKey IDENTIFIER =
        createTextAttributesKey("ILOC_IDENTIFIER", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey VAR =
        createTextAttributesKey("ILOC_VAR", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey INTEGER =
        createTextAttributesKey("ILOC_INTEGER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey TOKEN =
        createTextAttributesKey("ILOC_TOKEN", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey BAD =
        createTextAttributesKey("ILOC_BAD", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] VAR_KEYS = new TextAttributesKey[]{VAR};
    private static final TextAttributesKey[] INTEGER_KEYS = new TextAttributesKey[]{INTEGER};
    private static final TextAttributesKey[] TOKEN_KEYS = new TextAttributesKey[]{TOKEN};
    private static final TextAttributesKey[] BAD_KEYS = new TextAttributesKey[]{BAD};

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new IlocLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(IlocTypes.ID)) {
            return IDENTIFIER_KEYS;
        }
        if (tokenType.equals(IlocTypes.INTEGER)) {
            return INTEGER_KEYS;
        }
        if (tokenType.equals(IlocTypes.COMMA) || tokenType.equals(IlocTypes.COLON)) {
            return TOKEN_KEYS;
        }
        if (tokenType.equals(IlocTypes.VAR)) {
            return VAR_KEYS;
        }
        if (tokenType.equals(IlocTypes.OP_1) || tokenType.equals(IlocTypes.OP_2)) {
            return OPERATOR_KEYS;
        }
        if (tokenType.equals(IlocTypes.COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(IlocTypes.STRING)) {
            return STRING_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_KEYS;
        }

        return TextAttributesKey.EMPTY_ARRAY;
    }

}
