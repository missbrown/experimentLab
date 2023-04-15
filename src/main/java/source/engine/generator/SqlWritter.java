package source.engine.generator;

import com.bosc.assessment.util.CommonUtil;

import source.engine.SourceDescriptor;

public class SqlWritter {
    
    public static String generateTABLESQL(SourceDescriptor sd) {
        StringBuilder sb = new StringBuilder();
        sb.append("create table jc_t_off_balance (");
        sb.append("\n\tid integer not null,");
        for(String fieldName : sd.getFieldMap().keySet()) {
            String fieldType = sd.getFieldMap().get(fieldName);
            sb.append("\n\t" + CommonUtil.toUnderscore(fieldName) + " ");
            if(fieldType.equals("String")) {
                sb.append("varchar2(50),");
            } else if(fieldType.equals("Integer")) {
                sb.append("integer,");
            } else if(fieldType.equals("Double")) {
                sb.append("number(26, 6),");
            }
        }
        sb.append("\n\tcreator integer,");
        sb.append("\n\tcreate time date default sysdate");
        sb.append("\n);");
        // add constraint
        sb.append("\nalter table " + sd.getTableName() + " add constraint " + sd.getTableName() + "_pk primary key (id);");
        // sequence
        sb.append("\ncreate sequence " + sd.getTableName() + "_seq");
        sb.append("\nminvalue 1");
        sb.append("\nmaxvalue 99999999999999");
        sb.append("\nstart with 1");
        sb.append("\nincrement by 1;");
        return sb.toString();
    }
}
