package org.intellij.sdk.language.reference;

import com.intellij.model.Pointer;
import com.intellij.platform.backend.documentation.DocumentationResult;
import com.intellij.platform.backend.documentation.DocumentationTarget;
import com.intellij.platform.backend.documentation.PsiDocumentationTargetProvider;
import com.intellij.platform.backend.presentation.TargetPresentation;
import com.intellij.psi.PsiElement;
import org.intellij.sdk.language.functions.IlocDefaultFunctions;
import org.intellij.sdk.language.functions.IlocFunctionDeclaration;
import org.intellij.sdk.language.psi.IlocFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IlocDocumentationProvider implements PsiDocumentationTargetProvider {

    @Override
    public @Nullable DocumentationTarget documentationTarget(@NotNull PsiElement element,
        @Nullable PsiElement originalElement) {

        if (element instanceof IlocFunction function) {
            String name = function.getName();
            IlocFunctionDeclaration declaration = IlocDefaultFunctions.get(name);

            if (declaration == null) {
                return null;
            }

            return new IlocDocumentationTarget(declaration);
        }
        return null;
    }

    private static @NotNull String getDoc(IlocFunctionDeclaration declaration) {
        String unofficial = declaration.isUnofficial() ? "(unofficial)<br>" : "";
        return String.format("<h2>%s</h2>%s<b>%s</b><br>%s",
            declaration.getName(), unofficial, declaration.getSignature(), declaration.getDocumentation());
    }

    @SuppressWarnings("UnstableApiUsage")
    private static final class IlocDocumentationTarget implements DocumentationTarget {

        private final IlocFunctionDeclaration declaration;
        private final String doc;

        private IlocDocumentationTarget(IlocFunctionDeclaration declaration) {
            this.declaration = declaration;
            this.doc = getDoc(declaration);
        }

        @Override
        public @NotNull DocumentationResult computeDocumentation() {
            return DocumentationResult.documentation(doc);
        }

        @Nullable
        @Override
        public String computeDocumentationHint() {
            return doc;
        }

        @NotNull
        @Override
        public TargetPresentation computePresentation() {
            return TargetPresentation.builder(declaration.getName()).presentation();
        }

        @NotNull
        @Override
        public Pointer<? extends DocumentationTarget> createPointer() {
            return () -> this;
        }

    }

}
