import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass {
    public static String fileName;


    public static void main(String[] args) {

        Scanner scanner = initializeScannerFromFile();

        while (scanner.hasNext()) {
            String lineFromFile = scanner.nextLine();
            if (isValidLine(lineFromFile)) {
                Person person = new Person(lineFromFile);
                if (isValidPerson(person)) {
                    System.out.println(person);
                }
            }
        }
    }

    public static boolean isValidPerson(Person person) {
        if ((person.getAge() > 15) & (Person.Sex.Male.equals(person.getSex()))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidLine(String lineFromFile) {
        String[] arrayOfParameters = lineFromFile.split("\\|");

        if (arrayOfParameters.length >= 4) {
            if ((arrayOfParameters[0] instanceof String) & (arrayOfParameters[1] instanceof String)) {
                try {
                    Integer.parseInt(arrayOfParameters[2]);
                    Integer.parseInt(arrayOfParameters[3]);
                    return true;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return false;
    }

    public static Scanner initializeScannerFromFile(){
        Scanner filenameScanner = new Scanner(System.in);
        Scanner scanner;

        // Обработка FileNotFoundException и ввод имени файла.

        System.out.println("Введите путь к файлу");
        while (true) {
            fileName = filenameScanner.nextLine();
            try {
                scanner = new Scanner(new FileInputStream(fileName), "cp1251");
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
            }
        }
        filenameScanner.close();
        return scanner;
    }


}


