package com.anapoleon.android.stronglifts;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class WorkoutEditB extends Activity {

	private boolean workoutA;
	 //public TextView mTitleText;
	 //private EditText mBodyText;
	 private Long mRowId;
	 private StrongDbAdapter mDbHelper;
	 private ViewFlipper viewFlipper;
	 private ViewFlipper viewFlipperB;
	 public TextView squats;
	 public TextView squatsB;

	 public TextView pressLabel;
	 public TextView deadLabel;

	 public String workoutState = "Workout B";

	 private String mainTitle;
	 //private double rowId = mRowId;
	 public String squatLabel;
	 public String squatLabelB;

	 public Button confirmButton;
	 public Button confirmButtonB;

	 public Button next1B;
	 public Button next2B;

	 private Long prevId ;
	 //public int rowNum = 0;
	 private String title;

	 private NumberPicker squatSet1;
	 private NumberPicker squatSet1B;
	 private String squatSet01;
	 private String squatSet01B;

	 private NumberPicker squatSet2;
	 private NumberPicker squatSet2B;
	 private String squatSet02;
	 private String squatSet02B;

	 private NumberPicker squatSet3;
	 private NumberPicker squatSet3B;
	 private String squatSet03;
	 private String squatSet03B;

	 private NumberPicker squatSet4;
	 private NumberPicker squatSet4B;
	 private String squatSet04;
	 private String squatSet04B;

	 private NumberPicker squatSet5;
	 private NumberPicker squatSet5B;
	 private String squatSet05;
	 private String squatSet05B;

	 private NumberPicker pressSet1;
	 private String pressSet01;

	 private NumberPicker pressSet2;
	 private String pressSet02;

	 private NumberPicker pressSet3;
	 private String pressSet03;

	 private NumberPicker pressSet4;
	 private String pressSet04;

	 private NumberPicker pressSet5;
	 private String pressSet05;

	 private NumberPicker deadSet3;
	 private String deadSet03;


	 private RadioGroup radioGroup;
	 private RadioGroup radioGroupB;

	 private String benchLabel;
	 private String rowLabel;

	 private String benchSet1;
	 private String benchSet2;
	 private String benchSet3;
	 private String benchSet4;
	 private String benchSet5;

	 private String rowSet1;
	 private String rowSet2;
	 private String rowSet3;
	 private String rowSet4;
	 private String rowSet5;

	 protected AppPreferences appPrefs;




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

        setContentView(R.layout.workout_editb);

        mRowId = (savedInstanceState == null) ? null :
            (Long) savedInstanceState.getSerializable(StrongDbAdapter.KEY_ROWID);
        if (mRowId == null) {


        		Bundle extras = getIntent().getExtras();
        		mRowId = extras != null ? extras.getLong(StrongDbAdapter.KEY_ROWID)
                                    : null;
        }

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        appPrefs = new AppPreferences(getApplicationContext());



        if(mRowId == null){

        	Calendar c = Calendar.getInstance();
            //System.out.println("Current time => " + c.getTime());

            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = df.format(c.getTime());
        	mainTitle = "Workout B:  " + formattedDate;
        }



        mDbHelper = new StrongDbAdapter(this);
        mDbHelper.open();

        viewFlipperB = (ViewFlipper) findViewById(R.id.viewFlipperB);
        radioGroupB = (RadioGroup) findViewById(R.id.radgroupB);

        squatsB = (TextView) findViewById(R.id.squatLabelB);
        pressLabel = (TextView) findViewById(R.id.pressLabel);
        deadLabel = (TextView) findViewById(R.id.deadLabel);



        confirmButtonB = (Button) findViewById(R.id.confirmButtonB);
        next1B = (Button) findViewById(R.id.next1B);
        next2B = (Button) findViewById(R.id.next2B);



        squatLabelB = squatsB.getText().toString();


        squatSet1B = (NumberPicker) findViewById(R.id.squatSet1b);
        squatSet1B.getValue();
        squatSet01B = String.valueOf(squatSet1B);

        squatSet2B = (NumberPicker) findViewById(R.id.squatSet2b);
        squatSet2B.getValue();
        squatSet02B = String.valueOf(squatSet2B);

        squatSet3B = (NumberPicker) findViewById(R.id.squatSet3b);
        squatSet3B.getValue();
        squatSet03B = String.valueOf(squatSet3B);

        squatSet4B = (NumberPicker) findViewById(R.id.squatSet4b);
        squatSet4B.getValue();
        squatSet04B = String.valueOf(squatSet4B);

        squatSet5B = (NumberPicker) findViewById(R.id.squatSet5b);
        squatSet5B.getValue();
        squatSet05B = String.valueOf(squatSet5B);

        pressSet1 = (NumberPicker) findViewById(R.id.pressSet1);
        pressSet1.getValue();
        pressSet01 = String.valueOf(pressSet1);

        pressSet2 = (NumberPicker) findViewById(R.id.pressSet2);
        pressSet2.getValue();
        pressSet02 = String.valueOf(pressSet2);

        pressSet3 = (NumberPicker) findViewById(R.id.pressSet3);
        pressSet3.getValue();
        pressSet03 = String.valueOf(pressSet3);

        pressSet4 = (NumberPicker) findViewById(R.id.pressSet4);
        pressSet4.getValue();
        pressSet04 = String.valueOf(pressSet4);

        pressSet5 = (NumberPicker) findViewById(R.id.pressSet5);
        pressSet5.getValue();
        pressSet05 = String.valueOf(pressSet5);

        deadSet3 = (NumberPicker) findViewById(R.id.deadSet3);
        deadSet3.getValue();
        deadSet03 = String.valueOf(deadSet3);






        confirmButtonB.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
            	setResult(RESULT_OK);
                finish();
            }

        });

        next1B.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                viewFlipperB.setDisplayedChild(1);
                radioGroupB.check(R.id.rad2b);

            }

        });

        next2B.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                viewFlipperB.setDisplayedChild(2);
                radioGroupB.check(R.id.rad3b);

            }

        });


        radioGroupB.setOnCheckedChangeListener(new OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case(R.id.rad2b):
                        viewFlipperB.setDisplayedChild(1);
                    break;
                    case(R.id.rad3b):
                        viewFlipperB.setDisplayedChild(2);
                    break;
                    default:
                        viewFlipperB.setDisplayedChild(0);
                    break;
                }
            }
        });


        squatsB.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				alert.setTitle("Squats");
				alert.setMessage("Message");

				//set an EditText view to get user input
				final EditText input = new EditText(aMethod());
				input.setInputType(InputType.TYPE_CLASS_NUMBER);


				alert.setView(input);

				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int whichButton){
						String value = input.getText().toString();
						//Do something with value

						value = "Squats - " + value;

						squatsB.setText(value);

					}
				});

				alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int whichButton){
						//Cancelled
					}
				});

				AlertDialog dialog = alert.create();

				dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

				dialog.show();

			}
		});


        pressLabel.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				alert.setTitle("Overhead Press");
				alert.setMessage("Message");

				//set an EditText view to get user input
				final EditText input = new EditText(aMethod());
				input.setInputType(InputType.TYPE_CLASS_NUMBER);


				alert.setView(input);

				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int whichButton){
						String value = input.getText().toString();
						//Do something with value

						value = "Overhead Press: " + value;

						pressLabel.setText(value);

					}
				});

				alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int whichButton){
						//Cancelled
					}
				});

				AlertDialog dialog = alert.create();

				dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

				dialog.show();

			}
		});


        deadLabel.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				alert.setTitle("Deadlift");
				alert.setMessage("Change your weight");

				//set an EditText view to get user input
				final EditText input = new EditText(aMethod());
				input.setInputType(InputType.TYPE_CLASS_NUMBER);


				alert.setView(input);

				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int whichButton){
						String value = input.getText().toString();
						//Do something with value

						value = "Deadlift: " + value;

						deadLabel.setText(value);

					}
				});

				alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int whichButton){
						//Cancelled
					}
				});

				AlertDialog dialog = alert.create();

				dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

				dialog.show();

			}
		});

        populateFields();



        //squat increment
        if(mRowId == null){

        	Cursor cursor = mDbHelper.fetchAllNotes();
			cursor.moveToLast();


        	if(cursor.getCount()>=1){

        		if(Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_1)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_2)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_3)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_4)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_5)))==5 ){

        			cursor.moveToLast();

            		squatsB.setText(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_LABEL)));

            		String squat = squatsB.getText().toString();
                    String squatsWeight= squat.replaceAll("[^\\d]", "");

                    int incWeight = Integer.parseInt(appPrefs.getSquatIncrement());


                    int squatWeight = Integer.parseInt(squatsWeight);
                    squatWeight = squatWeight + incWeight ;
                    String sWeight = Integer.toString(squatWeight);


                    squatsB.setText("Squats : " + sWeight);


        		}else{
        			cursor.moveToLast();
            		squatsB.setText(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_LABEL)));


            		int squatStall = Integer.valueOf(appPrefs.getSquatStall());
            		squatStall++;
            		appPrefs.setSquatStall(Integer.toString(squatStall));

            		if(squatStall>=3){
            			squatStall = 0;
            			int squatDeload = Integer.valueOf(appPrefs.getSquatDeload());
            			squatDeload++;
                		appPrefs.setSquatStall(Integer.toString(squatStall));
                		appPrefs.setSquatDeload(Integer.toString(squatDeload));
            		}

        		}


        	}

            cursor.close();

        }

        //Press increment
        if(mRowId == null){

        	Cursor cursor = mDbHelper.fetchAllNotes();
			cursor.moveToLast();


        	if(cursor.getCount()>=1){

        		if(Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_1)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_2)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_3)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_4)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_5)))==5 ){

        			cursor.moveToLast();

            		rowLabel = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_LABEL));
            		benchLabel = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_LABEL));

            		pressLabel.setText(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_LABEL)));

            		String press = pressLabel.getText().toString();
                    String pressWeight= press.replaceAll("[^\\d]", "");

                    int incWeight = Integer.parseInt(appPrefs.getPressIncrement());


                    int pressoWeight = Integer.parseInt(pressWeight);
                    pressoWeight = pressoWeight + incWeight ;
                    String pWeight = Integer.toString(pressoWeight);


                    pressLabel.setText("Overhead Press: " + pWeight);

        		}else{
        			cursor.moveToLast();
            		pressLabel.setText(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_LABEL)));


            		int pressStall = Integer.valueOf(appPrefs.getPressStall());
            		pressStall++;
            		appPrefs.setPressStall(Integer.toString(pressStall));

            		if(pressStall>=3){
            			pressStall = 0;
            			int pressDeload = Integer.valueOf(appPrefs.getPressDeload());
            			pressDeload++;
                		appPrefs.setPressStall(Integer.toString(pressStall));
                		appPrefs.setPressDeload(Integer.toString(pressDeload));
            		}

        		}

        	}

        	cursor.close();

        }

        //deadlift increment
        if(mRowId == null){

        	Cursor cursor = mDbHelper.fetchAllNotes();
			cursor.moveToLast();


        	if(cursor.getCount()>=1){

        		if(Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.DEADLIFT_3)))==5 ){

        			cursor.moveToLast();

            		deadLabel.setText(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.DEAD_LABEL)));

            		String deadlift = deadLabel.getText().toString();
                    String deadsWeight= deadlift.replaceAll("[^\\d]", "");

                    int incWeight = Integer.parseInt(appPrefs.getDeadIncrement());


                    int deadWeight = Integer.parseInt(deadsWeight);
                    deadWeight = deadWeight + incWeight ;
                    String dWeight = Integer.toString(deadWeight);


                    deadLabel.setText("Deadlift : " + dWeight);


        		}else{
        			cursor.moveToLast();
            		deadLabel.setText(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.DEAD_LABEL)));


            		int deadStall = Integer.valueOf(appPrefs.getDeadStall());
            		deadStall++;
            		appPrefs.setDeadStall(Integer.toString(deadStall));

            		if(deadStall>=3){
            			deadStall = 0;
            			int deadDeload = Integer.valueOf(appPrefs.getDeadDeload());
            			deadDeload++;
                		appPrefs.setDeadStall(Integer.toString(deadStall));
                		appPrefs.setDeadDeload(Integer.toString(deadDeload));
            		}

        		}


        	}

            cursor.close();

        }

        if(mRowId == null){
        	checkForce5x5();
            checkForce3x5();
            fillWithFives();
        }


        if(appPrefs.getAutoSetState().equals("true")){

        	if(Integer.valueOf(appPrefs.getSquatDeload())>=3){
            	appPrefs.setSquatState("3x5");
            }


            //Squat 3x5
            if(appPrefs.getSquatState().equals("3x5")){
            	squatSet2B.setVisibility(View.INVISIBLE);
            	squatSet4B.setVisibility(View.INVISIBLE);

            	 squatSet2B.setText("5");
                 squatSet2B.setValue(5);

                 squatSet4B.setText("5");
                 squatSet4B.setValue(5);
            }


            if(Integer.valueOf(appPrefs.getBenchDeload())>=3){
            	appPrefs.setBenchState("3x5");
            }


            //Bench 3x5
            if(appPrefs.getPressState().equals("3x5")){
            	pressSet2.setVisibility(View.INVISIBLE);
            	pressSet4.setVisibility(View.INVISIBLE);

            	pressSet2.setText("5");
            	pressSet2.setValue(5);

            	pressSet4.setText("5");
            	pressSet4.setValue(5);
            }


        }



        Cursor cursor = mDbHelper.fetchAllNotes();
        cursor.moveToLast();
        if(cursor.getCount()<1){
        	rowLabel = "Barbell Row: 45";

    		benchLabel = "Bench Press: 45";

    		pressLabel.setText("Overhead Press: 45");

    		benchSet1 = "0";
    		benchSet2 = "0";
    		benchSet3 = "0";
    		benchSet4 = "0";
    		benchSet5 = "0";

            rowSet1 = "0";
            rowSet2 = "0";
            rowSet3 = "0";
            rowSet4 = "0";
            rowSet5 = "0";


        }else if(cursor.getCount()>=1){

        	benchLabel=(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_LABEL)));

        	rowLabel=(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_LABEL)));

        	benchSet1 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_1));
        	benchSet2 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_2));
        	benchSet3 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_3));
        	benchSet4 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_4));
        	benchSet5 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_5));

        	rowSet1 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_1));
        	rowSet2 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_2));
        	rowSet3 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_3));
        	rowSet4 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_4));
        	rowSet5 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_5));

        }
        cursor.close();



