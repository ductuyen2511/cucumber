package utils;

public class Credential {
  private final String username;
  private final String password;

  public Credential(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }
}
