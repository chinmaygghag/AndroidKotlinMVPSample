package frost.com.sampleapplication.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import frost.com.sampleapplication.R

class LoginActivity : AppCompatActivity(), View.OnClickListener, LoginInterface.View {


    lateinit var edtUsername : EditText
    lateinit var edtPassword : EditText
    lateinit var btnLogin : Button
    lateinit var presenter: LoginPresenter
    lateinit var loginModel: LoginModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this)
        loginModel = LoginModel()
        viewinit()
        setClickListener()
    }

    private fun viewinit(){
        edtUsername = findViewById(R.id.edt_username)
        edtPassword = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btn_login)
    }


    private fun setClickListener(){
        btnLogin.setOnClickListener(this)
    }

    private fun validateLoginData(): Boolean {
        if(edtUsername.text.toString().equals("") || edtPassword.text.toString().equals("")){
            return false
        }else{
            return true
        }
    }

    override fun onClick(v: View) {
        val itemId = v.id
        when(itemId){
            R.id.btn_login -> {
                if(validateLoginData()){
                    loginModel.userName = edtUsername.text.toString()
                    loginModel.password = edtPassword.text.toString()
                    presenter.submitLoginData(loginModel)
                }else{
                    Toast.makeText(this,"Please enter Username and password both",Toast.LENGTH_SHORT).show()
                }

            }

        }
    }

    override fun loginSuccess(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun loginFailure(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}