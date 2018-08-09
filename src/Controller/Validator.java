package Controller;

import jdk.nashorn.internal.ir.BreakNode;

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

    public boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public boolean isValidNumber(String num) {
        return num.matches("[0-9]{1,13}(\\.[0-9]*)?");
    }

    public boolean isValidAge(String age) {                          //Age Accepting 16 to 120
        return age.matches("^15*(?:[1-9][0-9]?|120)$");       
    }

    public boolean isValidHeight(String height) {                 //height Accepting 90 to 240 centimeters with decimal values
        boolean status = false;
        if (height.matches("[0-9]{1,13}(\\.[0-9]*)?") && Double.parseDouble(height) >=90 && Double.parseDouble(height)<=240) {
            status=true;
        }
        return status;
    }

   

}
