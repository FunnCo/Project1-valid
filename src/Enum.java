public class Enum {
    public enum Sex {Female, Male}

    public static String getStringSex(Sex sex){
        if (sex == Sex.Male){
            return "муж";
        }  else return "жен";
    }
}
