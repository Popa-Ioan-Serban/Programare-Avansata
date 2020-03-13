package com.lab3;

public class Main {

    public static void main(String[] args) {
        ProblemGenerator problemGenerator = new ProblemGenerator();
        problemGenerator.generateInstance();

        SolutionAnalysis greedySolutionAnalysis = new SolutionAnalysis(new GreedyAlgorithm(problemGenerator.getKnapsack(), problemGenerator.getItems()));
        SolutionAnalysis dynamicProgrammingSolutionAnalysis = new SolutionAnalysis(new DynamicProgrammingAlgorithm(problemGenerator.getKnapsack(), problemGenerator.getItems()));

        System.out.println(greedySolutionAnalysis);
        System.out.println(dynamicProgrammingSolutionAnalysis);
    }
}
