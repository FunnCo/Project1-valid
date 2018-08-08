import entities.Person;

import java.io.IOException;
import java.util.ArrayList;

public class PersonsController {
    private ArrayList<Person> persons;

    public void readPersonsFromFile(String filePath) throws IOException, InterruptedException {

        Parser parser = new Parser(filePath);
        this.persons = parser.parseFile();
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public Integer getCountPerson(){
        int count = 0;
        for (Person person : persons){
            count++;
        }
        return count;
    }

    public ArrayList<Person> findPersonsByName(String name){
        ArrayList<Person> personArrayList = new ArrayList<Person>();
        for(Person person : this.persons){
            if (name.equals(person.getName())){
                personArrayList.add(person);
            }
        }
        return personArrayList;
    }

    public void removeUser(Person person){
        for (Person personFromArray : persons){
            if(person == personFromArray){
                persons.remove(personFromArray);
            }
        }
    }

}
