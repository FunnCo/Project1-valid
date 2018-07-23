import java.io.IOException;
import java.util.ArrayList;

public class MainClass {
    public static int countOfUpdates = 0;
    private static long timeOfSleep = 10000;
    public static ArrayList<Person> arrayListOfPersons = new ArrayList<Person>();


    public static void main(String[] args) throws IOException, InterruptedException {
        Parser parser = new Parser("D:\\Project1\\example.csv");
        while (true) {
            parser.parseFile();
            if (countOfUpdates > 0) {
                System.out.println("Прошло " + countOfUpdates + " обновление файла");
            } else {
                System.out.println("Файл считан");
            }
            countOfUpdates++;
            Thread.sleep(timeOfSleep);
        }

    }
}


