package com.example.loadingcomponenttesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            showLoading(true)
        }, 2000)


        Handler().postDelayed({
            showLoading(false)
            setLoadingLayout(R.layout.custom_layout)
        }, 5000)



        Handler().postDelayed({
            showLoading(true)
        }, 8000)

        Handler().postDelayed({
            showLoading(false)
        }, 10000)


    }
}
