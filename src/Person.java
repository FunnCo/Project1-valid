public class Person {
    public enum Sex {Female, Male}

    private String name;
    private String city;
    private String phoneNumber;
    private Sex sex;
    private int age;
    private int height;

    public Person(String parameters) {
        String[] arrayOfPararameters = parameters.split("\\|");

        this.name = arrayOfPararameters[0];
        if ("муж".equals(arrayOfPararameters[1])) {
            this.sex = Sex.Male;
        } else {
            this.sex = Sex.Female;
        }
        this.age = Integer.parseInt(arrayOfPararameters[2]);
        this.height = Integer.parseInt(arrayOfPararameters[3]);
        if (arrayOfPararameters.length >= 5) {
            this.phoneNumber = arrayOfPararameters[4];
            if (arrayOfPararameters.length == 6) {
                this.city = arrayOfPararameters[5];
            } else {
                this.city = "Неизвестно";
            }
        } else {
            this.phoneNumber = "Неизвестно";
            this.city = "Неизвестно";
        }

        if ("".equals(this.city)){
            this.city = "Неизвестно";
        }
        if ("".equals(this.phoneNumber)){
            this.phoneNumber = "Неизвестно";
        }

    }

    public String getStringSex(){
        if (this.sex == Sex.Male){
            return "муж";
        }  else return "жен";
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Имя: " + name + "\nПол: " + getStringSex() + "\nВозраст: " + age + "\nРост " + height + "\nНомер телефона: " + phoneNumber + "\nГород: " + city + "\n-------------------------------------------------------------------------------";
    }
}
