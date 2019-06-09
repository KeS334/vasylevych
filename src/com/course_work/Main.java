package com.course_work;


public class Main {
    public static void main(String[] args) {

        System.out.println("Serial approximate solve:");
        Dyffur dyffur = new Dyffur();

        long beginTimeSerial = System.nanoTime();
        double[][] approximateResult = new SerialSolution(dyffur).solve();
        long endTimeSerial = System.nanoTime();
        long serialTime = endTimeSerial - beginTimeSerial;
        printMatrix(approximateResult, dyffur);
        System.out.println("Time of serial solve: " + serialTime + " ns");
        System.out.println();


        System.out.println("Parallel solve");
        long beginTimeParallel = System.nanoTime();
        double[][] parallelSolution = new ParallelSolution(dyffur).solve();
        long endTimeParallel = System.nanoTime();
        long parallelTime = endTimeParallel - beginTimeParallel;
        printMatrix(parallelSolution, dyffur);
        System.out.println("Time of parallel solve: " + parallelTime + " ns");

        System.out.println("Exact solve:");
        Error errors = new Error();
        errors.printErrors(approximateResult, calculateExactResult(dyffur), dyffur);
    }

    private static double[][] calculateExactResult(Dyffur dyffur) {
        double[][] exactMatrix = new double[dyffur.getTpointsAmount()][dyffur.getHpointsAmount()];
        double t = dyffur.getT0();
        for (int i = 0; i < dyffur.getTpointsAmount(); i++) {
            double x = dyffur.getX0();
            for (int j = 0; j < dyffur.getHpointsAmount(); j++) {
                exactMatrix[i][j] = dyffur.calculateTrueSolution(x, t);
                x += dyffur.getH();
            }
            t += dyffur.getTau();
        }

        System.out.println();

       printMatrix(exactMatrix,dyffur);

        return exactMatrix;
    }

    private static void printMatrix(double[][] matrix, Dyffur dyffur) {
        for (int i = 0; i < dyffur.getTpointsAmount(); ++i) {
            for (int j = 0; j < dyffur.getHpointsAmount(); ++j) {
                System.out.print(String.format("%.5f\t", matrix[i][j]));
            }
            System.out.println();

        }
    }

//        private static void printMatrix(double[][] matrix, Dyffur dyffur) {
//            System.out.print("{");
//        for (int i = 0; i < dyffur.getTpointsAmount(); ++i) {
//            System.out.print("{");
//            for (int j = 0; j < dyffur.getHpointsAmount(); ++j) {
//                System.out.print(matrix[i][j]);
//                if (j !=dyffur.getHpointsAmount()-1) System.out.print(",");
//            }
//            if (i != dyffur.getHpointsAmount()-1) {System.out.print("},");}
//            else System.out.print("}");
//            System.out.println();
//
//
//        }
//            System.out.print("}");
//    }


}
