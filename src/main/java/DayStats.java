import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: rajesh.kolla
 * Date: 6/25/13
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class DayStats implements Comparable<DayStats> {
    private int day;
    private int minTemperature;
    private int maxTemperature;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }
    
    public int getTemperatureSpread()
    {
        return Math.abs(getMaxTemperature() - getMinTemperature());
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Override
    public String toString() {
        return "Day: " + getDay() + ", Spread: " + getTemperatureSpread();
    }

    @Override
    public int compareTo(DayStats dayStats) {
        if (getTemperatureSpread() == dayStats.getTemperatureSpread())
        {
            return 0;
        }
        else if (getTemperatureSpread() > dayStats.getTemperatureSpread())
        {
            return 1;
        }
        return -1;
    }

    /*@Override
    public boolean equals(Object o) {
        return EqualsBuilder.
    }*/
}
