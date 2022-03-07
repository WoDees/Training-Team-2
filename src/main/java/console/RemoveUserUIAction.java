package console;

import core.RemoveUserService;

import java.util.Scanner;

public class RemoveUserUIAction implements UIAction {

    private final RemoveUserService deleteService;

    public RemoveUserUIAction(RemoveUserService deleteService) {
        this.deleteService = deleteService;
    }

    @Override
    public void execute(Long userId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your nickname:");
        String nickname = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        deleteService.remove(nickname, password);
    }

    @Override
    public String getActionName() {
        return "Remove";
    }
}
