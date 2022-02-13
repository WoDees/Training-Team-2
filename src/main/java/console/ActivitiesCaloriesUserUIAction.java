package console;

import core.ActivitiesCaloriesService;

public class ActivitiesCaloriesUserUIAction implements UIAction {

    private final ActivitiesCaloriesService activitiesCaloriesService;

    public ActivitiesCaloriesUserUIAction(ActivitiesCaloriesService activitiesCaloriesService) {
        this.activitiesCaloriesService = activitiesCaloriesService;
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Activities");
    }

    @Override
    public String getActionName() {
        return null;
    }
}
