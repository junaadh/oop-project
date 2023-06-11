package oopsdg;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import javafx.util.StringConverter;

public class MonthStringConverter extends StringConverter<LocalDate> {

    private DateTimeFormatter formatter;

    public MonthStringConverter() {
        this.formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                .withLocale(Locale.getDefault())
                .withZone(ZoneId.systemDefault());
    }

    @Override
    public String toString(LocalDate date) {
        if (date != null) {
            return formatter.format(date);
        } else {
            return "";
        }
    }

    @Override
    public LocalDate fromString(String string) {
        if (string != null && !string.isEmpty()) {
            // Get the first day of the selected month
            LocalDate selectedDate = LocalDate.parse(string, formatter);
            return selectedDate.withDayOfMonth(1);
        } else {
            return null;
        }
    }
}