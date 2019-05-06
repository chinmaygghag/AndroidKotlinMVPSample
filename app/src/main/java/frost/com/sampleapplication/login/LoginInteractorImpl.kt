package frost.com.sampleapplication.login

import android.util.Log

class LoginInteractorImpl : LoginInterface.interactor{

    var presenter : LoginInterface.Listner

    /**
     * Initialized the presenter callback.
     */
    constructor(listner : LoginInterface.Listner){
        this.presenter = listner
    }


    /**
     * Call login API or get login results from Database, currently I have just hardcoded the username
     * and password
     * @param : User input Username and Password
     * */
    override fun callLoginApi(loginModel: LoginModel) {
        if(loginModel.userName.equals("admin") && loginModel.password.equals("admin")){
            presenter.loginSuccess("Login Successful")
        }else if(loginModel.userName.equals("admin") && !loginModel.password.equals("admin")){
            presenter.loginFailure("Incorrect Password")
        }else if(!loginModel.userName.equals("admin") && loginModel.password.equals("admin")){
            presenter.loginFailure("Incorrect Username")
        }else{
            Log.v("LoginModel ","Username : "+loginModel.userName)
            presenter.loginFailure("Incorrect Username & Password combination")
        }
    }


}