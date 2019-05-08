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
     * Script para actualizar la tabla en la base de datos.
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

        Log.w(DataBaseHelper.class.getName(), "Upgrading from version " +oldVersion + " to " +newVersion + ", which will destroy all old data");

        db.execSQL(DATABASE_UPGRADE);

        onCreate(db);
    }

    public void SetScriptCreateDatabase(String databaseCreate){
        DATABASE_CREATE = databaseCreate;
    }

    public void SetScriptUpgradeDatabase(String databaseUpgrade){
        DATABASE_UPGRADE = databaseUpgrade;
    }
}
