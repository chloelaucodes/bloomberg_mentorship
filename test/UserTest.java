import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
  String DEFAULT_NAME = "Firstname Surname";
  String DEFAULT_EMAIL = "user@domain.com";
  String DEFAULT_PHONE = "01234 567890";
  
  @Test
  public void addUserTest() {
    User user = new User();
    user.addNewUserProfile(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);
    
    LinkedList<String> list = new LinkedList<>();
    list.add(DEFAULT_NAME);
    list.add(DEFAULT_EMAIL);
    list.add(DEFAULT_PHONE);
    
    assertEquals(user.getUserDetails(0), list);
  }
  
  @Test
  public void checkUserIDExistTest() {
    User user = new User();
    user.addNewUserProfile(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);
    
    assertTrue(user.hasUser(0));
  }
  
  @Test
  public void changeNameTest() {
    User user = new User();
    user.addNewUserProfile(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);
    String NEW_NAME = "Newname Surname";
    user.changeUserName(0, NEW_NAME);
    
    assertEquals(user.getUserName(0), NEW_NAME);
  }
  
  @Test
  public void changeEmailTest() {
    User user = new User();
    user.addNewUserProfile(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);
    String NEW_EMAIL = "newuser@domain.com";
    user.changeUserEmailAddress(0, NEW_EMAIL);
    
    assertEquals(user.getUserEmailAddress(0), NEW_EMAIL);
  }
  
  @Test
  public void changePhoneNumTest() {
    User user = new User();
    user.addNewUserProfile(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);
    String NEW_PHONE = "00000 000000";
    user.changeUserPhoneNumber(0, NEW_PHONE);
    
    assertEquals(user.getUserPhoneNumber(0), NEW_PHONE);
  }
  
  @Test
  public void displayUserProfileTest() {
    User user = new User();
    user.addNewUserProfile(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);
    
    String display =
            "UserID: "
                    + 0
                    + "\nName: "
                    + DEFAULT_NAME
                    + "\nEmail Address: "
                    + DEFAULT_EMAIL
                    + "\nPhone Number: "
                    + DEFAULT_PHONE;
    
    assertEquals(display, user.makeString(0));
  }
}
