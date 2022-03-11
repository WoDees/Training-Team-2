package com.trainingApplication;


import com.trainingApplication.config.AppConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TrainingApplication {

    public static void main(String[] args) {
        try {
            var context = new AnnotationConfigApplicationContext(AppConfig.class);
            var UIMenu = context.getBean(com.trainingApplication.console.UIMenu.class);
            UIMenu.startUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
