/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.MealPlan;
import java.util.ArrayList;

/**
 *
 * @author Debug
 */
public class MealPlans extends ArrayList<MealPlan>{
    
    public MealPlans(){
        
    }
    
     public void addMealPlan(MealPlan mealPlan) {
        super.add(mealPlan);
        System.out.println("Meal Plan Added Succesfully..!");
        System.out.println("Number of Meal Plans  :" + this.size());
        mealPlan.setId(this.size());
     }
    
     public void removeMealPlan(MealPlan mealPlan){
         super.remove(mealPlan);
     }
       public MealPlan getMealPanById(int id) {
        MealPlan mealPlan = new MealPlan();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId()==id) {
                mealPlan = this.get(i);
            }
        }
        return mealPlan;

    }
        
    public MealPlans getMealPlanByName(String name) {
        MealPlan mealPlan = new MealPlan();
        MealPlans mealPlans = new MealPlans();
        for (int i = 0; i < super.size(); i++) {
            mealPlan = super.get(i);
            if (mealPlan.getName().equals(name)) {
                mealPlans.add(mealPlan);
            } else {
                mealPlan=null;
            }
        }
        return mealPlans;
    }
    
    public MealPlans getMealPlanBycalorieAmount(double amount) {
        MealPlan mealPlan = new MealPlan();
        MealPlans mealPlans = new MealPlans();
        for (int i = 0; i < super.size(); i++) {
            mealPlan = super.get(i);
            if (mealPlan.getCalorieAmount()==amount) {
                mealPlans.add(mealPlan);
            } else {
                mealPlan=null;
            }
        }
        return mealPlans;
    }

    
}
