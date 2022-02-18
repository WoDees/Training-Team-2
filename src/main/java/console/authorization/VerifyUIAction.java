package console.authorization;

import console.UIAction;
import core.VerifyService;
import domain.UserEntity;

import java.util.Scanner;

public class VerifyUIAction implements UIAction {

    private final VerifyService verifyService;

    public VerifyUIAction(VerifyService verifyService) {
        this.verifyService = verifyService;
    }

    @Override
    public void execute(Long userId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your nickName: ");
        String nickName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        verifyService.entrance(nickName, password);
        verifyService.findAll()
                .forEach(System.out::println);
    }

    @Override
    public String getActionName() {
        return "LogIn";
    }

    public Long login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your nickName: ");
        String nickName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        verifyService.findAll()
                .forEach(System.out::println);
        UserEntity entity = verifyService.entrance(nickName, password);

        return entity.getUserId();
    }
}
