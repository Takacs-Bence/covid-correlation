package org.takacsbence.correlation;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public interface DataCleanser<X, Y> {

    default void clean(Map<String, Map<String, X>> xs, Map<String, Map<String, Y>> ys) {
        Set<String> keysToRemove = xs.keySet().stream()
                .filter(c -> !ys.containsKey(c) || (c.equalsIgnoreCase("World") || c.equalsIgnoreCase("Global")))
                .collect(Collectors.toSet());
        for (String key : keysToRemove) {
            xs.remove(key);
        }

        keysToRemove = ys.keySet().stream()
                .filter(c -> !xs.containsKey(c) || (c.equalsIgnoreCase("World") || c.equalsIgnoreCase("Global")))
                .collect(Collectors.toSet());
        for (String key : keysToRemove) {
            ys.remove(key);
        }
    }

}
