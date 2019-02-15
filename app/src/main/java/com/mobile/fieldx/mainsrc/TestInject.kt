package com.mobile.fieldx.mainsrc

import android.content.Context
import android.widget.Toast
import javax.inject.Inject

class TestInject @Inject constructor(var context: Context) {
    fun CallWithoutProvider() {
        Toast.makeText(context, "RAJAN GUPTA", Toast.LENGTH_LONG).show()
    }
}