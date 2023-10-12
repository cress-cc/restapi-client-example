package cc.cress;

import java.io.IOException;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;

import cc.cress.dto.Response;

public class Main {
    public static void main(String[] args) throws IOException {
        GenericUrl url = new GenericUrl("https://zipcloud.ibsnet.co.jp/api/search");
        url.put("zipcode", "260-0855");

        HttpTransport transport = new NetHttpTransport();
        Response response = transport.createRequestFactory()
                .buildGetRequest(url)
                .setParser(new JsonObjectParser(new GsonFactory()))
                .execute()
                .parseAs(Response.class);

        for (Response.Result result : response.getResults()) {
            System.out.println(result.getAddress1());
            System.out.println(result.getAddress2());
            System.out.println(result.getAddress3());
        }
    }
}
