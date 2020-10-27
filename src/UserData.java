import java.util.Date;
import java.util.HashMap;

public class UserData {
  /** hashMap that stores all user data */
  private final HashMap<Integer, User> hashMap;

  /** the easiest way to implement a userID, could be improved by using a hashed function */
  private int counter;

  /** User Class Constructor */
  public UserData() {
    this.hashMap = new HashMap<>();
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
   * Get User in a String Pre: hasUser(userID)
   *
   * @param userID unique UserID used when adding user to hashMap
   * @return (String) user's name
   */
  public User getUser(Integer userID) {
    return this.hashMap.get(userID);
  }

  /**
   * Get User Name in a String Pre: hasUser(userID)
   *
   * @param userID unique UserID used when adding user to hashMap
   * @return (String) user's name
   */
  public String getUserName(Integer userID) {
    return this.hashMap.get(userID).getName();
  }

  /**
   * Get User Email Address in a String Pre: hasUser(userID)
   *
   * @param userID unique UserID used when adding user to hashMap
   * @return (String) user's email address
   */
  public String getUserEmailAddress(Integer userID) {
    return this.hashMap.get(userID).getEmail();
  }

  /**
   * Get User Phone Number in a String Pre: hasUser(userID)
   *
   * @param userID unique UserID used when adding user to hashMap
   * @return (String) user's phone number
   */
  public String getUserPhoneNumber(Integer userID) {
    return this.hashMap.get(userID).getPhone();
  }

  /**
   * Get User Join Date in a String Pre: hasUser(userID)
   *
   * @param userID unique UserID used when adding user to hashMap
   * @return (Date) user's join date
   */
  public Date getUserJoinDate(Integer userID) {
    return this.hashMap.get(userID).getJoinDate();
  }

  /**
   * Adds new user profile into the hashMap Pre: !hasUser(userID)
   *
   * @param name user's name
   * @param emailAddress user's email address
   * @param phoneNumber user's phone number
   */
  public Integer addNewUserProfile(String name, String emailAddress, String phoneNumber) {
    // Pre: Expected user does not already have a user profile
    this.hashMap.put(counter, new User(counter, name, emailAddress, phoneNumber));
    return counter++;
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
    User user = this.hashMap.get(userID);
    return "UserID: "
        + userID
        + "\nName: "
        + user.getName()
        + "\nEmail Address: "
        + user.getEmail()
        + "\nPhone Number: "
        + user.getPhone()
        + "\nJoined at: "
        + user.getJoinDate();
  }

  /**
   * Changes the user's name in the hashMap
   *
   * @param userID unique UserID used when adding user to hashMap
   * @param name new name to be change for the user
   */
  public void changeUserName(Integer userID, String name) {
    this.hashMap.get(userID).setName(name);
  }

  /**
   * Changes the user's email in the hashMap
   *
   * @param userID unique UserID used when adding user to hashMap
   * @param newEmailAddress new email address to be change for the user
   */
  public void changeUserEmailAddress(Integer userID, String newEmailAddress) {
    this.hashMap.get(userID).setEmail(newEmailAddress);
  }

  /**
   * Changes the user's name in the hashMap
   *
   * @param userID unique UserID used when adding user to hashMap
   * @param newPhoneNumber new phone number to be change for the user
   */
  public void changeUserPhoneNumber(Integer userID, String newPhoneNumber) {
    this.hashMap.get(userID).setPhone(newPhoneNumber);
  }
}
