package com.example.myapplication.services

import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.IBinder
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat

 class MyFirebaseMessagingServices : Service(){
     override fun onBind(p0: Intent?): IBinder? {
         TODO("Not yet implemented")
     }
 }