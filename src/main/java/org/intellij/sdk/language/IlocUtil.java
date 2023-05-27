package org.intellij.sdk.language;

import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.psi.IlocFile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class IlocUtil {

    public static <T extends PsiElement> List<PsiElement> find(IlocFile file, Class<T> clazz,
        Function<PsiElement, String> extractor, String key) {

        List<PsiElement> result = new ArrayList<>();
        Collection<PsiElement> ts = PsiTreeUtil.findChildrenOfType(file, clazz);

        for (PsiElement t : ts) {
            if (key.equals(extractor.apply(t))) {
                result.add(t);
            }
        }

        return result;
    }

    public static <T extends PsiElement> Collection<PsiElement> find(IlocFile file, Class<T> clazz) {
        return PsiTreeUtil.findChildrenOfType(file, clazz);
    }

}
