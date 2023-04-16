package com.bosc.assessment.sourceGen.engine.generator;

import java.util.Map;

public class GetterAndSetter {
    
    public static void initGetterAndSetter(Map<String, String> fieldMap, StringBuilder sb) {
        for(String fieldName: fieldMap.keySet()) {
            String fieldType = fieldMap.get(fieldName);
            String fieldNameWithFirstUpper = fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
            sb.append("\n\tpublic " + fieldType + " get"
                    + fieldNameWithFirstUpper + "() {"
                    + "\n\t\treturn this." + fieldName + ";"
                    + "\n\t}");
            sb.append("\n");
            sb.append("\n\tpublic void set" + fieldNameWithFirstUpper
                    + "(" + fieldType + " " + fieldName + ") {"
                    + "\n\t\tthis." + fieldName + " = " + fieldName + ";"
                    + "\n\t}");
            sb.append("\n");
        }
    }
    
}
