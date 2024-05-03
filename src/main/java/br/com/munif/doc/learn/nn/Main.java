package br.com.munif.doc.learn.nn;

public class Main {
    public static void main(String[] args) {
        Perceptron p=new Perceptron(new double[]{0,0,0});
        System.out.println(p);
        double sumError=1000;



        int epoc=0;
        while (epoc<10 && sumError!=0) {
            epoc++;
            sumError=0;
            System.out.println("Época "+epoc);
            sumError += Math.abs(p.train(new double[]{0, 0}, 0));
            sumError += Math.abs(p.train(new double[]{0, 1}, 0));
            sumError += Math.abs(p.train(new double[]{1, 0}, 0));
            sumError += Math.abs(p.train(new double[]{1, 1}, 1));
            System.out.println(p);
            System.out.println("Erro Total " + sumError);
            System.out.println();
        }
    }
}