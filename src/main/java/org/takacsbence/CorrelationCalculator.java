package org.takacsbence;

import org.takacsbence.correlation.CorrelationEngine;
import org.takacsbence.webclient.WebClient;

public class CorrelationCalculator {

    public static void main(String[] args) {
        try {
            WebClient webClient = new WebClient();
            CorrelationEngine correlationEngine = new CorrelationEngine(webClient.getCases(), webClient.getVaccines());
            double correlationCoefficient = correlationEngine.compute();
            System.out.println("The computed correlation coefficient is " + correlationCoefficient);
        } catch (Exception e) {
            System.out.println("An error happened. The correlation coefficient is not computable at this moment.");
        }
    }
}
