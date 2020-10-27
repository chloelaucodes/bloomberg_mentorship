import java.util.Date;

class User {
  private Integer userId;
  private String name;
  private String email;
  private String phone;
  private Date joinDate;

  public User(Integer userId, String name, String email, String phone) {
    this.userId = userId;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.joinDate = new Date();
  }

  public Integer getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Date getJoinDate() {
    return joinDate;
  }
}
