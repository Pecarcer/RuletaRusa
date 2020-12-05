package com.example.ruletarusa

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uno = findViewById(R.id.bt1) as Button
        val dos = findViewById(R.id.bt2) as Button
        val tres = findViewById(R.id.bt3) as Button
        val cuatro = findViewById(R.id.bt4) as Button
        val cinco = findViewById(R.id.bt5) as Button
        val seis = findViewById(R.id.bt6) as Button
        val btPrincipal = findViewById(R.id.bt_jugar) as Button
        val resultado = findViewById(R.id.iv_resultado) as ImageView
        val creditos = findViewById(R.id.bt_creditos) as Button

        creditos.setOnClickListener{
            val intencion = Intent(this, Creditos::class.java)
            startActivity(intencion)
        }



        var botones = ArrayList<Button>()
        botones.add(uno)
        botones.add(dos)
        botones.add(tres)
        botones.add(cuatro)
        botones.add(cinco)
        botones.add(seis)

        var numAleatorio : Int = random()

        uno.setOnClickListener {
            uno.isEnabled = false
            comprobar(numAleatorio,1,botones,btPrincipal)
        }

        dos.setOnClickListener {
            dos.isEnabled = false
            comprobar(numAleatorio,2,botones,btPrincipal)
        }

        tres.setOnClickListener {
            tres.isEnabled = false
            comprobar(numAleatorio,3,botones,btPrincipal)
        }

        cuatro.setOnClickListener {
            cuatro.isEnabled = false
            comprobar(numAleatorio,4,botones,btPrincipal)
        }

        cinco.setOnClickListener {
            cinco.isEnabled = false
            comprobar(numAleatorio,5,botones,btPrincipal)
        }

        seis.setOnClickListener {
            seis.isEnabled = false
            comprobar(numAleatorio,6,botones,btPrincipal)
        }

        btPrincipal.setOnClickListener {
            numAleatorio = random()
            for (i in 0 until botones.size){
                botones.get(i).isEnabled = true
            }
            btPrincipal.setText("Jugando")
            iv_resultado.setImageResource(R.drawable.vacio)
            btPrincipal.isEnabled = false
        }
    }

    fun random(): Int{
        var rand = ((Math.random() * 6)+1).toInt()
        return rand
    }

    fun comprobar(numAleatorio: Int,num: Int,botones: ArrayList<Button>, btPrincipal: Button){
        iv_resultado.setImageResource(R.drawable.vacio);
        if(numAleatorio == num){
            for (i in 0 until botones.size){
                botones.get(i).isEnabled = false
                iv_resultado.setImageResource(R.drawable.muerto)
            }
            btPrincipal.setText("Reiniciar")
            btPrincipal.isEnabled = true
        }
        else{
            iv_resultado.setImageResource(R.drawable.salvado)
        }
    }
}