package azhar.graduated.signupandlogin.ui.forgetPass

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import azhar.graduated.signupandlogin.UserRepoInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ForgetPasswordViewMosdel @Inject constructor (private var repoInterface: UserRepoInterface):ViewModel() {

//    fun name(data: String) {
//        viewModelScope.launch (Dispatchers.IO){
//            EmailSender.sendEmail(data, "Subject", "Hello, this is a test email!");
//        }}
}