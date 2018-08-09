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

    public boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public boolean isValidNumber(String num) {
        return num.matches("[0-9]{1,13}(\\.[0-9]*)?");
    }
    
    public boolean isValidAge(String age){
        return age.matches("^15*(?:[1-9][0-9]?|120)$");        //Age Accepting 16 to 120
    }
   
}
