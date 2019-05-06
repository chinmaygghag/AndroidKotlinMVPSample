package frost.com.sampleapplication.login

interface LoginInterface {
    interface View{
        fun loginSuccess(message: String)
        fun loginFailure(message: String)
    }

    interface Listner{
        fun submitLoginData(loginModel:LoginModel)
        fun loginSuccess(message:String)
        fun loginFailure(message:String)
    }

    interface interactor{
        fun callLoginApi(loginModel: LoginModel)
    }
}