package org.intellij.sdk.language.reference;

import com.intellij.lang.parameterInfo.CreateParameterInfoContext;
import com.intellij.lang.parameterInfo.ParameterInfoHandler;
import com.intellij.lang.parameterInfo.ParameterInfoUIContext;
import com.intellij.lang.parameterInfo.UpdateParameterInfoContext;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.functions.IlocDefaultFunctions;
import org.intellij.sdk.language.functions.IlocFunctionDeclaration;
import org.intellij.sdk.language.psi.IlocFunction;
import org.intellij.sdk.language.psi.IlocOperation;
import org.intellij.sdk.language.psi.IlocTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class IlocParameterInfoHandler implements ParameterInfoHandler<PsiElement, IlocFunction> {

    @Override
    public @Nullable IlocOperation findElementForParameterInfo(@NotNull CreateParameterInfoContext context) {
        IlocOperation operation = getOperation(context.getFile(), context.getOffset());
        if (operation == null) {
            return null;
        }

        IlocFunction function = operation.getFunction();

        if (!IlocDefaultFunctions.exists(function.getName())) {
            return null;
        }

        context.setItemsToShow(new Object[]{function});
        context.setHighlightedElement(operation);
        return operation;
    }

    @Override
    public void showParameterInfo(@NotNull PsiElement element, @NotNull CreateParameterInfoContext context) {
        context.showHint(element, context.getOffset(), this);
    }

    @Override
    public @Nullable IlocOperation findElementForUpdatingParameterInfo(@NotNull UpdateParameterInfoContext context) {
        IlocOperation operation = getOperation(context.getFile(), context.getOffset());
        if (operation == null) {
            return null;
        }

        IlocFunction function = operation.getFunction();

        if (!IlocDefaultFunctions.exists(function.getName())) {
            return null;
        }

        return operation;
    }

    @Override
    public void updateParameterInfo(@NotNull PsiElement operation, @NotNull UpdateParameterInfoContext context) {
        context.setCurrentParameter(0);
    }

    @Override
    public void updateUI(IlocFunction p, @NotNull ParameterInfoUIContext context) {
        if (p == null) {
            context.setUIComponentEnabled(false);
            return;
        }

        IlocFunctionDeclaration declaration = Objects.requireNonNull(IlocDefaultFunctions.get(p.getName()));

        context.setupUIComponentPresentation(declaration.getSignature(), 0, 0,
                false, false, false, context.getDefaultParameterColor());
    }

    private static @Nullable IlocOperation getOperation(PsiFile file, int offset) {
        PsiElement element = file.findElementAt(offset);
        if (element == null && offset > 0) {
            element = file.findElementAt(offset - 1);
        }

        while (element instanceof PsiWhiteSpace
                || element != null && IlocTypes.LINEBREAK.equals(element.getNode().getElementType())) {
            int nOffset = element.getTextOffset() - 1;
            if (nOffset > 0) {
                element = file.findElementAt(nOffset);
            } else {
                return null;
            }
        }

        return PsiTreeUtil.getParentOfType(element, IlocOperation.class);
    }

}
