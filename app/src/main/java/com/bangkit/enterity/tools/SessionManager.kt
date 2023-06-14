package com.bangkit.enterity.tools

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

/**
 * Created by DhytoDev on 4/29/17.
 */

class SessionManager(internal var _context: Context) {
    // Shared Preferences
    internal var pref: SharedPreferences

    // Editor for Shared preferences
    internal var editor: SharedPreferences.Editor

    // Shared pref mode
    internal var PRIVATE_MODE = 0

    val firebase_id: String?
        get() = pref.getString(KEY_FIREBASE_ID, null)

    val username: String?
        get() = pref.getString(KEY_USERNAME, null)

    val isLoggedIn: Boolean
        get() = pref.getBoolean(IS_LOGIN, false)

    val level: String?
        get() = pref.getString(KEY_LEVEL, null)

    val desa: String?
        get() = pref.getString(KEY_DESA, null)

    val token: String?
        get() = pref.getString(KEY_TOKEN, null)

    val phone: String?
        get() = pref.getString(KEY_PHONE, null)

    val name: String?
        get() = pref.getString(KEY_NAME, null)

    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    /**
     * Create login session
     */
//    fun createLoginSession(nim: String, nama: String) {
    fun createLoginSession() {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true)

        // commit changes
        editor.commit()
    }

    fun setFirebaseId(id: String) {
        editor.putString(KEY_FIREBASE_ID, id)
        editor.commit()
    }

    fun setUsername(username: String) {
        editor.putString(KEY_USERNAME, username)
        editor.commit()
    }

    fun setLevel(level: String) {
        editor.putString(KEY_LEVEL, level)
        editor.commit()
    }

    fun setDesa(desa: String) {
        editor.putString(KEY_DESA, desa)
        editor.commit()
    }

    fun setToken(token: String) {
        editor.putString(KEY_TOKEN, token)
        editor.commit()
    }

    fun setPhone(phone: String) {
        editor.putString(KEY_PHONE, phone)
        editor.commit()
    }

    fun setName(name: String) {
        editor.putString(KEY_NAME, name)
        editor.commit()
    }

    fun setDialogOption(idSurat : String, status : Int){
        editor.putInt(idSurat,status)
        editor.commit()
    }

//    fun checkLogin() {
//        // Check login status
//        if (!this.isLoggedIn) {
//            // user is not logged in redirect him to Login ActivityLog
//            val i = Intent(_context, ActLogin::class.java)
//            // Closing all the Activities
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//
//            // Add new Flag to start new ActivityLog
//            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//
//            // Staring Login ActivityLog
//            _context.startActivity(i)
//        }
//    }

    /**
     * Clear session details
     */
    fun logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear()
        editor.commit()

        // After logout redirect user to Loing ActivityLog
//        val i = Intent(_context, ActLogin::class.java)
        // Closing all the Activities
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        // Add new Flag to start new ActivityLog
//        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        // Staring Login ActivityLog
//        _context.startActivity(i)
    }

    companion object {

        // Sharedpref file name
        private val PREF_NAME = "Kioser_Pref"

        // All Shared Preferences Keys
        private val IS_LOGIN = "IsLoggedIn"

        // Email address (make variable public to access from outside)
        val KEY_FIREBASE_ID     = "firebase_id"
        val KEY_USERNAME        = "username"
        val KEY_LEVEL           = "level"
        val KEY_TOKEN           = "token"
        val KEY_DESA            = "desa"
        val KEY_PHONE           = "phone"
        val KEY_NAME            = "name"

        private var instance: SessionManager? = null

        fun with(context: Context): SessionManager {

            if (instance == null) {
                instance = SessionManager(context)
            }
            return instance as SessionManager
        }
    }

}