// End of onCreate---------------------------------------------------------------------------------------------------------

	}
	private void populateFields() {
        if (mRowId != null) {
            Cursor note = mDbHelper.fetchNote(mRowId);
            startManagingCursor(note);

            //mTitleText.setText(note.getString(
    	            //note.getColumnIndexOrThrow(StrongDbAdapter.KEY_TITLE)));
            //workoutState=(note.getString(
                    //note.getColumnIndexOrThrow(StrongDbAdapter.WORKOUT_STATE)));

            benchSet1 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_1));
            benchSet2 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_2));
            benchSet3 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_3));
            benchSet4 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_4));
            benchSet5 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_5));

            rowSet1 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_1));
        	rowSet2 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_2));
        	rowSet3 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_3));
        	rowSet4 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_4));
        	rowSet5 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_5));

            squatsB.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_LABEL)));

            pressLabel.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_LABEL)));

            rowLabel = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_LABEL));
    		benchLabel = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_LABEL));

    		deadLabel.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.DEAD_LABEL)));

            squatSet1B.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_1)));
            squatSet1B.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_1))));

            squatSet2B.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_2)));
            squatSet2B.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_2))));

            squatSet3B.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_3)));
            squatSet3B.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_3))));

            squatSet4B.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_4)));
            squatSet4B.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_4))));

            squatSet5B.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_5)));
            squatSet5B.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_5))));

            pressSet1.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_1)));
            pressSet1.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_1))));

            pressSet2.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_2)));
            pressSet2.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_2))));

            pressSet3.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_3)));
            pressSet3.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_3))));

            pressSet4.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_4)));
            pressSet4.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_4))));

            pressSet5.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_5)));
            pressSet5.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_5))));

            deadSet3.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.DEADLIFT_3)));
            deadSet3.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.DEADLIFT_3))));


        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveState();
        outState.putSerializable(StrongDbAdapter.KEY_ROWID, mRowId);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        populateFields();
    }



    //Saves all the data to the database
    private void saveState() {

    	String title = mainTitle;
        String squatLabel = squatsB.getText().toString();
        String pressLabel1 = pressLabel.getText().toString();
        String deadLabel1 = deadLabel.getText().toString();



        squatSet1B.getValue();
        squatSet01B = String.valueOf(squatSet1B.getValue());

        squatSet2B.getValue();
        squatSet02B = String.valueOf(squatSet2B.getValue());

        squatSet3B.getValue();
        squatSet03B = String.valueOf(squatSet3B.getValue());

        squatSet4B.getValue();
        squatSet04B = String.valueOf(squatSet4B.getValue());

        squatSet5B.getValue();
        squatSet05B = String.valueOf(squatSet5B.getValue());

        pressSet1.getValue();
        pressSet01 = String.valueOf(pressSet1.getValue());

        pressSet2.getValue();
        pressSet02 = String.valueOf(pressSet2.getValue());

        pressSet3.getValue();
        pressSet03 = String.valueOf(pressSet3.getValue());

        pressSet4.getValue();
        pressSet04 = String.valueOf(pressSet4.getValue());

        pressSet5.getValue();
        pressSet05 = String.valueOf(pressSet5.getValue());

        deadSet3.getValue();
        deadSet03 = String.valueOf(deadSet3.getValue());

        String benchValues = "0";
        String rowValues = "0";




        if (mRowId == null) {
            long id = mDbHelper.createNote(title, squatLabel, workoutState,
            		squatSet01B, squatSet02B, squatSet03B, squatSet04B, squatSet05B,
            		pressLabel1, pressSet01, pressSet02, pressSet03, pressSet04, pressSet05,
            		deadLabel1, deadSet03,
            		benchLabel, benchSet1, benchSet2, benchSet3, benchSet4, benchSet5,
            		rowLabel, rowSet1, rowSet2, rowSet3, rowSet4, rowSet5);
            if (id > 0) {
                mRowId = id;
            }
        } else {
            mDbHelper.updateNote(mRowId, title, squatLabel,
            		squatSet01B, squatSet02B, squatSet03B, squatSet04B, squatSet05B,
            		pressLabel1, pressSet01, pressSet02, pressSet03, pressSet04, pressSet05,
            		deadLabel1, deadSet03,
            		benchLabel, benchSet1, benchSet2, benchSet3, benchSet4, benchSet5,
            		rowLabel, rowSet1, rowSet2, rowSet3, rowSet4, rowSet5);
        }

    }

    public Context aMethod(){
    	Context actContext = this;
		return actContext;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDbHelper != null) {
            mDbHelper.close();
        }

    }

    public boolean getWorkoutState(){
		if(workoutA==false){
			workoutA = true;
			workoutState = "Workout A";
		}else{
			workoutA = false;
			workoutState = "Workout B";
		}


    	return workoutA;

    }

