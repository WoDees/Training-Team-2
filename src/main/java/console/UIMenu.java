package console;

import console.authorization.AuthorizationUIAction;

import java.util.List;
import java.util.Scanner;

public class UIMenu {

    private final List<UIAction> uiActions;
    private final List<AuthorizationUIAction> authorizationActions;

    public UIMenu(List<UIAction> uiActions, List<AuthorizationUIAction> authorizationActions) {
        this.uiActions = uiActions;
        this.authorizationActions = authorizationActions;
    }

    public void startUI() {
        Long userId = null;
        while (true) {
            try {
                while (userId == null) {
                    for (AuthorizationUIAction action : authorizationActions) {
                        if (action.getActionName().equals("Authorization")) {
                            userId = action.authorization();

                        }
                    }
                }
                System.out.println("Please make your choice: ");
                for (int i = 0; i < uiActions.size(); i++) {
                    var uiAction = uiActions.get(i);
                    System.out.println(i + ". " + uiAction.getActionName());
                }
                Scanner scanner = new Scanner(System.in);
                int userInput = scanner.nextInt();

                uiActions.get(userInput).execute(userId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
