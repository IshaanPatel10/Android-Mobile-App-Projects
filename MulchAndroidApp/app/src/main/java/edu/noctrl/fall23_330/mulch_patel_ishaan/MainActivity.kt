package edu.noctrl.fall23_330.mulch_patel_ishaan

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import edu.noctrl.fall23_330.mulch_patel_ishaan.ordermulchactivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val str = ""

        val nextPage = findViewById<Button>(R.id.button)

        nextPage.setOnClickListener{
            val intent = Intent(this, ordermulchactivity::class.java)
            startActivity(intent)
        }



        }


}