package azhar.graduated.signupandlogin.di

import azhar.graduated.signupandlogin.UserRepoInterface
import azhar.graduated.signupandlogin.data.DB.UserDao
import azhar.graduated.signupandlogin.data.DB.UserDatabase
import azhar.graduated.signupandlogin.data.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object Module {
    @Provides
    fun provideDao(db: UserDatabase) = db.userDao()

    @Provides
    fun provideuserRepo(dao:UserDao ):UserRepoInterface= UserRepositoryImpl(dao)


}