package App;

import Controller.DietMaths;

public class test {

    public static void main(String[] args) {
        //call the API
//        LUIS L=new LUIS();
//        L.setQuery("text that I'm busy");
//        L.ProcessQuery();
//        System.out.println("TopIntent = "+L.getTopScoreIntent());

    
        
        DietMaths t=new DietMaths();
      //  System.out.println(t.TDEE_M(88, 183, 29, 3));
      //  t.TDEE_M(88, 183, 29, 3);
       // System.out.println(t.BMI(80,180));
       t.MACRONUTRIENT(1, 2000);
   
    }

    

    

}
