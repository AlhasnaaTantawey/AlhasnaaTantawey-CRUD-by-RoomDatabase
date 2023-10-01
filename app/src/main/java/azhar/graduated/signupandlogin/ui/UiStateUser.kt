package azhar.graduated.signupandlogin.ui

import azhar.graduated.signupandlogin.data.DB.UserEntity

sealed class UiStateUser {

    data class sucessState(val userEntity: UserEntity): UiStateUser()
    data class ErrorState(val message :String): UiStateUser()
    object LoadingState : UiStateUser()

}