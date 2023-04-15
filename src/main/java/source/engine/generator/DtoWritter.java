package source.engine.generator;

import java.util.HashMap;
import java.util.Map;

import source.engine.SourceDescriptor;

public class DtoWritter {
    
    public static String produceDtoString(SourceDescriptor sd) {
        StringBuilder sb = new StringBuilder();
        sb.append("package " + sd.getPackagePrefix() + ";");
        sb.append("\n\nimport java.util.Date;");
        sb.append("\n\npublic class " + sd.getDtoName() + " {");
        Map<String, String> dtoFieldMap = new HashMap<>();
        dtoFieldMap.putAll(sd.getFieldMap());
        for(String fieldName: sd.getFieldMap().keySet()) {
            String fieldType = sd.getFieldMap().get(fieldName);
            sb.append("\n\tprivate " + fieldType + " " + fieldName + ";");
            if(fieldName.equals("dataTime")) {
                sb.append("\n\tprivate String " + fieldName + "Str;");
                dtoFieldMap.put("dataTimeStr", "String");
            }
        }
        sb.append("\n");
        GetterAndSetter.initGetterAndSetter(dtoFieldMap, sb);
        sb.append("\n\n}");
        return sb.toString(); 
    }
}
