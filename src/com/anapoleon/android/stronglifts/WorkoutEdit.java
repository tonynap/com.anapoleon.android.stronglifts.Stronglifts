package com.anapoleon.android.stronglifts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class WorkoutEdit
    extends Activity
{

    private boolean         workoutA;
    // public TextView mTitleText;
    // private EditText mBodyText;
    private Long            mRowId;
    private StrongDbAdapter mDbHelper;
    private ViewFlipper     viewFlipper;
    private ViewFlipper     viewFlipperB;
    public TextView         squats;
    public TextView         squatsB;
    // public boolean workoutA;
    public String           workoutState;
    // private double rowId = mRowId;
    public String           squatLabel;
    public String           squatLabelB;

    public Button           confirmButton;
    public Button           confirmButtonB;
    private Long            prevId;
    // public int rowNum = 0;
    private String          title;
    private NumberPicker    squatSet1;
    private NumberPicker    squatSet1B;

    private String          squatSet01;
    private String          squatSet01B;
    private RadioGroup      radioGroup;
    private RadioGroup      radioGroupB;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // setContentView(R.layout.workout_edit3);

        mRowId =
            (savedInstanceState == null) ? null : (Long)savedInstanceState
                .getSerializable(StrongDbAdapter.KEY_ROWID);
        if (mRowId == null)
        {

            Bundle extras = getIntent().getExtras();
            mRowId =
                extras != null
                    ? extras.getLong(StrongDbAdapter.KEY_ROWID)
                    : null;
        }

        if (mRowId == null)
        {

            StrongDbAdapter DbHelper = new StrongDbAdapter(this);
            DbHelper.open();

            Cursor note = DbHelper.fetchAllNotes();

            if (note.getCount() == 0)
            {
                // squats.setText("Squats :: 45");
                workoutState = "Workout A";
                workoutA = true;

            }
            else if (note.getCount() >= 1 && note.getCount() % 2 == 1)
            {
                note.moveToLast();
                // workoutState =
// note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.WORKOUT_STATE));
                workoutA = false;
                workoutState = "Workout B";

            }
            else if (note.getCount() >= 1 && note.getCount() % 2 == 0)
            {
                note.moveToLast();

                workoutA = true;
                workoutState = "Workout A";
            }
            note.close();
            DbHelper.close();

        }

        if (workoutState == "Workout A")
        {
            setContentView(R.layout.workout_edit3);

            final AlertDialog.Builder alert = new AlertDialog.Builder(this);

            mDbHelper = new StrongDbAdapter(this);
            mDbHelper.open();

            viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
            radioGroup = (RadioGroup)findViewById(R.id.radgroup1);
            squats = (TextView)findViewById(R.id.squatLabel);

            confirmButton = (Button)findViewById(R.id.confirmButton);

            squatLabel = squats.getText().toString();
            squatSet1 = (NumberPicker)findViewById(R.id.squatSet1);
            squatSet1.getValue();
            squatSet01 = String.valueOf(squatSet1);

            confirmButton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view)
                {
                    setResult(RESULT_OK);
                    finish();
                }

            });

            radioGroup
                .setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup group, int checkedId)
                    {
                        switch (checkedId)
                        {
                            case (R.id.rad2):
                                viewFlipper.setDisplayedChild(1);
                                break;
                            case (R.id.rad3):
                                viewFlipper.setDisplayedChild(2);
                                break;
                            default:
                                viewFlipper.setDisplayedChild(0);
                                break;
                        }
                    }
                });

            squats.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v)
                {
                    // TODO Auto-generated method stub

                    alert.setTitle("Squats");
                    alert.setMessage("Message");

                    // set an EditText view to get user input
                    final EditText input = new EditText(aMethod());
                    input.setInputType(InputType.TYPE_CLASS_NUMBER);

                    alert.setView(input);

                    alert.setPositiveButton(
                        "Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                DialogInterface dialog,
                                int whichButton)
                            {
                                String value = input.getText().toString();
                                // Do something with value

                                value = "Squats - " + value;

                                squats.setText(value);

                            }
                        });

                    alert.setNegativeButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                DialogInterface dialog,
                                int whichButton)
                            {
                                // Cancelled
                            }
                        });

                    AlertDialog dialog = alert.create();

                    dialog.getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

                    dialog.show();

                }
            });

        }
        else if (workoutState == "Workout A")
        {
            setContentView(R.layout.workout_editb);

            final AlertDialog.Builder alert = new AlertDialog.Builder(this);

            mDbHelper = new StrongDbAdapter(this);
            mDbHelper.open();

            viewFlipperB = (ViewFlipper)findViewById(R.id.viewFlipperB);
            radioGroupB = (RadioGroup)findViewById(R.id.radgroupB);
            squatsB = (TextView)findViewById(R.id.squatLabelB);

            confirmButtonB = (Button)findViewById(R.id.confirmButton);

            squatLabelB = squatsB.getText().toString();
            squatSet1B = (NumberPicker)findViewById(R.id.squatSet1b);
            squatSet1B.getValue();
            squatSet01B = String.valueOf(squatSet1B);

            confirmButtonB.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view)
                {
                    setResult(RESULT_OK);
                    finish();
                }

            });

            radioGroupB
                .setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup group, int checkedId)
                    {
                        switch (checkedId)
                        {
                            case (R.id.rad2b):
                                viewFlipperB.setDisplayedChild(1);
                                break;
                            case (R.id.rad3b):
                                viewFlipperB.setDisplayedChild(2);
                                break;
                            default:
                                viewFlipperB.setDisplayedChild(0);
                                break;
                        }
                    }
                });

            squatsB.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v)
                {

                    alert.setTitle("Squats");
                    alert.setMessage("Message");

                    // set an EditText view to get user input
                    final EditText input = new EditText(aMethod());
                    input.setInputType(InputType.TYPE_CLASS_NUMBER);

                    alert.setView(input);

                    alert.setPositiveButton(
                        "Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                DialogInterface dialog,
                                int whichButton)
                            {
                                String value = input.getText().toString();
                                // Do something with value

                                value = "Squats - " + value;

                                squatsB.setText(value);

                            }
                        });

                    alert.setNegativeButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                DialogInterface dialog,
                                int whichButton)
                            {
                                // Cancelled
                            }
                        });

                    AlertDialog dialog = alert.create();

                    dialog.getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

                    dialog.show();

                }
            });

        }

        mDbHelper = new StrongDbAdapter(this);
        mDbHelper.open();

        setTitle(R.string.edit_workout);

        // mTitleText = (TextView) findViewById(R.id.workout_row);
        // mBodyText = (EditText) findViewById(R.id.body);

        // viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        // viewFlipperB = (ViewFlipper) findViewById(R.id.viewFlipperB);

        // squats = (TextView) findViewById(R.id.squatLabel);
        // squatsB = (TextView) findViewById(R.id.squatLabelB);
        // squatLabel = squats.getText().toString();
        // squatSet1 = (NumberPicker) findViewById(R.id.squatSet1);
        // squatSet1.getValue();
        // squatSet01 = String.valueOf(squatSet1);

        // radioGroup = (RadioGroup) findViewById(R.id.radgroup1);
        // radioGroupB = (RadioGroup) findViewById(R.id.radgroupB);

