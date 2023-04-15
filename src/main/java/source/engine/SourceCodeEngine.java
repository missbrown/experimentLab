package source.engine;

import com.google.gson.Gson;

import source.engine.generator.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class SourceCodeEngine {

    public static void generate() throws Exception {
        init(read("/sourceTemplate.json"));
    }

    public static SourceDescriptor read(String path) throws Exception {
        File file = new File(path);
        try(Scanner scanner = new Scanner(file);) {
            if(file.exists()) {
                StringBuffer sb = new StringBuffer();
                while(scanner.hasNextLine()) {
                    sb.append(scanner.nextLine());
                }
                String json = sb.toString();
                json = json.trim();
                SourceDescriptor sourceDescriptor = new Gson().fromJson(json, SourceDescriptor.class);
                return sourceDescriptor;
            }
        } catch(Exception ex) {
            throw ex;
        }
        return null;
    }

    public static void init(SourceDescriptor sourceDescriptor) {
        sourceDescriptor.setEntityName(sourceDescriptor.getEntity());
        sourceDescriptor.setDtoName(sourceDescriptor.getEntity() + "Dto");
        sourceDescriptor.setMapperName(sourceDescriptor.getEntity() + "Mapper");
        String path = "D:\\projects\\workflowTest\\src\\main\\java\\com\\bosc\\assessment\\domain\\" + sourceDescriptor.getPackagePrefix();
        sourceDescriptor.setPackagePrefix("com.bosc.assessment.domain." + sourceDescriptor.getPackagePrefix());
        String entityFileString = EntityWriter.produceEntityString(sourceDescriptor);
        String dtoFileString = DtoWritter.produceDtoString(sourceDescriptor);
        String mapperFileString = MapperWritter.produceMapperInterface(sourceDescriptor);
        String serviceFileString = ServiceWritter.produceService(sourceDescriptor);
        String jsFileString = JsWritter.productJs(sourceDescriptor);
        String controllerFileString = ControllerWritter.produceController(sourceDescriptor);
        String xmlFileString = MapperWritter.produceMapperXml(sourceDescriptor);
        String sqlString = SqlWritter.generateTABLESQL(sourceDescriptor);
        writeFile(path + "\\" + sourceDescriptor.getEntityName() + ".java", entityFileString);
        writeFile(path + "\\" + sourceDescriptor.getDtoName() + ".java", dtoFileString);
        writeFile(path + "\\" + sourceDescriptor.getMapperName() + ".java", mapperFileString);
        writeFile(path + "\\" + sourceDescriptor.getEntity() + "Service.java", serviceFileString);
        writeFile(path + "\\" + sourceDescriptor.getEntity() + "Controller.java", controllerFileString);
        writeFile(path + "\\" + sourceDescriptor.getMapperName() + ".xml", xmlFileString);
        writeFile(path + "\\" + sourceDescriptor.getTableName() + ".sql", sqlString);
        writeFile(path + "\\" + sourceDescriptor.getEntity() + ".js", jsFileString);
    }

    public static void writeFile(String fileName, String content) {
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(fileName)))) {
            pw.print(content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
