package org.intellij.sdk.language;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.language.psi.IlocFunction;
import org.intellij.sdk.language.psi.IlocTypes;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;

import static com.intellij.patterns.PlatformPatterns.psiElement;

public class IlocCompletionContributor extends CompletionContributor {

    public IlocCompletionContributor() {
        extend(CompletionType.BASIC, psiElement(IlocTypes.ID), new IlocCompletionProvider());
    }

    private static class IlocCompletionProvider extends CompletionProvider<CompletionParameters> {

        @Override
        protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context,
            @NotNull CompletionResultSet result) {

            PsiElement element = parameters.getPosition();
            PsiElement parent = element.getParent();

            if (parent instanceof IlocFunction function && function.getId() == element) {
                result.addAllElements(FUNCTION_ELEMENTS);
            }
        }

    }

    private static final Collection<? extends LookupElement> FUNCTION_ELEMENTS;
    private static final String[] FUNCTIONS = new String[]{
        "nop", "add", "sub", "mult", "div", "addI", "rsubI", "multI", "divI", "rdivI", "lshift", "lshiftI", "rshift",
        "rshiftI", "or", "orI", "and", "andI", "xor", "xorI", "loadI", "load", "loadAI", "loadAO", "cload", "cloadAI",
        "cloadAO", "store", "storeAI", "storeAO", "cstore", "cstoreAI", "cstoreAO", "i2i", "c2c", "c2i", "i2c",
        "cmp_LT", "cmp_LE", "cmp_EQ", "cmp_GE", "cmp_GT", "cmp_NE", "cbr", "jumpI", "jump", "tbl", "push", "pop",
        "cpush", "cpop", "in", "out", "cin", "cout"
    };

    static {
        FUNCTION_ELEMENTS = Arrays.stream(FUNCTIONS)
            .map(f -> LookupElementBuilder.create(f).withIcon(IlocIcons.FUNCTION))
            .toList();
    }

}
