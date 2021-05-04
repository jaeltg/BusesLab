import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    private BusStop busStop;
    private Person person;
    @Before
    public void setUp(){
        busStop = new BusStop("Waverley Steps");
        person = new Person();
    }

    @Test
    public void canAddToQueue(){
        busStop.addPerson(person);
        assertEquals(1, busStop.queueCount());
    }

    @Test
    public void canRemoveFromQueue(){
        busStop.addPerson(person);
        busStop.addPerson(person);
        busStop.removePerson();
        assertEquals(1, busStop.queueCount());
    }

    @Test
    public void canNotRemoveIfEmpty(){
        busStop.removePerson();
        assertEquals(0, busStop.queueCount());
    }
}
