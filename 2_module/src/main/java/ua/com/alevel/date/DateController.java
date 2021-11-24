package ua.com.alevel.date;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateController{

    public static String[] fixDate(List<String> dates) {
        List <String> notFixDate = new ArrayList<>();

        List<String> dateFormats = List.of(
                "(?<day>\\d{2})/(?<month>\\d{2})/(?<year>\\d{4})",
                "(?<day>\\d{2})/(?<year>\\d{4})/(?<month>\\d{2})",
                "(?<month>\\d{2})/(?<day>\\d{2})/(?<year>\\d{4})",
                "(?<month>\\d{2})/(?<year>\\d{4})/(?<day>\\d{2})",
                "(?<year>\\d{4})/(?<month>\\d{2})/(?<day>\\d{2})",
                "(?<year>\\d{4})/(?<day>\\d{2})/(?<month>\\d{2})",

                "(?<day>\\d{2})-(?<month>\\d{2})-(?<year>\\d{4})",
                "(?<day>\\d{2})-(?<year>\\d{4})-(?<month>\\d{2})",
                "(?<month>\\d{2})-(?<day>\\d{2})-(?<year>\\d{4})",
                "(?<month>\\d{2})-(?<year>\\d{4})-(?<day>\\d{2})",
                "(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})",
                "(?<year>\\d{4})-(?<day>\\d{2})-(?<month>\\d{2})",

                "(?<day>\\d{2});(?<month>\\d{2});(?<year>\\d{4})",
                "(?<day>\\d{2});(?<year>\\d{4});(?<month>\\d{2})",
                "(?<month>\\d{2});(?<day>\\d{2});(?<year>\\d{4})",
                "(?<month>\\d{2});(?<year>\\d{4});(?<day>\\d{2})",
                "(?<year>\\d{4});(?<month>\\d{2});(?<day>\\d{2})",
                "(?<year>\\d{4});(?<day>\\d{2});(?<month>\\d{2})",

                "(?<day>\\d{2}):(?<month>\\d{2}):(?<year>\\d{4})",
                "(?<day>\\d{2}):(?<year>\\d{4}):(?<month>\\d{2})",
                "(?<month>\\d{2}):(?<day>\\d{2}):(?<year>\\d{4})",
                "(?<month>\\d{2}):(?<year>\\d{4}):(?<day>\\d{2})",
                "(?<year>\\d{4}):(?<month>\\d{2}):(?<day>\\d{2})",
                "(?<year>\\d{4}):(?<day>\\d{2}):(?<month>\\d{2})");

        for (String date : dates) {
            for (String dateFormat : dateFormats) {
                Matcher matcher = Pattern.compile(dateFormat).matcher(date);
                if ((matcher.matches())) {
                    notFixDate.add(collect(matcher.group("year"), matcher.group("month"), matcher.group("day")));
                    break;
                }
            }
        }
        return notFixDate.toArray(new String[0]);
    }

    private static String collect(String year, String month, String day) {
        if (Integer.parseInt(month) > 12 && Integer.parseInt(day) <= 12) {
            String chs;
            chs = month;
            month = day;
            day = chs;
        }
        if (
                (Integer.parseInt(year) >= 0 && Integer.parseInt(month) > 0 && Integer.parseInt(month) <= 12 && Integer.parseInt(day) > 0 && Integer.parseInt(day) <= 31) ||
                (Integer.parseInt(year) >= 0 && Integer.parseInt(day) > 0 && Integer.parseInt(day) <= 31 && Integer.parseInt(month) > 0 && Integer.parseInt(month) <= 12)) {
            return year + month + day;
        }
        return "";
    }
}