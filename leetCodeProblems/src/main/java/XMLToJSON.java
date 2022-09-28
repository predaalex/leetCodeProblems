import org.json.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class XMLToJSON {
    public static void main(String[] args) throws IOException {
        //path to xml file
        File xmlFile = new File("leetCodeProblems/resources/PurchaseOrders.xml");

        //reading xml file into byte array
        byte[] b = Files.readAllBytes(xmlFile.toPath());

        //converting byte array into String
        String xml = new String(b);

        //removing <Items> and </Items> from String to specified format
        xml = xml.replace("<Items>", "");
        xml = xml.replace("</Items>", "");

        xml = xml.replace("<Item", "<Items");
        xml = xml.replace("</Item>", "</Items>");

        //converting xml into JSON object
        JSONObject obj = XML.toJSONObject(xml);

        //creating .JSON file
        String path = "leetCodeProblems/resources/PurchaseOrders.JSON";
        try{
            File jsonFile = new File(path);
            if(jsonFile.createNewFile()) {
                System.out.println("File created: " + jsonFile.getName());
            } else {
                System.out.println("File aready exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //writing JSON object into .JSON file
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}