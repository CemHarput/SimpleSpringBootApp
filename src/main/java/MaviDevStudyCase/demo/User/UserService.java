package MaviDevStudyCase.demo.User;

import MaviDevStudyCase.demo.config.JpaUserDetailsService;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService{

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JpaUserDetailsService jpaUserDetailsService;

    public void register_user(UserData user) throws Exception {



      //  if(Objects.equals(user.getUsername(), String.valueOf(checkIfUserExist(user.getUsername())))){
      //      throw  new Exception("Username:"+user.getUsername()+" not found");
     //   }else{
        User user_entity = new User();//you can use builder also.
        BeanUtils.copyProperties(user,user_entity);
        encodePassword(user_entity,user);
        userRepository.save(user_entity);


    }

    public UserDetails checkIfUserExist(String username) {
       // return userRepository.findByUsername(username).isPresent();
        return jpaUserDetailsService.loadUserByUsername(username);

    }

    private void encodePassword( User user_entity, UserData user){
        user_entity.setPassword(passwordEncoder.encode(user.getPassword()));
    }


}
