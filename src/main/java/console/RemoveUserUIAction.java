package console;

import core.service.RemoveUserService;
import dto.request.RemoveUserRequest;

import java.util.Scanner;

public class RemoveUserUIAction implements UIAction {

    private final RemoveUserService removeUserService;

    public RemoveUserUIAction(RemoveUserService deleteService) {
        this.removeUserService = deleteService;
    }

    @Override
    public void execute(Long userId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your nickname:");
        String nickname = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        var request = new RemoveUserRequest();
        request.setNickname(nickname);
        request.setPassword(password);

        var response = removeUserService.remove(request);
        System.out.println("Received response: " + response);
    }

    @Override
    public String getActionName() {
        return "Remove";
    }
}
