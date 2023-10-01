package azhar.graduated.signupandlogin.ui.newPass

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import azhar.graduated.signupandlogin.UserRepoInterface
import azhar.graduated.signupandlogin.data.MyPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewPasswordViewModel @Inject constructor (private var repoInterface: UserRepoInterface,
     application: Application, val myPreference: MyPreference
):AndroidViewModel(application){




fun updatePassword(password: String, id: Int) {
        viewModelScope.launch {
            repoInterface.update(password,id)
        }
    }

    fun recieveDataFromSharedPrefernce():Int{
        return myPreference.getStoredTag()
    }





}