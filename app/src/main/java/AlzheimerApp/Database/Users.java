package AlzheimerApp.Database;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Modelo de usuario
 * @author luis jose padilla benitez
 */
@Table(name = "users")
public class Users extends Model {
    @Column(name = "user_name")
    public String userName;

    public Users(){
        super();
    }

    public Users(String userName){
        super();
        this.userName = userName;
    }
}
