import com.jayway.jsonpath.JsonPath;
import java.io.IOException;

/**
 * Created by A.Menchuk
 * 11/06/2018
 */
public class RequestExecutor {
    public static void main(String[] args) throws IOException {
        String domain = "https://noName.testrail.io";

        Requests requests = new Requests();

        String getStringResponse  = requests.GET(domain + "/index.php?/api/v2/get_case/727");
        String postStringResponse = requests.POST(domain + "/index.php?/api/v2/add_run/4","{\"name\":\"Test Run NEW Name.\"}");

        System.out.println("GET request: " + getStringResponse);
        System.out.println("ID: " + getJsonValue(getStringResponse,"$.id"));
        System.out.println("Title: " + getJsonValue(getStringResponse,"$.title"));
        System.out.println("Estimate forecast: " + getJsonValue(getStringResponse,"$.estimate_forecast"));

        System.out.println("\n");

        System.out.println("POST request: " + postStringResponse);
        System.out.println("ID: " + getJsonValue(postStringResponse,"$.id"));
        System.out.println("Name: " + getJsonValue(postStringResponse,"$.name"));
        System.out.println("Description: " + getJsonValue(postStringResponse,"$.description"));
        System.out.println("Created on: " + getJsonValue(postStringResponse,"$.created_on"));
        System.out.println("Project ID: " + getJsonValue(postStringResponse,"$.project_id"));
    }

    private static String getJsonValue(String string, String pathToValue){
        try{
            return JsonPath.parse(string).read(pathToValue).toString();
        }catch (NullPointerException e){
            return "null";
        }
    }
}
