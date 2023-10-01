package azhar.graduated.signupandlogin.ui.signup

import android.app.Application
import androidx.lifecycle.*
import azhar.graduated.signupandlogin.UserRepoInterface
import azhar.graduated.signupandlogin.data.DB.UserEntity
import azhar.graduated.signupandlogin.data.MyPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewMode@Inject constructor(
    private var repoInterface: UserRepoInterface, application: Application,
    val myPreference: MyPreference
):AndroidViewModel(application) {

    private val _insertUsersDataStatus = MutableLiveData<Long>()

    val insertUsersDataStatus: LiveData<Long> = _insertUsersDataStatus

    fun insertUserData(users: UserEntity) {
        viewModelScope.launch {
            val data = repoInterface.addUser(users)
            _insertUsersDataStatus.postValue(data)
        }
    }

        fun savevalue(value:Int){
            myPreference.setStoredTag(value)

        }














}

//    var name=MutableLiveData<String>()
//    var email=MutableLiveData<String>()
//    var password=MutableLiveData<String>()
//    var userName=""
//    var userEmail=""
//    var userPass=""
//
//    init {
//        adduser()
//    }
//
//
//    fun adduser(){
//        userName= name.value.toString()
//        userEmail=email.value.toString()
//        userPass=password.value.toString()
//
//        viewModelScope.launch(Dispatchers.IO){
//      repository.addUser(UserEntity(userName,userEmail,userPass))}
//    }
