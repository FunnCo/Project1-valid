public class Sex {
    public enum SEX {Female, Male}

    public static String getStringSex(SEX sex) {
        if (sex == SEX.Male) {
            return "муж";
        } else return "жен";
    }
}
