package com.bosc.assessment.sourceGen.engine;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SourceDescriptor implements Serializable {
    @Override
    public String toString() {
        return "SourceDescriptor{" +
                "tableName='" + tableName + '\'' +
                ", entity='" + entity + '\'' +
                ", entityName='" + entityName + '\'' +
                ", dtoName='" + dtoName + '\'' +
                ", mapperName='" + mapperName + '\'' +
                ", enableImport=" + enableImport +
                ", importTemplateCode='" + importTemplateCode + '\'' +
                ", importTemplateName='" + importTemplateName + '\'' +
                ", importFields=" + importFields +
                ", fieldMap=" + fieldMap +
                ", queryParams=" + queryParams +
                ", exportFields=" + exportFields +
                ", exportFileName='" + exportFileName + '\'' +
                ", packagePrefix='" + packagePrefix + '\'' +
                '}';
    }

    private String tableName;
    private String entity;
    private String entityName;
    private String dtoName;
    private String mapperName;

    private boolean enableImport;
    private String importTemplateCode;
    private String importTemplateName;
    private Map<String, String> importFields;
    private Map<String, String> fieldMap;
    private Map<String, String> queryParams;
    private List<String> exportFields;
    private String exportFileName;

    public boolean isEnableImport() {
        return enableImport;
    }

    public void setEnableImport(boolean enableImport) {
        this.enableImport = enableImport;
    }

    private String packagePrefix;

    public String getPackagePrefix() {
        return packagePrefix;
    }

    public void setPackagePrefix(String packagePrefix) {
        this.packagePrefix = packagePrefix;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }

    public String getDtoName() {
        return dtoName;
    }

    public void setDtoName(String dtoName) {
        this.dtoName = dtoName;
    }

    public String getImportTemplateCode() {
        return importTemplateCode;
    }

    public void setImportTemplateCode(String importTemplateCode) {
        this.importTemplateCode = importTemplateCode;
    }

    public String getImportTemplateName() {
        return importTemplateName;
    }

    public void setImportTemplateName(String importTemplateName) {
        this.importTemplateName = importTemplateName;
    }

    public Map<String, String> getImportFields() {
        return importFields;
    }

    public void setImportFields(Map<String, String> importFields) {
        this.importFields = importFields;
    }

    public Map<String, String> getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(Map<String, String> fieldMap) {
        this.fieldMap = fieldMap;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public List<String> getExportFields() {
        return exportFields;
    }

    public void setExportFields(List<String> exportFields) {
        this.exportFields = exportFields;
    }

    public String getExportFileName() {
        return exportFileName;
    }

    public void setExportFileName(String exportFileName) {
        this.exportFileName = exportFileName;
    }
}
