package org.intellij.sdk.language.editor;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiElement;
import org.intellij.sdk.language.psi.IlocFunction;
import org.intellij.sdk.language.psi.IlocLabel;
import org.intellij.sdk.language.psi.IlocRegister;
import org.jetbrains.annotations.NotNull;

public class IlocAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        PsiElement parent = element.getParent();
        if (parent instanceof IlocFunction func && func.getId() == element) {
            highlight(holder, element, IlocSyntaxHighlighter.FUNCTION);
            return;
        }

        if (parent instanceof IlocLabel label && label.getId() == element) {
            highlight(holder, element, IlocSyntaxHighlighter.LABEL);
            return;
        }

        if (parent instanceof IlocRegister register && register.getId() == element) {
            highlight(holder, element, IlocSyntaxHighlighter.REGISTER);
        }

    }

    private void highlight(AnnotationHolder holder, PsiElement range, TextAttributesKey attributesKey) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(range)
            .textAttributes(attributesKey)
            .create();
    }

}
