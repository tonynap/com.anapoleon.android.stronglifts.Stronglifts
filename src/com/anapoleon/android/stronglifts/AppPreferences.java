package com.anapoleon.android.stronglifts;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class AppPreferences {
     private static final String APP_SHARED_PREFS = "myPrefsFile"; //  Name of the file -.xml
     private SharedPreferences appSharedPrefs;
     private Editor prefsEditor;

     public AppPreferences(Context context)
     {
         this.appSharedPrefs = context.getSharedPreferences(APP_SHARED_PREFS, Activity.MODE_PRIVATE);
         this.prefsEditor = appSharedPrefs.edit();
     }

     public String getSquatIncrement() {
         return appSharedPrefs.getString("squat_increment", "5");
     }

     public void setSquatIncrement(String text) {
         prefsEditor.putString("squat_increment", text);
         prefsEditor.commit();
     }
     
     public String getBenchIncrement() {
         return appSharedPrefs.getString("bench_increment", "5");
     }

     public void setBenchIncrement(String text) {
         prefsEditor.putString("bench_increment", text);
         prefsEditor.commit();
     }
     
     public String getRowIncrement() {
         return appSharedPrefs.getString("row_increment", "5");
     }

     public void setRowIncrement(String text) {
         prefsEditor.putString("row_increment", text);
         prefsEditor.commit();
     }
     
     public String getPressIncrement() {
         return appSharedPrefs.getString("press_increment", "5");
     }

     public void setPressIncrement(String text) {
         prefsEditor.putString("press_increment", text);
         prefsEditor.commit();
     }
     
     public String getDeadIncrement() {
         return appSharedPrefs.getString("dead_increment", "10");
     }

     public void setDeadIncrement(String text) {
         prefsEditor.putString("dead_increment", text);
         prefsEditor.commit();
     }
     
     public String getFivesPreference() {
         return appSharedPrefs.getString("fives_pref", "off");
     }

     public void setFivesPreference(String text) {
         prefsEditor.putString("fives_pref", text);
         prefsEditor.commit();
     }
     
     public String getSquatStall() {
         return appSharedPrefs.getString("squat_stall", "0");
     }

     public void setSquatStall(String text) {
         prefsEditor.putString("squat_stall", text);
         prefsEditor.commit();
     }
     
     public String getBenchStall() {
         return appSharedPrefs.getString("bench_stall", "0");
     }

     public void setBenchStall(String text) {
         prefsEditor.putString("bench_stall", text);
         prefsEditor.commit();
     }
     
     public String getRowStall() {
         return appSharedPrefs.getString("row_stall", "0");
     }

     public void setRowStall(String text) {
         prefsEditor.putString("row_stall", text);
         prefsEditor.commit();
     }
     
     public String getPressStall() {
         return appSharedPrefs.getString("press_stall", "0");
     }

     public void setPressStall(String text) {
         prefsEditor.putString("press_stall", text);
         prefsEditor.commit();
     }
     
     public String getDeadStall() {
         return appSharedPrefs.getString("dead_stall", "0");
     }

     public void setDeadStall(String text) {
         prefsEditor.putString("dead_stall", text);
         prefsEditor.commit();
     }
     
     
     
     public String getSquatDeload() {
         return appSharedPrefs.getString("squat_deload", "0");
     }

     public void setSquatDeload(String text) {
         prefsEditor.putString("squat_deload", text);
         prefsEditor.commit();
     }
     
     public String getBenchDeload() {
         return appSharedPrefs.getString("bench_deload", "0");
     }

     public void setBenchDeload(String text) {
         prefsEditor.putString("bench_deload", text);
         prefsEditor.commit();
     }
     
     public String getRowDeload() {
         return appSharedPrefs.getString("row_deload", "0");
     }

     public void setRowDeload(String text) {
         prefsEditor.putString("row_deload", text);
         prefsEditor.commit();
     }
     
     public String getPressDeload() {
         return appSharedPrefs.getString("press_deload", "0");
     }

     public void setPressDeload(String text) {
         prefsEditor.putString("press_deload", text);
         prefsEditor.commit();
     }
     
     public String getDeadDeload() {
         return appSharedPrefs.getString("dead_deload", "0");
     }

     public void setDeadDeload(String text) {
         prefsEditor.putString("dead_deload", text);
         prefsEditor.commit();
     }
     
     
     
     public String getAutoSetState() {
         return appSharedPrefs.getString("auto_set", "true");
     }

     public void setAutoSetState(String text) {
         prefsEditor.putString("auto_set", text);
         prefsEditor.commit();
     }
     
     public String getForce5x5() {
         return appSharedPrefs.getString("force_5x5", "false");
     }

     public void setForce5x5(String text) {
         prefsEditor.putString("force_5x5", text);
         prefsEditor.commit();
     }
     
     public String getForce3x5() {
         return appSharedPrefs.getString("force_3x5", "false");
     }

     public void setForce3x5(String text) {
         prefsEditor.putString("force_3x5", text);
         prefsEditor.commit();
     }
     
     public String getSquatState(){
    	 return appSharedPrefs.getString("squat_set", "5x5");
     }
     
     public void setSquatState(String text){
    	 prefsEditor.putString("squat_set", text);
    	 prefsEditor.commit();
     }
     
     public String getBenchState(){
    	 return appSharedPrefs.getString("bench_set", "5x5");
     }
     
     public void setBenchState(String text){
    	 prefsEditor.putString("bench_set", text);
    	 prefsEditor.commit();
     }
     
     public String getRowState(){
    	 return appSharedPrefs.getString("row_set", "5x5");
     }
     
     public void setRowState(String text){
    	 prefsEditor.putString("row_set", text);
    	 prefsEditor.commit();
     }
     
     public String getPressState(){
    	 return appSharedPrefs.getString("press_set", "5x5");
     }
     
     public void setPressState(String text){
    	 prefsEditor.putString("press_set", text);
    	 prefsEditor.commit();
     }
     
     public String getDeadState(){
    	 return appSharedPrefs.getString("dead_set", "5x5");
     }
     
     public void setDeadState(String text){
    	 prefsEditor.putString("dead_set", text);
    	 prefsEditor.commit();
     }
     
     
     public String getSquatDeloadPercent() {
         return appSharedPrefs.getString("squat_deload_percent", "10");
     }

     public void setSquatDeloadPercent(String text) {
         prefsEditor.putString("squat_deload_percent", text);
         prefsEditor.commit();
     }
     
     public String getBenchDeloadPercent() {
         return appSharedPrefs.getString("bench_deload_percent", "10");
     }

     public void setBenchDeloadPercent(String text) {
         prefsEditor.putString("bench_deload_percent", text);
         prefsEditor.commit();
     }
     
     public String getRowDeloadPercent() {
         return appSharedPrefs.getString("row_deload_percent", "10");
     }

     public void setRowDeloadPercent(String text) {
         prefsEditor.putString("row_deload_percent", text);
         prefsEditor.commit();
     }
     
     public String getPressDeloadPercent() {
         return appSharedPrefs.getString("press_deload_percent", "10");
     }

     public void setPressDeloadPercent(String text) {
         prefsEditor.putString("press_deload_percent", text);
         prefsEditor.commit();
     }
     
     public String getDeadDeloadPercent() {
         return appSharedPrefs.getString("dead_deload_percent", "10");
     }

     public void setDeadDeloadPercent(String text) {
         prefsEditor.putString("dead_deload_percent", text);
         prefsEditor.commit();
     }
     
     
     
     
     
     
     
}