package Models;


import java.io.Serializable;

/**
 *
 * @author Harshana
 */
public class User implements Serializable {

    private String name;
    //unique
    private String email;
    private int age;
    private double height;
    private double weight;
    private String gender;
    private String password;
    private String goal;
    private String ActivityLevel;
    
    public User() {

    }

    /**
     *
     * @param name
     * @param email
     * @param age
     * @param height
     * @param weight
     * @param gender
     * @param password
     */

    public User(String name, String email, int age, double height, double weight, String gender, String password) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.password = password;
        System.out.println("User created--!");

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the goal
     */
    public String getGoal() {
        return goal;
    }

    /**
     * @param goal the goal to set
     */
    public void setGoal(String goal) {
        this.goal = goal;
    }

    /**
     * @return the ActivityLevel
     */
    public String getActivityLevel() {
        return ActivityLevel;
    }

    /**
     * @param ActivityLevel the ActivityLevel to set
     */
    public void setActivityLevel(String ActivityLevel) {
        this.ActivityLevel = ActivityLevel;
    }

}
