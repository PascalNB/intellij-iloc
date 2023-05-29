package com.pascalnb.iloc.executor;

import com.intellij.execution.configurations.LocatableRunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;

public class IlocConfigurationOptions extends LocatableRunConfigurationOptions {

    private final StoredProperty<String> name = string("").provideDelegate(this, "fileName");

    public String getFileName() {
        return name.getValue(this);
    }

    public void setFileName(String name) {
        this.name.setValue(this, name);
    }

}
