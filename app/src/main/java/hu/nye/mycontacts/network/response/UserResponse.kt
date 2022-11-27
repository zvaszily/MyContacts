package hu.nye.mycontacts.network.response

data class UserResponse (
    var name: UserNameResponse,
    var email: String,
    var location: UserLocationResponse,
    var picture: UserPictureResponse

        )