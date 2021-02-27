package com.company;

public class CalcNumbers {
    //метод конвертирования обычных цифр в римские
    static String convertArabicToRoman(String arabicNumber){
        //объявляются три массива с римским числами, еденицы, десятки и сотни
        String[] ones = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tens = new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hounds =new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};

        //получение сотен
        String hound = hounds[Integer.valueOf(arabicNumber) / 100 % 10];
        //получение десятков
        String ten = tens[Integer.valueOf(arabicNumber) / 10 % 10];
        //получение единиц
        String one = ones[Integer.valueOf(arabicNumber) % 10];

        return hound+ten+one;
    }

    //метод конвертирование римских чисел в обычные(используется упрощённый вариант)
    static Integer convertRomanToArabic(String romanNumber){
        int index = 0;

        //в цикле найти индекс римского числа
        for (String roman: WorkWithNumbers.romanNumbers){
            if (roman.equals(romanNumber)){
                //и вернуть значение с этим индексом и обычных чисел
                String arabicNumber = WorkWithNumbers.arabicNumbers[ index ];
                return Integer.valueOf(arabicNumber);
            }
            index++;
        }
        return -1;
    }

    //метод вычисления примера
    static String calc(String first,String second,String operation,String typeNumber){
        String result = "";
        Integer firstInt = 0;
        Integer secondInt = 0;
        //если числа римские то
        if (typeNumber.equals("roman")){
            //конвертировать в обычные
            firstInt = convertRomanToArabic(first);
            secondInt = convertRomanToArabic(second);
        } else {
            //иначе просто преобразовать из строк целочисленный тип
            firstInt = Integer.valueOf(first);
            secondInt = Integer.valueOf(second);
        }

        //выбрать нужную операцию и провести вычисления
        switch (operation){
            case "+":
                result = String.valueOf(firstInt + secondInt);
            break;
            case "-":
                result = String.valueOf(firstInt - secondInt);
                break;
            case "*":
                result = String.valueOf(firstInt * secondInt);
                break;
            case "/":
                result = String.valueOf(firstInt / secondInt);
                break;
        }
        return result;
    }

}
