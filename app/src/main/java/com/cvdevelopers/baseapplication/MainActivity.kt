package com.cvdevelopers.baseapplication

import android.os.Bundle
import com.cvdevelopers.baseapplication.baseclasses.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
