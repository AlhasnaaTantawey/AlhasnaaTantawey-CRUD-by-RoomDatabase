package azhar.graduated.signupandlogin.ui.login


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import azhar.graduated.signupandlogin.databinding.ActivityLoginBinding
import azhar.graduated.signupandlogin.ui.forgetPass.ForgetPasswordActivity
import azhar.graduated.signupandlogin.ui.signup.SignActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
//          viewModel.delet()
        onLoginClick()

onSignupCall()
        onForgetPassword()
        clickForFacebook()
        clickForGoogle()
      nameeditextOnclick()
        passeditextOnclick()
    }



    private  fun  nameeditextOnclick(){
        binding.fullNameLayout.editText!!.addTextChangedListener {
            if (it!!.length > 0){
                binding.activityMainTextviewErrormessage.visibility = View.INVISIBLE
            }
        }
    }

    private  fun  passeditextOnclick(){
        binding.activityMainEdittextPassword.editText!!.addTextChangedListener{
            if (it!!.length > 0){
                binding.activityMainTextviewErrormessage.visibility = View.INVISIBLE
            }
        }
    }

    private fun clickForFacebook() {
        binding.activityMainButtonCreateFacebookAccount.setOnClickListener {
            var facebookId = "fb://page/327031464582675";
            var urlPage = "http://www.facebook.com/";

            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(facebookId)));
            } catch (e: java.lang.Exception) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(urlPage)));
            }
        }
    }

    private fun clickForGoogle() {
        binding.activityMainButtonCreateGoogleAccount.setOnClickListener {
            var googleId = "geo:37.7749,-122.4194";
            var urlPage = "https://www.google.com/";

            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(googleId)));
            } catch (e: java.lang.Exception) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(urlPage)));
            }
        }
    }

    private fun onSignupCall() {
        binding!!.activityMainTextviewSignupNewOne.setOnClickListener {
            startActivity(Intent(this, SignActivity::class.java))
        }
    }

    private fun onForgetPassword() {
        binding!!.activityMainTextviewForgetPass.setOnClickListener {
            startActivity(Intent(this, ForgetPasswordActivity::class.java))
        }
    }

    private fun setUpViewModel() {

        var name = binding!!.fullNameLayout.editText?.text.toString()
        var pass = binding!!.activityMainEdittextPassword.editText!!.text.toString()
        viewModel.getUserLoginDataStatus(
            name,
            pass
        )
        viewModel.userAndPass.observe(this) {
            if (it != null) {
                viewModel.savevalue(it.id.toInt())
                startActivity(Intent(this, DashBoardActivity::class.java))
             finish()
            } else {
//                binding.activityMainTextviewErrormessage.text =
//                    "يجب ادخال اسم المستخدم وكلمه المرور !"
//                binding.activityMainTextviewErrormessage.visibility = View.VISIBLE
                Toast.makeText(this, "المستخدم لا يوجد فى قاعده البيانات.", Toast.LENGTH_LONG)
                            .show()

            }

        }
    }


    private fun onLoginClick() {
        binding!!.activityMainButtonCreateAnAccount.setOnClickListener {
                setUpViewModel()

        }
    }
}