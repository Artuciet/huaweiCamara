package com.example.hselfiecamera1.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.hselfiecamera1.R
import com.example.hselfiecamera1.auth.AuthActivity
import com.huawei.hms.support.hwid.HuaweiIdAuthManager
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper

class MainActivity : AppCompatActivity() {

    //Igualmente, sin el metodo de youtube no avanzaba en la leccion. Tendre que memorizar usar el "lateinit var nombre del boton:boton"
    lateinit var btnLogout:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Tambien tendre que memorizar poner el "nombre del boton = findViewById(R.id.nombre del boton)"
        btnLogout = findViewById(R.id.btnLogout)

        btnLogout.setOnClickListener {
            //logout Huawei ID

        }
    }

    override fun onBackPressed() {
        logoutHuaweiId()
    }

    private fun logoutHuaweiId(){
        val mAuthParams = HuaweiIdAuthParamsHelper(HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM)
            .createParams()
        val mAuthManager = HuaweiIdAuthManager.getService(this, mAuthParams)
        val logoutTask = mAuthManager.signOut()
        logoutTask.addOnSuccessListener {
            startActivity(Intent(this@MainActivity, AuthActivity::class.java))
            finish()
        }
        logoutTask.addOnFailureListener {
            Toast.makeText(this, "Logout Fallo!!", Toast.LENGTH_LONG).show()
        }
    }
}