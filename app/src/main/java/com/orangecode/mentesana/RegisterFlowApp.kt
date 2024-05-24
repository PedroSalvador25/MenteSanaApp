package com.orangecode.mentesana

import android.app.Application
import com.google.firebase.FirebaseApp

class RegisterFlowApp : Application(){

    override fun onCreate(){
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}