package azhar.graduated.signupandlogin.ui.signup

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import azhar.graduated.signupandlogin.R
import azhar.graduated.signupandlogin.data.DB.UserEntity
import azhar.graduated.signupandlogin.databinding.ActivityLoginBinding
import azhar.graduated.signupandlogin.databinding.ActivitySignBinding
import azhar.graduated.signupandlogin.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SignActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignBinding
    private  val viewModel: SignUpViewMode by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignBinding.inflate(layoutInflater)
        setContentView(binding.root)

      clickForSignup()
       clickForLogin()
clickForFacebook()
        clickForGoogle()


    }
    private  fun clickForFacebook(){
        binding.activityMainButtonCreateFacebookAccount.setOnClickListener{
            var facebookId = "fb://page/327031464582675";
            var urlPage = "http://www.facebook.com/";

            try {
                startActivity( Intent(Intent.ACTION_VIEW, Uri.parse(facebookId )));
            }catch (  e:java.lang.Exception){
                startActivity( Intent(Intent.ACTION_VIEW, Uri.parse(urlPage )));
            }
        }
    }

    private fun clickForGoogle(){
binding.activityMainButtonCreateGoogleAccount.setOnClickListener{
    var googleId = "fb://page/327031464582675";
    var urlPage = "https://www.google.com/";

    try {
        startActivity( Intent(Intent.ACTION_VIEW, Uri.parse(googleId )));
    }catch (  e:java.lang.Exception){
        startActivity( Intent(Intent.ACTION_VIEW, Uri.parse(urlPage )));
    }
}
    }


    private fun clickForLogin(){
        binding.activityMainTextviewSignupNewOne.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun clickForSignup() {
       lateinit var  users:UserEntity
        binding!!.activityMainButtonCreateAnAccount.setOnClickListener {
            validation()

            users = UserEntity(
                    name = binding!!.activitySignEdittextName.editText!!.text.toString(),
                    password = binding!!.activitySignEdittextPassword.editText!!.text.toString(),
                    email = binding!!.activitySignEdittextEmail.editText!!.text.toString(),
                )
                viewModel.insertUserData(users)
                viewModel.insertUsersDataStatus.observe(this) {

                    viewModel.savevalue(it.toInt())
                    Toast.makeText(this,"تم انشاءالحساب بنجاح",Toast.LENGTH_LONG).show()
                }

            }

        }


        private fun validation() {
            binding.activityMainButtonCreateAnAccount.setOnClickListener{
                 if ((binding!!.activitySignEdittextName.editText!!.text.toString()=="")
                     &&(binding!!.activitySignEdittextPassword.editText!!.text.toString()=="")&&
                     (binding!!.activitySignEdittextEmail.editText!!.text.toString()=="")) {
                     binding.activitySignTextviewErrorinpassword.text=" يجب ادخال اسم المستخدم وكلمه المرور والايميل"
                     binding.activitySignTextviewErrorinpassword.visibility=View.VISIBLE
                 }

              else if ((binding!!.activitySignEdittextName.editText!!.text.toString()=="")
                     &&(binding!!.activitySignEdittextPassword.editText!!.text.toString()!="")&&
                     (binding!!.activitySignEdittextEmail.editText!!.text.toString()!=""))  {

                  binding.activitySignTextviewErrorinuser.visibility=View.VISIBLE

                 }

                 else if ((binding!!.activitySignEdittextName.editText!!.text.toString()!="")
                     &&(binding!!.activitySignEdittextPassword.editText!!.text.toString()=="")&&
                     (binding!!.activitySignEdittextEmail.editText!!.text.toString()!=""))  {

                     binding.activitySignTextviewErrorinpassword.visibility=View.VISIBLE

                 }

                 else if ((binding!!.activitySignEdittextName.editText!!.text.toString()!="")
                     &&(binding!!.activitySignEdittextPassword.editText!!.text.toString()!="")&&
                     (binding!!.activitySignEdittextEmail.editText!!.text.toString()==""))  {

                     binding.activitySignEdittextEmail.visibility=View.VISIBLE

                 }
            }

        }
    }
