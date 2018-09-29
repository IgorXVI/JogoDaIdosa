package com.example.alunos.jogodasuamae

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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
                btn = pegarBotao(i)
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
        var num = Random().nextInt(6) + 1
        var btn = pegarBotao(num)
        var texto = btn.text
        if(texto.equals("O")){
            vezComputador()
        }
        else{
            btn.setText("O")
            btn.setEnabled(false)
        }
    }

    fun pegarBotao(num: Int): Button{
        var nome = "button{$num}"
        var id = resources.getIdentifier(nome, "id", this.packageName)
        var btn: Button = findViewById(id)
        return btn
    }

    fun checkarFim(){
        var btn1 = pegarBotao(1).text
        var btn2 = pegarBotao(2).text
        var btn3 = pegarBotao(3).text
        var btn4 = pegarBotao(4).text
        var btn5 = pegarBotao(5).text
        var btn6 = pegarBotao(6).text
        var btn7 = pegarBotao(7).text
        var btn8 = pegarBotao(8).text
        var btn9 = pegarBotao(9).text

    }

    fun travarTudo(){
        var btn: Button
        for(i in 1..9){
            btn = pegarBotao(i)
            if(btn.text.equals(" ")){
                btn.setEnabled(false)
            }
        }
    }

    fun checkarLado(txt: String): Int{
        if(txt.equals("X")){
            return 1
        }
        else if(txt.equals("O")){
            return 2
        }
        else{
            return 3
        }
    }
}
