package com.example.tamrin;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private SharedPreferences sharedpreferences;
    public UserManager(Context context){
        sharedpreferences=context.getSharedPreferences("user_information",context.MODE_PRIVATE);

    }
    public void saveUserInformation(String off,
                                    String on
                                    ){
        SharedPreferences.Editor editor=sharedpreferences.edit();
        editor.putString("if_on",on);
        editor.putString("if_off",off);

        editor.apply();
    }

    public String geton(){
        return sharedpreferences.getString("if_on","");
    }

    public String getoff(){
        return sharedpreferences.getString("if_off","");
    }

}
