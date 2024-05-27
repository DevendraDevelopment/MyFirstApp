package com.example.myfirstapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkerClass(private val appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {

        val input = inputData.getString("KEY_INPUT")

        // Enter work details to perform on background
        Log.d("WorkerClass: input Data ", input.toString())
        Log.d("WorkerClass", "It's Working")

        showNotification(appContext = appContext)
        Thread.sleep(3000)
        // Task result 
        return Result.success()
    }


    private fun showNotification(appContext: Context) {
        val builder = NotificationCompat.Builder(appContext, NotificationActivity.CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("This is the title")
            .setContentText("This is the content text")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)


        with(NotificationManagerCompat.from(appContext)) {
            if (ActivityCompat.checkSelfPermission(
                    appContext,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                // ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                // public fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                //                                        grantResults: IntArray)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.

                return@with
            }
            // notificationId is a unique int for each notification that you must define.
            var notificationId = 1
            notificationId++
            notify(notificationId, builder.build())
        }
    }

}