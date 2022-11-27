package hu.nye.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hu.nye.mycontacts.adapter.ItemAdapter
import hu.nye.mycontacts.data.DataSource
import hu.nye.mycontacts.entity.User
import hu.nye.mycontacts.network.controller.UserController
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(findViewById(R.id.contact_list_toolbar))
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            title = getString(R.string.app_name)
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
        UserController().getUsers(30)
            .subscribe({ users ->
            Log.d("users arrived", "list size is ${users.size} ")
            usersData.adapter = ItemAdapter(this, users)
        },{
            it.printStackTrace()
            Log.e("user request error ", "onStart: ${it.message} ", )
        })


    }


}