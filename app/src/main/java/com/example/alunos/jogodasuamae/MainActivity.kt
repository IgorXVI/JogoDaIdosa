package com.example.alunos.jogodasuamae

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener{
            vezJogador(button1)
        }
        button2.setOnClickListener{
            vezJogador(button2)
        }
        button3.setOnClickListener{
            vezJogador(button3)
        }
        button4.setOnClickListener{
            vezJogador(button4)
        }
        button5.setOnClickListener{
            vezJogador(button5)
        }
        button6.setOnClickListener{
            vezJogador(button6)
        }
        button7.setOnClickListener{
            vezJogador(button7)
        }
        button8.setOnClickListener{
            vezJogador(button8)
        }
        button9.setOnClickListener{
            vezJogador(button9)
        }
    }

    fun resetarJogo(view: View){
        runOnUiThread {
            var btn: Button
            var id: Int
            var nome: String
            for(i in 1..9){
                nome = "button{$i}"
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
