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

    var terminou = false

    fun resetarJogo(view: View){
        terminou = false
        for(i in 1..9){
            var btn = pegarBotao(i)
            btn.setText(" ")
            btn.setEnabled(true)
        }
    }

    fun menssagemPerdeu(){
        terminou = true
        var text = Toast.makeText(this, "Você Perdeu!", Toast.LENGTH_SHORT)
        text.show()
    }

    fun menssagemVenceu(){
        terminou = true
        var text = Toast.makeText(this, "Você Venceu!", Toast.LENGTH_SHORT)
        text.show()
    }

    fun menssagemEmpate(){
        terminou = true
        var text = Toast.makeText(this, "Empate!", Toast.LENGTH_SHORT)
        text.show()
    }

    fun vezJogador(btn: Button){
        btn.setText("X")
        btn.setEnabled(false)
        travarTudo()
        checkarFim()
        if(!terminou){
            vezComputador()
        }
    }

    fun vezComputador(){
        var num = Random().nextInt(9) + 1
        var btn = pegarBotao(num)
        var texto = btn.text
        if(texto.equals("O")){
            vezComputador()
        }
        else{
            btn.setText("O")
            btn.setEnabled(false)
        }
        checkarFim()
        if(!terminou){
            destravarTudo()
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
        var linha1 = btn1.equals(btn2) && btn2.equals(btn3)
        var coluna1 = btn1.equals(btn4) && btn4.equals(btn7)
        var diagonal1 = btn1.equals(btn5) && btn5.equals(btn9)
        var linha2 = btn4.equals(btn5) && btn5.equals(btn6)
        var linha3 = btn7.equals(btn8) && btn8.equals(btn9)
        var coluna2 = btn2.equals(btn5)&& btn5.equals(btn8)
        var coluna3 = btn3.equals(btn6) && btn6.equals(btn9)
        var diagonal2 = btn3.equals(btn5) && btn5.equals(btn7)
        if(linha1 || coluna1 || diagonal1){
            checkarLado(btn1)
        }
        else if(linha2 || coluna2 || diagonal2){
            checkarLado(btn5)
        }
        else if(linha3 || coluna3){
            checkarLado(btn9)
        }
        else{
            checkarEmpate()
        }
    }

    fun travarTudo(){
        for(i in 1..9){
            var btn = pegarBotao(i)
            if(!btn.text.equals("X") && !btn.text.equals("O")){
                btn.setEnabled(false)
            }
        }
    }

    fun destravarTudo(){
        for(i in 1..9){
            var btn = pegarBotao(i)
            if(!btn.text.equals("X") && !btn.text.equals("O")){
                btn.setEnabled(true)
            }
        }
    }

    fun checkarEmpate(){
        var empate = true
        for(i in 1..9){
            var btn = pegarBotao(i).text
            if(!btn.equals("X") && !btn.equals("O")){
                empate = false
                break
            }
        }
        if(empate){
            menssagemEmpate()
        }
    }

    fun checkarLado(txt: CharSequence){
        if(txt.equals("X")){
            menssagemVenceu()
        }
        else if(txt.equals("O")){
            menssagemPerdeu()
        }
    }
}
