import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
* Created by IntelliJ IDEA.
* User: rajesh.kolla
* Date: 6/25/13
* Time: 2:56 PM
* To change this template use File | Settings | File Templates.
*/
public class WeatherServiceTest {

    @Test
    public void testFindMinTemperatureSpread() throws Exception {
        WeatherService ws = new WeatherService();
        DayStats day = ws.findMinTemperatureSpread("/Users/rajesh.kolla/Desktop/weather.dat");
        System.out.println(day);
        assertEquals(day.getTemperatureSpread(), 2);
    }
}
