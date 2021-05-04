import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person person;
    private BusStop busStop;

    @Before
    public void setUp(){
        bus = new Bus("Portobello",2);
        person = new Person();
        busStop = new BusStop("Waverley Steps");
        busStop.addPerson(person);
        busStop.addPerson(person);
        busStop.addPerson(person);
    }

    @Test
    public void passengersStartsEmpty() {
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void canAddPassengerToBus(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(2, bus.passengerCount());
    }

    @Test
    public void canRemovePassenger(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.removePassenger();
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void canPickUpFromBusStop(){
        bus.pickUp(busStop);
        assertEquals(1, bus.passengerCount());
        assertEquals(2, busStop.queueCount());
    }

    @Test
    public void doesNotPickUpWhenBusIsFull(){
        bus.pickUp(busStop);
        bus.pickUp(busStop);
        bus.pickUp(busStop);
        assertEquals(2, bus.passengerCount());
        assertEquals(1, busStop.queueCount());
    }
}
