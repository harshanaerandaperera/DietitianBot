/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.User;
import java.util.ArrayList;

/**
 *
 * @author Debug
 */
public class Users extends ArrayList<User>{
    
    
    private static Users usersInstance;
    
    private Users(){
        
    }
    
   public static Users getUsersInstance() {
            
          if (usersInstance == null) {
            usersInstance = new Users();
        }  
            return usersInstance;
            
        } 
   
   public void addUser(User user){
       super.add(user);
       System.out.println("User Added Succesfully..!");
       System.out.println("Number of register users :"+this.size());
   }
     public void removeUser(User user){
       super.remove(user);
   }
     
   public void getUserByEmail(String email){
       System.out.println("hai");
      // User user=new User();
        for(int i=0;i<usersInstance.size();i++){
            if(usersInstance.get(i).getEmail().equals(email)){
                    System.out.println(this.get(i).getName());
            }
        }
         //  return user;

   }    
     
    
}
