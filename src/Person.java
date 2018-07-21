public class Person {

    private String name;
    private String city;
    private String phoneNumber;
    private Sex sex;
    private int age;
    private int height;

    public Person(String parameters) {
        String[] arrayOfPararameters = parameters.split("\\|");

        this.name = arrayOfPararameters[Columns.NAME.getColumnNumber()];
        this.sex=Sex.getSex(arrayOfPararameters[Columns.SEX.getColumnNumber()]);
        this.age = Integer.parseInt(arrayOfPararameters[Columns.AGE.getColumnNumber()]);
        this.height = Integer.parseInt(arrayOfPararameters[Columns.HEIGHT.getColumnNumber()]);
        this.phoneNumber = arrayOfPararameters[Columns.PHONE.getColumnNumber()];
        this.city = arrayOfPararameters[Columns.CITY.getColumnNumber()];
    }


    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Имя: " + name +
                "\nПол: " + sex.getValue()+
                "\nВозраст: " + age +
                "\nРост " + height +
                "\nНомер телефона: " + phoneNumber +
                "\nГород: " + city +
                "\n-------------------------------------------------------------------------------\n";
    }
}
