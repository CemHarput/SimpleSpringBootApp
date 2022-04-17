package MaviDevStudyCase.demo.Role;

import MaviDevStudyCase.demo.User.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String role;


    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
