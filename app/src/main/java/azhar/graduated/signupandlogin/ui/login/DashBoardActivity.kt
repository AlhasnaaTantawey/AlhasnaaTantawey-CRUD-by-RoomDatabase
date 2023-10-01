package azhar.graduated.signupandlogin.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import azhar.graduated.signupandlogin.databinding.ActivityDashBoardBinding

class DashBoardActivity : AppCompatActivity() {
    lateinit var binding:ActivityDashBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onBackPressed() {

            super.onBackPressed()
       startActivity(Intent(this,LoginActivity::class.java))
        }
    }
