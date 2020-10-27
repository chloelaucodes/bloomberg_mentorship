import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
  String DEFAULT_NAME = "Firstname Surname";
  String DEFAULT_EMAIL = "user@domain.com";
  String DEFAULT_PHONE = "01234 567890";

  @Test
  public void checkUserIDExistTest() {
    UserData userData = new UserData();
    userData.addNewUserProfile(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);

    assertTrue(userData.hasUser(0));
  }
  
  @Test
  public void addUserTest() {
    UserData userData = new UserData();
    int userId = userData.addNewUserProfile(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);
    User user = userData.getUser(userId);
    assertEquals(user.getName(), DEFAULT_NAME);
    assertEquals(user.getEmail(), DEFAULT_EMAIL);
    assertEquals(user.getPhone(), DEFAULT_PHONE);
    assertEquals(user.getUserId(), userId);
  }
  
  @Test
  public void changeNameTest() {
    UserData userData = new UserData();
    int userId = userData.addNewUserProfile(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);
    String NEW_NAME = "Newname Surname";
    userData.changeUserName(userId, NEW_NAME);

    assertEquals(userData.getUserName(userId), NEW_NAME);
  }

  @Test
  public void changeEmailTest() {
    UserData userData = new UserData();
    int userId = userData.addNewUserProfile(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);
    String NEW_EMAIL = "newuser@domain.com";
    userData.changeUserEmailAddress(userId, NEW_EMAIL);

    assertEquals(userData.getUserEmailAddress(userId), NEW_EMAIL);
  }

  @Test
  public void changePhoneNumTest() {
    UserData userData = new UserData();
    int userId = userData.addNewUserProfile(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);
    String NEW_PHONE = "00000 000000";
    userData.changeUserPhoneNumber(userId, NEW_PHONE);

    assertEquals(userData.getUserPhoneNumber(userId), NEW_PHONE);
  }

  @Test
  public void displayUserProfileTest() {
    UserData userData = new UserData();
    int userId = userData.addNewUserProfile(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PHONE);
    Date joinDate = userData.getUserJoinDate(userId);
    String display =
        "UserID: "
            + userId
            + "\nName: "
            + DEFAULT_NAME
            + "\nEmail Address: "
            + DEFAULT_EMAIL
            + "\nPhone Number: "
            + DEFAULT_PHONE
            + "\nJoined at: "
            + joinDate;
    
    assertEquals(display, userData.makeString(userId));
  }
}
