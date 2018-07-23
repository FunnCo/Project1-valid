import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class InterractionWithArrayOfPersons {
    private ArrayList<Person> arrayListOfPersons;

    public InterractionWithArrayOfPersons(String filename) throws IOException, InterruptedException {
        this.arrayListOfPersons = getPersons(new FileInputStream(filename));
    }

    public ArrayList<Person> getPersons(FileInputStream file) throws IOException, InterruptedException {
        Parser parser = new Parser(file);
        return parser.parseFile();
    }

    public Integer getCountPerson(ArrayList<Person> persons){
        int count = 0;
        for (Person person : persons){
            count++;
        }
        return count;
    }

    public ArrayList<Person> findPersonsByName(String name){
        ArrayList<Person> personArrayList = new ArrayList<Person>();
        for(Person person : this.arrayListOfPersons){
            if (name.equals(person.getName())){
                personArrayList.add(person);
            }
        }
        return personArrayList;
    }

    public void removeUser(Person person){
        for (Person personFromArray : arrayListOfPersons){
            if(person == personFromArray){
                arrayListOfPersons.remove(personFromArray);
            }
        }
    }

}
