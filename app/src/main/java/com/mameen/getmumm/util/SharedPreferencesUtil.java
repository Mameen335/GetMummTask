package com.mameen.getmumm.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.mameen.getmumm.data.models.User;

public class SharedPreferencesUtil {

    private static final String SHARED_PREFERANCE_NAME = "prefrence_name";
    //    private static final String USER_id_PREFERANCE = "user_pref";
    private static final String USER_token_PREFERANCE = "user_pref";
    private static final String USER_LOGIN_KEY = "login_pref";

    private static final String SEARCH_TAGS = "tags";

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREFERANCE_NAME, Context.MODE_PRIVATE);
    }

    public static void setUser(Context context, User user) {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(user);
        getSharedPreferences(context).edit().putString(USER_token_PREFERANCE, jsonInString).commit();
    }

    public static void UpdateUser(Context context, User user) {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(user);
//        getSharedPreferences(context).edit().putString(USER_id_PREFERANCE, jsonInString).apply();
        getSharedPreferences(context).edit().putString(USER_token_PREFERANCE, jsonInString).commit();
    }

    public static void deleteUser(Context context) {
        getSharedPreferences(context).edit().clear().commit();
    }


    public static User getUser(Context context) {
        Gson gson = new Gson();
        String jsonInString = getSharedPreferences(context).getString(USER_token_PREFERANCE, "");
        return gson.fromJson(jsonInString, User.class);
    }

    public static void setUserLogin(Context context, boolean token) {
        getSharedPreferences(context).edit().putBoolean(USER_LOGIN_KEY, token).apply();
    }

    public static boolean getUserlogin(Context context) {
        return getSharedPreferences(context).getBoolean(USER_LOGIN_KEY, false);
    }

}
