import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

/**
 * WeatherService implementation class
 * User: rajesh.kolla
 * Date: 6/25/13
 * Time: 2:26 PM
 */
public class WeatherService {

    public DayStats findMinTemperatureSpread(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new RuntimeException("File does not exist: " + filename);
        }

        List<String> lines = FileUtils.readLines(file);
        List<DayStats> days = new ArrayList<DayStats>();
        for (String line : lines) {
            String[] elements = StringUtils.split(line, " ");
            DayStats dayStats = mapToDayStats(elements);
            if (dayStats != null) {
                days.add(dayStats);
            }
        }
        sort(days);
        return days.get(0);
    }

    public DayStats mapToDayStats(String[] elements) {
        if (elements.length < 3) {
            return null;
        }
        try {
            parseInt(elements[0]);
        } catch (Exception e) {
            return null;
        }
        DayStats dayStats = new DayStats();
        dayStats.setDay(parseInt(elements[0]));
        dayStats.setMaxTemperature(parseInt(elements[1]));
        dayStats.setMinTemperature(parseInt(elements[2]));
        return dayStats;

    }

    private int parseInt(String element) {
        String clean = element.replace('*', ' ');
        return Integer.parseInt(StringUtils.trim(clean));
    }
}
