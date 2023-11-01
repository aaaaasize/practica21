package com.example.pr21_pr_33_tstrevnikovaav

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var crime_title_et:EditText
    private lateinit var crime_date_btn:Button
    private lateinit var crime_solved_cb:CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        crime_title_et=findViewById(R.id.crime_title_et)
        crime_date_btn=findViewById(R.id.crime_date_btn)
        crime_solved_cb=findViewById(R.id.crime_solved_cb)

        crime_date_btn.isEnabled = false
        crime_date_btn.text = Date().toString()

        crime_solved_cb.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
            {
                val message= getString(R.string.crime_report_solved)
                Snackbar.make(findViewById(android.R.id.content),message, Snackbar.LENGTH_LONG).show()
                val intent=Intent(this,SolvedCrime::class.java)
                startActivity(intent)
            }
        }
    }
}