package azhar.graduated.signupandlogin.data.DB

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities =arrayOf(UserEntity::class), version = 1, exportSchema = false)
abstract class UserDatabase :RoomDatabase() {
    abstract fun userDao():UserDao
}