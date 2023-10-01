package azhar.graduated.signupandlogin.data.DB

import androidx.room.*
@Dao
interface UserDao {
    //for single user insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(userEntity: UserEntity): Long

    //checking user exist or not in our db
    @Query("SELECT * FROM USER_TABLE WHERE name LIKE :userName AND password LIKE :password")
    fun readLoginData(userName: String, password: String):UserEntity

    //getting all data
    @Query("select * from USER_TABLE")
    fun getAllUsers():List<UserEntity>



//    @Update()
//    suspend fun updateNote(userEntity: UserEntity)

    @Query("UPDATE USER_TABLE SET password= :password WHERE id = :id")
    suspend fun update(password: String,id:Int)

    //deleting all user from db
//    @Query("DELETE FROM USER_TABLE")
//    fun deleteAll()


}


