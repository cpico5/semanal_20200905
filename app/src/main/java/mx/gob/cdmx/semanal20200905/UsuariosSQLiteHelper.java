package mx.gob.cdmx.semanal20200905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.UUID;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

public class UsuariosSQLiteHelper extends SQLiteOpenHelper {

    private static final String ENCODING = "ISO-8859-1";


    public static String getHostName(String defValue) {
        try {
            Method getString = Build.class.getDeclaredMethod("getString", String.class);
            getString.setAccessible(true);
            return getString.invoke(null, "net.hostname").toString();
        } catch (Exception ex) {
            return defValue;
        }
    }


    UUID uuid = UUID.randomUUID();

    public String tablet;
    InputStream datos, usuarios, nofue, acambio,prd, pri, pan, morena, independiente= null;

    static Nombre nom= new Nombre();
    static String nombreE = nom.nombreEncuesta();



    static String ID = getHostName(null);
    static String prefix = ID;

// private static final String DATABASE_NAME = Environment.getExternalStorageDirectory() +"/Mis_archivos/" +nombreE+"_"+prefix+"";
    private static final int DATABASE_VERSION = 6;

    public UsuariosSQLiteHelper(Context context, String name,CursorFactory factory, int version, String DATABASE_NAME) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
// TODO Auto-generated constructor stub
        try {
            datos = context.getAssets().open("datos.sql");
            usuarios = context.getAssets().open("usuarios.sql");

        } catch (Exception ex) {
            Log.i(null, "HORROR-1: " + ex.fillInStackTrace());
        }

    }

//////////////////////   TABLA DATOS  //////////////////////////////////////////////////////////////


    public static class TablaDatos{
        public static String TABLA_DATOS = "datos";
        public static String COLUMNA_SECCION = "seccion";
        public static String COLUMNA_DISTRITO = "distrito";
        public static String COLUMNA_MUNICIPIO = "municipio";
        public static String COLUMNA_DELEGACION = "delegacion";
        public static String COLUMNA_EQUIPOS = "equipo";
        public static String COLUMNA_COORDINADOR = "coordinador";

    }

    private static final String DATABASE_DATOS = "create table "
    + TablaDatos.TABLA_DATOS + "("
    + TablaDatos.COLUMNA_SECCION + " INTEGER not null, "
    + TablaDatos.COLUMNA_DISTRITO + " text not null, "
    + TablaDatos.COLUMNA_MUNICIPIO + " text not null, "
    + TablaDatos.COLUMNA_DELEGACION + " integer not null, "
    + TablaDatos.COLUMNA_EQUIPOS + " text not null, "
    + TablaDatos.COLUMNA_COORDINADOR + " text not null); ";






