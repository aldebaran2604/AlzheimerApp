package AlzheimerApp.Database;

import android.content.ContentValues;
import android.content.Context;

public class User extends  DataBaseAdapter {

    private String TABLE_NAME = "users";

    private String SCRIPT_CREATE = "CREATE TABLE users(id integer primary key autoincrement, nombre TEXT, apellidoPaterno TEXT, apellidoMaterno TEXT, sexo integer, password TEXT)";

    private String SCRIPT_UPGRADE = "DROP TABLE IF EXISTS users";

    public int id;

    public String nombre;

    public String apellidoPaterno;

    public String apellidoMaterno;

    public Sexo sexo;

    public String password;

    public User(Context _context) {
        super(_context);

        dbHelper.SetScriptCreateDatabase(SCRIPT_CREATE);
        dbHelper.SetScriptUpgradeDatabase(SCRIPT_UPGRADE);
    }

    public boolean DBInser(){
        if(!(nombre != null && !nombre.isEmpty())){
            return false;
        }
        if(!(apellidoPaterno != null && !apellidoPaterno.isEmpty())){
            return false;
        }
        if(!(apellidoMaterno != null && !apellidoMaterno.isEmpty())){
            return false;
        }
        if(sexo == Sexo.Ninguno){
            return false;
        }
        if(!(password != null && !password.isEmpty())){
            return false;
        }
        ContentValues newValues = new ContentValues();
        newValues.put("nombre", nombre);
        newValues.put("apellidoPaterno", apellidoPaterno);
        newValues.put("apellidoMaterno", apellidoMaterno);
        newValues.put("sexo", sexo.getValue());
        newValues.put("password", password);

        Long resultData = GetDatabase().insert(TABLE_NAME, null, newValues);

        return true;
    }
}
