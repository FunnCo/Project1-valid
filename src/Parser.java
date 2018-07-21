import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Parser {
    private static final int COUNT_OF_COLUMN = 6;
    private String fileNameOfInput;
    public String fileNameOfOutput;
    private FileWriter fileWriter;
    private Scanner scanner;


    public void parseFile() throws InterruptedException, IOException {
        initializeScannerFromFile();
        initializeFileWriter();
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
        close();


    }

    public Parser(String fileNameOfInput, String fileNameOfOutput) {
        this.fileNameOfInput = fileNameOfInput;
        this.fileNameOfOutput = fileNameOfOutput;
    }

    private void close() throws IOException {
        this.fileWriter.close();
        this.scanner.close();
    }

    public void initializeScannerFromFile() throws FileNotFoundException {
        Scanner scanner;
        while (true) {
            try {
                scanner = new Scanner(new FileInputStream(fileNameOfInput), "cp1251");
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
            }
        }
        this.scanner = scanner;
    }

    public void initializeFileWriter() throws IOException {
        FileWriter fileWriter;
        while (true) {
            try {
                fileWriter = new FileWriter(fileNameOfOutput);
                break;
            } catch (IOException e) {
                System.out.println("Файл не найден");
            }
        }

        this.fileWriter = fileWriter;
    }

    public static boolean isValidPerson(Person person) {
        if ((person.getAge() > 15) & (Sex.Male.equals(person.getSex()))) {
            return true;
        } else {
            return false;
        }
    }

    public  boolean isValidLine(String lineFromFile) {
        String[] arrayOfParameters = lineFromFile.split("\\|");

        if (arrayOfParameters.length == COUNT_OF_COLUMN) {
            try {
                Integer.parseInt(arrayOfParameters[Columns.AGE.getColumnNumber()]);
                Integer.parseInt(arrayOfParameters[Columns.HEIGHT.getColumnNumber()]);
                return true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }

}


