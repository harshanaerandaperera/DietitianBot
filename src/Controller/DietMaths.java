package Controller;

/**
 *
 * @author Harshana
 */
public class DietMaths {

    public DietMaths(){
        
    }
    /**
     * 
     * @param Weight
     * @param Height
     * @return 
     */
    
    public double BMI(double Weight, double Height) {     //W in KG and H in centimeters

        return Weight / (Height / 100 * Height / 100);
    }

    /**
     * Total Daily Energy Expenditure(Daily Calorie requirement) For Male
     *
     * @param Weight
     * @param Height
     * @param Age
     * @param ActivityLevelIndex
     * @return TDEE
     */
    public int TDEE_M(double Weight, double Height, int Age, int ActivityLevelIndex) {  //W in KG and H in centimeters      //to lose weight TDEE-500 range calorie eg if TDEE is 3000 ,to lose weight the calorie range should be 2500-2900
        double ActivityLevel = 0;

        if (ActivityLevelIndex == 0) {
            ActivityLevel = 1.2;
            System.out.println("ActivityLevel"+ActivityLevel);
        }
        if (ActivityLevelIndex == 1) {
            ActivityLevel = 1.375;
            System.out.println("ActivityLevel"+ActivityLevel);
        }
        if (ActivityLevelIndex == 2) {
            ActivityLevel = 1.55;
            System.out.println("ActivityLevel"+ActivityLevel);
        }
        if (ActivityLevelIndex == 3) {
            ActivityLevel = 1.725;
            System.out.println("ActivityLevel"+ActivityLevel);
        }

        int REE = (int) Math.round((Weight * 10) + (Height * 6.25) - (5 * Age) + 5);  // Resting Energy Expenditure (REE)
        int TDEE = (int) Math.round(REE * ActivityLevel);                   //TDEE (Total Daily Energy Expenditure)
        return TDEE;
    }

    /** Total Daily Energy Expenditure(Daily Calorie requirement) For female
     *
     * @param Weight
     * @param Height
     * @param Age
     * @param ActivityLevelIndex
     * @return TDEE
     */
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
    
/** General NUTRIENT Calculator
 * 
 * @param GoalIndex
 * @param cals 
 */
    public String MNUTRIENT(double cals) {

        double protein = 0;
        double fats = 0;
        double carbs = 0;
        //(Moderate Ratio) Carbs/Protein/Fat(50/30/20)     
        { 
            carbs = cals * .5;
            protein = cals * .3;
            fats = cals * .2;
        }
  
        StringBuilder sb=new StringBuilder();
        sb.append("Calories for protein : ");
        sb.append(protein);
        sb.append("\n");
        sb.append("Calories for fats : ");
        sb.append(fats);
        sb.append("\n");
        sb.append("Calories for carbs : ");
        sb.append(carbs);
        sb.append("\n");
        sb.append("Grams for protein : ");
        sb.append(protein/4);
        sb.append("\n");
        sb.append("Grams for fats : ");
        sb.append(fats/9);
        sb.append("\n");
        sb.append("Grams for carbs : ");
        sb.append(carbs/4);

        
        return sb.toString();
        
    }

}
