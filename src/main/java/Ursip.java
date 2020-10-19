import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ursip {
    public static void main(String[] args) {
        System.out.println("007: " + Ursip.generateNum(new ArrayList<>(Arrays.asList(6, 6, 6, 6, 6))));

        System.out.println("003: " + Ursip.generateNum(new ArrayList<>(Arrays.asList(1, 2, 4, 5, 6))));
        System.out.println("013: " + Ursip.generateNum(new ArrayList<>(Arrays.asList(11, 12, 14, 15, 16))));
        System.out.println("112: " + Ursip.generateNum(new ArrayList<>(Arrays.asList(111, 121, 141, 151, 161))));

        System.out.println("006: " + Ursip.generateNum(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
        System.out.println("016: " + Ursip.generateNum(new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15))));
        System.out.println("116: " + Ursip.generateNum(new ArrayList<>(Arrays.asList(111, 112, 113, 114, 115))));
    }

    public static String generateNum(List<Integer> numbers) {
        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        List<Integer> emptyValues = new ArrayList<>();
        int result;

        for (int i = 0; i < sorted.size() - 1; i++) {
            if (sorted.get(i + 1) != sorted.get(i) + 1) {
                emptyValues.add(sorted.get(i) + 1);
            }
        }

        if (!emptyValues.isEmpty()) {
            result = emptyValues.get(0);
        } else {
            result = sorted.get(sorted.size() - 1) + 1;
        }

        return applyMask(result);
    }

    private static String applyMask(Integer i) {
        char[] chars = i.toString().toCharArray();
        String result;
        int charLength = chars.length;

        if (charLength == 1) {
            result = "00" + i;
        } else if (charLength == 2) {
            result = ("0" + i + "0").substring(0, 3);
        } else {
            result = i.toString();
        }

        return result;
    }
}

//        Задание:
//
//        Реализовать метод для генерации номера проекта на Java, Kotlin или Scala
//
//        Сигнатура метода (java):
//        public static String generateNum(List<Integer> numbers)
//
//        На вход будет переданы сущетвующие номера в виде масива целых чисел.
//        Необходимо вернуть номер следующего проекта, по следующей логике:
//        Если текущие номера проекта не содержат пропусков, то необходимо вернуть максимальный элемент + 1.
//        Если пропуски есть, необходимо вернуть минимальный из них.
//        Пропуском называется разница между номерами больше или равная единицы (f(1,3) содержит пропуск, а f(1,2) нет).
//        Переданные номера проектов могут дублироваться, но сгенерированный методом номер не должен повторять существующий.
//        Номера проектов неотрицательные.
//
//        Пример:
//        f(1,2,3) = 4
//        f(1,3) = 2
//        f(2) = 1
//
//        Сгенерированный номер необходимо вернуть в формате трехразрядной строки, т.е.:
//        f(1) = "001"
//        f(10) = "010"
//        f(100) = "100"
//
//        В реализации приветствуется функциональный стиль.
//        Оцениваться будет качество кода и его корректность.
//        Решение необходимо залить в публичный репозиторий и предоставить ссылку.
