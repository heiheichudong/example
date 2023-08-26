package com.gess.appkotlin

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.gess.appkotlin.utils.CrashHandler

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        CrashHandler.getInstance(this)
    }

    /**
     *
     */
    fun initMonitorApp() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityDestroyed(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

            }

            override fun onActivityResumed(activity: Activity) {

            }
        })
    }
}