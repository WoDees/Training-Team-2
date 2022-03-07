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
        String nickname = scanner.nextLine();
        System.out.println("Please enter your e-mail: ");
        String mail = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        var request = new AddUserRequest();
        request.setNickname(nickname);
        request.setPassword(password);
        request.setMail(mail);

        var response = addUserService.add(request);
        System.out.println("Received response: " + response);
        addUserService.findAll().forEach(System.out::println);
        return response.getCreatedUserId();
    }

    @Override
    public String getActionName() {
        return "Registration";
    }
}
