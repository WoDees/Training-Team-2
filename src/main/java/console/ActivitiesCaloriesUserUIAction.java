package console;

import core.service.ActivitiesCaloriesService;

public class ActivitiesCaloriesUserUIAction implements UIAction {

    private final ActivitiesCaloriesService activitiesCaloriesService;

    public ActivitiesCaloriesUserUIAction(ActivitiesCaloriesService activitiesCaloriesService) {
        this.activitiesCaloriesService = activitiesCaloriesService;
    }

    @Override
    public void execute(Long userId) {
        throw new UnsupportedOperationException("Activities");
    }

    @Override
    public String getActionName() {
        return "ActivitiesCalories";
    }
}
