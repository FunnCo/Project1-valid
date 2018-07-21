import java.io.IOException;

public class MainClass {
    public static int countOfUpdates = 0;
    private static long timeOfSleep=10000;


    public static void main(String[] args) throws IOException, InterruptedException {
        Parser parser = new Parser("C:\\Users\\VaYls_Comp\\IdeaProjects\\Project1-valid\\example.csv",
                "C:\\Users\\VaYls_Comp\\IdeaProjects\\Project1-valid\\example.txt");
        while (true) {
            parser.parseFile();
            if (countOfUpdates > 0) {
                System.out.println("Прошло " + countOfUpdates + " обновление файла");
            }else{
                System.out.println("Файл считан");
            }
            countOfUpdates++;
            Thread.sleep(timeOfSleep);
        }

    }
}


