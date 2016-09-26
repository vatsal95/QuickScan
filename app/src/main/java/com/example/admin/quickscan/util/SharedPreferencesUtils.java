package com.example.admin.quickscan.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by chint on 09-02-2016.
 */
public class SharedPreferencesUtils {

    public static final String PREFERENCE_NAME = "RestClientPreferences";
    private static SharedPreferencesUtils mSharedPreferencesUtils;
    private SharedPreferences mSharedPreferences;
    private Context mContext;

    public SharedPreferencesUtils(Context context) {
        this.mContext = context;
    }

    public static SharedPreferencesUtils getInstance(Context context) {
        if (mSharedPreferencesUtils == null) {
            mSharedPreferencesUtils = new SharedPreferencesUtils(context);
        }
        return mSharedPreferencesUtils;
    }

    public SharedPreferences getSharedPreferences() {
        if (mSharedPreferences == null) {
            mSharedPreferences = mContext.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        }
        return mSharedPreferences;
    }

    public void setInt(String key, int value) {
        getSharedPreferences().edit().putInt(key, value).apply();
    }

    public int getInt(String key) {
        return getSharedPreferences().getInt(key, 0);
    }

    public void setString(String key, String value) {
        getSharedPreferences().edit().putString(key, value).apply();
    }

    public String getString(String key) {
        return getSharedPreferences().getString(key, "");
    }

    public void setBoolean(String key, boolean value) {
        getSharedPreferences().edit().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key) {
        return getSharedPreferences().getBoolean(key, false);
    }
}
