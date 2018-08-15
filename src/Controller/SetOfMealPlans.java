package Controller;

import Models.MealPlan;
import java.util.ArrayList;

/**
 *
 * @author Harshana
 */
public class SetOfMealPlans extends ArrayList<MealPlan> {

    public SetOfMealPlans() {

    }

    public void addMealPlan(MealPlan mealPlan) {

        if (super.isEmpty()) {
            super.add(mealPlan);
            mealPlan.setId(1);
        } else {
            super.add(mealPlan);
            mealPlan.setId(super.get(super.size() - 2).getId() + 1);
        }

        System.out.println("Meal Plan Added Succesfully..!");
        System.out.println("Mealplans ArrayList size: " + super.size());

    }

    public void removeMealPlan(MealPlan mealPlan) {
        super.remove(mealPlan);
    }

    public SetOfMealPlans getMealPlanByName(String name) {
        MealPlan mealPlan = new MealPlan();
        SetOfMealPlans mealPlans = new SetOfMealPlans();
        for (int i = 0; i < super.size(); i++) {
            mealPlan = super.get(i);
            if (mealPlan.getName().equals(name)) {
                mealPlans.add(mealPlan);
            } else {
                mealPlan = null;
            }
        }
        return mealPlans;
    }

    public SetOfMealPlans getMealPlanBycalorieAmount(double amount) {
        MealPlan mealPlan = new MealPlan();
        SetOfMealPlans mealPlans = new SetOfMealPlans();
        for (int i = 0; i < super.size(); i++) {
            mealPlan = super.get(i);
            if (mealPlan.getCalorieAmount() == amount) {
                mealPlans.add(mealPlan);
            } else {
                mealPlan = null;
            }
        }
        return mealPlans;
    }

    public MealPlan getMealPlanById(int id) {
        MealPlan mealPlan = new MealPlan();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId() == id) {
                mealPlan = this.get(i);
            }
        }
        return mealPlan;

    }

}