public void checkForce5x5(){

    	if(appPrefs.getForce5x5().equals("true")){

        	squatSet1B.setVisibility(View.VISIBLE);
        	squatSet2B.setVisibility(View.VISIBLE);
        	squatSet3B.setVisibility(View.VISIBLE);
        	squatSet4B.setVisibility(View.VISIBLE);
        	squatSet5B.setVisibility(View.VISIBLE);


        	pressSet1.setVisibility(View.VISIBLE);
        	pressSet2.setVisibility(View.VISIBLE);
        	pressSet3.setVisibility(View.VISIBLE);
        	pressSet4.setVisibility(View.VISIBLE);
        	pressSet5.setVisibility(View.VISIBLE);



    	}

    }

    public void checkForce3x5(){

    	if(appPrefs.getForce3x5().equals("true")){

        	squatSet1B.setVisibility(View.VISIBLE);
        	squatSet2B.setVisibility(View.INVISIBLE);
        	squatSet3B.setVisibility(View.VISIBLE);
        	squatSet4B.setVisibility(View.INVISIBLE);
        	squatSet5B.setVisibility(View.VISIBLE);


        	pressSet1.setVisibility(View.VISIBLE);
        	pressSet2.setVisibility(View.INVISIBLE);
        	pressSet3.setVisibility(View.VISIBLE);
        	pressSet4.setVisibility(View.INVISIBLE);
        	pressSet5.setVisibility(View.VISIBLE);




        	squatSet2B.setText("5");
            squatSet2B.setValue(5);

            squatSet4B.setText("5");
            squatSet4B.setValue(5);

            pressSet2.setText("5");
            pressSet2.setValue(5);

            pressSet4.setText("5");
            pressSet4.setValue(5);



    	}

    }

    public void fillWithFives(){

    	if(appPrefs.getFivesPreference().equals("on")){

    		squatSet1B.setText("5");
            squatSet1B.setValue(5);
    		squatSet2B.setText("5");
            squatSet2B.setValue(5);
            squatSet3B.setText("5");
            squatSet3B.setValue(5);
            squatSet4B.setText("5");
            squatSet4B.setValue(5);
            squatSet5B.setText("5");
            squatSet5B.setValue(5);

            pressSet1.setText("5");
            pressSet1.setValue(5);
            pressSet2.setText("5");
            pressSet2.setValue(5);
            pressSet3.setText("5");
            pressSet3.setValue(5);
            pressSet4.setText("5");
            pressSet4.setValue(5);
            pressSet5.setText("5");
            pressSet5.setValue(5);


            deadSet3.setText("5");
            deadSet3.setValue(5);






    	}

    }

}
