package AlzheimerApp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Clase para el manejo de la base de datos.
 * @author Luis Jose Padilla Benitez
 */
public class DataBaseAdapter {

    /**
     * Nombre del archivo de base de datos.
     */
    private String DATABASE_NAME = "alzheimer.db";

    /**
     * Versión de la base de datos.
     */
    private int DATABASE_VERSION = 1;

    /**
     *  Aplicación que utiliza la base de datos.
     */
    private static Context context;

    /**
     * Helper para abrir y/o actualizar la base de datos.
     */
    private DataBaseHelper dbHelper;

    /**
     * Base de datos.
     */
    private SQLiteDatabase db;

    public DataBaseAdapter(Context _context){
        context = _context;
        dbHelper = new DataBaseHelper(_context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Abre la conexió a la base de datos.
     */
    protected void Open(){
        try{
            db = dbHelper.getWritableDatabase();
        }catch (Exception ex){
            Log.e(DataBaseAdapter.class.getName(), ex.getMessage());
        }
    }

    /**
     * Cierra la conexión a la base de datos.
     */
    protected void  Close(){
        try{
            db.close();
        }catch (Exception ex){
            Log.e(DataBaseAdapter.class.getName(), ex.getMessage());
        }
    }

    /**
     * Se obtiene la instancia de la base de datos.
     * @return Instancia de base de datos.
     */
    protected SQLiteDatabase GetDatabase(){
        return db;
    }
}
