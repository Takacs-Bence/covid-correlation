package org.takacsbence.correlation;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.takacsbence.model.Cases;
import org.takacsbence.model.Vaccines;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
        List<Double> reducedCase = new ArrayList<>();
        List<Double> reducedVacc = new ArrayList<>();
        for (Map<String, Cases> next : cases.values()) {
            Collection<Cases> values = next.entrySet()
                    .stream()
                    .filter(entry -> "All".equalsIgnoreCase(entry.getKey()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                    .values();


            values.stream()
                    .filter(c -> c.getPopulation() != null)
                    .forEach(c -> {
                        Long deaths = c.getDeaths();
                        Long population = c.getPopulation();
                        double val = deaths.doubleValue() / (population / 100000.00);
                        reducedCase.add(val);
                    });
        }

        for (Map<String, Vaccines> next : vaccines.values()) {
            Collection<Vaccines> values = next.entrySet()
                    .stream()
                    .filter(entry -> "All".equalsIgnoreCase(entry.getKey()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                    .values();

            values.stream()
                    .filter(v -> v.getPopulation() != null)
                    .forEach(v -> {
                        Long vaccinated = v.getPeopleVaccinated();
                        Long population = v.getPopulation();
                        double val = vaccinated.doubleValue() / (population / 100000.00);
                        reducedVacc.add(val);
                    });
        }

        double[] xs = reducedCase.stream().mapToDouble(Double::doubleValue).toArray();
        double[] ys = reducedVacc.stream().mapToDouble(Double::doubleValue).toArray();

        return new double[][]{xs, ys};
    }
}
