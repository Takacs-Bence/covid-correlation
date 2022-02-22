package org.takacsbence.webclient;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WebClientConfig {

    private static final Logger log = LoggerFactory.getLogger(WebClientConfig.class);

    private static WebClientConfig instance;

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") // clients are populated in the read method
    private final List<ClientItem> clients = new LinkedList<>();
    private final Map<String, ClientItem> clientsMap = new HashMap<>();

    private WebClientConfig() {
    }

    public static WebClientConfig getInstance() {
        if (instance == null) {
            instance = read();
            log.info(instance.toString());

            instance.clients.forEach(c -> instance.clientsMap.put(c.getName(), c));
        }
        return instance;
    }

    public int getVersion(String name) {
        return get(name).getVersion();
    }

    public String getBasePath(String name) {
        return get(name).getBasePath();
    }

    public ClientItem get(String name) {
        ClientItem a = clientsMap.get(name);
        if (a == null) {
            throw new IllegalArgumentException("unknown client name: " + name);
        }

        return a;
    }

    private static WebClientConfig read() {
        Gson gson = new Gson();
        ClassLoader classLoader = WebClientConfig.class.getClassLoader();
        InputStream resource = classLoader.getResourceAsStream("web-client-config.json");
        if (resource == null) {
            throw new IllegalStateException("web client config resource not found");
        }
        try (Reader r = new InputStreamReader(resource)) {
            return gson.fromJson(r, WebClientConfig.class);
        } catch (Exception e) {
            log.error("read failed", e);
            return new WebClientConfig();
        }
    }

    @Override
    public String toString() {
        return "WebClientConfig {clients=" +
                clients +
                "}";
    }
}
