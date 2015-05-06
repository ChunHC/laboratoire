package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Manage database
 * Created by chun on 2015-05-02.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    private static DatabaseHandler instance = null;
    private ArrayList<Club> clubList;

    public static DatabaseHandler getInstance(Context context) {
        if (instance == null)
            instance = new DatabaseHandler(context);
        return instance;
    }

    // table name
    private final String TABLE = "club";

    // Table Columns names
    private final String KEY_ID = "id";
    private final String KEY_NOM = "nom";
    private final String KEY_LOCAL = "local";
    private final String KEY_ICONE = "icone";
    private final String KEY_SITEWEB = "siteweb";

    private DatabaseHandler(Context context) {
        super(context, "AndroidLab", null, 1);

        getAllClubs();
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE + "(" +
                    KEY_ID      + " INTEGER AUTO_INCREMENT PRIMARY KEY," +
                    KEY_NOM     + " NVARCHAR(255)," +
                    KEY_LOCAL   + " NVARCHAR(255)," +
                    KEY_ICONE   + " NVARCHAR(255)," +
                    KEY_SITEWEB + " NVARCHAR(255)" +
                ")";
        db.execSQL(CREATE_TABLE);

        initDB(db);
    }

    // Upgrading database
    // not supposed to update the whole database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE);

        // Create tables again
        //onCreate(db);
    }

    private void initDB(SQLiteDatabase db) {
        addClub(db, new Club(
                "Avion cargo",
                "A-1956 et A-1742",
                "ic_ace",
                "http://www.avioncargoets.com"
        ));
        addClub(db, new Club(
                "ApplETS – Ingénierie mobile",
                "A-1966",
                "ic_applets",
                "http://applets.etsmtl.ca"
        ));
        addClub(db, new Club(
                "Baja ÉTS – Véhicule tout-terrain amphibie",
                "",
                "ic_baja",
                "http://baja.etsmtl.ca"
        ));
        addClub(db, new Club(
                "Canoë de béton",
                "",
                "ic_canoedebeton",
                "http://canoe.etsmtl.ca"
        ));
        addClub(db, new Club(
                "Capra – Robots terrestres autonomes",
                "",
                "ic_capra",
                "http://capra.etsmtl.ca"
        ));
        addClub(db, new Club(
                "Chinook – Véhicule éolien",
                "",
                "ic_chinook",
                "http://chinook.etsmtl.ca"
        ));
        addClub(db, new Club(
                "Conjure – Développement de jeux vidéo",
                "",
                "ic_conjure",
                "http://conjure.etsmtl.ca"
        ));
        addClub(db, new Club(
                "Dronolab – Aéronef autonome",
                "A-1760",
                "ic_dronolab",
                "http://www.dronolab.com"
        ));
        addClub(db, new Club(
                "Éclipse – Véhicule solaire",
                "",
                "ic_eclipse",
                "http://eclipse.etsmtl.ca"
        ));
        addClub(db, new Club(
                "Formule ETS – Voiture de course",
                "",
                "ic_formuleets",
                "http://www.formuleets.ca"
        ));
        addClub(db, new Club(
                "GéniALE – Développement brassicole",
                "A-1244",
                "ic_geniale",
                "http://sites.google.com/a/etsmtl.net/geniale/home"
        ));
        addClub(db, new Club(
                "IEEE-ÉTS",
                "A-3850",
                "ic_ieee",
                "http://ieee.etsmtl.ca"
        ));
        addClub(db, new Club(
                "Omer – Sous-marins à propulsion humaine",
                "",
                "ic_omer",
                "http://www.omerets.com"
        ));
        addClub(db, new Club(
                "QUIETS – Motoneige écologique",
                "",
                "ic_quiets",
                "http://www.teamquiets.com"
        ));
        addClub(db, new Club(
                "RockÉTS – Fusée haute puissance",
                "A-1764",
                "ic_rockets",
                "http://www.clubrockets.ca "
        ));
        addClub(db, new Club(
                "S.O.N.I.A. – Sous-marin autonome",
                "",
                "ic_sonia",
                "http://sonia.etsmtl.ca/?lang=fr"
        ));
        addClub(db, new Club(
                "Walking Machine – Robots autonomese",
                "",
                "ic_walkingmachine",
                "http://wm.etsmtl.ca"
        ));
    }

    private void addClub(SQLiteDatabase db, Club club) {
        ContentValues values = new ContentValues();
        //values.put(KEY_ID, club.getId());
        values.put(KEY_NOM, club.getNom());
        values.put(KEY_LOCAL, club.getLocal());
        values.put(KEY_ICONE, club.getIcone());
        values.put(KEY_SITEWEB, club.getSiteweb());

        // Inserting Row
        db.insert(TABLE, null, values);
    }

    // read all clubs
    private void getAllClubs() {
        ArrayList<Club> clubList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Club club = new Club(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
                // Adding club to list
                clubList.add(club);
            } while (cursor.moveToNext());

            cursor.close();
        }

        this.clubList = clubList;
    }

    public ArrayList<Club> getClubList() {
        return clubList;
    }
}
