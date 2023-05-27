package org.intellij.sdk.language;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.intellij.sdk.language.editor.IlocSyntaxHighlighter;
import org.intellij.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class IlocAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        PsiFile file = element.getContainingFile();
        PsiElement parent = element.getParent();
        if (parent instanceof IlocFunction func && func.getId() == element) {
            highlight(holder, element, IlocSyntaxHighlighter.FUNCTION);
            return;
        }

        if (parent instanceof IlocLabel label && label.getLabeldecl() == element) {
            highlight(holder, element, IlocSyntaxHighlighter.LABEL);
            String name = label.getName();

            List<PsiElement> found = IlocUtil.find(file, IlocLabel.class, IlocLabel::getName, name);
            if (!found.isEmpty() && found.get(0) != label) {
                annotate(holder, element, HighlightSeverity.WARNING, "Label has already been declared");
            }

            if (!IlocUtil.exists(file, IlocLabelRef.class, IlocLabelRef::getText, name)) {
                annotate(holder, element, HighlightSeverity.WEAK_WARNING, "Label is unused");
            }

            return;
        }

        if (parent instanceof IlocLabelRef label && label.getId() == element) {
            highlight(holder, element, IlocSyntaxHighlighter.LABEL);

            List<PsiElement> found = IlocUtil.find(file, IlocLabel.class, IlocLabel::getName, label.getText());
            if (found.isEmpty()) {
                annotate(holder, element, HighlightSeverity.WARNING, "Label has not been declared");
            }

            return;
        }

        if (parent instanceof IlocRegister register && register.getId() == element) {
            highlight(holder, element, IlocSyntaxHighlighter.REGISTER);
        }

        if (parent instanceof IlocRegisterRef register && register.getId() == element) {
            highlight(holder, element, IlocSyntaxHighlighter.REGISTER);
        }

        if (parent instanceof IlocVariable variable && variable.getId() == element) {
            highlight(holder, element, IlocSyntaxHighlighter.VARIABLE);

            String name = variable.getName();
            List<PsiElement> found = IlocUtil.find(file, IlocVariable.class, IlocVariable::getName, name);
            if (!found.isEmpty() && found.get(0) != variable) {
                annotate(holder, element, HighlightSeverity.WARNING, "Variable has already been declared");
            }

            if (!IlocUtil.exists(file, IlocVariableRef.class, IlocVariableRef::getText, name)) {
                annotate(holder, element, HighlightSeverity.WEAK_WARNING, "Variable is unused");
            }
        }

        if (parent instanceof IlocVariableRef) {
            highlight(holder, element, IlocSyntaxHighlighter.VARIABLE);
        }

    }

    private void highlight(AnnotationHolder holder, PsiElement range, TextAttributesKey attributesKey) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(range)
            .textAttributes(attributesKey)
            .create();
    }

    private void annotate(AnnotationHolder holder, PsiElement range, HighlightSeverity severity, String message) {
        holder.newAnnotation(severity, message)
            .range(range)
            .create();
    }

}
