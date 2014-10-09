package com.anapoleon.android.stronglifts;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Stronglifts extends Activity {
	
	private Button workList;
	private Button settings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stronglifts);
        
        workList = (Button) findViewById(R.id.slButton);
        
        settings = (Button) findViewById(R.id.bSettings);
        
        workList.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
            	Intent i = new Intent(aMethod(), WorkoutList.class);
            	startActivity(i);
            }

        });
        
        settings.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
            	Intent i = new Intent(aMethod(), OptionsList.class);
            	startActivity(i);
            }

        });
        
        
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_stronglifts, menu);
        return true;
    }
    
    
    public void onClickButton(View v) {
    	Intent i = new Intent(this, WorkoutList.class);
    	startActivity(i);
    	
    }
    
    public Context aMethod(){
    	Context actContext = this;
		return actContext;
    }

    
}
