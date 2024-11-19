package com.walking.intensive.chapter1.task1;

/**
 * Реализуйте метод getAgeString(), который будет принимать параметром целое число (возраст) и возвращать строку
 * вида: "Вам N лет". Программа должна учитывать правила русского языка.
 *
 * <p>Пример верного исполнения кода: "Вам 5 лет", "Вам 4 года".
 * Пример неверной работы программы: "Вам 14 года".
 *
 * <p>Также необходимо учесть негативные сценарии. Например, попытку передать в метод невалидное значение - например,
 * отрицательное число. В таких случаях ожидается, что метод вернет строку "Некорректный ввод".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task1 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        for (int i = -10; i <= 128; i++) {
            System.out.println(getAgeString(i));
        }
    }

    static String getAgeString(int age) {
        String ageString;
        int remainder;

        if (age < 0 || age > 127) {
            ageString = "Некорректный ввод";
            return ageString;
        }

        remainder = age % 100; //отсекаем 100-ые порядки
        if (remainder < 15 && remainder > 10) { //исключительно для "Вам 11, 12, 13, 14 лет"
            ageString = "Вам " + age + " лет";
            return ageString;
        }

        remainder = age % 10; //отсекаем 10-ые порядки
        if (remainder == 1) {
            ageString = "Вам " + age + " год";
        } else if (remainder == 2 || remainder == 3 || remainder == 4) {
            ageString = "Вам " + age + " года";
        } else {
            ageString = "Вам " + age + " лет";
        }

        return ageString;
    }
}
