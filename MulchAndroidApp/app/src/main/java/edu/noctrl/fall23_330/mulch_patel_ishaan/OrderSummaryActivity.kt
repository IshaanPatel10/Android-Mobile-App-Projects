package edu.noctrl.fall23_330.mulch_patel_ishaan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OrderSummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_summary)

        val street = findViewById<TextView>(R.id.textView6)
        val city = findViewById<TextView>(R.id.textView7)
        val state = findViewById<TextView>(R.id.textView9)
        val zip_code = findViewById<TextView>(R.id.textView14)
        val phone = findViewById<TextView>(R.id.textView16)
        val email = findViewById<TextView>(R.id.textView17)

        street.text = intent.getStringExtra("street")
        city.text = intent.getStringExtra("city")
        state.text = intent.getStringExtra("state")
        zip_code.text = intent.getStringExtra("zip_code")
        phone.text = intent.getStringExtra("phone")
        email.text = intent.getStringExtra("email")


    }
}