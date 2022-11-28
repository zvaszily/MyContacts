package hu.nye.mycontacts.data

import hu.nye.mycontacts.R
import hu.nye.mycontacts.entity.User

class DataSource {

    fun loadUser(): List<User> {
        return listOf<User>(
            User("Test Elek", "test@elek", "test address", "","","@/drawable/pup"),
            User("Test Elek", "test@elek", "test address", "","","@/drawable/pup"),
            User("Test Elek", "test@elek", "test address", "","","@/drawable/pup")
        )
    }
}