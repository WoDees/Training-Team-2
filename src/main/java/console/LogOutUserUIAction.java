package console;

import core.LogOutUserService;

public class LogOutUserUIAction implements UIAction {

    private final LogOutUserService logOutService;

    public LogOutUserUIAction(LogOutUserService logOutService) {
        this.logOutService = logOutService;
    }

    @Override
    public void execute(Long userId) {
        System.out.println("""
                Do you really want to log out?\s
                1 - Yes
                2 - No""");
    }

    @Override
    public String getActionName() {
        return "Log Out";
    }
}