/*
 * mRowId = (savedInstanceState == null) ? null : (Long)
 * savedInstanceState.getSerializable(StrongDbAdapter.KEY_ROWID); if (mRowId ==
 * null) { Bundle extras = getIntent().getExtras(); mRowId = extras != null ?
 * extras.getLong(StrongDbAdapter.KEY_ROWID) : null; }
 */

        populateFields();

        // RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radgroup1);

        /*
         * if(workoutState == "Workout A"){
         * radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(){
         * public void onCheckedChanged(RadioGroup group, int checkedId) {
         * switch(checkedId) { case(R.id.rad2):
         * viewFlipper.setDisplayedChild(1); break; case(R.id.rad3):
         * viewFlipper.setDisplayedChild(2); break; default:
         * viewFlipper.setDisplayedChild(0); break; } } }); }else
         * if(workoutState == "Workout B"){
         * radioGroupB.setOnCheckedChangeListener(new OnCheckedChangeListener(){
         * public void onCheckedChanged(RadioGroup group, int checkedId) {
         * switch(checkedId) { case(R.id.rad2b):
         * viewFlipperB.setDisplayedChild(1); break; case(R.id.rad3b):
         * viewFlipperB.setDisplayedChild(2); break; default:
         * viewFlipperB.setDisplayedChild(0); break; } } }); }
         */
        if (mRowId == null)
        {

            Cursor cursor = mDbHelper.fetchAllNotes();

            if (cursor.getCount() >= 1)
            {
                cursor.moveToLast();

                if (cursor.getString(cursor
                    .getColumnIndexOrThrow(StrongDbAdapter.WORKOUT_STATE)) == "Workout B")
                {
                    squatsB.setText(cursor.getString(cursor
                        .getColumnIndexOrThrow(StrongDbAdapter.SQUAT_LABEL)));

                    String squat = squatsB.getText().toString();
                    String squatsWeight = squat.replaceAll("[^\\d]", "");

                    int squatWeight = Integer.parseInt(squatsWeight);
                    squatWeight = squatWeight + 5;
                    String sWeight = Integer.toString(squatWeight);

                    squatsB.setText("Squats : " + sWeight);
                }
                else if (cursor.getString(cursor
                    .getColumnIndexOrThrow(StrongDbAdapter.WORKOUT_STATE)) == "Workout A")
                {
                    squats.setText(cursor.getString(cursor
                        .getColumnIndexOrThrow(StrongDbAdapter.SQUAT_LABEL)));

                    String squat = squats.getText().toString();
                    String squatsWeight = squat.replaceAll("[^\\d]", "");

                    int squatWeight = Integer.parseInt(squatsWeight);
                    squatWeight = squatWeight + 5;
                    String sWeight = Integer.toString(squatWeight);

                    squats.setText("Squats : " + sWeight);
                }

                cursor.close();
            }

        }

