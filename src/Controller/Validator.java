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

    public boolean isUniqueEmail(String email, SetOfUsers users) {
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
        boolean status = false;
        if (age.matches("[0-9]{1,13}(\\[0-9]*)?") && Double.parseDouble(age) >=16 && Double.parseDouble(age)<=120) {
            status=true;
        }
        return status;     
    }

    public boolean isValidHeight(String height) {                 //height Accepting 90 to 240 centimeters with decimal values
        boolean status = false;
        if (height.matches("[0-9]{1,13}(\\.[0-9]*)?") && Double.parseDouble(height) >=90 && Double.parseDouble(height)<=240) {
            status=true;
        }
        return status;
    }
    
    public boolean isValidWeight(String weight) {                 //weight Accepting 30 to 500 Kg with decimal values     according to https://en.wikipedia.org/wiki/List_of_the_heaviest_people ,I set the maximum weight 500 because average weight of 26 people in the list was 493.4230769230769
        boolean status = false;
        if (weight.matches("[0-9]{1,13}(\\.[0-9]*)?") && Double.parseDouble(weight) >=30 && Double.parseDouble(weight)<=500) {
            status=true;
        }
        return status;
    }
  
}
