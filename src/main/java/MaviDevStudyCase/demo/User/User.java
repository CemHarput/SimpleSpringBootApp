package MaviDevStudyCase.demo.User;

import MaviDevStudyCase.demo.Role.Role;
import lombok.*;

import javax.persistence.*;

import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "info_user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;


    @Singular
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name ="user_and_role",
            joinColumns={@JoinColumn(name="USER_ID",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="ROLE_ID",referencedColumnName = "id")})
    private Set<Role> roles;

    @Builder.Default
    private Boolean accountNonExpired =true;

    @Builder.Default
    private Boolean accountNonLocked = true;

    @Builder.Default
    private Boolean credentialsNonExpired = true;

    @Builder.Default
    private Boolean enabled=true;


}
