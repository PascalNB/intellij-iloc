package com.pascalnb.iloc.executor;

import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.pascalnb.iloc.language.IlocIcons;

public class IlocConfigurationType extends ConfigurationTypeBase {

    public IlocConfigurationType() {
        super("iloc-configuration", "Run ILOC", null, IlocIcons.FILE);
        addFactory(new IlocConfigurationFactory(this));
    }

}
