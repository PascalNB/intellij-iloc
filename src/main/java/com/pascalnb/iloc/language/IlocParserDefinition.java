package com.pascalnb.iloc.language;

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
import com.pascalnb.iloc.language.parser.IlocParser;
import com.pascalnb.iloc.language.psi.IlocFile;
import com.pascalnb.iloc.language.psi.IlocTokenSets;
import com.pascalnb.iloc.language.psi.IlocTypes;
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
        return TokenSet.EMPTY;
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
