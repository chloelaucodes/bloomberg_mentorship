import java.util.HashMap;
import java.util.LinkedList;

public class User {
  /** hashMap that stores all user data */
  private final HashMap<Integer, LinkedList<String>> hashMap;

  /** the easiest way to implement a userID, could be improved by using a hashed function */
  private int counter;

  /** User Class Constructor */
  public User() {
    this.hashMap = new HashMap<Integer, LinkedList<String>>();
    this.counter = 0;
  }

  /**
   * Checks if the database has a specific user with the userID
   *
   * @param userID unique UserID used when adding user to hashMap
   * @return (boolean) whether user exists
   */
  public boolean hasUser(Integer userID) {
    return this.hashMap.containsKey(userID);
  }

  /**
   * Get User Details in a LinkedList<String> Pre: hasUser(userID)
   *
   * @param userID unique UserID used when adding user to hashMap
   * @return (LinkedList < String >) [String name, String emailAddress, String phoneNumber]
   */
  public LinkedList<String> getUserDetails(Integer userID) {
    return this.hashMap.get(userID);
  }

  /**
   * Get User Name in a String Pre: hasUser(userID)
   *
   * @param userID unique UserID used when adding user to hashMap
   * @return (String) user's name
   */
  public String getUserName(Integer userID) {
    return this.hashMap.get(userID).get(0);
  }

  /**
   * Get User Email Address in a String Pre: hasUser(userID)
   *
   * @param userID unique UserID used when adding user to hashMap
   * @return (String) user's email address
   */
  public String getUserEmailAddress(Integer userID) {
    return this.hashMap.get(userID).get(1);
  }

  /**
   * Get User Phone Number in a String Pre: hasUser(userID)
   *
   * @param userID unique UserID used when adding user to hashMap
   * @return (String) user's phone number
   */
  public String getUserPhoneNumber(Integer userID) {
    return this.hashMap.get(userID).get(2);
  }

  /**
   * Adds new user profile into the hashMap Pre: !hasUser(userID)
   *
   * @param name user's name
   * @param emailAddress user's email address
   * @param phoneNumber user's phone number
   */
  public void addNewUserProfile(String name, String emailAddress, String phoneNumber) {
    // Pre: Expected user does not already have a user profile
    LinkedList<String> value = new LinkedList<>();
    value.add(name);
    value.add(emailAddress);
    value.add(phoneNumber);

    this.hashMap.put(counter++, value);
  }

  /**
   * Prints User Profile to terminal
   *
   * @param userID unique UserID used when adding user to hashMap
   */
  public void displayUserProfile(Integer userID) {

    System.out.println(makeString(userID));
  }

  /**
   * Make String for displayUserProfile(userID) to print
   *
   * @param userID unique UserID used when adding user to hashMap
   * @return (String) user details in a string
   */
  public String makeString(Integer userID) {
    LinkedList<String> value = this.hashMap.get(userID);
    return "UserID: "
        + userID
        + "\nName: "
        + value.get(0)
        + "\nEmail Address: "
        + value.get(1)
        + "\nPhone Number: "
        + value.get(2);
  }

  /**
   * Changes the user's name in the hashMap
   *
   * @param userID unique UserID used when adding user to hashMap
   * @param name new name to be change for the user
   */
  public void changeUserName(Integer userID, String name) {
    LinkedList<String> newValue = this.hashMap.get(userID);
    newValue.set(0, name);

    this.hashMap.replace(userID, newValue);
  }

  /**
   * Changes the user's name in the hashMap
   *
   * @param userID unique UserID used when adding user to hashMap
   * @param newEmailAddress new email address to be change for the user
   */
  public void changeUserEmailAddress(Integer userID, String newEmailAddress) {
    LinkedList<String> newValue = this.hashMap.get(userID);
    newValue.set(1, newEmailAddress);

    this.hashMap.replace(userID, newValue);
  }

  /**
   * Changes the user's name in the hashMap
   *
   * @param userID unique UserID used when adding user to hashMap
   * @param newPhoneNumber new phone number to be change for the user
   */
  public void changeUserPhoneNumber(Integer userID, String newPhoneNumber) {
    LinkedList<String> newValue = this.hashMap.get(userID);
    newValue.set(2, newPhoneNumber);

    this.hashMap.replace(userID, newValue);
  }
}
