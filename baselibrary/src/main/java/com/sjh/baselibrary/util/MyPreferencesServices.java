package com.sjh.baselibrary.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.HashMap;

/**
 * date: 2019/10/16
 * author:SJH
 * description: Lightweight saving tool for android
 */
public class MyPreferencesServices {
    private static SharedPreferences preferences;

    public MyPreferencesServices() {
    }
    public MyPreferencesServices(Context context) {
        if (null == preferences) {
            preferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    public void save(String key, String value) {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(key, value);
        edit.commit();
    }

    public String getValue(String key, String defaltValue) {
        String object = preferences.getString(key, defaltValue);
        return object;
    }

    public void save(String key, Boolean value) {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    public boolean getValue(String key) {
        boolean object = preferences.getBoolean(key, false);
        return object;
    }

    public boolean putHashMap(String key, HashMap<Object, Object> hashMap) {
        SharedPreferences.Editor editor = preferences.edit();
        try {
            String listStr = SceneList2String(hashMap);
            editor.putString(key, listStr);
        } catch (IOException e) {
            return false;
        }
        return editor.commit();
    }

    public HashMap<Object, Object> getHashMap(String key) {
        String listStr = preferences.getString(key, "");
        try {
            return String2SceneList(listStr);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean saveObj(String key, Object object) {
        String strObject = serialize(object);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(key, strObject);
        return edit.commit();
    }

    public Object getObj(String key) {
        String seria = preferences.getString(key, null);
        Object object;
        try {
            String redStr = java.net.URLDecoder.decode(seria, "UTF-8");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(redStr.getBytes("ISO-8859-1"));
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            object = objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
        } catch (Exception e) {
            return null;
        }
        return object;
    }

    private String SceneList2String(HashMap<Object, Object> hashmap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(hashmap);
        String SceneListString = new String(Base64.encode(byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
        objectOutputStream.close();
        return SceneListString;
    }

    private HashMap<Object, Object> String2SceneList(String SceneListString) throws StreamCorruptedException, IOException, ClassNotFoundException {
        byte[] mobileBytes = Base64.decode(SceneListString.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mobileBytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        HashMap<Object, Object> SceneList = (HashMap<Object, Object>) objectInputStream.readObject();
        objectInputStream.close();
        return SceneList;
    }

    private String serialize(Object object) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        String serStr;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            serStr = byteArrayOutputStream.toString("ISO-8859-1");
            serStr = java.net.URLEncoder.encode(serStr, "UTF-8");
            objectOutputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            return null;
        }
        return serStr;
    }
}
