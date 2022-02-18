package console;

import core.VerifyService;

import java.util.Scanner;

public class VerifyUIAction implements UIAction {

    private final VerifyService verifyService;

    public VerifyUIAction(VerifyService verifyService) {
        this.verifyService = verifyService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your nickName: ");
        String nickName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        verifyService.entrance(nickName, password);
    }

    @Override
    public String getActionName() {
        return "LogIn";
    }
}
