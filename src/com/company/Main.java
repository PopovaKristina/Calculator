package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

                System.out.println("Input:");
                //считываем введённый пример и удалёем все пробелы в нём
                String example = reader.readLine().replaceAll(" ","");
                //Запускаем основной метод
                WorkWithNumbers.runParseAndCalc(example);

            reader.close();
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
    }
}
