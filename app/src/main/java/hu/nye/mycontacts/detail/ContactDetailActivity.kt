package hu.nye.mycontacts.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.bumptech.glide.Glide
import hu.nye.mycontacts.R

class ContactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        setSupportActionBar(findViewById(R.id.detail_toolbar))
        supportActionBar?.apply { title = "" }

        Glide.with(this).load(R.drawable.download).into(findViewById(R.id.detail_header_image))

        setClickListeners()

    }

    private fun setClickListeners() {
        val detailDialButton : ImageView = findViewById(R.id.detail_dial_button)
        detailDialButton.setOnClickListener{
            dialNumber("+36301234567")
        }

        val detailMessageButtonFirst : ImageView = findViewById(R.id.detail_message_button_first)
        detailMessageButtonFirst.setOnClickListener{
            sendMessage("+36301234567")
        }

        val detailMessageButtonSecond : ImageView = findViewById(R.id.detail_message_button_second)
        detailMessageButtonSecond.setOnClickListener{
            sendMessage("+36301234567")
        }

        val detailEmailButton : ImageView = findViewById(R.id.detail_email_button)
        detailEmailButton.setOnClickListener{
            sendEmail("test@test.com")
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