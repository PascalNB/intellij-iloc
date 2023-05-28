package com.pascalnb.iloc.language.format;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.FormatterUtil;
import com.intellij.psi.tree.IElementType;
import com.pascalnb.iloc.language.psi.IlocFile;
import com.pascalnb.iloc.language.psi.IlocLabeledBlock;
import com.pascalnb.iloc.language.psi.IlocTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class IlocBlock implements ASTBlock {

    private final ASTNode node;
    private final PsiElement psi;
    private final Alignment alignment;
    private final Indent indent;
    private final Wrap wrap;
    private final SpacingBuilder spacingBuilder;

    protected IlocBlock(@NotNull ASTNode node, Alignment alignment, Indent indent, Wrap wrap,
        SpacingBuilder spacingBuilder) {
        this.node = node;
        this.psi = node.getPsi();
        this.alignment = alignment;
        this.indent = indent;
        this.wrap = wrap;
        this.spacingBuilder = spacingBuilder;
    }

    private List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = node.getFirstChildNode();

        while (child != null) {
            IElementType type = child.getElementType();
            if (type != TokenType.WHITE_SPACE && type != IlocTypes.LINEBREAK) {
                Block block = new IlocBlock(child,
                    Alignment.createAlignment(true),
                    Indent.getNoneIndent(),
                    null,
                    spacingBuilder);
                blocks.add(block);
            }
            child = child.getTreeNext();
        }
        return blocks;
    }

    @Override
    public @NotNull TextRange getTextRange() {
        return psi.getTextRange();
    }

    @Override
    public @NotNull List<Block> getSubBlocks() {
        return buildChildren();
    }

    @Override
    public @Nullable Wrap getWrap() {
        return wrap;
    }

    @Override
    public Indent getIndent() {
        return indent;
    }

    @Override
    public @Nullable Alignment getAlignment() {
        return alignment;
    }

    @Override
    public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return node.getFirstChildNode() == null;
    }

    @Override
    public @Nullable String getDebugName() {
        return psi.toString();
    }

    @Override
    public @NotNull ChildAttributes getChildAttributes(int newChildIndex) {
        if (newChildIndex == 0) {
            return new ChildAttributes(Indent.getNoneIndent(), null);
        }
        if (psi instanceof IlocFile || psi instanceof PsiComment || psi instanceof IlocLabeledBlock) {
            return ChildAttributes.DELEGATE_TO_PREV_CHILD;
        }

        if (psi instanceof com.pascalnb.iloc.language.psi.IlocBlock block) {
            int spaces = block.getStartOffsetInParent();
            return new ChildAttributes(Indent.getSpaceIndent(spaces), null);
        }

        return new ChildAttributes(Indent.getNoneIndent(), null);
    }

    @Override
    public boolean isIncomplete() {
        return FormatterUtil.isIncomplete(node);
    }

    @Override
    public @Nullable ASTNode getNode() {
        return node;
    }

}
