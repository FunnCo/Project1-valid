import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Parser {
    private static String fileNameOfInput = "";
    public static String fileNameOfOutput = "";
    public static int timeOfSleep = 60000;
    public static FileWriter fileWriter;

    public static void parseFile() {
        Scanner scanner = initializeScannerFromFile();
        fileWriter = initializeFileWriter();

        while (scanner.hasNext()) {
            String lineFromFile = scanner.nextLine();
            if (isValidLine(lineFromFile)) {
                Person person = new Person(lineFromFile);
                if (isValidPerson(person)) {
                    try {
                        fileWriter.write(person.toString());
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }
        }

        // Interrupted и IO исключения
        try {
            scanner.close();
            fileWriter.close();
            Thread.sleep(timeOfSleep);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Scanner initializeScannerFromFile() {
        Scanner scanner;
        if (fileNameOfInput.isEmpty()) {
            Scanner filenameScanner = new Scanner(System.in);
            System.out.println("Введите путь к файлу ввода");
            while (true) {
                try {
                    fileNameOfInput = filenameScanner.nextLine();
                    scanner = new Scanner(new FileInputStream(fileNameOfInput), "cp1251");
                    break;
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не найден");
                }
            }
        } else {
            while (true) {
                try {
                    scanner = new Scanner(new FileInputStream(fileNameOfInput), "cp1251");
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

    public static boolean isValidPerson(Person person) {
        if ((person.getAge() > 15) & (Sex.SEX.Male.equals(person.getSex()))) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isValidLine(String lineFromFile) {
        String[] arrayOfParameters = lineFromFile.split("\\|");

        if (arrayOfParameters.length == 6) {
            try {
                Integer.parseInt(arrayOfParameters[2]);
                Integer.parseInt(arrayOfParameters[3]);
                return true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }

}


