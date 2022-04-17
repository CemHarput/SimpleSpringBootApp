package MaviDevStudyCase.demo.User;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class UserData implements Serializable {

    @NotEmpty(message = "username can not be empty")
    private String username;



    @NotEmpty(message = "Role can not be empty")
    private String role;

    @NotEmpty(message = "Password can not be empty")
    private String password;
}
