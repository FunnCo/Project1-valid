import entities.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class PersonsController {
    private ArrayList<Person> persons;

    public void readPersonsFromFile(String filePath) throws IOException, InterruptedException {

        Parser parser = new Parser(filePath);
        this.persons = parser.parseFile();
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public Integer getCountPerson() {
        int count = 0;
        for (Person person : persons) {
            count++;
        }
        return count;
    }

    public ArrayList<Person> findPersonsByName(String name) {
        ArrayList<Person> personArrayList = new ArrayList<Person>();
        for (Person person : this.persons) {
            if (name.equals(person.getName())) {
                personArrayList.add(person);
            }
        }
        return personArrayList;
    }

    public void removeUser(Person person) {
        for (Person personFromArray : persons) {
            if (person == personFromArray) {
                persons.remove(personFromArray);
            }
        }
    }

    public void createPerson(String parameters) {
        persons.add(new Person(parameters));
    }

    public ArrayList<Person> sortPersons(String compareBy) {
        TreeSet<Person> treeSetOfPersons = new TreeSet<Person>();
        if ("age".equals(compareBy)) {
            Comparator<Person> comparator = new PersonAgeComparator();
            treeSetOfPersons = new TreeSet<Person>(comparator);
            treeSetOfPersons.addAll(persons);
        } else if ("height".equals(compareBy)) {
            Comparator<Person> comparator = new PersonHeightComparator();
            treeSetOfPersons = new TreeSet<Person>(comparator);
            treeSetOfPersons.addAll(persons);
        }
        ArrayList<Person> personArrayList = new ArrayList<Person>();
        personArrayList.addAll(treeSetOfPersons);
        return personArrayList;
    }

    public void writeInCSV(ArrayList<Person> persons) throws IOException {
        PrintWriter fileWriter = new PrintWriter("D:\\Project1-valid\\example_output.csv","cp1251");
        for (Person person : persons){
            fileWriter.write(person.getParameters() + "\n");
        }
        fileWriter.close();
    }

    //Comparators

    public class PersonAgeComparator implements Comparator<Person> {
        public int compare(Person firstPerson, Person secondPerson) {
            if (firstPerson.getAge() > secondPerson.getAge()) {
                return 1;
            } else if (firstPerson.getAge() < secondPerson.getAge()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public class PersonHeightComparator implements Comparator<Person> {
        public int compare(Person firstPerson, Person secondPerson) {
            if (firstPerson.getHeight() > secondPerson.getHeight()) {
                return 1;
            } else if (firstPerson.getHeight() < secondPerson.getHeight()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
