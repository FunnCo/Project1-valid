import entities.Person;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PersonsControllerTest {
    PersonsController personsController;

    @Before
    public void prepare() throws IOException, InterruptedException {
        personsController = new PersonsController();
        personsController.readPersonsFromFile("E:\\Project1-valid\\example.csv");
    }

    @Test
    public void getPersonsTest() {
        assertNotNull(personsController.getPersons());
    }

    @Test
    public void getCountPersonTest() {
        assertEquals(3, (long) personsController.getCountPerson());
    }

    @Test
    public void findPersonsByNameTest() {
        Person person = personsController.findPersonsByName("Иванов Иван").get(0);
        assertEquals(person, personsController.getPersons().get(0));
    }

    @Test
    public void removeUserTest() {
        ArrayList<Person> personArrayList = personsController.getPersons();
        Person person = personArrayList.get(1);
        personsController.removeUser(personArrayList.get(1));
        try {
            assertNotEquals(person, personsController.findPersonsByName("Сидорова Мария").get(0));
            fail();
        } catch (IndexOutOfBoundsException e){
            assertEquals(1,1);
        }
    }

    @Test
    public void createPersonTest() {
        personsController.createPerson("Test test|муж|19|163|+79623454527|Test");
        Person person = personsController.findPersonsByName("Test test").get(0);
        assertEquals(person, personsController.getPersons().get(3));
    }

    @Test
    public void sortPersonsControllerByAge() {
        int countOfPassed = 0;
        ArrayList<Person> personArrayList = personsController.sortPersons("age");
        if (personArrayList.get(0).equals(personsController.getPersons().get(1))) {
            countOfPassed++;
        }
        if (personArrayList.get(1).equals(personsController.getPersons().get(0))) {
            countOfPassed++;
        }
        if (personArrayList.get(2).equals(personsController.getPersons().get(2))) {
            countOfPassed++;
        }
        assertEquals(3, countOfPassed);
    }

    @Test
    public void sortPersonsControllerByHeight() {
        int countOfPassed = 0;
        ArrayList<Person> personArrayList = personsController.sortPersons("height");
        if (personArrayList.get(0).equals(personsController.getPersons().get(1))) {
            countOfPassed++;
        }
        if (personArrayList.get(1).equals(personsController.getPersons().get(0))) {
            countOfPassed++;
        }
        if (personArrayList.get(2).equals(personsController.getPersons().get(2))) {
            countOfPassed++;
        }
        assertEquals(3, countOfPassed);
    }

    @Test
    public void writeInCSVTest() throws IOException, InterruptedException {
        personsController.writeInCSV(personsController.getPersons());
        Scanner scannerFromActual = new Scanner(new FileInputStream("E:\\Project1-valid\\example_output.csv"),"cp1251");

        String lineFromActualFile = "";
        while (scannerFromActual.hasNext()){
            lineFromActualFile = lineFromActualFile + scannerFromActual.nextLine();
        }
        byte[] actual = lineFromActualFile.getBytes();

        Scanner scannerFromExpected = new Scanner(new FileInputStream("E:\\Project1-valid\\example.csv"),"cp1251");
        String lineFromExpectedFile = "";
        while (scannerFromExpected.hasNext()){
            lineFromExpectedFile = lineFromExpectedFile + scannerFromExpected.nextLine();
        }
        byte[] expected = lineFromExpectedFile.getBytes();

        scannerFromActual.close();
        scannerFromExpected.close();

        assertArrayEquals(expected, actual);
    }
}
