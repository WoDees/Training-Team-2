package console.authorization;

import console.UIAction;
import core.RegistrationService;
import domain.UserEntity;

import java.util.Scanner;

public class RegistrationUserUIAction implements UIAction {

    private final RegistrationService registrationService;

    public RegistrationUserUIAction(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public void execute(Long userId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your nickname: ");
        String nickName = scanner.nextLine();
        System.out.println("Please enter your e-mail: ");
        String mail = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        UserEntity newUser = new UserEntity();
        newUser.setNickName(nickName);
        newUser.setMail(mail);
        newUser.setPassword(password);

        registrationService.add(newUser);
    }

    @Override
    public String getActionName() {
        return "Registration";
    }

    public Long registration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your nickname: ");
        String nickName = scanner.nextLine();
        System.out.println("Please enter your e-mail: ");
        String mail = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        System.out.println("Registration successful!");

        UserEntity newUser = new UserEntity();
        newUser.setNickName(nickName);
        newUser.setMail(mail);
        newUser.setPassword(password);

        registrationService.add(newUser);
        return newUser.getUserId();
    }
}
