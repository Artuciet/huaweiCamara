package com.example.hselfiecamera1.auth

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.hselfiecamera1.R
import com.example.hselfiecamera1.main.MainActivity
import com.huawei.hms.support.hwid.HuaweiIdAuthManager
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper

class AuthActivity : AppCompatActivity() {

    //Esto tuve que crearlo con youtube para que kotlin consiga el boton.
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //Youtube con esto tambien.
        btnLogin = findViewById(R.id.btnLogin)

        //A partir de aca se enseña en el curso, tuve que definir arriba la lateninit var junto con el codigo de arriba de findViewById.
        btnLogin.setOnClickListener{
            loginHuaweiIdAuth()
        }
    }
    private fun loginHuaweiIdAuth(){
        val mAuthParams = HuaweiIdAuthParamsHelper(HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM)
            .setEmail()
            .setAccessToken()
            .setProfile()
            .setIdToken()
            .setUid()
            .setId()
            .createParams()
        val mAuthManager = HuaweiIdAuthManager.getService(this, mAuthParams)
        startIntentSenderForResult(mAuthManager.signInIntent, 1000) //este numero representa el numero de identificacion del servicio de login. Este uede ser "1","2","300" o el numero que se desee.
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000){
            if (resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this, "Login Cancelado", Toast.LENGTH_LONG).show()
            }else if (resultCode == Activity.RESULT_OK){
                val authHuaweiIdTask = HuaweiIdAuthManager.parseAuthResultFromIntent(data)
                if (authHuaweiIdTask.isSuccessful){
                    //Toast.makeText(this, "Login Exitoso!", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this, "Login Fallo!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}