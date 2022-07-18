package br.ufrn.imd.moviessitebackend.util;

import java.nio.charset.StandardCharsets;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import static org.apache.http.impl.client.HttpClients.createDefault;

public class Requests {

    public static String getString(String endpoint) {
        CloseableHttpClient httpClient = createDefault();
        HttpGet httpGet = new HttpGet(endpoint);
        RequestConfig requestConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.STANDARD)
                .build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        String responseString = "";
        try {
            response = httpClient.execute(httpGet);
            responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return responseString;
    }
}
