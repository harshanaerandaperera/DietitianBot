package App;

/**
 *
 * @author Harshana
 */
public class DietMaths {

    public double BMI(double Weight, double Height) {     //W in KG and H in centimeters

        return Weight / (Height / 100 * Height / 100);
    }

    public int TDEE_M(double Weight, double Height, int Age, int ActivityLevelIndex) {  //W in KG and H in centimeters      //to lose weight TDEE-500 range calorie eg if TDEE is 3000 ,to lose weight the calorie range should be 2500-2900
        double ActivityLevel = 0;

        if (ActivityLevelIndex == 0) {
            ActivityLevel = 1.2;
        }
        if (ActivityLevelIndex == 1) {
            ActivityLevel = 1.375;
        }
        if (ActivityLevelIndex == 2) {
            ActivityLevel = 1.55;
        }
        if (ActivityLevelIndex == 3) {
            ActivityLevel = 1.725;
        }

        int REE = (int) Math.round((Weight * 10) + (Height * 6.25) - (5 * Age) + 5);  // Resting Energy Expenditure (REE)
        int TDEE = (int) Math.round(REE * ActivityLevel);                   //TDEE (Total Daily Energy Expenditure)
        return TDEE;
    }

    public int TDEE_F(double Weight, double Height, int Age, int ActivityLevelIndex) {
        double ActivityLevel = 0;

        if (ActivityLevelIndex == 0) {
            ActivityLevel = 1.2;
        }
        if (ActivityLevelIndex == 1) {
            ActivityLevel = 1.375;
        }
        if (ActivityLevelIndex == 2) {
            ActivityLevel = 1.55;
        }
        if (ActivityLevelIndex == 3) {
            ActivityLevel = 1.725;
        }

        int REE = (int) Math.round((Weight * 10) + (Height * 6.25) - (5 * Age) - 161);
        int TDEE = (int) Math.round(REE * ActivityLevel);
        return TDEE;
    }

    public void MACRONUTRIENT(int GoalIndex,int cals) {
      
        double protein=0;
        double fats=0;
        double carbs=0;
        
        if(GoalIndex==0){
            carbs = cals * .5;              
        protein = cals * .25;               
        fats = cals * .25;
        }
        if(GoalIndex==1){       //ModerateI suitable for maintaining weight
            
        carbs = cals * .5;              
        protein = cals * .25;               
        fats = cals * .25;                  
        }
        
        //for a 1 day
        System.out.println("Calories for protein " + protein);
        System.out.println("Calories for fats " + fats);
        System.out.println("Calories for carbs " + carbs);
        System.out.println("Grams for protein " + protein/4);
        System.out.println("Grams for fats " + fats/9);
        System.out.println("Grams for carbs " + carbs/4);
    }

}
