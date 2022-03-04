package console.authorization;

import console.UIAction;
import core.VerifyUserService;
import domain.UserEntity;

import java.util.Scanner;

public class VerifyUIAction implements UIAuthorization {

    private final VerifyUserService verifyService;

    public VerifyUIAction(VerifyUserService verifyService) {
        this.verifyService = verifyService;
    }

    @Override
    public Long execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your nickName: ");
        String nickName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        UserEntity entity = verifyService.entrance(nickName, password);

        if (entity.getUserId() != null) {
            verifyService.findAll()
                    .forEach(System.out::println);

            System.out.println("Log in successful!");
            return entity.getUserId();
        }
        System.out.println("Wrong user name or password!");
        return null;
    }

    @Override
    public String getActionName() {
        return "Log In";
    }
}
