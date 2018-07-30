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
 * @author Harshana
 */
public class Users extends ArrayList<User>{
    
    
  //  private static Users usersInstance;
    
    public Users(){
        
    }
//    
//   public static Users getUsersInstance() {
//            
//          if (usersInstance == null) {
//            usersInstance = new Users();
//        }  
//            return usersInstance;
//            
//        } 
   
   public void registerUser(User user){
       super.add(user);
       System.out.println("User Added Succesfully..!");
       System.out.println("Number of register users :"+this.size());
   }
     public void removeUser(User user){
       super.remove(user);
   }
     
   public User getUserByEmail(String email){
       User user=new User();
        for(int i=0;i<this.size();i++){
            if(this.get(i).getEmail().equals(email)){
                    //System.out.println(this.get(i).getName());
                    user=this.get(i);
            }
        }
          return user;

   }    
   
   public boolean checkUser(String email){
       
       boolean status=false;
       for(int i=0;i<this.size();i++){
            if(this.get(i).getEmail().equals(email)){
                    //System.out.println(this.get(i).getName());
                       status=true;
            }
            else{
                status=false;
            }
        }
       
       return status;
   }
   
     
    
}
