package org.intellij.sdk.language.format;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.psi.PsiElement;
import org.intellij.sdk.language.IlocUtil;
import org.intellij.sdk.language.psi.IlocBlock;
import org.intellij.sdk.language.psi.IlocLabeledBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IlocFoldingBuilder extends FoldingBuilderEx {

    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document,
        boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();
        Collection<PsiElement> elements = IlocUtil.find(root, IlocLabeledBlock.class);

        for (PsiElement element : elements) {
            IlocLabeledBlock labeledBlock = (IlocLabeledBlock) element;
            IlocBlock block = labeledBlock.getBlock();
            if (block == null || block.getChildren().length < 2) {
                continue;
            }
            FoldingDescriptor descriptor = new FoldingDescriptor(block.getNode(), block.getTextRange());
            descriptors.add(descriptor);
        }

        return descriptors.toArray(new FoldingDescriptor[0]);
    }

    @Override
    public @Nullable String getPlaceholderText(@NotNull ASTNode node) {
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }

}
