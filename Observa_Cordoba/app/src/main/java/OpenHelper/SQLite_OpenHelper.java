package OpenHelper;

/*Clase que definira la estructura de la BD*/

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite_OpenHelper extends SQLiteOpenHelper {

    /*Por name es donde entrara en nombre de la BD*/
    public SQLite_OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /*Creamos las estructuras de las tablas y sus relaciones*/
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="create table usuarios(_ID integer primary key autoincrement, Usuario text, Correo text, Contrasenia text)";
        db.execSQL(query);
    }

    /*Si queremos modificar alguna parte de la estructura*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*Abrir BD para poder escribir en ella*/
    public void abrir(){
        this.getWritableDatabase();
    }

    /*Cerrar BD*/
    public void cerrar(){
        this.close();
    }

    /*Insertar registros en la tabla Usuarios*/
    public void insertarRegistro(String user, String mail, String pass){
        ContentValues valores = new ContentValues();
        valores.put("Usuario",user);
        valores.put("Correo",mail);
        valores.put("Contrasenia",pass);
        this.getWritableDatabase().insert("usuarios",null,valores);
    }
}
