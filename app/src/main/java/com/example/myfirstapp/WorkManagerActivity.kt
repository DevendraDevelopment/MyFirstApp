package com.example.myfirstapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.myfirstapp.NotificationActivity.Companion.CHANNEL_ID
import java.util.concurrent.TimeUnit

class WorkManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)


        //Input the data
        val inputData = Data.Builder()
            .putString("KEY_INPUT", "Hello, WorkManager!")
            .build()

        // Created a Work Request
//        val uploadWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<WorkerClass>()
//            .setInputData(inputData)
//            .build()

        // Submit the WorkRequest to the system
//        WorkManager.getInstance(this).enqueue(uploadWorkRequest)

//        WorkManager.getInstance(this).getWorkInfoByIdLiveData(uploadWorkRequest.id)
//            .observe(this, Observer { workInfo ->
//                if (workInfo != null && workInfo.state.isFinished) {
                     //Work is finished
//                    Log.d("WorkerClass", "Work has been done")
//                }
//            })




        //TODO for Periodic
        val periodicWorkRequest = PeriodicWorkRequest.Builder(WorkerClass::class.java, 15, TimeUnit.MINUTES)
            .setInputData(inputData)
            .build()

        WorkManager.getInstance(this).enqueue(periodicWorkRequest)

    }

}