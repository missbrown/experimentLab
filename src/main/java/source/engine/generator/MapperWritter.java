package source.engine.generator;

import com.bosc.assessment.util.CommonUtil;

import source.engine.SourceDescriptor;

public class MapperWritter {
    
    public static String produceMapperInterface(SourceDescriptor sd) {
        StringBuilder sb = new StringBuilder();
        sb.append("package " + sd.getPackagePrefix() + ";");
        sb.append("\n\nimport java.util.Date;");
        sb.append("\nimport java.util.List;");
        sb.append("\nimport org.apache.ibatis.annotations.Param;");
        sb.append("\n\npublic interface " + sd.getMapperName() + " {");
        sb.append("\n\n\tvoid insert(" + sd.getEntityName() + " entity);");
        sb.append("\n\tvoid delete(@Param(\"dataTime\") Date dataTime);");
        sb.append("\n\tvoid deleteById(@Param(\"id\") Long id);");
        // sb.append("\n\t" + sd.getEntityName() + " getById(@Param(\"id\") Long id);");
        sb.append("\n\tList<" + sd.getDtoName() + "> getList(@Param(\"query\") " + sd.getDtoName() + " query" + ");");
        sb.append("\n\n}");
        return sb.toString();
    }

    public static String produceMapperXml(SourceDescriptor sd) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("\n<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
        sb.append("\n<mapper namespace=\"com.bosc.assessment." + sd.getMapperName() + "\">");
        // get list
        sb.append("\n\t<select id=\"getList\" resultType=\"" + sd.getPackagePrefix() + "." + sd.getDtoName() + "\">");
        sb.append("\n\t\tselect t.id,");
        StringBuilder columnSb = new StringBuilder();
        StringBuilder conditionSb = new StringBuilder();
        String whiteSpace = "\n\t\t";
        for(String fieldName : sd.getFieldMap().keySet()) {
            String fieldType = sd.getFieldMap().get(fieldName);
            columnSb.append(whiteSpace + "t." + CommonUtil.toUnderscore(fieldName) + " " + fieldName + ",");
            if(!fieldName.equals("dataTime")) {
                conditionSb.append(whiteSpace + "<if test=\"query." + fieldName + " != null");
                if("String".equals(fieldType)) {
                    conditionSb.append(" and query." + fieldName + " != ''");
                } else if("Integer".equals(fieldType)) {
                    conditionSb.append(" and query." + fieldName + " != -1");
                }
                conditionSb.append("\">");
                conditionSb.append(whiteSpace + "\t and " + CommonUtil.toUnderscore(fieldName) + " = #{query." + fieldName + "}");
                conditionSb.append(whiteSpace + "</if>");
            }
        }
        sb.append(columnSb);
        sb.append("\n\t\tfrom " + sd.getTableName() + " t");
        sb.append("\n\t\twhere data_time = #{query.dataTime}");
        sb.append(conditionSb);
        sb.append("\n\t</select>");
        // insert
        sb.append("\n\n\t<insert id=\"insert\" parameterType=\"" + sd.getPackagePrefix() + "." + sd.getDtoName() + "\">");
        sb.append("\n\t\tinsert into " + sd.getTableName() + " (");
        StringBuilder insertColumnSb = new StringBuilder();
        StringBuilder insertFieldSb = new StringBuilder();
        whiteSpace = "\n\t\t";
        insertColumnSb.append(whiteSpace + "\tid,");
        for(String fieldName : sd.getFieldMap().keySet()) {
            String fieldType = sd.getFieldMap().get(fieldName);
            insertColumnSb.append(whiteSpace + "\t" + CommonUtil.toUnderscore(fieldName) + ",");
            insertFieldSb.append(whiteSpace + "\t#{" + fieldName);
            if("String".equals(fieldType)) {
                insertFieldSb.append(", jdbcType=VARCHAR");
            } else if("Integer".equals(fieldType)) {
                insertFieldSb.append(", jdbcType=INTEGER");
            }
            insertFieldSb.append("},");
        }
        sb.append(insertColumnSb);
        sb.append("\n\t\t)");
        sb.append("\n\t\tvalues (");
        sb.append("\n\t\t\t" + sd.getTableName() + "_seq.nextval,");
        sb.append(insertFieldSb);
        sb.append("\n\t\t)");
        sb.append("\n\t</insert>");
        // delete
        sb.append("\n\n\t<delete id=\"delete\">");
        sb.append("\n\t\tdelete from " + sd.getTableName() + " where dataTime = #{dataTime}");
        sb.append("\n\t</delete>");
        // delete by id
        sb.append("\n\n\t<delete id=\"deleteById\">");
        sb.append("\n\t\tdelete from " + sd.getTableName() + " where id = #{id}");
        sb.append("\n\t</delete>");
        sb.append("\n\n</mapper>");
        return sb.toString();
    }
}
