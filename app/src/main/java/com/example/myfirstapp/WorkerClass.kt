package com.example.myfirstapp

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class WorkerClass(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {

        val input = inputData.getString("KEY_INPUT")

        // Enter work details to perform on background
        Log.d("WorkerClass: input Data ", input.toString())
        Log.d("WorkerClass", "It's Working")

        showNotification()
        Thread.sleep(3000)
        // Task result 
        return Result.success()
    }

    private fun showNotification() {

    }
}