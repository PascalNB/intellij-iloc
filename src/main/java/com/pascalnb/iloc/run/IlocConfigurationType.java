package com.pascalnb.iloc.run;

import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.pascalnb.iloc.language.IlocIcons;

public class IlocConfigurationType extends ConfigurationTypeBase {

    public IlocConfigurationType() {
        super("iloc-configuration", "Run ILOC", null, IlocIcons.FILE);
        IlocConfigurationFactory.setType(this);
        addFactory(IlocConfigurationFactory.getInstance());
    }

}
