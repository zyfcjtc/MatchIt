package ca.gbc.mobile.yafanzhang.matchit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**************************************************
 * Yafan Zhang
 * 100816652
 * created: 10/21/2014
 * lastEdit: 10/23/2014
 **************************************************/
public class MySQLHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="players.db";
    public static final int DATABASE_VERSION=1;
    //tables and columns
    public static final String TABLE_PLAYERS = "players";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_TIME="time";

    //create statement
    public static final String DATABASE_CREATE =
            "create table "
                    + TABLE_PLAYERS
                    + "("+COLUMN_ID  + " integer primary key autoincrement,"
                    +     COLUMN_NAME+ " text not null,"
                    +     COLUMN_TIME+ " text not null);";

    public MySQLHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.w(MySQLHelper.class.getName(),
                "Create database " + DATABASE_NAME
                        + " version " + DATABASE_VERSION);
        db.execSQL(DATABASE_CREATE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersionNo,
                          int newVersionNo) {

        Log.w(MySQLHelper.class.getName(),
                "Upgrade database from version " + oldVersionNo +
                        " to version " + newVersionNo);
        //this should contain all changes that
        // you made in your database structure
        // starting from version 1 up

        db.execSQL("Drop table if exists " + TABLE_PLAYERS);
        onCreate(db);

    }
    public void createPlayer(String name,long time) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, name);
        values.put(COLUMN_TIME, time);


        db.insert(TABLE_PLAYERS, null, values);
        db.close();
    }
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<Player>();

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PLAYERS+" ORDER BY "+COLUMN_TIME+" ASC  LIMIT 10", null);

        if (cursor.moveToFirst()) {
            do {
                players.add(new Player(cursor.getString(1), cursor.getLong(2)));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return players;
    }
    public void deletePlayer(Player player) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_PLAYERS, COLUMN_ID + "=?", new String[] { String.valueOf(player.getId()) });
        db.close();
    }

}
