package MaviDevStudyCase.demo.Info;


import javax.persistence.*;

@Entity
@Table
public class Info {
    @Id
    @SequenceGenerator(
            name ="info_sequence",
            sequenceName = "info_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "info_sequence"
    )
    private Long id;
    private String il;
    private String ilce;


    public Info() {
    }

    public Info(Long id, String il, String ilce) {
        this.id = id;
        this.il = il;
        this.ilce = ilce;
    }

    public Info(String il, String ilce) {
        this.il = il;
        this.ilce = ilce;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", il='" + il + '\'' +
                ", ilce='" + ilce + '\'' +
                '}';
    }
}
