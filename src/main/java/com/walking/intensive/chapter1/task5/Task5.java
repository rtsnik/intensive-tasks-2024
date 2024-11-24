package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

import static java.lang.Math.acos;
import static java.lang.Math.sqrt;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {
        System.out.println("Test method: getAreaByHeron");
        System.out.println("Expected: " + 30.0 + "   Recive: " + getAreaByHeron(12, 13, 5));
        System.out.println("Expected: " + 6.0 + "   Recive: " + getAreaByHeron(3, 4, 5));
        System.out.println("Expected: " + 120.0 + "   Recive: " + getAreaByHeron(17, 17, 16));
        System.out.println("Expected: " + 72.30793524918272 + "   Recive: " + getAreaByHeron(12, 13, 14));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(12, 1, 4));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(17, 1, 1));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(17, 1, 1));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(0, 10, 20));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(20, 0, 10));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(10, 20, 0));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(-1, 10, 10));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(10, -1, 10));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(10, 10, -1));
        System.out.println();

        System.out.println("Test method: getHeights");
        System.out.println("Expected: " + new double[]{4.615384615384615, 5.0, 12.0}.toString() +
                            "   Recive: " + getHeights(12, 13, 5).toString());
        System.out.println("Expected: " + new double[]{2.4, 3.0, 4.0}.toString() +
                            "   Recive: " + getHeights(3, 4, 5).toString());
        System.out.println("Expected: " + new double[]{}.toString() + "   Recive: " +
                            getHeights(17, 1, 1).toString());
        System.out.println("Expected: " + new double[]{}.toString() +
                            "   Recive: " + getHeights(0, 10, 12).toString());
        System.out.println("Expected: " + new double[]{}.toString() +
                            "   Recive: " + getHeights(20, -10, 10).toString());

    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {

        if (a <= 0.0 || b <= 0.0 || c <= 0.0) {
            return -1;
        }
        if ((a + b) <= c || (a + c) <= b || (b + c) <= a) {
            return -1;
        }
        double p = 0.5 * (a + b + c);
        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (a <= 0.0 || b <= 0.0 || c <= 0.0) {
            return new double[]{};
        }
        double p = (a + b + c) / 2;
        double rootOfSemiPerimeter = p * (p - a) * (p - b) * (p - c);
        double hA = 2 / a * sqrt(rootOfSemiPerimeter);
        double hB = 2 / b * sqrt(rootOfSemiPerimeter);
        double hC = 2 / c * sqrt(rootOfSemiPerimeter);
        double[] heights = {hA, hB, hC};
        Arrays.sort(heights);
        return heights;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (a <= 0.0 || b <= 0.0 || c <= 0.0) {
            return new double[]{};
        }
        double mA = 1.0 / 2 * sqrt(2 * c * c + 2 * b * b - a * a);
        double mB = 1.0 / 2 * sqrt(2 * c * c + 2 * a * a - b * b);
        double mC = 1.0 / 2 * sqrt(2 * a * a + 2 * b * b - c * c);
        double[] medians = {mA, mB, mC};
        Arrays.sort(medians);
        return medians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (a <= 0.0 || b <= 0.0 || c <= 0.0) {
            return new double[]{};
        }
        double bA = sqrt(b * c * (b * b + 2 * b * c + c * c - a * a)) / (b + c);
        double bB = sqrt(a * c * (a * a + 2 * a * c + c * c - b * b)) / (a + c);
        double bC = sqrt(b * a * (b * b + 2 * b * a + a * a - c * c)) / (b + a);
        double[] bisectors = {bA, bB, bC};
        Arrays.sort(bisectors);
        return bisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (a <= 0.0 || b <= 0.0 || c <= 0.0) {
            return new double[]{};
        }
        if ((a + b) <= c || (a + c) <= b || (b + c) <= a) {
            return new double[]{};
        }
        double anglesAlfa = acos((a * a + c * c - b * b) / (2 * a * c));
        double anglesBeta = acos((a * a + b * b - c * c) / (2 * a * b));
        double anglesGamma = acos((b * b + c * c - a * a) / (2 * b * c));
        double[] angles = {anglesAlfa, anglesBeta, anglesGamma};
        Arrays.sort(angles);
        return angles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (a <= 0.0 || b <= 0.0 || c <= 0.0) {
            return -1;
        }
        double semiPerimeter = (a + b + c) / 2;
        return getAreaByHeron(a, b, c) / semiPerimeter;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (a <= 0.0 || b <= 0.0 || c <= 0.0) {
            return -1;
        }
        return (a * b * c) / (4 * getAreaByHeron(a, b, c));
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        if (a <= 0.0 || b <= 0.0 || c <= 0.0) {
            return -1;
        }

        double area;
        return 0;
    }
}
