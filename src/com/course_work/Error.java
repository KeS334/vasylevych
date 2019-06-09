package com.course_work;

public class Error {

    void printErrors(double[][] approximateResult, double[][] exactMatrix, Dyffur dyffur) {
        System.out.println("AverageAbsoluteError: " + averageAbsoluteError(approximateResult, exactMatrix, dyffur));
        System.out.println("MaxAbsoluteError: " + maxAbsoluteError(approximateResult, exactMatrix, dyffur));
        System.out.println("AverageRelativeError: " + averageRelativeError(approximateResult, exactMatrix, dyffur));
        System.out.println("MaxRelativeError: " + maxRelativeError(approximateResult, exactMatrix, dyffur));
    }


    private  double averageAbsoluteError(double[][] approximateResult, double[][] exactMatrix, Dyffur dyffur) {
        double[][] matrix = new double[dyffur.getTpointsAmount()][dyffur.getHpointsAmount()];
        double error = 0;
        double errorResult = 0;

        for (int i = 0; i < dyffur.getTpointsAmount(); i++) {
            for (int j = 0; j < dyffur.getHpointsAmount(); j++) {
                matrix[i][j] = Math.abs(approximateResult[i][j] - exactMatrix[i][j]);
            }
        }

        for (int i = 0; i < dyffur.getTpointsAmount(); i++) {
            for (int j = 0; j < dyffur.getHpointsAmount(); j++) {
                error += matrix[i][j];
            }
        }
        errorResult = error / (dyffur.getTpointsAmount() * dyffur.getHpointsAmount());

        return errorResult;
    }

    private  double maxAbsoluteError(double[][] approximateResult, double[][] exactMatrix, Dyffur dyffur) {
        double[][] matrix = new double[dyffur.getTpointsAmount()][dyffur.getHpointsAmount()];
        double maxError = 0;

        for (int i = 0; i < dyffur.getTpointsAmount(); i++) {
            for (int j = 0; j < dyffur.getHpointsAmount(); j++) {
                matrix[i][j] = Math.abs(approximateResult[i][j] - exactMatrix[i][j]);
            }
        }

        maxError = matrix[0][0];
        for (int i = 0; i < dyffur.getTpointsAmount(); i++) {
            for (int j = 0; j < dyffur.getHpointsAmount(); j++) {
                if (maxError < matrix[i][j]) {
                    maxError = matrix[i][j];
                }
            }
        }


        return maxError;
    }


    private  double averageRelativeError(double[][] approximateResult, double[][] exactMatrix, Dyffur dyffur) {
        double[][] matrix = new double[dyffur.getTpointsAmount()][dyffur.getHpointsAmount()];
        double error = 0;
        double errorResult = 0;

        for (int i = 0; i < dyffur.getTpointsAmount(); i++) {
            for (int j = 0; j < dyffur.getHpointsAmount(); j++) {
                if (exactMatrix[i][j] == 0) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = (Math.abs(approximateResult[i][j] - exactMatrix[i][j]) / exactMatrix[i][j]) * 100;
                }
                error += matrix[i][j];
            }
        }


        errorResult = error / (dyffur.getTpointsAmount() * dyffur.getHpointsAmount());

        return errorResult;
    }

    private  double maxRelativeError(double[][] approximateResult, double[][] exactMatrix, Dyffur dyffur) {
        double[][] matrix = new double[dyffur.getTpointsAmount()][dyffur.getHpointsAmount()];
        double maxError = 0;

        for (int i = 0; i < dyffur.getTpointsAmount(); i++) {
            for (int j = 0; j < dyffur.getHpointsAmount(); j++) {
                if (exactMatrix[i][j] == 0) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = (Math.abs(approximateResult[i][j] - exactMatrix[i][j]) / exactMatrix[i][j]) * 100;
                }
            }
        }

        maxError = matrix[0][0];
        for (int i = 0; i < dyffur.getTpointsAmount(); i++) {
            for (int j = 0; j < dyffur.getHpointsAmount(); j++) {
                if (maxError < matrix[i][j]) {
                    maxError = matrix[i][j];
                }
            }
        }


        return maxError;
    }

}
