package org.intellij.sdk.language;

import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class IlocUtil {

    public static <T extends PsiElement> boolean exists(PsiElement file, Class<T> clazz,
        Function<T, String> extractor, String key) {

        Collection<T> ts = PsiTreeUtil.findChildrenOfType(file, clazz);
        for (T t : ts) {
            if (key.equals(extractor.apply(t))) {
                return true;
            }
        }

        return false;
    }

    public static <T extends PsiElement> List<PsiElement> find(PsiElement file, Class<T> clazz,
        Function<T, String> extractor, String key) {

        List<PsiElement> result = new ArrayList<>();
        Collection<T> ts = PsiTreeUtil.findChildrenOfType(file, clazz);

        for (T t : ts) {
            if (key.equals(extractor.apply(t))) {
                result.add(t);
            }
        }

        return result;
    }

    public static <T extends PsiElement> Collection<PsiElement> find(PsiElement file, Class<T> clazz) {
        return PsiTreeUtil.findChildrenOfType(file, clazz);
    }

}
