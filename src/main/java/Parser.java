import entities.Person;
import enums.Columns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    private static final int COUNT_OF_COLUMN = 6;
    private FileInputStream file;
    private Scanner scanner;


    public ArrayList<Person> parseFile() throws InterruptedException, IOException {
        ArrayList<Person> personArrayList = new ArrayList<Person>();
        initializeScannerFromFile();
        while (scanner.hasNext()) {
            String lineFromFile = scanner.nextLine();
            if (isValidLine(lineFromFile)) {
                personArrayList.add(new Person(lineFromFile));
            }
        }
        close();
        return personArrayList;
    }

    public Parser(String fileNameOfInput) throws FileNotFoundException {
        this.file = new FileInputStream(fileNameOfInput);
    }

    public Parser(FileInputStream file) { this.file = file; }

    private void close() throws IOException {
        this.scanner.close();
    }

    public void initializeScannerFromFile() throws FileNotFoundException {
        Scanner scanner;
        scanner = new Scanner(this.file, "cp1251");
        this.scanner = scanner;
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


