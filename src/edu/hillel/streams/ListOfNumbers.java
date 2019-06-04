package edu.hillel.streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
      /*1) Создать класс код которого указан выше:
      2) в классе ListOfNumbers создать метод writeContentToFile(String fileLocation) - который должен записать в файл содержимое списка (каждое значение на новой строке) в файл fileLocation
      если файла fileLocation не существует - создать его
      3) в классе ListOfNumbers создать метод readContentFromFile(String fileLocation)
      в котором считать из файла данные в список list из файла fileLocation (считать что в файле fileLocation каждое значение расположено на новой строке).
      если файла fileLocation не существует - реализовать собственное исключение и бросить его
      если файл пустой - реализовать собственное исключение и бросить его
      Создать класс ListOfNumbersDemo - где показать пример использования методов ListOfNumbers с обработкой всех возможных исключений.*/

    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(new Integer(i));
    }

    public List<Integer> getList() {
        return this.list;
    }


    public void writeContentToFile(String fileLocation) throws IOException, NotFoundFileException {
        BufferedWriter bufferedWriter = null;

        try {
            File file = new File(fileLocation);
            if (file.isDirectory()) {
                throw new FileIsDirectoryException("This is not a valid file path!");
            }
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new NotFoundFileException("Unable to create file");
                }
            } else if (!file.canWrite()) {
                throw new NoAccessRightsException("Check access rights!");
            }
            FileWriter fileWriter = new FileWriter(fileLocation);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (Object integerLine : this.getList()) {
                bufferedWriter.write(integerLine.toString());
                bufferedWriter.write(System.getProperty("line.separator"));
            }
        } catch (FileIsDirectoryException e) {
            throw new NotFoundFileException("A wrong file path!", e);
        } catch (NoAccessRightsException ex) {
            ex.printStackTrace();
        } catch (NotFoundFileException exception) {
            exception.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.flush();
                bufferedWriter.close();

            }
        }
    }

    public void readContentFromFile(String fileLocation) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            File file = new File(fileLocation);
            if (file.isDirectory()) {
                throw new FileIsDirectoryException("This is not a valid file path!");
            }
            if (!file.exists()) {
                throw new NotFoundFileException("Unable to create file");
            } else if (!file.canRead()) {
                throw new NoAccessRightsException("Check access rights!");
            }
            fileReader = new FileReader(fileLocation);
            bufferedReader = new BufferedReader(fileReader);
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                getList().add(Integer.valueOf(string));
            }

        } catch (NoAccessRightsException e) {
            e.printStackTrace();
        } catch (FileIsDirectoryException e) {
            e.printStackTrace();
        } catch (NotFoundFileException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }
}
