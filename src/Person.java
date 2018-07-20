public class Person {

    private String name;
    private String city;
    private String phoneNumber;
    private Sex.SEX sex;
    private int age;
    private int height;

    public Person(String parameters) {
        String[] arrayOfPararameters = parameters.split("\\|");

        this.name = arrayOfPararameters[0];
        if ("муж".equals(arrayOfPararameters[1])) {
            this.sex = Sex.SEX.Male;
        } else {
            this.sex = Sex.SEX.Female;
        }
        this.age = Integer.parseInt(arrayOfPararameters[2]);
        this.height = Integer.parseInt(arrayOfPararameters[3]);
        this.phoneNumber = arrayOfPararameters[4];
        this.city = arrayOfPararameters[5];
    }


    public Sex.SEX getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Имя: " + name +
                "\nПол: " + Sex.getStringSex(sex) +
                "\nВозраст: " + age +
                "\nРост " + height +
                "\nНомер телефона: " + phoneNumber +
                "\nГород: " + city +
                "\n-------------------------------------------------------------------------------\n";
    }
}
