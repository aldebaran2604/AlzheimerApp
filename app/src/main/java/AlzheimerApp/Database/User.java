package AlzheimerApp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

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

    public User(){
        super();
    }

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

    public boolean DBDelete(Integer id) {
        int resultData = GetDatabase().delete(TABLE_NAME, "id = ?", new String[]{ id.toString() } );
        return true;
    }

    public boolean DBUpdate(Integer id){
        ContentValues updateValues = new ContentValues();
        updateValues.put("nombre", nombre);
        updateValues.put("apellidoPaterno", apellidoPaterno);
        updateValues.put("apellidoMaterno", apellidoMaterno);
        updateValues.put("sexo", sexo.getValue());
        updateValues.put("password", password);

        int resultData = GetDatabase().update(TABLE_NAME, updateValues, "id = ?", new String[]{ id.toString() });
        return true;
    }

    public User GetByID(Integer id){
        Cursor cursor = GetDatabase().rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE id = "+ id.toString(), null);
        cursor.moveToFirst();
        User user = null;
        if(cursor.getCount() > 0){
            user = new User();
            user.nombre = cursor.getString(cursor.getColumnIndex("nombre"));
            user.apellidoPaterno = cursor.getString(cursor.getColumnIndex("apellidoPaterno"));
            user.apellidoMaterno = cursor.getString(cursor.getColumnIndex("apellidoMaterno"));
            user.sexo = Sexo.valueOf(Integer.parseInt(cursor.getString(cursor.getColumnIndex("sexo"))));
            user.password = cursor.getString(cursor.getColumnIndex("password"));
        }
        return user;
    }

    public List<User> GetAll(){
        List<User> users = new ArrayList<User>();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = GetDatabase().rawQuery(query, null);
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false){
            User user = new User();
            users.add(user);
            user.nombre = cursor.getString(cursor.getColumnIndex("nombre"));
            user.apellidoPaterno = cursor.getString(cursor.getColumnIndex("apellidoPaterno"));
            user.apellidoMaterno = cursor.getString(cursor.getColumnIndex("apellidoMaterno"));
            user.sexo = Sexo.valueOf(Integer.parseInt(cursor.getString(cursor.getColumnIndex("sexo"))));
            user.password = cursor.getString(cursor.getColumnIndex("password"));
            cursor.moveToNext();
        }
        return users;
    }
}
