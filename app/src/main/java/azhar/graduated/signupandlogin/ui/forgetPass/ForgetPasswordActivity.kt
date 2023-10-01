package azhar.graduated.signupandlogin.ui.forgetPass


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import azhar.graduated.signupandlogin.databinding.ActivityForgetPasswordBinding
import azhar.graduated.signupandlogin.ui.verification.VerificationActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class ForgetPasswordActivity : AppCompatActivity() {


    private lateinit var binding: ActivityForgetPasswordBinding
    private val viewModel: ForgetPasswordViewMosdel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.activityMainButtonCreateAnAccount.setOnClickListener{
            if (binding.activityForgetPassEdittextEmail.editText!!.text.isNullOrEmpty())
            {
                binding.textviewErrorinemail.visibility=View.VISIBLE}
            else{
                var intent=Intent(this,VerificationActivity::class.java)
                startActivity(intent)
            }

        }
    }






    }







