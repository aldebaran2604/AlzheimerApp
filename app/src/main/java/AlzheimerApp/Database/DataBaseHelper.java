package AlzheimerApp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author Luis Jose Padilla Benitez
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    /**
     * Script para crear la tabla en la base de datos.
     */
    private String DATABASE_CREATE = "";

    /**
     * Nombre de la tabla.
     */
    private String DATABASE_UPGRADE = "";

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(DATABASE_CREATE);
        }
        catch (Exception ex){
            Log.e(DataBaseHelper.class.getName(), ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("");
    }

    public void SetScriptCreateDatabase(String databaseCreate){
        DATABASE_CREATE = databaseCreate;
    }

    public void SetDatabaseTable(String databaseUpgrade){
        DATABASE_UPGRADE = databaseUpgrade;
    }
}
