package edu.noctrl.fall23_330.mulch_patel_ishaan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout




class ordermulchactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordermulchactivity)



        val amount = findViewById<EditText>(R.id.editTextText)
        val street = findViewById<EditText>(R.id.editTextText2)
        val city = findViewById<EditText>(R.id.editTextText3)
        val state = findViewById<EditText>(R.id.editTextText4)
        val zip_code = findViewById<EditText>(R.id.editTextText5)
        val email = findViewById<EditText>(R.id.editTextText6)
        val phone = findViewById<EditText>(R.id.editTextText7)
        val button2 = findViewById<Button>(R.id.button2)



        button2.setOnClickListener {
            val sendInfoIntent = Intent(this, OrderSummaryActivity::class.java).apply{
                putExtra("Amount", amount.text.toString().toDouble())
                putExtra("street", street.text.toString())
                putExtra("city", city.text.toString())
                putExtra("state", state.text.toString())
                putExtra("zip_code", zip_code.text.toString())
                putExtra("phone", phone.text.toString())
                putExtra("email", email.text.toString())
            }
            startActivity(sendInfoIntent)

        }


    }
}