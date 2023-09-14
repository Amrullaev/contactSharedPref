package com.example.sharedprefnew.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

object SharedPref {

    @SuppressLint("ApplySharedPref")
    fun addData(context: Context, token: String) {
        /** yozish  uchun */
        val sharedrefrence = context.getSharedPreferences("Token", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedrefrence.edit()
        editor.putString("token", token).commit()
    }


    fun getData(context: Context): String? {
        val sharedrefrence = context.getSharedPreferences("Token", Context.MODE_PRIVATE)
        /** uqish uchun */
        return sharedrefrence.getString("token", "")
    }

    @SuppressLint("ApplySharedPref")
    fun addDataCunt(context: Context, count: Int) {
        /** yozish  uchun */
        val sharedrefrence = context.getSharedPreferences("Token", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedrefrence.edit()
        editor.putInt("count", count).commit()
    }


    fun getDataCount(context: Context): Int {
        val sharedrefrence = context.getSharedPreferences("Token", Context.MODE_PRIVATE)
        /** uqish uchun */
        return sharedrefrence.getInt("count", 0)

    }

    /** change theme app */
    @SuppressLint("ApplySharedPref")
    fun changeThemeApp(context: Context, theme: String) {
        val sharedPreferences = context.getSharedPreferences("Theme", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("theme", theme).commit()
    }

    /** get change theme app*/
    fun getThemeApp(context: Context): String {
        val sharedPreferences = context.getSharedPreferences("Theme", Context.MODE_PRIVATE)
        return sharedPreferences.getString("theme", "white").toString()
    }
    /**change lang*/
    @SuppressLint("ApplySharedPref")
    fun changLanguage(lang: String, context: Context) {
        val sharedPreferences = context.getSharedPreferences("Lang", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("lang", lang).commit()
    }

    fun getLanguage(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences("Lang", Context.MODE_PRIVATE)
        return sharedPreferences.getString("lang", "ru")
    }

    /**setIsOnline*/
    @SuppressLint("ApplySharedPref")
    fun setIsOnLine(isOnline: Boolean, context: Context) {
        val sharedPreferences = context.getSharedPreferences("IsOnline", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean("isOnline", isOnline).commit()
    }
    /**sectionType*/
    @SuppressLint("ApplySharedPref")
    fun sectionType(type: String, context: Context) {
        val sharedPreferences = context.getSharedPreferences("Type", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("type", type).commit()
    }

    /**getSectionType*/
    fun getSectionType(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences("Type", Context.MODE_PRIVATE)
        return sharedPreferences.getString("type", "")
    }


    /**set driver id*/
    @SuppressLint("ApplySharedPref")
    fun setDriverId(id: String, context: Context) {
        val sharedPreferences = context.getSharedPreferences("DriverID", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("id", id).commit()
    }

    /**get driver id*/
    fun getDriverID(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences("DriverID", Context.MODE_PRIVATE)
        return sharedPreferences.getString("id", "45")
    }

    /**********************INTER AREA**************************************************************/

    /**addInterArea order id*/
    @SuppressLint("ApplySharedPref")
    fun addInterAreaOrderId(context: Context, id: String) {
        val sharedPreferences =
            context.getSharedPreferences("InterAreaOrderId", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("id", id).commit()
    }

    /**get driver id*/
    fun getInterAreaOrderId(context: Context): String? {
        val sharedPreferences =
            context.getSharedPreferences("InterAreaOrderId", Context.MODE_PRIVATE)
        return sharedPreferences.getString("id", "")
    }

    /**order id City***************************************/
    @SuppressLint("ApplySharedPref")
    fun addCityOrderId(context: Context, id: String) {
        val sharedPreferences =
            context.getSharedPreferences("CityOrderId", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("id", id).commit()
    }

    /**get driver id*/
    fun getCityOrderId(context: Context): String? {
        val sharedPreferences =
            context.getSharedPreferences("CityOrderId", Context.MODE_PRIVATE)
        return sharedPreferences.getString("id", "")
    }

    /**order id City***************************************/
    @SuppressLint("ApplySharedPref")
    fun addOnline(context: Context, online: String) {
        val sharedPreferences =
            context.getSharedPreferences("Online", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("online", online).commit()
    }

    /**get driver online*/
    fun getOnline(context: Context): String? {
        val sharedPreferences =
            context.getSharedPreferences("Online", Context.MODE_PRIVATE)
        return sharedPreferences.getString("online", "")
    }


    /**add balance cashing*/
    @SuppressLint("ApplySharedPref")
    fun addBalance(context: Context, balance: String) {
        val sharedPreferences =
            context.getSharedPreferences("Balance", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("balance", balance).commit()
    }

    /**get balance*/
    fun getBalance(context: Context): String? {
        val sharedPreferences =
            context.getSharedPreferences("Balance", Context.MODE_PRIVATE)
        return sharedPreferences.getString("balance", "")
    }

}