/////////////////////  TABLA ENCUESTAS  ///////////////////////////////////////////////

    public static class TablaEncuestas{
        public static String TABLA_ENCUESTAS = "encuestas";
        public static String COLUMNA_CONSECUTIVO_DIARIO = "consecutivo_diario";
        public static String COLUMNA_EQUIPO = "equipo";
        public static String COLUMNA_USUARIO = "usuario";
        public static String COLUMNA_NOMBRE_ENCUESTA = "nombre_encuesta";
        public static String COLUMNA_FECHA = "fecha";
        public static String COLUMNA_HORA = "hora";
        public static String COLUMNA_imei = "imei";
        public static String COLUMNA_SECCION = "seccion";
        public static String COLUMNA_latitud = "latitud";
        public static String COLUMNA_longitud = "longitud";
//INICIAN PREGUNTAS
public static String COLUMNA_pregunta_1="pregunta_1";
        public static String COLUMNA_pregunta_2="pregunta_2";
        public static String COLUMNA_pregunta_3="pregunta_3";
        public static String COLUMNA_pregunta_4="pregunta_4";
        public static String COLUMNA_pregunta_5="pregunta_5";
        public static String COLUMNA_pregunta_6="pregunta_6";
        public static String COLUMNA_pregunta_7="pregunta_7";
        public static String COLUMNA_pregunta_8="pregunta_8";
        public static String COLUMNA_pregunta_9="pregunta_9";
        public static String COLUMNA_pregunta_c1="pregunta_c1";
        public static String COLUMNA_pregunta_c2="pregunta_c2";
        public static String COLUMNA_pregunta_c3="pregunta_c3";
        public static String COLUMNA_pregunta_c4="pregunta_c4";
        public static String COLUMNA_pregunta_c5="pregunta_c5";
        public static String COLUMNA_pregunta_c5a="pregunta_c5a";
        public static String COLUMNA_pregunta_c5b="pregunta_c5b";
        public static String COLUMNA_pregunta_c5c="pregunta_c5c";
        public static String COLUMNA_pregunta_c5d="pregunta_c5d";
        public static String COLUMNA_pregunta_c5e="pregunta_c5e";
        public static String COLUMNA_pregunta_c5f="pregunta_c5f";
        public static String COLUMNA_pregunta_c5g="pregunta_c5g";
        public static String COLUMNA_pregunta_c6="pregunta_c6";
        public static String COLUMNA_pregunta_c7="pregunta_c7";
        public static String COLUMNA_pregunta_c7a="pregunta_c7a";
        public static String COLUMNA_pregunta_c7b="pregunta_c7b";
        public static String COLUMNA_pregunta_c7c="pregunta_c7c";
        public static String COLUMNA_pregunta_c7d="pregunta_c7d";
        public static String COLUMNA_pregunta_c7e="pregunta_c7e";
        public static String COLUMNA_pregunta_c7f="pregunta_c7f";
        public static String COLUMNA_pregunta_c7g="pregunta_c7g";
        public static String COLUMNA_pregunta_c8="pregunta_c8";
        public static String COLUMNA_pregunta_c9="pregunta_c9";
        public static String COLUMNA_pregunta_c10="pregunta_c10";
        public static String COLUMNA_pregunta_c10a="pregunta_c10a";
        public static String COLUMNA_pregunta_c10b="pregunta_c10b";
        public static String COLUMNA_pregunta_c11="pregunta_c11";

        public static String COLUMNA_aporta  		="aporta";
        public static String COLUMNA_ocupacion  	="ocupacion";
        public static String COLUMNA_cuantos_coches ="cuantos_coches";
        public static String COLUMNA_cuartos  		="cuartos";
        public static String COLUMNA_cuartos_dormir ="cuartos_dormir";
        public static String COLUMNA_focos  		="focos";
        public static String COLUMNA_banos  		="banos";
        public static String COLUMNA_regadera  	="regadera";
        public static String COLUMNA_estufa  		="estufa";
        public static String COLUMNA_edad  		="edad";
        public static String COLUMNA_genero  		="genero";
        public static String COLUMNA_tipo_vivienda ="tipo_vivienda";
        public static String COLUMNA_tipo_piso 	="tipo_piso";


        public static String COLUMNA_abandono="abandono";
        public static String COLUMNA_suma="suma";
        public static String COLUMNA_status="status";
// FINALIZAN PREGUNTAS
        public static String COLUMNA_TIEMPO = "tiempo";
        public static String COLUMNA_TIPO_CAPTURA = "tipo_captura";
        public static String COLUMNA_enviado = "enviado";
    }




    private static final String DATABASE_ENCUESTA= "create table "
            + TablaEncuestas.TABLA_ENCUESTAS + "("
            + "id integer primary key autoincrement,"
            + TablaEncuestas.COLUMNA_CONSECUTIVO_DIARIO + " text not null, "
            + TablaEncuestas.COLUMNA_EQUIPO + " text not null, "
            + TablaEncuestas.COLUMNA_USUARIO + " text not null, "
            + TablaEncuestas.COLUMNA_NOMBRE_ENCUESTA + " text not null, "
            + TablaEncuestas.COLUMNA_FECHA + " date not null, "
            + TablaEncuestas.COLUMNA_HORA + " text not null, "
            + TablaEncuestas.COLUMNA_imei + " text not null, "
            + TablaEncuestas.COLUMNA_SECCION + " INTEGER not null, "
            + TablaEncuestas.COLUMNA_latitud + " text, "
            + TablaEncuestas.COLUMNA_longitud + " text, "

            + TablaEncuestas.COLUMNA_pregunta_1 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_2 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_3 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_4 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_5 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_6 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_7 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_8 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_9 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c1 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c2 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c3 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c4 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c5 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c5a +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c5b +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c5c +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c5d +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c5e +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c5f +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c5g +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c6 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c7 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c7a +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c7b +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c7c +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c7d +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c7e +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c7f +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c7g +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c8 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c9 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c10 +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c10a +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c10b +  " text, "
            + TablaEncuestas.COLUMNA_pregunta_c11 +  " text, "


            + TablaEncuestas.COLUMNA_aporta  +  " text, "
            + TablaEncuestas.COLUMNA_ocupacion  +  " text, "
            + TablaEncuestas.COLUMNA_cuantos_coches  +  " text, "
            + TablaEncuestas.COLUMNA_cuartos  +  " text, "
            + TablaEncuestas.COLUMNA_cuartos_dormir  +  " text, "
            + TablaEncuestas.COLUMNA_focos  +  " text, "
            + TablaEncuestas.COLUMNA_banos  +  " text, "
            + TablaEncuestas.COLUMNA_regadera  +  " text, "
            + TablaEncuestas.COLUMNA_estufa  +  " text, "
            + TablaEncuestas.COLUMNA_edad  +  " text, "
            + TablaEncuestas.COLUMNA_genero  +  " text, "
            + TablaEncuestas.COLUMNA_tipo_vivienda  +  " text, "
            + TablaEncuestas.COLUMNA_tipo_piso  +  " text, "

    + TablaEncuestas.COLUMNA_abandono +  " text, "

    + TablaEncuestas.COLUMNA_suma +  " text, "
    + TablaEncuestas.COLUMNA_status +  " text, "
    + TablaEncuestas.COLUMNA_TIEMPO + " text, "
    + TablaEncuestas.COLUMNA_TIPO_CAPTURA + " text, "
    + TablaEncuestas.COLUMNA_enviado + " text not null); ";

