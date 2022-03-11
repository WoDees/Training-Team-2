package com.trainingApplication.console;

import org.springframework.stereotype.Component;

@Component
public interface UIAction {

    void execute(Long userId);

    String getActionName();

}
