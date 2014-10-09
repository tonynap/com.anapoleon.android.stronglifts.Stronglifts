package com.anapoleon.android.stronglifts;

import java.util.Collections;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.AdapterContextMenuInfo;

public class WorkoutList extends ListActivity {
    private static final int ACTIVITY_CREATE=0;
    private static final int ACTIVITY_EDIT=1;

    private static final int INSERT_ID = Menu.FIRST;
    private static final int INSERTB_ID = Menu.FIRST+2;

    
    private static final int DELETE_ID = Menu.FIRST + 1;
    public int countID = 0;
    
    private Long mRowId;
    public boolean workoutA;
    public String workoutState;
    public boolean workoutAA;

    private StrongDbAdapter mDbHelper;
    
    private SimpleCursorAdapter notes;
    

    /** Called when the 5x5 button is pressed in first activity */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_list);
        
        
        mDbHelper = new StrongDbAdapter(this);
        mDbHelper.open();
        fillData();
        registerForContextMenu(getListView());
       
        	Cursor note = mDbHelper.fetchAllNotes();

        	if(note.getCount()==0){
        		//squats.setText("Squats :: 45");
        		workoutState = "Workout A";
        		workoutA = true;
        		
        		
        	}else if(note.getCount()>=1 && note.getCount()%2 == 1){
        		note.moveToLast();
                //workoutState = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.WORKOUT_STATE));
        		workoutA = false;
        		workoutState = "Workout B";
        		
                                    
        	}else if(note.getCount()>=1 && note.getCount()%2 == 0){
        		note.moveToLast();
        	
        		workoutA = true;
        		workoutState = "Workout A";
        	}
        	note.close();
        	
    }

    private void fillData() {
        Cursor NotesCursor = mDbHelper.fetchAllNotes();
    	
    	// Get all of the rows from the database and create the item list
        //NotesCursor = mDbHelper.fetchAllNotes();
        startManagingCursor(NotesCursor);

        // Create an array to specify the fields we want to display in the list (only TITLE)
        String[] from = new String[]{StrongDbAdapter.KEY_TITLE,};

        // and an array of the fields we want to bind those fields to (in this case just text1)
        int[] to = new int[]{R.id.workout_row };

        // Now create a simple cursor adapter and set it to display
        
         notes = 
            new SimpleCursorAdapter(this, R.layout.workout_row, NotesCursor, from, to);
        setListAdapter(notes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, INSERT_ID, 0, R.string.menu_insert);
        menu.add(0, INSERTB_ID, 0, R.string.menu_insertB);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
    	// when menu item is selected
        switch(item.getItemId()) {
            case INSERT_ID:
                countID++;
            	createNote();
                return true;
            case INSERTB_ID:
            	createNoteB();
        }

        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
    	//create context menu from long click
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, DELETE_ID, 0, R.string.menu_delete);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	//when long click item is selected
        switch(item.getItemId()) {
            case DELETE_ID:
                countID--;
            	AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
                mDbHelper.deleteNote(info.id);
                fillData();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    private void createNote() {
        //create workout A 
    	Intent i = new Intent(this, WorkoutEditA.class);
        startActivityForResult(i, ACTIVITY_CREATE);
    	
    }
    
    private void createNoteB(){
    	
    	//create workout B
    	Intent i = new Intent(this, WorkoutEditB.class);
        startActivityForResult(i, ACTIVITY_CREATE);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
        Long rowId = id;
        
        Cursor cursor = mDbHelper.fetchNote(rowId);
        
        String activity = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.WORKOUT_STATE));
        
        if(activity.equals("Workout A")){
        	workoutAA = true;
        }else if(activity.equals("Workout B")){
        	workoutAA = false;
        }
        
        
        if(workoutAA == true){
        	Intent i = new Intent(this, WorkoutEditA.class);
            i.putExtra(StrongDbAdapter.KEY_ROWID, id);
            startActivityForResult(i, ACTIVITY_EDIT);
        }else if(workoutAA == false){
        	Intent i = new Intent(this, WorkoutEditB.class);
            i.putExtra(StrongDbAdapter.KEY_ROWID, id);
            startActivityForResult(i, ACTIVITY_EDIT);
        }
        
        
        
       // startActivityForResult(i, ACTIVITY_EDIT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        fillData();
    }
    
    
}
