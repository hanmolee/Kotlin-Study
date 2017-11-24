package com.memoria.com.memoria.Activity

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.memoria.com.memoria.R
import com.memoria.com.memoria.layout.Layout_GetStarted
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

/**
 * Created by mac on 2017. 11. 23..
 */

class GetStartedActivity : AppCompatActivity() {

    private lateinit var view: Layout_GetStarted

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = Layout_GetStarted()
        view.setContentView(this)
    }

    fun authorizeUser(username: String, password: String) {
        val name = "hanmo"
        val pwd = "0000"

        if (username.equals(name) ||password.equals(pwd)){
            toast("LOGIN!!")


        }
    }
}
