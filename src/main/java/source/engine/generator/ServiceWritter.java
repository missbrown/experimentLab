package source.engine.generator;

import source.engine.SourceDescriptor;

public class ServiceWritter {
    
    public static String produceService(SourceDescriptor sd) {
        StringBuilder sb = new StringBuilder();
        sb.append("package " + sd.getPackagePrefix() + ";");
        sb.append("\n\nimport java.util.Date;");
        sb.append("\nimport java.util.List;");
        sb.append("\nimport com.bosc.assessment.dto.PageResultDto;");
        sb.append("\nimport com.bosc.assessment.util.BusinessException;");
        sb.append("\nimport com.bosc.assessment.util.ReturnCode;");
        sb.append("\nimport com.bosc.assessment.util.CommonUtil;");
        sb.append("\nimport com.github.pagehelper.PageHelper;");
        sb.append("\nimport com.github.pagehelper.PageInfo;");
        sb.append("\nimport org.springframework.beans.factory.annotation.Autowired;");
        sb.append("\nimport org.springframework.stereotype.Service;");
        sb.append("\nimport org.springframework.transaction.annotation.Transactional;");
        sb.append("\nimport org.springframework.util.StringUtils;");
        sb.append("\n\n@Service");
        sb.append("\npublic class " + sd.getEntity() + "Service {");
        sb.append("\n\n\t@Autowired");
        sb.append("\n\t" + sd.getMapperName() + " mapper" + ";");
        sb.append("\n\n\t@Transactional(readOnly = true)");
        sb.append("\n\tpublic PageResultDto<" + sd.getDtoName()
                + "> getPagedList("
                + sd.getDtoName() + " query,"
                + " int page, int rows) {");
        sb.append("\n\t\tPageHelper.startPage(page, rows);");
        sb.append("\n\t\tList<" + sd.getDtoName() + "> list = getList(query);");
        sb.append("\n\t\tPageInfo<" + sd.getDtoName() + "> pageInfo = new PageInfo<>(list);");
        sb.append("\n\t\treturn new PageResultDto(pageInfo.getTotal(), initDto(list));");
        sb.append("\n\t}");
        sb.append("\n\n\tpublic List<" + sd.getDtoName() + "> getList("+ sd.getDtoName() + " query) {");
        sb.append("\n\t\tif(query.getDataTime() == null) {");
        sb.append("\n\t\t\tif(StringUtils.hasText(query.getDataTimeStr())) {");
        sb.append("\n\t\t\t\tquery.setDataTime(CommonUtil.parseDateString(query.getDataTimeStr()));");
        sb.append("\n\t\t\t} else {");
        sb.append("\n\t\t\t\tthrow new BusinessException(ReturnCode.ILLEGAL_ARGUMENT);");
        sb.append("\n\t\t\t}");
        sb.append("\n\t\t}");
        sb.append("\n\t\treturn mapper.getList(query);");
        sb.append("\n\t}");
        sb.append("\n\n\tpublic List<" + sd.getDtoName() + "> initDto(List<" + sd.getDtoName() + "> list) {");
        sb.append("\n\t\tfor(" + sd.getDtoName() + " dto: list) {");
        sb.append("\n\t\t\tdto.setDataTimeStr(CommonUtil.formatDate(dto.getDataTime()));");
        sb.append("\n\t\t}");
        sb.append("\n\t\treturn list;");
        sb.append("\n\t}");
        // import
        sb.append("\n\n\tpublic void importFromFile(");
        sb.append(") {");
        sb.append("\n\t}");
        sb.append("\n\n}");
        return sb.toString();
    }
}
