package br.com.munif.doc.learn.nn;

import java.util.Arrays;

public class Perceptron {

    public double LEARN_RATE=1;
    public  static long TOTAL=0;

    private long id=++TOTAL;

    private double[] weights;
    private double threshold=0;

    public Perceptron(int inputSize) {
        this.weights = new double[inputSize+1];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Math.random() * 2 - 1;
        }
    }

    public Perceptron(double initiaWeights[]) {
        this.weights = initiaWeights;
    }


    public double predict(double[] inputs) {
        if (inputs.length!=weights.length-1) throw new RuntimeException("Input size must be "+(weights.length-1));
        double sum = 0.0;
        for (int i = 0; i < weights.length; i++) {
            sum += (i==0?weights[0]:weights[i] * inputs[i-1]);
        }
        return activationFunction(sum);
    }

    public double activationFunction(double sum) {
        return sum > threshold ? 1.0 : 0;
    }

    public double train(double[] inputs, int expectedOutput) {
        double prediction = predict(inputs);
        double error = expectedOutput - prediction;
        for (int i = 0; i < weights.length; i++) {
            weights[i] += LEARN_RATE * error * (i==0?1:inputs[i-1]);
        }
        return error;
    }

    @Override
    public String toString() {
        return "Perceptron{" +
               "id=" + id +
               ", weights=" + Arrays.toString(weights) +
               ", threshold=" + threshold +
               '}';
    }
}
