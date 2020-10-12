package com.example.formulariocalculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_calculadora.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun Logueo(view: View) {
        var Nombre = findViewById<EditText>(R.id.Nombre)
        var user: String = Nombre.text.toString()

        val intent = Intent(this, Calculadora::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
        finish()
    }
}
