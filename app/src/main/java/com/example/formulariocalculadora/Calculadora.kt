package com.example.formulariocalculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_calculadora.*
import kotlinx.android.synthetic.main.activity_main.*

class Calculadora : AppCompatActivity() {
    var isNewOp = true
    var oldNumber = ""
    var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)


        val OIntent : Intent = intent
        var Nombre = OIntent.getStringExtra("user")
        setTitle("Hola" +" "+ Nombre);

        }


    fun numberEvent(view: View) {
        if(isNewOp)
            editText.setText("")
        isNewOp = false
        var buclick:String= editText.text.toString()
        var buselect:Button = view as Button
        when(buselect.id){
            Uno.id -> {buclick += "1"}
            Dos.id -> {buclick += "2"}
            Tres.id -> {buclick += "3"}
            Cuatro.id -> {buclick += "4"}
            Cinco.id -> {buclick += "5"}
            Seis.id -> {buclick += "6"}
            Siete.id -> {buclick += "7"}
            Ocho.id -> {buclick += "8"}
            Nueve.id -> {buclick += "9"}
            Cero.id -> {buclick += "0"}
            Punto.id -> {buclick += "."}
            MasMenos.id ->{buclick= "-$buclick"}

        }
        editText.setText(buclick)
    }

    fun OperatorEvent(view: View) {
        isNewOp = true
        oldNumber = editText.text.toString()
        var buselect = view as Button
        when(buselect.id){
            Multiplicar.id -> {op = "*"}
            Mas.id -> {op = "+"}
            Menos.id -> {op = "-"}
            Dividir.id -> {op = "/"}
        }
    }

    fun EqualEvent(view: View) {
        var newnumber:String = editText.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNumber.toDouble() + newnumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newnumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newnumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newnumber.toDouble()}

        }
        editText.setText(result.toString())
    }

    fun acEvent(view: View) {
        editText.setText("0")
        isNewOp=true
    }

    fun percentEvent(view: View) {
        var no = editText.text.toString().toDouble()/100
        editText.setText(no.toString())
        isNewOp = true
    }
}
