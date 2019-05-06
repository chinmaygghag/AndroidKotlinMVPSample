package frost.com.sampleapplication.login

import android.util.Log

class LoginPresenter : LoginInterface.Listner {

    var interactorImpl : LoginInteractorImpl
    var view : LoginInterface.View

    /**
     * Initialize the interactor implementor and view callback.
     * */
    constructor(loginView: LoginInterface.View) {
        interactorImpl = LoginInteractorImpl(this)
        view = loginView
    }

    /**
     * Send message to the view on login success
     * @param: Success Message
     * */
    override fun loginSuccess(message: String) {
        view.loginSuccess(message)
    }

    /**
     * Send message to the view on login success
     * @param: Failure Message
     * */
    override fun loginFailure(message: String) {
        view.loginFailure(message)
    }


    /**
     * Sends user login data to the interactor Implemtaor
     * @param LoginModel : Username and Password for the user.
     * */
    override fun submitLoginData(loginModel: LoginModel) {
        interactorImpl.callLoginApi(loginModel)
    }



}