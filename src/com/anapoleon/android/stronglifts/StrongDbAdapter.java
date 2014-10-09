package com.anapoleon.android.stronglifts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Simple notes database access helper class. Defines the basic CRUD operations
 * for the notepad example, and gives the ability to list all notes as well as
 * retrieve or modify a specific note.
 * 
 * This has been improved from the first version of this tutorial through the
 * addition of better error handling and also using returning a Cursor instead
 * of using a collection of inner classes (which is less scalable and not
 * recommended).
 */
public class StrongDbAdapter {

    public static final String KEY_TITLE = "title";
    public static final String KEY_BODY = "body";
    public static final String KEY_ROWID = "_id";
    
    public static final String SQUAT_1 = "squat1";
    public static final String SQUAT_2 = "squat2";
    public static final String SQUAT_3 = "squat3";
    public static final String SQUAT_4 = "squat4";
    public static final String SQUAT_5 = "squat5";
    
    public static final String PRESS_1 = "press1";
    public static final String PRESS_2 = "press2";
    public static final String PRESS_3 = "press3";
    public static final String PRESS_4 = "press4";
    public static final String PRESS_5 = "press5";
    
    public static final String DEADLIFT_1 = "dead1";
    public static final String DEADLIFT_2 = "dead2";
    public static final String DEADLIFT_3 = "dead3";
    public static final String DEADLIFT_4 = "dead4";
    public static final String DEADLIFT_5 = "dead5";

    public static final String BENCH_1 = "bench1";
    public static final String BENCH_2 = "bench2";
    public static final String BENCH_3 = "bench3";
    public static final String BENCH_4 = "bench4";
    public static final String BENCH_5 = "bench5";

    public static final String ROW_1 = "row1";
    public static final String ROW_2 = "row2";
    public static final String ROW_3 = "row3";
    public static final String ROW_4 = "row4";
    public static final String ROW_5 = "row5";
    
    
    
    public static final String WORKOUT_STATE = "workoutState";
    public static final String WORKOUT_A = "workoutA";

    public static final String SQUAT_LABEL = "squatLabel";
    public static final String PRESS_LABEL = "pressLabel";
    public static final String BENCH_LABEL = "benchLabel";
    public static final String ROW_LABEL = "rowLabel";
    public static final String DEAD_LABEL = "deadLabel";


    
    

    private static final String TAG = "StrongDbAdapter";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;
    
    
    private static final String DATABASE_NAME = "data";
    private static final String DATABASE_TABLE = "notes";
    private static final int DATABASE_VERSION = 9;
    
    

    /**
     * Database creation sql statement
     */
    private static final String DATABASE_CREATE =
        "create table notes (_id integer primary key autoincrement , "
        + "title text," +
        " squatLabel text," +
        " workoutState text" +
        ", squat1 text, squat2 text, squat3 text, squat4 text, squat5 text, " +
        "pressLabel, press1 text, press2 text, press3 text, press4 text, press5 text," +
        "deadLabel text, dead3 text," +
        " benchLabel text, bench1 text, bench2 text, bench3 text, bench4 text, bench5 text," +
        " rowLabel text, row1 text, row2 text, row3 text, row4 text, row5 text " +
        " );";
    
    
   
    
    

   // private static final String DATABASE_NAME = "data";
   // private static final String DATABASE_TABLE = "notes";
   // private static final int DATABASE_VERSION = 2;

