package azhar.graduated.signupandlogin.data.DB

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "USER_TABLE")
data class UserEntity (
    @PrimaryKey (autoGenerate = true)
    val id:Long=0,
    var password: String?="",
    var name:String?="",
    var email:String?=""
         )



