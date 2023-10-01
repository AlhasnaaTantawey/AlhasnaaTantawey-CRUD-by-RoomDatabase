package azhar.graduated.signupandlogin.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import azhar.graduated.signupandlogin.data.DB.UserDatabase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context) = Room.databaseBuilder(app,
       UserDatabase::class.java,
        "myDatabase").build()
}


