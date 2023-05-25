package org.intellij.sdk.language;

import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.psi.IlocFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class IlocUtil {

    public static <T extends PsiElement> List<T> find(IlocFile file, Class<T> clazz, Function<T, String> extractor,
        String key) {

        List<T> result = new ArrayList<>();
        T[] ts = PsiTreeUtil.getChildrenOfType(file, clazz);

        if (ts != null) {
            for (T t : ts) {
                if (key.equals(extractor.apply(t))) {
                    result.add(t);
                }
            }
        }

        return result;
    }

    public static <T extends PsiElement> List<T> find(IlocFile file, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        T[] ts = PsiTreeUtil.getChildrenOfType(file, clazz);

        if (ts != null) {
            result.addAll(Arrays.asList(ts));
        }

        return result;
    }

}
