package MaviDevStudyCase.demo.User;

import MaviDevStudyCase.demo.Role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String role);
    User getUser(String username);




}
