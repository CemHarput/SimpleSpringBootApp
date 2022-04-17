package MaviDevStudyCase.demo.User;

import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void register_user(UserData user){

     //   if(checkIfUserExist(user.getUsername())){
     //       throw new DuplicateRequestException("Username is already exist");
     //   }
        User user_entity = new User();//you can use builder also.
        BeanUtils.copyProperties(user,user_entity);
        encodePassword(user_entity,user);
        userRepository.save(user_entity);

    }

    public boolean checkIfUserExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    private void encodePassword( User user_entity, UserData user){
        user_entity.setPassword(passwordEncoder.encode(user.getPassword()));
    }


}
