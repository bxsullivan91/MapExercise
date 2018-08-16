import java.util.HashMap;
import java.util.Map;

public class TimeZoneDemo
{
    private Map<String, Integer> timeMap = new HashMap<>();

    public static void main(String[] args)
    {
        TimeZoneDemo timeZone = new TimeZoneDemo();

        timeZone.demo();



    }
    private void demo()
    {
        timeMap.put("EST", -5);
        timeMap.put("CST", -6);
        timeMap.put("MST", -7);
        timeMap.put("PST", -8);
        timeMap.put("GMT", 0);

        int difference;
        difference = getTimeDiff("PST", "EST");
        System.out.println("Time difference is " + difference);
    }
    private int getTimeDiff(String timeZoneOne, String timeZoneTwo)
    {
        int one = timeMap.get(timeZoneOne);
        int two = timeMap.get(timeZoneTwo);
        int diff = one - two;

        return diff;
    }
}
