package azhar.graduated.signupandlogin.data

import azhar.graduated.signupandlogin.UserRepoInterface
import azhar.graduated.signupandlogin.data.DB.UserDao
import azhar.graduated.signupandlogin.data.DB.UserEntity
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dao: UserDao
): UserRepoInterface  {

    override suspend fun addUser(entity: UserEntity):Long {
      return  dao.insertUser(entity)
    }

    override suspend fun verifyLoginUser(userName: String, password: String): UserEntity {
        return  dao.readLoginData(userName,password)
    }

    override suspend fun getAllUsers(): List<UserEntity> {
        return  dao.getAllUsers()
    }

    override suspend fun update(password: String, id: Int) {
        return dao.update(password,id)
    }

//    override suspend fun deleteAll() {
//        dao.deleteAll()
//    }

//    override suspend fun update(entity: UserEntity) {
//        return dao.updateNote(entity)
//    }


}