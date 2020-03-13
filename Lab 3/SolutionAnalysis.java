package com.lab3;

public class SolutionAnalysis {
    private Algorithm algorithm;

    public SolutionAnalysis(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    private long calculateRuntime() {
        long t0 = System.nanoTime();

        algorithm.computeSolution();

        long t1 = System.nanoTime();

        return t1 - t0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        if (algorithm instanceof GreedyAlgorithm)
            str.append("Greedy:\n");
        else
            str.append("Dynamic Programming:\n");


        str.append("runtime: ").append(calculateRuntime()).append(" ns\nsolution: ").append(algorithm.getSolution()).append("\n\n");

        return str.toString();
    }
}
