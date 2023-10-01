package azhar.graduated.signupandlogin

import azhar.graduated.signupandlogin.data.DB.UserEntity

interface UserRepoInterface {
    suspend fun  addUser(entity: UserEntity):Long

   suspend fun verifyLoginUser(userName:String,password:String): UserEntity

   suspend fun  getAllUsers():List<UserEntity>
 //  suspend fun  update(entity: UserEntity)

   suspend fun  update(password: String,id:Int)

   // suspend fun deleteAll()

}