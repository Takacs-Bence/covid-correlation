package org.takacsbence.correlation;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.takacsbence.model.Cases;
import org.takacsbence.model.Vaccines;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class CorrelationEngine implements DataCleanser<Cases, Vaccines> {

    private final Map<String, Map<String, Cases>> cases;
    private final Map<String, Map<String, Vaccines>> vaccines;

    public CorrelationEngine(Map<String, Map<String, Cases>> cases, Map<String, Map<String, Vaccines>> vaccines) {
        this.cases = cases;
        this.vaccines = vaccines;
    }

    public double compute() {

        if (cases.size() != vaccines.size()) {

            clean(cases, vaccines);

            if (cases.size() != vaccines.size()) {
                throw new IllegalArgumentException("cleaning data was not successful. data is corrupt");
            }

        }

        double[][] data = reduce();
        return doCalculate(data);
    }

    public static double doCalculate(double[][] xy) {
        if (xy.length != 2) {
            throw new IllegalArgumentException("correlaction calculation data should contain exactly two arrays");
        }
        return new PearsonsCorrelation().correlation(xy[0], xy[1]);
    }

    private double[][] reduce() {

        double[] xs = new double[this.cases.size()];
        double[] ys = new double[this.vaccines.size()];
        int j = 0;
        int k = 0;

        for (Map<String, Cases> next : cases.values()) {
            Collection<Cases> values = next.entrySet()
                    .stream()
                    .filter(entry -> "All".equalsIgnoreCase(entry.getKey()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                    .values();

            for (Cases c : values) {
                Long deaths = c.getDeaths();
                double val = deaths.doubleValue();
                xs[j] = val;
                j++;
            }

        }

        for (Map<String, Vaccines> next : vaccines.values()) {
            Collection<Vaccines> values = next.entrySet()
                    .stream()
                    .filter(entry -> "All".equalsIgnoreCase(entry.getKey()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                    .values();

            for (Vaccines v : values) {
                Long vaccinated = v.getPeopleVaccinated();
                double val = vaccinated.doubleValue();
                ys[k] = val;
                k++;
            }
        }

        return new double[][]{xs, ys};
    }
}
