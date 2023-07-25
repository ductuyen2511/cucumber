package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class UserHelpers {
  static ObjectMapper mapper = null;
  public static JSONParser parser = new JSONParser();

  public static User inputUser(String userName) throws Exception {
    String data = parser.parse(new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\stubdata\\testDatas\\userColection.json")).toString();
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    UserCollection userCollection = mapper.readValue(data, UserCollection.class);
    List<User> users = userCollection.users.stream()
        .filter(user -> user.username.equalsIgnoreCase(userName))
        .toList();
    if (users.size() == 0) {
      throw new Exception(String.format("no username found, user: %s", userName));
    }
    return users.get(0);
  }

}




