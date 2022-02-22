package org.takacsbence.webclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.takacsbence.model.Cases;
import org.takacsbence.model.Vaccines;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

public class CovidClient {

    private static final Logger log = LoggerFactory.getLogger(CovidClient.class);

    private final WebAgent webAgent;

    public CovidClient(WebAgent webAgent) {
        this.webAgent = webAgent;
    }

    public Map<String, Map<String, Cases>> getCases() {
        /*String result;
        InputStream resource = getClass().getClassLoader().getResourceAsStream("cases.txt");
        InputStreamReader in = new InputStreamReader(resource);
        BufferedReader br = new BufferedReader(in);
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {}

        result = sb.toString();
        */

        String result = webAgent.executeClientCall("/cases", "GET");
        Type casesType = new TypeToken<Map<String, Map<String, Cases>>>() {}.getType();
        Gson gson = getGsonInstance();
        return gson.fromJson(result, casesType);
    }

    public Map<String, Map<String, Vaccines>> getVaccines() {
        /*
        String result;
        InputStream resource = getClass().getClassLoader().getResourceAsStream("vaccines.txt");
        InputStreamReader in = new InputStreamReader(resource);
        BufferedReader br = new BufferedReader(in);
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {}

        result = sb.toString();
         */
        String result = webAgent.executeClientCall("/vaccines", "GET");
        Type vaccinesType = new TypeToken<Map<String, Map<String, Vaccines>>>() {}.getType();
        Gson gson = getGsonInstance();
        return gson.fromJson(result, vaccinesType);
    }

    private Gson getGsonInstance() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }
}
