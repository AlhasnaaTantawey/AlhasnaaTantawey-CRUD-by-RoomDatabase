package azhar.graduated.signupandlogin.ui.login

import android.app.Application
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.*
import azhar.graduated.signupandlogin.UserRepoInterface
import azhar.graduated.signupandlogin.data.DB.UserEntity
import azhar.graduated.signupandlogin.data.MyPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class LoginViewModel @Inject constructor (
    private var repoInterface: UserRepoInterface, application: Application,
    val myPreference: MyPreference
): AndroidViewModel(application) {

    private val _GetUserLoginDataStatus = MutableLiveData<UserEntity>()

   val userAndPass: LiveData<UserEntity> = _GetUserLoginDataStatus
//
//     val getAllUsers = MutableLiveData<List<UserEntity>>()



init {
  //  getAllUserLogin()

}
    fun getUserLoginDataStatus(usename:String,password:String) {
        viewModelScope.launch (Dispatchers.IO){
                val data = repoInterface.verifyLoginUser(usename,password)
            Timber.d("$data")
                _GetUserLoginDataStatus.postValue(data)

        }

    }

    fun savevalue(value:Int){
        myPreference.setStoredTag(value)

    }

//    fun delet(){
//        viewModelScope.launch(Dispatchers.IO) {
//            repoInterface.deleteAll()
//        }
    }

//    fun getAllUserLogin() {
//        viewModelScope.launch (Dispatchers.IO){
//            getAllUsers.postValue(repoInterface.getAllUsers())
//
//        }
//    }







