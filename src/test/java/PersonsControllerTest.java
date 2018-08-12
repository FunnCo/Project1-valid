import entities.Person;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonsControllerTest {


    @Test
    public void getPersonsTest() throws IOException, InterruptedException {
        PersonsController personsController = new PersonsController();
        personsController.readPersonsFromFile("D:\\Project1-valid\\example.csv");
        assertNotNull(personsController.getPersons());
    }

    @Test
    public void getCountPersonTest() throws IOException, InterruptedException {
        PersonsController personsController = new PersonsController();
        personsController.readPersonsFromFile("D:\\Project1-valid\\example.csv");
        assertEquals(3,(long)personsController.getCountPerson());
    }

    @Test
    public void findPersonsByNameTest() throws IOException, InterruptedException {
         PersonsController personsController = new PersonsController();
         personsController.readPersonsFromFile("D:\\Project1-valid\\example.csv");
         ArrayList<Person> arrayListOfPersons = personsController.findPersonsByName("Иванов Иван");

         Person[] arrayOfPersonsActual = new Person[arrayListOfPersons.size()];
         Person[] arrayOfPersonsExpected = new Person[1];
         arrayListOfPersons.add(new Person("Иванов Иван|муж|19|163|+79623454527|Питер"));

         assertArrayEquals(arrayOfPersonsExpected, arrayOfPersonsActual);
    }

    @Test
    public void removeUserTest() throws IOException, InterruptedException {
        PersonsController personsController = new PersonsController();
        personsController.readPersonsFromFile("D:\\Project1-valid\\example.csv");

        ArrayList<Person> personArrayList = personsController.getPersons();

        personsController.removeUser(personArrayList.get(1));
        assertEquals(2,(long)personsController.getCountPerson());
    }
}
