package org.intellij.sdk.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.intellij.sdk.language.parser.IlocParser;
import org.intellij.sdk.language.psi.IlocFile;
import org.intellij.sdk.language.psi.IlocTokenSets;
import org.intellij.sdk.language.psi.IlocTypes;
import org.jetbrains.annotations.NotNull;

public class IlocParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(IlocLanguage.INSTANCE);

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new IlocLexerAdapter();
    }

    @Override
    public @NotNull PsiParser createParser(Project project) {
        return new IlocParser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return IlocTokenSets.COMMENTS;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return IlocTokenSets.STRINGS;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        return IlocTypes.Factory.createElement(node);
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new IlocFile(viewProvider);
    }

}
