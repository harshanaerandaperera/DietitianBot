package Models;

import java.io.Serializable;

/**
 *
 * @author Harshana
 */
public class MealPlan implements Serializable {

    private int id;
    private String name;
    private double calorieAmount;
    private String breakfast;
    private String lunch;
    private String dinner;
    private String snack;
    private String macro;

    public MealPlan() {

    }

    public MealPlan(String name, double calorieAmount, String breakfast, String lunch, String dinner, String snack, String nutrient) {
        this.name = name;
        this.calorieAmount = calorieAmount;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.snack = snack;
        this.macro = nutrient;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the calorieAmount
     */
    public double getCalorieAmount() {
        return calorieAmount;
    }

    /**
     * @return the breakfast
     */
    public String getBreakfast() {
        return breakfast;
    }

    /**
     * @return the lunch
     */
    public String getLunch() {
        return lunch;
    }

    /**
     * @return the dinner
     */
    public String getDinner() {
        return dinner;
    }

    /**
     * @return the snack
     */
    public String getSnack() {
        return snack;
    }

    /**
     * @return the macro
     */
    public String getMacro() {
        return macro;
    }

}
