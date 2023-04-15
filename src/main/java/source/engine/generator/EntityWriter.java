package source.engine.generator;

import source.engine.SourceDescriptor;

public class EntityWriter {
    
    public static String produceEntityString(SourceDescriptor sd) {
        StringBuilder sb = new StringBuilder();
        sb.append("package " + sd.getPackagePrefix() + ";");
        sb.append("\n\nimport java.util.Date;");
        sb.append("\n\npublic class " + sd.getEntityName() + " {");
        for(String fieldName: sd.getFieldMap().keySet()) {
            String fieldType = sd.getFieldMap().get(fieldName);
            sb.append("\n\tprivate " + fieldType + " " + fieldName + ";");
        }
        sb.append("\n");
        GetterAndSetter.initGetterAndSetter(sd.getFieldMap(), sb);
        sb.append("\n\n}");
        return sb.toString();
    }
}