////////////////////////////  TABLA USUARIOS	 /////////////////////////////////////////////////////////

    public static class TablaUsuarios{
        public static String TABLA_USUARIOS = "usuarios";
        public static String COLUMNA_USUARIO = "usuario";
        public static String COLUMNA_PASSWORD = "password";

    }

    private static final String DATABASE_USUARIOS = "create table "
    + TablaUsuarios.TABLA_USUARIOS + "("
    + TablaUsuarios.COLUMNA_USUARIO + " text not null, "
    + TablaUsuarios.COLUMNA_PASSWORD+ " text not null); ";


    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub
        db.execSQL(DATABASE_ENCUESTA);



    }


    public void cargaDatos(SQLiteDatabase db){
        InputStream tabla=datos;
        try {

            if (tabla != null) {
                db.beginTransaction();
                BufferedReader reader = new BufferedReader(new InputStreamReader(tabla,ENCODING));
                String line = reader.readLine();
                while (!TextUtils.isEmpty(line)) {
                    db.execSQL(line);
                    line = reader.readLine();
                }
                db.setTransactionSuccessful();
            }
        } catch (Exception ex) {
            Log.i(null, "HORROR-2: " + ex.getMessage());
        } finally {
            db.endTransaction();
            if (tabla != null) {
                try {
                    tabla.close();
                } catch (IOException e) {
                    Log.i(null, "HORROR-3; " + e.getMessage());
                }
            }
        }

    }

    public void cargaUsuarios(SQLiteDatabase db){
        InputStream tabla=usuarios;
        try {

            if (tabla != null) {
                db.beginTransaction();
                BufferedReader reader = new BufferedReader(new InputStreamReader(tabla,ENCODING));
                String line = reader.readLine();
                while (!TextUtils.isEmpty(line)) {
                    db.execSQL(line);
                    line = reader.readLine();
                }
                db.setTransactionSuccessful();
            }
        } catch (Exception ex) {
            Log.i(null, "HORROR-2: " + ex.getMessage());
        } finally {
            db.endTransaction();
            if (tabla != null) {
                try {
                    tabla.close();
                } catch (IOException e) {
                    Log.i(null, "HORROR-3; " + e.getMessage());
                }
            }
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
        db.execSQL("drop table if exists " + TablaEncuestas.TABLA_ENCUESTAS);
        onCreate(db);
    }
}
