package edu.hillel.streams;

import java.io.IOException;

public class ListOfNumbersDemo {
    public static void main(String[] args) {

        //пример использования методов ListOfNumbers с обработкой всех возможных исключений

        String fileLocation = "C:\\Users\\Public\\Documents\\ForJava\\test\\test-test\\file.txt";
        ListOfNumbers listOfNumbers = new ListOfNumbers();

        try {
            listOfNumbers.writeContentToFile(fileLocation);
            listOfNumbers.readContentFromFile(fileLocation);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundFileException e) {
            e.printStackTrace();
        }

        System.out.println("New list:\n");
        for (int i = 0; i < listOfNumbers.getList().size(); i++) {
            System.out.print(listOfNumbers.getList().get(i));

        }
    }
}
