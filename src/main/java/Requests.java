import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
/**
 * Created by A.Menchuk
 * 11/06/2018
 */
public class Requests {

    private HttpClient client = HttpClients.custom().build();
    private HttpUriRequest request;
    private HttpResponse httpResponse;
    private String response = "";

    String GET(String uri){
        try {
            request = RequestBuilder.get()
                    .setUri(uri)
                    .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                    .setHeader(HttpHeaders.AUTHORIZATION,"Basic YW50b24ubWVuY2h1a0B0YXAudWE6UzRiS2xTSHpRV1M4bmFqTmlReFotelBxWXdJRE1RalJsZ0d6SnlBQVI=")
                    .build();

            httpResponse = client.execute(request);
            response = new BasicResponseHandler().handleResponse(httpResponse);

        //printing method name and request status
        System.out.println( "Status info:\n" +
                Thread.currentThread().getStackTrace()[1].getMethodName() + " " +
                httpResponse.getStatusLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return response;
    }

    String POST(String uri, String parameters) {
        try {
            request = RequestBuilder.post()
                    .setUri(uri)
                    .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                    .setHeader(HttpHeaders.AUTHORIZATION,"Basic YW50b24ubWVuY2h1a0B0YXAudWE6UzRiS2xTSHpRV1M4bmFqTmlReFotelBxWXdJRE1RalJsZ0d6SnlBQVI=")
                    .setEntity(new StringEntity(parameters))
                    .build();

            httpResponse = client.execute(request);
            response = new BasicResponseHandler().handleResponse(httpResponse);

        //printing method name and request status
            System.out.println( "Status info:\n" +
                    Thread.currentThread().getStackTrace()[1].getMethodName() + " " +
                    httpResponse.getStatusLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return response;
    }
}
