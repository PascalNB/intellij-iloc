package org.intellij.sdk.language.editor;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.intellij.sdk.language.IlocIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class IlocColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
        new AttributesDescriptor("Identifier", IlocSyntaxHighlighter.IDENTIFIER),
        new AttributesDescriptor("Register", IlocSyntaxHighlighter.REGISTER),
        new AttributesDescriptor("Function", IlocSyntaxHighlighter.FUNCTION),
        new AttributesDescriptor("Label", IlocSyntaxHighlighter.LABEL),
        new AttributesDescriptor("Integer", IlocSyntaxHighlighter.INTEGER),
        new AttributesDescriptor("Comment", IlocSyntaxHighlighter.COMMENT),
        new AttributesDescriptor("Variable", IlocSyntaxHighlighter.VARIABLE),
        new AttributesDescriptor("Operator", IlocSyntaxHighlighter.OPERATOR),
        };

    @Override
    public @Nullable Icon getIcon() {
        return IlocIcons.FILE;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new IlocSyntaxHighlighter();
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        return """
            label:  function r_1, @a => r_3  // comment
                    functionI r_1, 5 => r_1
                    function r_1 -> label, label2
            label2: out "bla bla ", r_2
            """;
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull String getDisplayName() {
        return "ILOC";
    }

}
