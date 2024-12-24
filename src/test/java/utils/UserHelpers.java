package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class UserHelpers {
    static ObjectMapper objectMapper = new ObjectMapper();;
    public static String json = "src/test/resources/stubdata/testDatas/userColection.json";

    public static User inputUser(String userName) throws Exception {
        String jsonContent = new String(Files.readAllBytes(Paths.get(json)));
        objectMapper.registerModule(new JavaTimeModule());
        UserCollection userCollection = objectMapper.readValue(jsonContent, UserCollection.class);
        List<User> users = userCollection.users.stream()
                .filter(user -> user.username.equalsIgnoreCase(userName))
                .collect(Collectors.toList());
        if (users.isEmpty()) {
            throw new Exception(String.format("no username found, user: %s", userName));
        }
        return users.get(0);
    }

}




