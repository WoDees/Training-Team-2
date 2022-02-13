package console;

import core.CalendarService;

public class CalendarUserUIAction implements UIAction {

    private final CalendarService calendarService;

    public CalendarUserUIAction(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Calendar");
    }

    @Override
    public String getActionName() {
        return null;
    }
}
