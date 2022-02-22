package org.takacsbence.webclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebAgent {

    private final String basePath;
    private final int version;

    public WebAgent(String basePath, int version) {
        this.basePath = basePath;
        this.version = version;
    }

    public String executeClientCall(String path, String httpMethod) {

        if (!isHttpMethodSupported(httpMethod)) {
            throw new IllegalArgumentException(httpMethod + " is not supported");
        }

        String version = "/v" + this.version;

        try {
            URL url = new URL(basePath + version + path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(httpMethod);
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            conn.disconnect();
            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isHttpMethodSupported(String httpMethod) {
        return "GET".equalsIgnoreCase(httpMethod);
    }
}
