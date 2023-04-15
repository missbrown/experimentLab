package source.engine.generator;

import source.engine.SourceDescriptor;

public class JsWritter {
    
    public static String productJs(SourceDescriptor sd) {
        StringBuilder sb = new StringBuilder();
        sb.append("const accountingFormatter = _common.accountingFormatter");
        sb.append("\nconst resource = {");
        sb.append("\n\ttable: {");
        sb.append("\n\t\tlistTable: {");
        sb.append("\n\t\t\tid: 'listTable',");
        sb.append("\n\t\t\tgetParam: () => {");
        sb.append("\n\t\t\tconst dataTimeStr = $('#dataTime').datebox('getValue');");
        sb.append("\n\t\t\tconst subBranchOrg = $('#subBranchOrg').combobox('getValue');");
        sb.append("\n\t\t\tconst teamId = $('#teamId').combobox('getValue');");
        sb.append("\n\t\t\tconst teamId = $('#teamCode').combobox('getValue');");

        return sb.toString();
    }
}
