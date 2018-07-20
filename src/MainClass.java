public class MainClass {
    public static int countOfUpdates = 0;


    public static void main(String[] args) {

        while (true) {
            Parser.parseFile();
            if (countOfUpdates > 0) {
                System.out.println("Прошло " + countOfUpdates + " обновление файла");

            }
            countOfUpdates++;
        }
    }
}


