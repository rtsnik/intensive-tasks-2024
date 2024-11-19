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
        int age = 0;
        for (int i = -10; i <= 200; i++) {
            System.out.println(getAgeString(i));
        }
    }

    static String getAgeString(int age) {
        String result;
        int remainder = 0;
        if (age >= 0) {
            if (age == 0) {
                result = "Вам " + age + " лет";
            } else {
                remainder = age - age/100*100; //отсекаем 100-ые порядки
                if (remainder < 21 && remainder > 4) {
                    result = "Вам " + age + " лет";
                } else {
                    remainder = age - age/10*10; //отсекаем 10-ые порядки
                    if(remainder == 1) {
                        result = "Вам " + age + " год";
                    } else if (remainder == 2 || remainder == 3 || remainder == 4) {
                        result = "Вам " + age + " года";
                    } else
                        result = "Вам " + age + " лет";
                }
            }
        } else
            result = "Некорректный ввод";

        return result;
    }
}
