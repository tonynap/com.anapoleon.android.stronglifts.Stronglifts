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

public class WorkoutEditA extends Activity {

	 private boolean workoutA;
	 //public TextView mTitleText;
	 //private EditText mBodyText;
	 private Long mRowId;
	 private StrongDbAdapter mDbHelper;
	 private ViewFlipper viewFlipper;
	 private ViewFlipper viewFlipperB;
	 public TextView squats;
	 public TextView squatsB;
	 //public boolean workoutA;
	 public String workoutState = "Workout A";

	 private String mainTitle;
	 //private double rowId = mRowId;
	 public String squatLabel;
	 public String squatLabelB;

	 private TextView benchLabel;
	 private TextView rowLabel;


	 public Button confirmButton;
	 public Button confirmButtonB;

	 public Button next1;
	 public Button next2;

	 private Long prevId ;
	 //public int rowNum = 0;
	 private String title;

	 private NumberPicker squatSet1;
	 private NumberPicker squatSet1B;
	 private String squatSet01;
	 private String squatSet01B;

	 private RadioGroup radioGroup;
	 private RadioGroup radioGroupB;

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

	 private NumberPicker benchSet1;
	 private String benchSet01;

	 private NumberPicker benchSet2;
	 private String benchSet02;

	 private NumberPicker benchSet3;
	 private String benchSet03;

	 private NumberPicker benchSet4;
	 private String benchSet04;

	 private NumberPicker benchSet5;
	 private String benchSet05;

	 private NumberPicker rowSet1;
	 private String rowSet01;

	 private NumberPicker rowSet2;
	 private String rowSet02;

	 private NumberPicker rowSet3;
	 private String rowSet03;

	 private NumberPicker rowSet4;
	 private String rowSet04;

	 private NumberPicker rowSet5;
	 private String rowSet05;


	 //private String rowLabel;

	 private String deadLabel;
	 private String pressLabel;

	 private String squatIncrement;

	 protected AppPreferences appPrefs;

	 private String pressSet1;
	 private String pressSet2;
	 private String pressSet3;
	 private String pressSet4;
	 private String pressSet5;

	 private String deadSet03;





	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

        setContentView(R.layout.workout_edit3);

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
        	mainTitle = "Workout A:  " + formattedDate;
        }



        mDbHelper = new StrongDbAdapter(this);
        mDbHelper.open();

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        radioGroup = (RadioGroup) findViewById(R.id.radgroup1);

        confirmButton = (Button) findViewById(R.id.confirmButton);
        next1 = (Button) findViewById(R.id.next1);
        next2 = (Button) findViewById(R.id.next2);



        squats = (TextView)	findViewById(R.id.squatLabel);

        //squatLabel = squats.getText().toString();


        squatSet1 = (NumberPicker) findViewById(R.id.squatSet1);
        squatSet1.getValue();
        squatSet01 = String.valueOf(squatSet1);

        squatSet2 = (NumberPicker) findViewById(R.id.squatSet2);
        squatSet2.getValue();
        squatSet02 = String.valueOf(squatSet2);

        squatSet3 = (NumberPicker) findViewById(R.id.squatSet3);
        squatSet3.getValue();
        squatSet03 = String.valueOf(squatSet3);

        squatSet4 = (NumberPicker) findViewById(R.id.squatSet4);
        squatSet4.getValue();
        squatSet04 = String.valueOf(squatSet4);

        squatSet5 = (NumberPicker) findViewById(R.id.squatSet5);
        squatSet5.getValue();
        squatSet05 = String.valueOf(squatSet5);

        benchLabel= (TextView)findViewById(R.id.benchLabel);

        benchSet1 = (NumberPicker) findViewById(R.id.benchSet1);
        benchSet1.getValue();
        benchSet01 = String.valueOf(benchSet1);

        benchSet2 = (NumberPicker) findViewById(R.id.benchSet2);
        benchSet2.getValue();
        benchSet02 = String.valueOf(benchSet2);

        benchSet3 = (NumberPicker) findViewById(R.id.benchSet3);
        benchSet3.getValue();
        benchSet03 = String.valueOf(benchSet3);

        benchSet4 = (NumberPicker) findViewById(R.id.benchSet4);
        benchSet4.getValue();
        benchSet04 = String.valueOf(benchSet4);

        benchSet5 = (NumberPicker) findViewById(R.id.benchSet5);
        benchSet5.getValue();
        benchSet05 = String.valueOf(benchSet5);

        rowLabel= (TextView)findViewById(R.id.rowLabel);

        rowSet1 = (NumberPicker) findViewById(R.id.rowSet1);
        rowSet1.getValue();
        rowSet01 = String.valueOf(rowSet1);

        rowSet2 = (NumberPicker) findViewById(R.id.rowSet2);
        rowSet2.getValue();
        rowSet02 = String.valueOf(rowSet2);

        rowSet3 = (NumberPicker) findViewById(R.id.rowSet3);
        rowSet3.getValue();
        rowSet03 = String.valueOf(rowSet3);

        rowSet4 = (NumberPicker) findViewById(R.id.rowSet4);
        rowSet4.getValue();
        rowSet04 = String.valueOf(rowSet4);

        rowSet5 = (NumberPicker) findViewById(R.id.rowSet5);
        rowSet5.getValue();
        rowSet05 = String.valueOf(rowSet5);



