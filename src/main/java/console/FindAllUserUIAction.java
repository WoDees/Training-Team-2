package console;

import core.service.FindAllUserService;

public class FindAllUserUIAction implements UIAction {

    private final FindAllUserService findAllUserService;

    public FindAllUserUIAction(FindAllUserService findAllUserService) {
        this.findAllUserService = findAllUserService;
    }

    @Override
    public void execute(Long userId) {
        var response = findAllUserService.findAll();
        System.out.println(response);
    }

    @Override
    public String getActionName() {
        return "Find all users";
    }
}
