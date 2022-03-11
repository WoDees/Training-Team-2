package com.trainingApplication;

import com.trainingApplication.config.AppConfig;
import com.trainingApplication.console.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TrainingApplication {

    public static void main(String[] args) {

        try {
            var context = new AnnotationConfigApplicationContext(AppConfig.class);
            var uiMenu = context.getBean(UIMenu.class);
            uiMenu.startUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
