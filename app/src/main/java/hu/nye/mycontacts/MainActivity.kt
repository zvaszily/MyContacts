package hu.nye.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hu.nye.mycontacts.adapter.ItemAdapter
import hu.nye.mycontacts.data.DataSource
import hu.nye.mycontacts.entity.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(findViewById(R.id.contact_list_toolbar))
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            title = getString(R.string.codeyard)
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onStart() {
        super.onStart()
        val usersData: RecyclerView = findViewById(R.id.contact_list)
        val myDataset = DataSource().loadUser()
        usersData.layoutManager = LinearLayoutManager(this)
        usersData.adapter = ItemAdapter(this, myDataset)
    }

    private fun getUsers(): List<User> {
        return arrayListOf(User("Test Elek", "test@elek", "test address", R.drawable.poodle),
            User("Test2 Elek", "test2@elek", "test address", R.drawable.pug),
            User("Test3 Elek", "test3@elek", "test address", R.drawable.download))

    }
}