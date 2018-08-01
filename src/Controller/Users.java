package Controller;

import Models.User;
import java.util.ArrayList;

/**
 *
 * @author Harshana
 */
public class Users extends ArrayList<User> {

    public Users() {

    }
    public void registerUser(User user) {
        super.add(user);
        System.out.println("User Added Succesfully..!");
        System.out.println("Number of register users :" + this.size());
    }

    public void removeUser(User user) {
        super.remove(user);
    }

    public User getUserByEmail(String email) {
        User user = new User();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEmail().equals(email)) {
                user = this.get(i);
            }
        }
        return user;

    }

}
