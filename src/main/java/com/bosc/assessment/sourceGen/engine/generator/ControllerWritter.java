package com.bosc.assessment.sourceGen.engine.generator;

import com.bosc.assessment.sourceGen.engine.SourceDescriptor;

public class ControllerWritter {
    
    public static String produceController(SourceDescriptor sd) {
        StringBuilder sb = new StringBuilder();
        sb.append("package " + sd.getPackagePrefix() + ";");
        sb.append("\n\nimport org.springframework.beans.factory.annotation.Autowired;");
        sb.append("\nimport org.springframework.web.bind.annotation.RestController;");
        sb.append("\nimport org.springframework.web.bind.annotation.RequestMapping;");
        sb.append("\nimport com.bosc.assessment.dto.PageResultDto;");
        sb.append("\nimport com.bosc.assessment.dto.ResponseDto;");
        sb.append("\n\n@RestController");
        sb.append("\n@RequestMapping(\"/" + sd.getEntity() + "\")");
        sb.append("\npublic class " + sd.getEntity() + "Controller {");
        sb.append("\n\n\t@Autowired");
        sb.append("\n\t" + sd.getEntity() + "Service service" + ";");
        sb.append("\n\n\tpublic ResponseDto<PageResultDto<"
                + sd.getDtoName()
                + ">> getPagedList("
                + sd.getDtoName() + " query, int page, int rows) {");
        sb.append("\n\t\tResponseDto<PageResultDto<"
                + sd.getDtoName()
                + ">> response = new ResponseDto<>();"
                + ";");
        sb.append("\n\t\tresponse.setData(service.getPagedList(query, page, rows));");
        sb.append("\n\t\tresponse.success();");
        sb.append("\n\t\treturn response;");
        sb.append("\n\t}");
        sb.append("\n\n}");
        return sb.toString();
    }
}