// end of onCreate

    }


    private void populateFields()
    {
        if (mRowId != null)
        {
            Cursor note = mDbHelper.fetchNote(mRowId);
            startManagingCursor(note);

            // mTitleText.setText(note.getString(
            // note.getColumnIndexOrThrow(StrongDbAdapter.KEY_TITLE)));
            workoutState =
                (note.getString(note
                    .getColumnIndexOrThrow(StrongDbAdapter.WORKOUT_STATE)));
            squats.setText(note.getString(note
                .getColumnIndexOrThrow(StrongDbAdapter.SQUAT_LABEL)));
            squatSet1.setText(note.getString(note
                .getColumnIndexOrThrow(StrongDbAdapter.SQUAT_1)));
            squatSet1.setValue(Integer.valueOf(note.getString(note
                .getColumnIndexOrThrow(StrongDbAdapter.SQUAT_1))));
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        // saveState();
        outState.putSerializable(StrongDbAdapter.KEY_ROWID, mRowId);
    }


    @Override
    protected void onPause()
    {
        super.onPause();
        // saveState();
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        populateFields();
    }


    /*
     * //Saves all the data to the database private void saveState() {
     * if(workoutState == "Workout A"){ String title = workoutState; String
     * squatLabel = squats.getText().toString(); squatSet1.getValue();
     * squatSet01 = String.valueOf(squatSet1.getValue()); if (mRowId == null) {
     * long id = mDbHelper.createNote(title, squatLabel, workoutState,
     * squatSet01); if (id > 0) { mRowId = id; } } else {
     * mDbHelper.updateNote(mRowId, title); } }else if(workoutState ==
     * "Workout B"){ String title = workoutState; String squatLabel =
     * squatsB.getText().toString(); squatSet1B.getValue(); squatSet01B =
     * String.valueOf(squatSet1B.getValue()); if (mRowId == null) { long id =
     * mDbHelper.createNote(title, squatLabel, workoutState, squatSet01B); if
     * (id > 0) { mRowId = id; } } else { mDbHelper.updateNote(mRowId, title); }
     * } }
     */

    public Context aMethod()
    {
        Context actContext = this;
        return actContext;
    }


    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (mDbHelper != null)
        {
            mDbHelper.close();
        }

    }


    public boolean getWorkoutState()
    {
        if (workoutA == false)
        {
            workoutA = true;
            workoutState = "Workout A";
        }
        else
        {
            workoutA = false;
            workoutState = "Workout B";
        }

        return workoutA;

    }

}
