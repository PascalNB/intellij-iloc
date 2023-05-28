package com.pascalnb.iloc.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.pascalnb.iloc.language.IlocFileType;

public class IlocElementFactory {

    @SuppressWarnings("unchecked")
    public static <T> T create(Project project, String name) {
        IlocFile file = createFile(project, name);
        return (T) file.getFirstChild();
    }

    public static IlocFile createFile(Project project, String text) {
        String name = "dummy.iloc";
        return (IlocFile) PsiFileFactory.getInstance(project).createFileFromText(name, IlocFileType.INSTANCE, text);
    }

}
