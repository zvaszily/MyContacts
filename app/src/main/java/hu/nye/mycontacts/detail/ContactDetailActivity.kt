package hu.nye.mycontacts.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import hu.nye.mycontacts.R
import hu.nye.mycontacts.adapter.SELECTED_USER
import hu.nye.mycontacts.entity.User

class ContactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        setSupportActionBar(findViewById(R.id.detail_toolbar))
        supportActionBar?.apply { title = "" }

        Glide.with(this).load(R.drawable.download).into(findViewById(R.id.detail_header_image))

        val selectedUser = intent.getParcelableExtra<User>(SELECTED_USER)
        selectedUser?.let { setHeaderImage(it) }
        selectedUser?.let { setTexts(it) }
        selectedUser?.let { setClickListeners(it) }

    }

    private fun setHeaderImage(selectedUser: User) {
        Glide.with(this).load(selectedUser.imageUrlId).into(findViewById(R.id.detail_header_image))
    }

    private fun setTexts(selectedUser: User) {
        val detailName: TextView = findViewById(R.id.detail_name)
        val detailPhoneNumberFirst: TextView = findViewById(R.id.detail_phone_number_first)
        val detailPhoneNumberSecond: TextView = findViewById(R.id.detail_phone_number_second)
        val detailEmail: TextView = findViewById(R.id.detail_email)
        detailName.text = selectedUser.nameId
        detailPhoneNumberFirst.text = selectedUser.privatePhoneNumber
        detailPhoneNumberSecond.text = selectedUser.workPhoneNumber
        detailEmail.text = selectedUser.emailId
    }

    private fun setClickListeners(selectedUser: User) {
        val detailDialButton : ImageView = findViewById(R.id.detail_dial_button)
        detailDialButton.setOnClickListener{
            dialNumber(selectedUser.privatePhoneNumber)
        }

        val detailMessageButtonFirst : ImageView = findViewById(R.id.detail_message_button_first)
        detailMessageButtonFirst.setOnClickListener{
            sendMessage(selectedUser.privatePhoneNumber)
        }

        val detailMessageButtonSecond : ImageView = findViewById(R.id.detail_message_button_second)
        detailMessageButtonSecond.setOnClickListener{
            sendMessage(selectedUser.workPhoneNumber)
        }

        val detailEmailButton : ImageView = findViewById(R.id.detail_email_button)
        detailEmailButton.setOnClickListener{
            sendEmail(selectedUser.emailId)
        }
    }

    private fun sendEmail(email: String) {
        val emailUri = Uri.parse("mailto:$email")
        val intent = Intent(Intent.ACTION_SENDTO,emailUri)
        startActivity(intent)
    }

    private fun sendMessage(phoneNumber: String) {
        val phoneUri = Uri.parse("smsto:$phoneNumber")
        val intent = Intent(Intent.ACTION_SENDTO,phoneUri)
        startActivity(intent)
    }

    private fun dialNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.setData(Uri.parse("tel:$phoneNumber"))
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}