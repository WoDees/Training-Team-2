package console;

import core.RegistrationService;

public class RegistrationUserUIAction implements UIAction {

    private final RegistrationService registrationService;

    public RegistrationUserUIAction(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Registration");
    }

    @Override
    public String getActionName() {
        return null;
    }
}
