import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class PersonsControllerTest {


    @Test
    public void getPersonsTest() throws IOException, InterruptedException {
        PersonsController personsController = new PersonsController();
        personsController.readPersonsFromFile("C:\\Users\\VaYls_Comp\\IdeaProjects\\Project1-valid\\example.csv");
        assertNotNull(personsController.getPersons());
    }
}
