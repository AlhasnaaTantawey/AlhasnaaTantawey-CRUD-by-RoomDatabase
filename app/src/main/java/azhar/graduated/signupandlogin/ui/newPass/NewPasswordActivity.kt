package azhar.graduated.signupandlogin.ui.newPass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import azhar.graduated.signupandlogin.databinding.ActivityNewPasswordBinding
import azhar.graduated.signupandlogin.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewPasswordBinding
    private val viewModel: NewPasswordViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)





binding.activityNewPassEdittextNewpassword.editText!!.addTextChangedListener {
    viewModel.updatePassword(it.toString(),viewModel.recieveDataFromSharedPrefernce())
}






        binding.activityMainButtonCreateAnAccount.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}