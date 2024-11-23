package com.walking.intensive.chapter1.task4;

import static java.lang.Math.sqrt;

/**
 * Дано уравнение:
 *
 * <p>ax² + bx + c = 0
 *
 * <p>Реализуйте метод solveEquation(), который параметрами принимает
 * коэффициенты - вещественные числа a, b и c.
 *
 * <p>Метод должен возвращать в виде строки количество решений, а также сами решения в указанном ниже формате:
 * <ul>
 * <li> "Количество решений: 2. Корни: -4;4"
 * <li> "Количество решений: 1. Корень: 0"
 * <li> "Количество решений: 0."
 * <li> "Бесконечное множество решений."
 * </ul>
 *
 * <p>Обратите внимание, что если корней уравнения два - они должны располагаться по возрастанию.
 *
 * <p>P.S. Квадратные уравнения решаются либо через теорему Виета, либо через дискриминант.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task4 {
    public static void main(String[] args) {

        System.out.println(solveEquation(0, 0, -10));
        System.out.println(solveEquation(0, 0, 1));
        System.out.println(solveEquation(0, 0, 4));
        System.out.println(solveEquation(0, 0, 0));
        System.out.println(solveEquation(1, 0, 1));
        System.out.println(solveEquation(2, 0, 2));
        System.out.println(solveEquation(3, 0, 3));
        System.out.println(solveEquation(4, 2, 5));
        System.out.println(solveEquation(5, 1, 6));
        System.out.println(solveEquation(6, -1, 8));
        System.out.println(solveEquation(7, 3, 10));
        System.out.println(solveEquation(8, 4, 20));
        System.out.println(solveEquation(9, 5, 30));
        System.out.println(solveEquation(10, 6, 40));
        System.out.println(solveEquation(0, -2, 2));
        System.out.println(solveEquation(0, -2, 4));
        System.out.println(solveEquation(0, -2, 8));
        System.out.println(solveEquation(0, 20, -40));
        System.out.println(solveEquation(0, 10, -80));
        System.out.println(solveEquation(1, 0, 0));
        System.out.println(solveEquation(1, -2, 1));
        System.out.println(solveEquation(1, -4, 4));
        System.out.println(solveEquation(1, -6, 9));
        System.out.println(solveEquation(1, -8, 16));
        System.out.println(solveEquation(1, -10, 25));
        System.out.println(solveEquation(1, 9, 20));
        System.out.println(solveEquation(1, 5, 6));
        System.out.println(solveEquation(1, -8, 15));
        System.out.println(solveEquation(1, 4, -45));
        System.out.println(solveEquation(-1, 3, 4));
    }

    static String solveEquation(double a, double b, double c) {

        if (a == 0.0 && b == 0.0 && c == 0.0) {
            return "Бесконечное множество решений.";
        }

        if (a == 0.0 && b == 0.0) {
            return "Количество решений: 0.";
        }

        if (a == 0.0) {
            return "Количество решений: 1. Корень: " + -c / b;
        }

        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0.0) {
            return "Количество решений: 0.";
        }

        if (discriminant == 0.0) {
            double x = ((-1.0) * b + sqrt(discriminant)) / (2 * a);
            return "Количество решений: 1. Корень: " + x;
        }

        double x1 = (-b + sqrt(discriminant)) / (2 * a);
        double x2 = (-b - sqrt(discriminant)) / (2 * a);
        return "Количество решений: 2. Корни: " + (x1 < x2 ? x1 + ";" + x2 : x2 + ";" + x1);
    }
}