//puts listeners on all of the buttons to make them flip to next lift
        //or exit
        confirmButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
            	setResult(RESULT_OK);
                finish();
            }

        });

        next1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                viewFlipper.setDisplayedChild(1);
                radioGroup.check(R.id.rad2);
            }

        });

        next2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                viewFlipper.setDisplayedChild(2);
                radioGroup.check(R.id.rad3);
            }

        });


        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case(R.id.rad2):
                        viewFlipper.setDisplayedChild(1);
                    break;
                    case(R.id.rad3):
                        viewFlipper.setDisplayedChild(2);
                    break;
                    default:
                        viewFlipper.setDisplayedChild(0);
                    break;
                }
            }
        });


        squats.setOnClickListener(new View.OnClickListener() {

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

						squats.setText(value);

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

        benchLabel.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				alert.setTitle("Bench Press");
				alert.setMessage("Change Weight");

				//set an EditText view to get user input
				final EditText input = new EditText(aMethod());
				input.setInputType(InputType.TYPE_CLASS_NUMBER);


				alert.setView(input);

				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int whichButton){
						String value = input.getText().toString();
						//Do something with value

						value = "Bench Press: " + value;

						benchLabel.setText(value);

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

        rowLabel.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				alert.setTitle("Barbell Row");
				alert.setMessage("Change Weight");

				//set an EditText view to get user input
				final EditText input = new EditText(aMethod());
				input.setInputType(InputType.TYPE_CLASS_NUMBER);


				alert.setView(input);

				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int whichButton){
						String value = input.getText().toString();
						//Do something with value

						value = "Barbell Row: " + value;

						rowLabel.setText(value);

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


        //auto increase squat weight
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

            		squats.setText(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_LABEL)));

            		String squat = squats.getText().toString();
                    String squatsWeight= squat.replaceAll("[^\\d]", "");

                    int incWeight = Integer.parseInt(appPrefs.getSquatIncrement());


                    int squatWeight = Integer.parseInt(squatsWeight);
                    squatWeight = squatWeight + incWeight ;
                    String sWeight = Integer.toString(squatWeight);


                    squats.setText("Squats : " + sWeight);
        		}else{
        			cursor.moveToLast();
            		squats.setText(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_LABEL)));


            		int squatStall = Integer.valueOf(appPrefs.getSquatStall());
            		squatStall++;
            		appPrefs.setSquatStall(Integer.toString(squatStall));

            		if(squatStall>=3){
            			squatStall = 0;
            			int squatDeload = Integer.valueOf(appPrefs.getSquatDeload());
            			squatDeload++;
                		appPrefs.setSquatStall(Integer.toString(squatStall));
                		appPrefs.setSquatDeload(Integer.toString(squatDeload));

                		double squatDeloadPercent = Double.parseDouble(appPrefs.getSquatDeloadPercent());


                		squatDeloadPercent = squatDeloadPercent/100;

                		String squat = squats.getText().toString();
                        String squatsWeight= squat.replaceAll("[^\\d]", "");
                        double squatWeight = Double.parseDouble(squatsWeight);
                        double squatWeight2 = Double.parseDouble(squatsWeight);

                        //new Array String[] = {


                        squatWeight = squatWeight2*squatDeloadPercent;


                        squatWeight2 = squatWeight2 - squatWeight;
                        String sWeight = Double.toString(squatWeight2);
                        squats.setText("Squats : " + sWeight);

                        //squats.setText(Double.toString(squatWeight));


            		}

        		}

        	}
        	cursor.close();
        }


        //Bench increment
        if(mRowId == null){

        	Cursor cursor = mDbHelper.fetchAllNotes();
			cursor.moveToLast();


        	if(cursor.getCount()>=1){

        		if(Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_1)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_2)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_3)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_4)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_5)))==5 ){

        			cursor.moveToLast();

            		pressLabel = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_LABEL));
            		deadLabel = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.DEAD_LABEL));

            		benchLabel.setText(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_LABEL)));

            		String bench = benchLabel.getText().toString();
                    String benchWeight= bench.replaceAll("[^\\d]", "");

                    int incWeight = Integer.parseInt(appPrefs.getBenchIncrement());



                    int benchoWeight = Integer.parseInt(benchWeight);
                    benchoWeight = benchoWeight + incWeight ;
                    String bWeight = Integer.toString(benchoWeight);


                    benchLabel.setText("Bench Press: " + bWeight);

        		}else{
        			cursor.moveToLast();
            		benchLabel.setText(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.BENCH_LABEL)));


            		int benchStall = Integer.valueOf(appPrefs.getBenchStall());
            		benchStall++;
            		appPrefs.setBenchStall(Integer.toString(benchStall));

            		if(benchStall>=3){
            			benchStall = 0;
            			int benchDeload = Integer.valueOf(appPrefs.getBenchDeload());
            			benchDeload++;
                		appPrefs.setBenchStall(Integer.toString(benchStall));
                		appPrefs.setBenchDeload(Integer.toString(benchDeload));
            		}

        		}

        	}


        	cursor.close();

        }


        //Row increment
        if(mRowId == null){

        	Cursor cursor = mDbHelper.fetchAllNotes();
        	cursor.moveToLast();

        	if(cursor.getCount()>=1){

        		if(Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_1)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_2)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_3)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_4)))==5 &&
            			Integer.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_5)))==5 ){

        			cursor.moveToLast();

            		rowLabel.setText(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_LABEL)));

            		String row = rowLabel.getText().toString();
                    String rowsWeight= row.replaceAll("[^\\d]", "");

                    int incWeight = Integer.parseInt(appPrefs.getRowIncrement());


                    int rowWeight = Integer.parseInt(rowsWeight);
                    rowWeight = rowWeight + incWeight ;
                    String rWeight = Integer.toString(rowWeight);


                    rowLabel.setText("Barbell Rows : " + rWeight);

        		}else{
        			cursor.moveToLast();
        			rowLabel.setText(cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.ROW_LABEL)));


            		int rowStall = Integer.valueOf(appPrefs.getRowStall());
            		rowStall++;
            		appPrefs.setRowStall(Integer.toString(rowStall));

            		if(rowStall>=3){
            			rowStall = 0;
            			int rowDeload = Integer.valueOf(appPrefs.getRowDeload());
            			rowDeload++;
                		appPrefs.setRowStall(Integer.toString(rowStall));
                		appPrefs.setRowDeload(Integer.toString(rowDeload));
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



        if(mRowId == null){

        	if(appPrefs.getAutoSetState().equals("true")){

            	if(Integer.valueOf(appPrefs.getSquatDeload())>=3){
                	appPrefs.setSquatState("3x5");
                }


                //Squat 3x5
                if(appPrefs.getSquatState().equals("3x5")){
                	squatSet2.setVisibility(View.INVISIBLE);
                	squatSet4.setVisibility(View.INVISIBLE);

                	 squatSet2.setText("5");
                     squatSet2.setValue(5);

                     squatSet4.setText("5");
                     squatSet4.setValue(5);
                }


                if(Integer.valueOf(appPrefs.getBenchDeload())>=3){
                	appPrefs.setBenchState("3x5");
                }


                //Bench 3x5
                if(appPrefs.getBenchState().equals("3x5")){
                	benchSet2.setVisibility(View.INVISIBLE);
                	benchSet4.setVisibility(View.INVISIBLE);

                	 benchSet2.setText("5");
                     benchSet2.setValue(5);

                     benchSet4.setText("5");
                     benchSet4.setValue(5);
                }


                if(Integer.valueOf(appPrefs.getRowDeload())>=3){
                	appPrefs.setRowState("3x5");
                }


                //Row 3x5
                if(appPrefs.getRowState().equals("3x5")){
                	rowSet2.setVisibility(View.INVISIBLE);
                	rowSet4.setVisibility(View.INVISIBLE);

                	 rowSet2.setText("5");
                     rowSet2.setValue(5);

                     rowSet4.setText("5");
                     rowSet4.setValue(5);
                }

            }

        }




        Cursor cursor = mDbHelper.fetchAllNotes();
        cursor.moveToLast();
        if(cursor.getCount()<1){
        	pressLabel = "Overhead Press: 45";

    		deadLabel = "Deadlift: 45";

    		benchLabel.setText("Bench Press: 45");

    		pressSet1 = "0";
            pressSet2 = "0";
            pressSet3 = "0";
            pressSet4 = "0";
            pressSet5 = "0";

            deadSet03 = "0";


        }else if(cursor.getCount()>=1){

        	pressLabel = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_LABEL));

        	deadLabel = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.DEAD_LABEL));

        	pressSet1 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_1));
            pressSet2 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_2));
            pressSet3 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_3));
            pressSet4 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_4));
            pressSet5 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.PRESS_5));

            deadSet03 = cursor.getString(cursor.getColumnIndexOrThrow(StrongDbAdapter.DEADLIFT_3));

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
            workoutState=(note.getString(
                    note.getColumnIndexOrThrow(StrongDbAdapter.WORKOUT_STATE)));
            squats.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_LABEL)));

            benchLabel.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_LABEL)));

            pressLabel = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_LABEL));

            pressSet1 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_1));
            pressSet2 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_2));
            pressSet3 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_3));
            pressSet4 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_4));
            pressSet5 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.PRESS_5));


    		deadLabel = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.DEAD_LABEL));

    		deadSet03 = note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.DEADLIFT_3));

    		rowLabel.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_LABEL)));


            squatSet1.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_1)));
            squatSet1.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_1))));

            squatSet2.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_2)));
            squatSet2.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_2))));

            squatSet3.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_3)));
            squatSet3.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_3))));

            squatSet4.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_4)));
            squatSet4.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_4))));

            squatSet5.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_5)));
            squatSet5.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.SQUAT_5))));

            benchSet1.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_1)));
            benchSet1.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_1))));

            benchSet2.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_2)));
            benchSet2.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_2))));

            benchSet3.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_3)));
            benchSet3.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_3))));

            benchSet4.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_4)));
            benchSet4.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_4))));

            benchSet5.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_5)));
            benchSet5.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.BENCH_5))));

            rowSet1.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_1)));
            rowSet1.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_1))));

            rowSet2.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_2)));
            rowSet2.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_2))));

            rowSet3.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_3)));
            rowSet3.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_3))));

            rowSet4.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_4)));
            rowSet4.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_4))));

            rowSet5.setText(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_5)));
            rowSet5.setValue(Integer.valueOf(note.getString(note.getColumnIndexOrThrow(StrongDbAdapter.ROW_5))));

            String bench = benchLabel.getText().toString();
            String benchWeight= bench.replaceAll("[^\\d]", "");


            int benchoWeight = Integer.parseInt(benchWeight);
        //    benchoWeight = benchoWeight + 5 ;
            String bWeight = Integer.toString(benchoWeight);


            benchLabel.setText("Bench Press: " + bWeight);


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
        String squatLabel = squats.getText().toString();
        String benchLabel1 = benchLabel.getText().toString();
        String rowLabel1 = rowLabel.getText().toString();


        //squatSet1.getValue();
        squatSet01 = String.valueOf(squatSet1.getValue());
        squatSet02 = String.valueOf(squatSet2.getValue());
        squatSet03 = String.valueOf(squatSet3.getValue());
        squatSet04 = String.valueOf(squatSet4.getValue());
        squatSet05 = String.valueOf(squatSet5.getValue());

        benchSet01 = String.valueOf(benchSet1.getValue());
        benchSet02 = String.valueOf(benchSet2.getValue());
        benchSet03 = String.valueOf(benchSet3.getValue());
        benchSet04 = String.valueOf(benchSet4.getValue());
        benchSet05 = String.valueOf(benchSet5.getValue());

        rowSet01 = String.valueOf(rowSet1.getValue());
        rowSet02 = String.valueOf(rowSet2.getValue());
        rowSet03 = String.valueOf(rowSet3.getValue());
        rowSet04 = String.valueOf(rowSet4.getValue());
        rowSet05 = String.valueOf(rowSet5.getValue());


        String pressValues = "0";

        String deadValues = "0";





        if (mRowId == null) {
            long id = mDbHelper.createNote(title, squatLabel, workoutState,
            		squatSet01, squatSet02, squatSet03, squatSet04, squatSet05,
            		pressLabel, pressSet1, pressSet2, pressSet3, pressSet4, pressSet5,
            		deadLabel, deadSet03,
            		benchLabel1, benchSet01, benchSet02, benchSet03, benchSet04, benchSet05,
            		rowLabel1, rowSet01, rowSet02, rowSet03, rowSet04, rowSet05);
            if (id > 0) {
                mRowId = id;
            }
        } else {
            mDbHelper.updateNote(mRowId, title, squatLabel,
            		squatSet01, squatSet02, squatSet03, squatSet04, squatSet05,
            		pressLabel, pressSet1, pressSet2, pressSet3, pressSet4, pressSet5,
            		deadLabel, deadSet03,
            		benchLabel1, benchSet01, benchSet02, benchSet03, benchSet04, benchSet05,
            		rowLabel1, rowSet01, rowSet02, rowSet03, rowSet04, rowSet05);
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

        	squatSet1.setVisibility(View.VISIBLE);
        	squatSet2.setVisibility(View.VISIBLE);
        	squatSet3.setVisibility(View.VISIBLE);
        	squatSet4.setVisibility(View.VISIBLE);
        	squatSet5.setVisibility(View.VISIBLE);


        	benchSet1.setVisibility(View.VISIBLE);
        	benchSet2.setVisibility(View.VISIBLE);
        	benchSet3.setVisibility(View.VISIBLE);
        	benchSet4.setVisibility(View.VISIBLE);
        	benchSet5.setVisibility(View.VISIBLE);


        	rowSet1.setVisibility(View.VISIBLE);
        	rowSet2.setVisibility(View.VISIBLE);
        	rowSet3.setVisibility(View.VISIBLE);
        	rowSet4.setVisibility(View.VISIBLE);
        	rowSet5.setVisibility(View.VISIBLE);

    	}

    }

    public void checkForce3x5(){

    	if(appPrefs.getForce3x5().equals("true")){

        	squatSet1.setVisibility(View.VISIBLE);
        	squatSet2.setVisibility(View.INVISIBLE);
        	squatSet3.setVisibility(View.VISIBLE);
        	squatSet4.setVisibility(View.INVISIBLE);
        	squatSet5.setVisibility(View.VISIBLE);


        	benchSet1.setVisibility(View.VISIBLE);
        	benchSet2.setVisibility(View.INVISIBLE);
        	benchSet3.setVisibility(View.VISIBLE);
        	benchSet4.setVisibility(View.INVISIBLE);
        	benchSet5.setVisibility(View.VISIBLE);


        	rowSet1.setVisibility(View.VISIBLE);
        	rowSet2.setVisibility(View.INVISIBLE);
        	rowSet3.setVisibility(View.VISIBLE);
        	rowSet4.setVisibility(View.INVISIBLE);
        	rowSet5.setVisibility(View.VISIBLE);

        	squatSet2.setText("5");
            squatSet2.setValue(5);

            squatSet4.setText("5");
            squatSet4.setValue(5);

            benchSet2.setText("5");
            benchSet2.setValue(5);

            benchSet4.setText("5");
            benchSet4.setValue(5);

            rowSet2.setText("5");
            rowSet2.setValue(5);

            rowSet4.setText("5");
            rowSet4.setValue(5);

    	}

    }

    public void fillWithFives(){

    	if(appPrefs.getFivesPreference().equals("on")){

    		squatSet1.setText("5");
            squatSet1.setValue(5);
    		squatSet2.setText("5");
            squatSet2.setValue(5);
            squatSet3.setText("5");
            squatSet3.setValue(5);
            squatSet4.setText("5");
            squatSet4.setValue(5);
            squatSet5.setText("5");
            squatSet5.setValue(5);

            benchSet1.setText("5");
            benchSet1.setValue(5);
            benchSet2.setText("5");
            benchSet2.setValue(5);
            benchSet3.setText("5");
            benchSet3.setValue(5);
            benchSet4.setText("5");
            benchSet4.setValue(5);
            benchSet5.setText("5");
            benchSet5.setValue(5);

            rowSet1.setText("5");
            rowSet1.setValue(5);
            rowSet2.setText("5");
            rowSet2.setValue(5);
            rowSet3.setText("5");
            rowSet3.setValue(5);
            rowSet4.setText("5");
            rowSet4.setValue(5);
            rowSet5.setText("5");
            rowSet5.setValue(5);





    	}

    }



}



