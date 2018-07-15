import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class MainClass {
    public static String fileNameOfInput = "";
    public static int countOfLines;
    public static String fileNameOfOutput = "";


    public static void main(String[] args) {

        while (true) {
            Scanner scanner = initializeScannerFromFile();
            FileWriter fileWriter = initializeFileWriter();

            while (scanner.hasNext()) {
                String lineFromFile = scanner.nextLine();
                if (isValidLine(lineFromFile, fileWriter)) {
                    Person person = new Person(lineFromFile);
                    if (isValidPerson(person, fileWriter)) {
                        try {
                            fileWriter.write(countOfLines + ". " + "\n" + person);
                        } catch (IOException e) {
                            System.out.println(e);
                        }
                    }
                }
            }
            // Interrupted и IO исключения
            try {
                fileWriter.close();
                scanner.close();
                countOfLines = 0;
                Thread.sleep(60000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static boolean isValidPerson(Person person, FileWriter fileWriter) {
        if ((person.getAge() > 15) & (Enum.Sex.Male.equals(person.getSex()))) {
            return true;
        } else {
            try {
                fileWriter.write(countOfLines + ". " + "Не подходит к требованиям" +
                        "\n-------------------------------------------------------------------------------\n");
            } catch (IOException e) {
                System.out.println(countOfLines + ". " + e);
            }

            return false;
        }
    }

    public static boolean isValidLine(String lineFromFile, FileWriter fileWriter) {
        String[] arrayOfParameters = lineFromFile.split("\\|");
        countOfLines++;

        if (arrayOfParameters.length == 6) {

            try {
                Integer.parseInt(arrayOfParameters[2]);
                Integer.parseInt(arrayOfParameters[3]);
                return true;
            } catch (Exception e) {
                System.out.println(countOfLines + ". " + e);
            }

        } else {
            try {
                fileWriter.write(countOfLines + ". " + "Неверное количество параметров" +
                        "\n-------------------------------------------------------------------------------\n");
            } catch (IOException e) {
                System.out.println(e);
            }

        }
        return false;
    }

    public static Scanner initializeScannerFromFile() {
        Scanner scanner;
        if (fileNameOfInput.isEmpty()) {
            Scanner filenameScanner = new Scanner(System.in);
            System.out.println("Введите путь к файлу ввода");
            while (true) {
                try {
                    fileNameOfInput = filenameScanner.nextLine();
                    scanner = new Scanner(new FileInputStream(fileNameOfInput),"cp1251");
                    break;
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не найден");
                }
            }
        } else {
            while (true) {
                try {
                    scanner = new Scanner(new FileInputStream(fileNameOfInput),"cp1251");
                    break;
                } catch (FileNotFoundException e) {
                    System.out.println(e);
                }
            }
        }
        return scanner;
    }


    public static FileWriter initializeFileWriter() {
        FileWriter fileWriter;
        if (fileNameOfOutput.isEmpty()) {
            Scanner filenameScanner = new Scanner(System.in);
            System.out.println("Введите путь к файлу вывода");
            while (true) {
                try {
                    fileNameOfOutput = filenameScanner.nextLine();
                    fileWriter = new FileWriter(fileNameOfOutput);
                    break;
                } catch (IOException e) {
                    System.out.println("Файл не найден");
                }
            }
        } else {
            while (true) {
                try {
                    fileWriter = new FileWriter(fileNameOfOutput);
                    break;
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
        return fileWriter;
    }
}


