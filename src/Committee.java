import java.io.File;
import java.io.FileWriter;

public class Committee {
    public String mail;
    public String password;
    public String name;
    public String isCommittee;

    public Committee(String mailadd, String ps, String na, String is){
        this.mail = mailadd;
        this.password = ps;
        this.name = na;
        this.isCommittee = is;
    }

    public String writeNewPerson() {
        return this.mail + " " + this.password + " " + this.name + " " + this.isCommittee;
    }




}