    private final Context mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        	if (newVersion > oldVersion) {
                //db.execSQL("ALTER TABLE notes ADD COLUMN benchLabel TEXT ");
                

            }
        }
    }

    /**
     * Constructor - takes the context to allow the database to be
     * opened/created
     * 
     * @param ctx the Context within which to work
     */
    public StrongDbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    /**
     * Open the notes database. If it cannot be opened, try to create a new
     * instance of the database. If it cannot be created, throw an exception to
     * signal the failure
     * 
     * @return this (self reference, allowing this to be chained in an
     *         initialization call)
     * @throws SQLException if the database could be neither opened or created
     */
    public StrongDbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }


    /**
     * Create a new note using the title and body provided. If the note is
     * successfully created return the new rowId for that note, otherwise return
     * a -1 to indicate failure.
     * 
     * @param title the title of the note
     * @param body the body of the note
     * @return rowId or -1 if failed
     */
    public long createNote(String title, String squatLabel, String workoutState,
    		String squatSet01, String squatSet02, String squatSet03, String squatSet04, String squatSet05, 
    		String pressLabel, String pressSet1, String pressSet2, String pressSet3, String pressSet4, String pressSet5,
    		String deadLabel, String deadSet3, 
    		String benchLabel, String benchSet1, String benchSet2, String benchSet3, String benchSet4, String benchSet5,
    		String rowLabel, String rowSet1, String rowSet2, String rowSet3, String rowSet4, String rowSet5
    		) {
    	
    	
    	ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TITLE, title);
        //initialValues.put(WORKOUT_STATE, workoutState);
        initialValues.put(SQUAT_LABEL, squatLabel);
        initialValues.put(WORKOUT_STATE, workoutState);
        //initialValues.put(WORKOUT_A, workoutA)
        initialValues.put(SQUAT_1, squatSet01);
        initialValues.put(SQUAT_2, squatSet02);
        initialValues.put(SQUAT_3, squatSet03);
        initialValues.put(SQUAT_4, squatSet04);
        initialValues.put(SQUAT_5, squatSet05);

        
        initialValues.put(PRESS_LABEL, pressLabel);
        initialValues.put(PRESS_1, pressSet1);
        initialValues.put(PRESS_2, pressSet2);
        initialValues.put(PRESS_3, pressSet3);
        initialValues.put(PRESS_4, pressSet4);
        initialValues.put(PRESS_5, pressSet5);


        initialValues.put(DEAD_LABEL, deadLabel);
        initialValues.put(DEADLIFT_3, deadSet3);
        
        initialValues.put(BENCH_LABEL, benchLabel);
        initialValues.put(BENCH_1, benchSet1);
        initialValues.put(BENCH_2, benchSet2);
        initialValues.put(BENCH_3, benchSet3);
        initialValues.put(BENCH_4, benchSet4);
        initialValues.put(BENCH_5, benchSet5);
        
        initialValues.put(ROW_LABEL, rowLabel);
        initialValues.put(ROW_1, rowSet1);
        initialValues.put(ROW_2, rowSet2);
        initialValues.put(ROW_3, rowSet3);
        initialValues.put(ROW_4, rowSet4);
        initialValues.put(ROW_5, rowSet5);

        return mDb.insert(DATABASE_TABLE, null, initialValues);
    }

    /**
     * Delete the note with the given rowId
     * 
     * @param rowId id of note to delete
     * @return true if deleted, false otherwise
     */
    public boolean deleteNote(long rowId) {

        return mDb.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    /**
     * Return a Cursor over the list of all notes in the database
     * 
     * @return Cursor over all notes
     */
    public Cursor fetchAllNotes() {

        return mDb.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_TITLE,
               SQUAT_LABEL, WORKOUT_STATE, SQUAT_1, SQUAT_2, SQUAT_3, SQUAT_4, SQUAT_5, 
               PRESS_LABEL, PRESS_1, PRESS_2, PRESS_3, PRESS_4, PRESS_5,
               DEAD_LABEL, DEADLIFT_3, 
               BENCH_LABEL, BENCH_1, BENCH_2, BENCH_3, BENCH_4, BENCH_5, 
               ROW_LABEL, ROW_1, ROW_2, ROW_3, ROW_4, ROW_5, }, null, null, null, null, null);
    }

    /**
     * Return a Cursor positioned at the note that matches the given rowId
     * 
     * @param rowId id of note to retrieve
     * @return Cursor positioned to matching note, if found
     * @throws SQLException if note could not be found/retrieved
     */
    public Cursor fetchNote(long rowId) throws SQLException {

        Cursor mCursor =

            mDb.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                    KEY_TITLE, SQUAT_LABEL, WORKOUT_STATE,
                    SQUAT_1, SQUAT_2, SQUAT_3, SQUAT_4, SQUAT_5, 
                    PRESS_LABEL, PRESS_1, PRESS_2, PRESS_3, PRESS_4, PRESS_5,
                    DEAD_LABEL, DEADLIFT_3, 
                    BENCH_LABEL, BENCH_1, BENCH_2, BENCH_3, BENCH_4, BENCH_5, 
                    ROW_LABEL, ROW_1, ROW_2, ROW_3, ROW_4, ROW_5}, KEY_ROWID + "='" + rowId+"'", null,
                    null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    /**
     * Update the note using the details provided. The note to be updated is
     * specified using the rowId, and it is altered to use the title and body
     * values passed in
     * 
     * @param rowId id of note to update
     * @param title value to set note title to
     * @param body value to set note body to
     * @return true if the note was successfully updated, false otherwise
     */
    public boolean updateNote(long rowId, String title, String squatLabel,
    		String squatSet01, String squatSet02, String squatSet03, String squatSet04, String squatSet05, 
    		String pressLabel, String pressSet1, String pressSet2, String pressSet3, String pressSet4, String pressSet5,
    		String deadLabel, String deadSet3, 
    		String benchLabel, String benchSet1, String benchSet2, String benchSet3, String benchSet4, String benchSet5,
    		String rowLabel, String rowSet1, String rowSet2, String rowSet3, String rowSet4, String rowSet5) {
        ContentValues args = new ContentValues();
        args.put(SQUAT_LABEL, squatLabel);
        args.put(SQUAT_1, squatSet01);
        args.put(SQUAT_2, squatSet02);
        args.put(SQUAT_3, squatSet03);
        args.put(SQUAT_4, squatSet04);
        args.put(SQUAT_5, squatSet05);
        
        args.put(PRESS_LABEL, pressLabel);
        args.put(PRESS_1, pressSet1);
        args.put(PRESS_2, pressSet2);
        args.put(PRESS_3, pressSet3);
        args.put(PRESS_4, pressSet4);
        args.put(PRESS_5, pressSet5);
        
        args.put(DEAD_LABEL, deadLabel);
        args.put(DEADLIFT_3, deadSet3);
        
        args.put(BENCH_LABEL, benchLabel);
        args.put(BENCH_1, benchSet1);
        args.put(BENCH_2, benchSet2);
        args.put(BENCH_3, benchSet3);
        args.put(BENCH_4, benchSet4);
        args.put(BENCH_5, benchSet5);
        
        args.put(ROW_LABEL, rowLabel);
        args.put(ROW_1, rowSet1);
        args.put(ROW_2, rowSet2);
        args.put(ROW_3, rowSet3);
        args.put(ROW_4, rowSet4);
        args.put(ROW_5, rowSet5);


        //args.put(WORKOUT_STATE, workoutState);

        return mDb.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
