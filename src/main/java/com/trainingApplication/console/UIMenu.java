package com.trainingApplication.console;

import com.trainingApplication.console.authorization.UIAuthorization;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UIMenu {

    private final List<UIAction> uiActions;
    private final List<UIAuthorization> uiAuthorizations;

    public UIMenu(List<UIAction> uiActions, List<UIAuthorization> uiAuthorizations) {
        this.uiActions = uiActions;
        this.uiAuthorizations = uiAuthorizations;
    }

    public void startUI() {
        boolean onlineStatus = false;
        Long userId = null;

        while (true) {
            try {

                Scanner scanner = new Scanner(System.in);

                while (!onlineStatus) {
                    System.out.println("Please make your choice: ");
                    for (int i = 0; i < uiAuthorizations.size(); i++) {
                        var uiAuthorization = uiAuthorizations.get(i);
                        System.out.println(i + ". " + uiAuthorization.getActionName());
                    }

                    int userInput = scanner.nextInt();
                    userId = uiAuthorizations.get(userInput).execute();
                    if (userId != null) {
                        onlineStatus = true;
                    }
                }

                System.out.println("Please make your choice: ");
                for (int i = 0; i < uiActions.size(); i++) {
                    var uiAction = uiActions.get(i);
                    System.out.println(i + ". " + uiAction.getActionName());
                }

                int userInput = scanner.nextInt();
                uiActions.get(userInput).execute(userId);


                if (uiActions.get(userInput).getActionName().equals("Log Out")) {
                    onlineStatus = false;
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
