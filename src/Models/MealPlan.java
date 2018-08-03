package Models;

import java.io.Serializable;

/**
 *
 * @author Harshana
 */
public class MealPlan implements Serializable{

   
    private int id;
    private String name;
    private double calorieAmount;
    private String breakfast;
    private String lunch;
    private String dinner;
    private String snack;
    
    public MealPlan(){
        
    }
    
    public MealPlan(String name,double calorieAmount,String breakfast,String lunch,String dinner,String snack ){
        this.name=name;
        this.calorieAmount=calorieAmount;
        this.breakfast=breakfast;
        this.lunch=lunch;
        this.dinner=dinner;
        this.snack=snack;
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
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the calorieAmount
     */
    public double getCalorieAmount() {
        return calorieAmount;
    }

    /**
     * @param calorieAmount the calorieAmount to set
     */
    public void setCalorieAmount(double calorieAmount) {
        this.calorieAmount = calorieAmount;
    }

    /**
     * @return the breakfast
     */
    public String getBreakfast() {
        return breakfast;
    }

    /**
     * @param breakfast the breakfast to set
     */
    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    /**
     * @return the lunch
     */
    public String getLunch() {
        return lunch;
    }

    /**
     * @param lunch the lunch to set
     */
    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    /**
     * @return the dinner
     */
    public String getDinner() {
        return dinner;
    }

    /**
     * @param dinner the dinner to set
     */
    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    /**
     * @return the snack
     */
    public String getSnack() {
        return snack;
    }

    /**
     * @param snack the snack to set
     */
    public void setSnack(String snack) {
        this.snack = snack;
    }
 
    
}
