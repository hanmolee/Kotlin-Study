package com.memoria.com.memoria.layout

import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.memoria.com.memoria.Activity.GetStartedActivity
import com.memoria.com.memoria.R
import org.jetbrains.anko.*

/**
 * Created by mac on 2017. 11. 23..
 */
class Layout_GetStarted : AnkoComponent<GetStartedActivity>{

    private lateinit var ankoContext : AnkoContext<GetStartedActivity>

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun createView(ui: AnkoContext<GetStartedActivity>) = with(ui) {

        ankoContext = ui

        verticalLayout {

            this.gravity = Gravity.CENTER
            backgroundColor = Color.parseColor("#9C0911")


            scrollView {

                verticalLayout {
                    id = R.id.formLogin
                    gravity = Gravity.CENTER
                    padding = dip(20)


                    verticalLayout {
                        background = ContextCompat.getDrawable(
                                ctx, R.drawable.login_form)
                        padding = 10

                        val username = editText {
                            id = R.id.usernameEditText
                            hintResource = R.string.sign_in_username
                            background = ContextCompat.getDrawable(ctx, android.R.color.transparent)

                        }.lparams(width = matchParent, height = wrapContent)
                    }

                    verticalLayout {
                        background = ContextCompat.getDrawable(
                                ctx, R.drawable.login_form)
                        padding = 10

                        val password = editText {
                            id = R.id.passwordEditText
                            hintResource = R.string.signIn_password
                            background = ContextCompat.getDrawable(ctx, android.R.color.transparent)
                            inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD

                        }.lparams(width = matchParent, height = wrapContent)
                    }.lparams { topMargin = 20 }

                    button {
                        id = R.id.signIn_button
                        textResource = R.string.signIn_button
                        background = ContextCompat.getDrawable(ctx, R.drawable.login_btn_form)

                        onClick {
                            handleOnSignInButtonPressed(username =  .text.toString(), password = password.text.toString())
                        }
                    }.lparams{
                        width = matchParent
                        height = wrapContent
                        topMargin = 20
                    }



                    }.apply {
                        lparams(width = dip(300), height = matchParent) {
                            this.gravity = Gravity.CENTER
                            // background를 쓰려면 API >= 16



                            clipToPadding = false
                            bottomMargin = dip(16)
                    }
                }

            }.lparams(width = matchParent, height = matchParent)

        }


    }

    private fun handleOnSignInButtonPressed(username: String, password: String) {
        with(ankoContext) {
            if (username.isBlank() or password.isBlank()) {
                alert(title = R.string.sigIn_alert_invalid_user_title,
                        message = R.string.sigIn_alert_invalid_user_message) {

                    positiveButton(R.string.dialog_button_close) {}
                }.show()
            } else {
                owner.authorizeUser(username, password)
            }
        }
    }

    /*fun showAccessDeniedAlertDialog() {
        with(ankoContext) {
            alert(title = R.string.sigIn_alert_access_denied_title,
                    message = R.string.sigIn_alert_access_denied_msg) {

                positiveButton(R.string.dialog_button_close) {}
            }.show()
        }
    }*/


}

