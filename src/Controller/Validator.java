/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Oshin
 */
public class Validator {
    
     public boolean validatePassword(String password1,String password2){
        if(password1.equals(password2)){
            return true;
        }
        else{
        return false;
    }
     
   }
     
     public boolean validateEmail(String email){
         boolean status=false;
         Users users=Users.getUsersInstance();
         for(int i=0;i<users.size();i++){
             if(users.get(i).getEmail().equals(email)){
                status=true;
             }
             else{
                 status=false;
             }
         }
         
         return status;
     }
     
     
    
}
