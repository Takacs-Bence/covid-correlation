package org.takacsbence.webclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.takacsbence.model.Cases;
import org.takacsbence.model.Vaccines;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Map;

public class WebClient {
    private static final Logger log = LoggerFactory.getLogger(WebClient.class);

    @Client
    @SuppressWarnings("unused")
    private CovidClient covidClient;

    public WebClient() {
        WebClientConfig config = WebClientConfig.getInstance();

        try {
            Field[] fields = WebClient.class.getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(Client.class)) {
                    String name = f.getName();

                    int version = config.getVersion(name);

                    if (version == 0) {
                        String msg = String.format("version 0 is not allowed. client name: %s", name);
                        throw new IllegalArgumentException(msg);
                    }

                    String basePath = config.getBasePath(name);
                    WebAgent ac = new WebAgent(basePath, version);

                    Constructor<?> c = f.getType().getConstructor(WebAgent.class);

                    f.set(this, c.newInstance(ac));

                }
            }
        } catch (Exception ex) {
            log.error("Web client failed", ex);
            throw new IllegalStateException(ex);
        }
    }

    public Map<String, Map<String, Cases>> getCases() {
        return covidClient.getCases();
    }

    public Map<String, Map<String, Vaccines>> getVaccines() {
        return covidClient.getVaccines();
    }
}
