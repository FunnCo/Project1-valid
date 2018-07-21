public enum Sex {
    Female("жен"),
    Male("муж");

    private final String sex;

    Sex(String sex) {
        this.sex=sex;
    }

    public static Sex getSex(String input) {
        return Male.sex.equals(input)?Male:Female;
    }

    public String getValue(){
        return sex;
    }

}