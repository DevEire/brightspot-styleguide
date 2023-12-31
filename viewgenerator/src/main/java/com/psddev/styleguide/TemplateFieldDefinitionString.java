package com.psddev.styleguide;

import java.util.Collections;
import java.util.List;
import java.util.Set;

class TemplateFieldDefinitionString extends TemplateFieldDefinition {

    private boolean isAutoGeneratedText;

    public TemplateFieldDefinitionString(TemplateDefinitions templateDefinitions, String parentTemplate, String name, List<JsonObject> values, Set<String> mapTemplates, String javaClassNamePrefix) {
        super(templateDefinitions, parentTemplate, name, values, mapTemplates, javaClassNamePrefix);

        values.forEach((value) -> {
            if (value instanceof JsonString) {
                String string = ((JsonString) value).getValue();

                // ignoring this for now...
                if (string.startsWith("{{")) {
                    isAutoGeneratedText = true;
                }
            }
        });
    }

    @Override
    public String getJavaFieldType(Set<String> imports) {
        //return isAutoGeneratedText ? "Object" : "String";
        return "Object";
    }

    @Override
    public Set<String> getValueTypes() {
        return Collections.singleton("java.lang.String");
    }
}
