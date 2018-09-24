package com.example.alunos.jogodasuamae

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun resetarJogo(){
        runOnUiThread {
            var btn: Button
            var id: Int
            var nome: String
            for(i in 1..9){
                nome = "Button{$i}"
                id = resources.getIdentifier(nome, "id", this.packageName)
                btn = findViewById(id)
                btn.setText(" ")
                btn.setEnabled(true)
            }
        }
    }

    fun messagemPerdeu(){
        var text = Toast.makeText(this, "Você Perdeu!", Toast.LENGTH_SHORT)
        text.show()
    }

    fun messagemVenceu(){
        var text = Toast.makeText(this, "Você Venceu!", Toast.LENGTH_SHORT)
        text.show()
    }

    fun vezJogador(btn: Button){
        btn.setText("X")
        btn.setEnabled(false)
        vezComputador()
    }

    fun vezComputador(){

    }
}
