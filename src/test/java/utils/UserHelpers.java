package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.minidev.json.parser.JSONParser;

import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;


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
                .collect(Collectors.toList());
        if (users.isEmpty()) {
            throw new Exception(String.format("no username found, user: %s", userName));
        }
        return users.get(0);
    }

}




