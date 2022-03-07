package console.authorization;

import core.AddUserService;
import dto.request.AddUserRequest;

import java.util.Scanner;

public class AddUserUIAction implements UIAuthorization {

    private final AddUserService addUserService;

    public AddUserUIAction(AddUserService addUserService) {
        this.addUserService = addUserService;
    }

    @Override
    public Long execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your nickname: ");
        String nickName = scanner.nextLine();
        System.out.println("Please enter your e-mail: ");
        String mail = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        var request = new AddUserRequest();
        request.setNickName(nickName);
        request.setPassword(password);
        request.setMail(mail);
        request.setOnlineStatus(true);

        var response = addUserService.add(request);
        System.out.println("Received response: " + response);

        if (response == null) {
            System.out.println("Registration successful!");
            return response.getCreatedUserId();
        }
        return response.getCreatedUserId();

    }

    @Override
    public String getActionName() {
        return "Registration";
    }
}
