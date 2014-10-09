package com.anapoleon.android.stronglifts;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class OptionsList extends ListActivity {
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

    AlertDialog.Builder builder;
    AlertDialog alertDialog;

    private StrongDbAdapter mDbHelper;

    private SimpleCursorAdapter notes;

	protected AppPreferences appPrefs;


    private EditText squats;
    private EditText bench;
    private EditText row;
    private EditText press;
    private EditText deadlift;

    private EditText squatsDeloadPercent;
    private EditText benchDeloadPercent;
    private EditText rowDeloadPercent;
    private EditText pressDeloadPercent;
    private EditText deadliftDeloadPercent;

    private RadioButton on;
    private RadioButton off;

    private RadioGroup fivesGroup;
    private RadioGroup autoGroup;
    private RadioGroup forceFiveGroup;
    private RadioGroup forceThreeGroup;



    private EditText squatStall;
    private EditText squatDeload;
    private EditText benchStall;
    private EditText benchDeload;
    private EditText rowStall;
    private EditText rowDeload;
    private EditText pressStall;
    private EditText pressDeload;
    private EditText deadliftStall;
    private EditText deadliftDeload;




    static final String[] COUNTRIES = new String[] {
    	   "Edit Stalls and Deloads", "Edit Deload Percent", "Edit Weight Increments", "Fill with 5's", "Auto 3x5",
    	   "Force 5x5", "Force 3x5"
    	   };

    	   /** Called when the activity is first created. */
    	   @Override
    	   public void onCreate(Bundle savedInstanceState) {
    	       super.onCreate(savedInstanceState);
    	       setListAdapter(new ArrayAdapter<String>(this,
    	               android.R.layout.simple_list_item_1, COUNTRIES));
    	       getListView().setTextFilterEnabled(true);


    	   }

    	 @Override
    	 protected void onListItemClick(ListView l, View v, int position, long id) {
    	  // TODO Auto-generated method stub
    	  super.onListItemClick(l, v, position, id);
	      appPrefs = new AppPreferences(getApplicationContext());


    	  switch(position){
    	  case 0:

    		  View sdlayout = getLayoutInflater().inflate(R.layout.stalls_deloads, null);
    		  AlertDialog.Builder sdbuilder = new AlertDialog.Builder(this);

    		  sdbuilder.setTitle("Edit Stalls and Deloads")
    	        .setView(sdlayout);

    		  squatStall = (EditText) sdlayout.findViewById(R.id.squatStall);
    		  squatStall.setText(appPrefs.getSquatStall());

    		  benchStall = (EditText) sdlayout.findViewById(R.id.benchStall);
    		  benchStall.setText(appPrefs.getBenchStall());

    		  rowStall = (EditText) sdlayout.findViewById(R.id.rowStall);
    		  rowStall.setText(appPrefs.getRowStall());

    		  pressStall = (EditText) sdlayout.findViewById(R.id.pressStall);
    		  pressStall.setText(appPrefs.getPressStall());

    		  deadliftStall = (EditText) sdlayout.findViewById(R.id.deadliftStall);
    		  deadliftStall.setText(appPrefs.getDeadStall());

    		  squatDeload = (EditText) sdlayout.findViewById(R.id.squatDeload);
    		  squatDeload.setText(appPrefs.getSquatDeload());

    		  benchDeload = (EditText) sdlayout.findViewById(R.id.benchDeload);
    		  benchDeload.setText(appPrefs.getBenchDeload());

    		  rowDeload = (EditText) sdlayout.findViewById(R.id.rowDeload);
    		  rowDeload.setText(appPrefs.getRowDeload());

    		  pressDeload = (EditText) sdlayout.findViewById(R.id.pressDeload);
    		  pressDeload.setText(appPrefs.getPressDeload());

    		  deadliftDeload = (EditText) sdlayout.findViewById(R.id.deadliftDeload);
    		  deadliftDeload.setText(appPrefs.getDeadDeload());






    	        sdbuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {
    	            // Save values from editTexts to preferences
    	        	//squats;

    	        	appPrefs.setSquatStall(squatStall.getText().toString());
    	        	appPrefs.setBenchStall(benchStall.getText().toString());
    	        	appPrefs.setRowStall(rowStall.getText().toString());
    	        	appPrefs.setPressStall(pressStall.getText().toString());
    	        	appPrefs.setDeadStall(deadliftStall.getText().toString());

    	        	appPrefs.setSquatDeload(squatDeload.getText().toString());
    	        	appPrefs.setBenchDeload(benchDeload.getText().toString());
    	        	appPrefs.setRowDeload(rowDeload.getText().toString());
    	        	appPrefs.setPressDeload(pressDeload.getText().toString());
    	        	appPrefs.setDeadDeload(deadliftDeload.getText().toString());





    	        }})
    	        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {
    	            // cancel
    	        }
    	        }).show();



    		  break;

    	  case 1:

    		  //Context mContext = getApplicationContext();
    		  //LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
    		  View deloadlayout = getLayoutInflater().inflate(R.layout.deload_weight, null);
    		  AlertDialog.Builder deloadbuilder = new AlertDialog.Builder(this);

    		  deloadbuilder.setTitle("Edit Deload Percent")
    	        .setMessage("")
    	        .setView(deloadlayout);

    		  squatsDeloadPercent = (EditText) deloadlayout.findViewById(R.id.squatsDeloadEdit);
    		  String squatWeightDeload =(appPrefs.getSquatDeloadPercent());
    		  squatsDeloadPercent.setText(squatWeightDeload);

    		  benchDeloadPercent = (EditText) deloadlayout.findViewById(R.id.benchDeloadEdit);
    		  String benchWeightDeload =(appPrefs.getBenchDeloadPercent());
    		  benchDeloadPercent.setText(benchWeightDeload);

    		  rowDeloadPercent = (EditText) deloadlayout.findViewById(R.id.rowDeloadEdit);
    		  String rowWeightDeload =(appPrefs.getRowDeloadPercent());
    		  rowDeloadPercent.setText(rowWeightDeload);

    		  pressDeloadPercent = (EditText) deloadlayout.findViewById(R.id.pressDeloadEdit);
    		  String pressWeightDeload =(appPrefs.getPressDeloadPercent());
    		  pressDeloadPercent.setText(pressWeightDeload);

    		  deadliftDeloadPercent = (EditText) deloadlayout.findViewById(R.id.deadliftDeloadEdit);
    		  String deadWeightDeload =(appPrefs.getDeadDeloadPercent());
    		  deadliftDeloadPercent.setText(deadWeightDeload);

    		  deloadbuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {
    	            // Save values from editTexts to preferences
    	        	//squats;

    	        	appPrefs.setSquatDeloadPercent(squatsDeloadPercent.getText().toString());
    	        	appPrefs.setBenchDeloadPercent(benchDeloadPercent.getText().toString());
    	        	appPrefs.setRowDeloadPercent(rowDeloadPercent.getText().toString());
    	        	appPrefs.setPressDeloadPercent(pressDeloadPercent.getText().toString());
    	        	appPrefs.setDeadDeloadPercent(deadliftDeloadPercent.getText().toString());

    	        }})
    	        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {
    	            // cancel
    	        }
    	        }).show();







    		  break;

    	  case 2:
    		  //Context mContext = getApplicationContext();
    		  //LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
    		  View layout = getLayoutInflater().inflate(R.layout.weight_increments, null);
    		  AlertDialog.Builder builder = new AlertDialog.Builder(this);

    		  builder.setTitle("Edit Weight Increments")
    	        .setMessage("")
    	        .setView(layout);

    		  squats = (EditText) layout.findViewById(R.id.squatsIncEdit);
    		  String squatWeight =(appPrefs.getSquatIncrement());
    		  squats.setText(squatWeight);

    		  bench = (EditText) layout.findViewById(R.id.benchIncEdit);
    		  String benchWeight =(appPrefs.getBenchIncrement());
    		  bench.setText(benchWeight);

    		  row = (EditText) layout.findViewById(R.id.rowIncEdit);
    		  String rowWeight =(appPrefs.getRowIncrement());
    		  row.setText(rowWeight);

    		  press = (EditText) layout.findViewById(R.id.pressIncEdit);
    		  String pressWeight =(appPrefs.getPressIncrement());
    		  press.setText(pressWeight);

    		  deadlift = (EditText) layout.findViewById(R.id.deadliftIncEdit);
    		  String deadWeight =(appPrefs.getDeadIncrement());
    		  deadlift.setText(deadWeight);

    	        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {
    	            // Save values from editTexts to preferences
    	        	//squats;

    	        	appPrefs.setSquatIncrement(squats.getText().toString());
    	        	appPrefs.setBenchIncrement(bench.getText().toString());
    	        	appPrefs.setRowIncrement(row.getText().toString());
    	        	appPrefs.setPressIncrement(press.getText().toString());
    	        	appPrefs.setDeadIncrement(deadlift.getText().toString());

    	        }})
    	        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {
    	            // cancel
    	        }
    	        }).show();



    		  break;

    	  case 3:

    		  View fiveLayout = getLayoutInflater().inflate(R.layout.fill_with_fives, null);
    		  AlertDialog.Builder fivebuilder = new AlertDialog.Builder(this);

    		  fivebuilder.setTitle("Fill with 5's")
    	        .setView(fiveLayout);




    		  //	*************LAYOUT.FINDVIEWBYID**************


    		  fivesGroup = (RadioGroup) fiveLayout.findViewById(R.id.fivesGroup);

    		  fivesGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(){
    	            public void onCheckedChanged(RadioGroup group, int checkedId)
    	            {
    	                switch(checkedId)
    	                {
    	                    case(R.id.fivesOn):

    	                    break;
    	                    case(R.id.fivesOff):

    	                    break;

    	                }
    	            }
    	        });


    		  on = (RadioButton) fiveLayout.findViewById(R.id.fivesOn);
    		  off = (RadioButton) fiveLayout.findViewById(R.id.fivesOff);

    		  if(appPrefs.getFivesPreference().equals("off")){
    			  off.setChecked(true);
    		  }else if(appPrefs.getFivesPreference().equals("on")){
    			  on.setChecked(true);
    		  }




    	        fivebuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {


    	        	if(off.isChecked()== true){
    	        		appPrefs.setFivesPreference("off");
    	        	}else if(on.isChecked()==true){
    	        		appPrefs.setFivesPreference("on");
    	        	}



    	        }})
    	        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {
    	            // cancel



    	        }
    	        }).show();



    		  break;

    	  case 4:

    		  View autoLayout = getLayoutInflater().inflate(R.layout.autoset_layout, null);
    		  AlertDialog.Builder autobuilder = new AlertDialog.Builder(this);

    		  autobuilder.setTitle("Auto change to 3x5")
    	        .setView(autoLayout);




    		  //	*************LAYOUT.FINDVIEWBYID**************


    		  autoGroup = (RadioGroup) autoLayout.findViewById(R.id.autoSetGroup);

    		  autoGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(){
    	            public void onCheckedChanged(RadioGroup group, int checkedId)
    	            {
    	                switch(checkedId)
    	                {
    	                    case(R.id.autoSetOn):

    	                    break;
    	                    case(R.id.autoSetOff):

    	                    break;

    	                }
    	            }
    	        });


    		  on = (RadioButton) autoLayout.findViewById(R.id.autoSetOn);
    		  off = (RadioButton) autoLayout.findViewById(R.id.autoSetOff);

    		  if(appPrefs.getAutoSetState().equals("false")){
    			  off.setChecked(true);
    		  }else if(appPrefs.getAutoSetState().equals("true")){
    			  on.setChecked(true);
    		  }




    		  autobuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {


    	        	if(off.isChecked()== true){
    	        		appPrefs.setAutoSetState("false");
    	        	}else if(on.isChecked()==true){
    	        		appPrefs.setAutoSetState("true");
    	        		appPrefs.setForce5x5("false");
    	        		appPrefs.setForce3x5("false");
    	        	}



    	        }})
    	        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {
    	            // cancel



    	        }
    	        }).show();



    		  break;

    	  case 5:

    		  View forceFiveLayout = getLayoutInflater().inflate(R.layout.force_5x5, null);
    		  AlertDialog.Builder forcefivebuilder = new AlertDialog.Builder(this);

    		  forcefivebuilder.setTitle("Force everything to 5x5")
    	        .setView(forceFiveLayout);




    		  //	*************LAYOUT.FINDVIEWBYID**************


    		  forceFiveGroup = (RadioGroup) forceFiveLayout.findViewById(R.id.force5x5Group);

    		  forceFiveGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(){
    	            public void onCheckedChanged(RadioGroup group, int checkedId)
    	            {
    	                switch(checkedId)
    	                {
    	                    case(R.id.force5x5On):

    	                    break;
    	                    case(R.id.force5x5Off):

    	                    break;

    	                }
    	            }
    	        });


    		  on = (RadioButton) forceFiveLayout.findViewById(R.id.force5x5On);
    		  off = (RadioButton) forceFiveLayout.findViewById(R.id.force5x5Off);

    		  if(appPrefs.getForce5x5().equals("false")){
    			  off.setChecked(true);
    		  }else if(appPrefs.getForce5x5().equals("true")){
    			  on.setChecked(true);
    		  }




    		  forcefivebuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {


    	        	if(off.isChecked()== true){
    	        		appPrefs.setForce5x5("false");
    	        	}else if(on.isChecked()==true){
    	        		appPrefs.setForce5x5("true");
    	        		appPrefs.setAutoSetState("false");
    	        		appPrefs.setForce3x5("false");
    	        	}



    	        }})
    	        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {
    	            // cancel



    	        }
    	        }).show();



    		  break;

    	  case 6:

    		  View forceThreeLayout = getLayoutInflater().inflate(R.layout.force_3x5, null);
    		  AlertDialog.Builder forcethreebuilder = new AlertDialog.Builder(this);

    		  forcethreebuilder.setTitle("Force everything to 3x5")
    	        .setView(forceThreeLayout);




    		  //	*************LAYOUT.FINDVIEWBYID**************


    		  forceThreeGroup = (RadioGroup) forceThreeLayout.findViewById(R.id.force3x5Group);

    		  forceThreeGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(){
    	            public void onCheckedChanged(RadioGroup group, int checkedId)
    	            {
    	                switch(checkedId)
    	                {
    	                    case(R.id.force3x5On):

    	                    break;
    	                    case(R.id.force3x5Off):

    	                    break;

    	                }
    	            }
    	        });


    		  on = (RadioButton) forceThreeLayout.findViewById(R.id.force3x5On);
    		  off = (RadioButton) forceThreeLayout.findViewById(R.id.force3x5Off);

    		  if(appPrefs.getForce3x5().equals("false")){
    			  off.setChecked(true);
    		  }else if(appPrefs.getForce3x5().equals("true")){
    			  on.setChecked(true);
    		  }




    		  forcethreebuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {


    	        	if(off.isChecked()== true){
    	        		appPrefs.setForce3x5("false");
    	        	}else if(on.isChecked()==true){
    	        		appPrefs.setForce3x5("true");
    	        		appPrefs.setAutoSetState("false");
    	        		appPrefs.setForce5x5("false");
    	        	}



    	        }})
    	        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dlg, int sumthin) {
    	            // cancel



    	        }
    	        }).show();



    		  break;


    	  }

    	 }


   }
