package hu.nye.mycontacts.data

import hu.nye.mycontacts.R
import hu.nye.mycontacts.entity.User

class DataSource {

    fun loadUser(): List<User> {
        return listOf<User>(
            User("Test Elek", "test@elek", "test address", R.drawable.poodle),
            User("Test2 Elek", "test2@elek", "test address", R.drawable.pup),
            User("Test3 Elek", "test3@elek", "test address", R.drawable.pug)
        )
    }
}