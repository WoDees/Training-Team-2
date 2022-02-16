package console;

import core.RemoveUserService;

import java.util.Scanner;

public class RemoveUserUIAction implements UIAction {

    private final RemoveUserService deleteService;

    public RemoveUserUIAction(RemoveUserService deleteService) {
        this.deleteService = deleteService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your login:");
        String login = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        deleteService.delete(login, password);
    }

    @Override
    public String getActionName() {
        return "Remove";
    }
}
