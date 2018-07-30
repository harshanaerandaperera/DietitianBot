/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Harshana
 */
public class Validator {

    public boolean confirmPassword(String password1, String password2) {
        if (password1.equals(password2)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isUniqueEmail(String email, Users users) {
        boolean status = true;
        if (users.size() == 0) {
            status = true;
        } else {
            for (int i = 0; i < users.size();) {
                if (users.get(i).getEmail().equals(email)) {
                    status = false;
                    break;
                } else {
                    i++;
                }
            }
        }
        return status;
    }
    
    public boolean isValidEmail(String email) {
        return email.matches("^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$");
    }
    
}
