package azhar.graduated.signupandlogin.ui.verification

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import azhar.graduated.signupandlogin.databinding.ActivityVerificationBinding
import azhar.graduated.signupandlogin.ui.forgetPass.ForgetPasswordActivity
import azhar.graduated.signupandlogin.ui.newPass.NewPasswordActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class VerificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerificationBinding
    private lateinit var viewModel: VerificationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel= ViewModelProvider(this)[VerificationViewModel::class.java]
        Toast.makeText(this,"code vervication is : 2468",Toast.LENGTH_LONG).show()
       var email= intent.getStringExtra("email")

        binding.activityMainButtonCreateAnAccount.setOnClickListener{
            if((binding.activityVerifictionEdittext1.text.toString()!="")&&(binding.activityVerifictionEdittext2.text.toString()!="")
                &&(binding.activityVerifictionEdittext3.text.toString()!="")&&(binding.activityVerifictionEdittext4.text.toString()!="")){
                var intent=    Intent(this,NewPasswordActivity::class.java)
                startActivity(intent)
            }

        }


    }

    }