package id.co.venport.vendorportalandroidapplication.AppConfig;

/**
 * Created by user on 14/05/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import id.co.venport.vendorportalandroidapplication.SplashLoginRegister.TampilanAwalActivity;

/**
 * Created by user on 10/02/2018.
 */

public class PreferenceLogin {
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "PreferenceIntro";

    // All Shared Preferences Keys
    public static final String IS_PROCEED = "IsProceed";
    public static final String KEY_EMAIL = "Email";

    public PreferenceLogin(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createIntro(String email){
        // Storing login value as TRUE
        editor.putString(KEY_EMAIL, email);
        editor.putBoolean(IS_PROCEED, true);
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkProceed(){
        // Check login status
        if(!this.isProceedIn()){
            Intent i = new Intent(_context, TampilanAwalActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }

    }



    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserIntro(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
//        user.put(KEY_USERNAME, pref.getString(KEY_USERNAME, null));
//
//        // user email id
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
//        user.put(KEY_ID, String.valueOf(pref.getInt(KEY_ID,0)));
        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUserIntro(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, TampilanAwalActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isProceedIn(){
        return pref.getBoolean(IS_PROCEED, false);
    }
}

