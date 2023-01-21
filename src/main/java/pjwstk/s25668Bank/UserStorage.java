package pjwstk.s25668Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {
    private List<User> users = new ArrayList<>();

    public void addUser(User user)
    {
        users.add(user);
    }
    public User findAccount(String id)
    {
        for(User user : users)
        {
            if(user.getId().equals(id))
            {
                return user;
            }
        }
        return null;
    }
}
