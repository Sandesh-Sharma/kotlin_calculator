package com.sandesh.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.hussein.startup.R
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var userInput:EditText
    private lateinit var final:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize array of Buttons
        val buttons = arrayOf<Button>(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,divide,minus,add,dot)
        val clear:Button = findViewById(R.id.clear)
        val equals:Button = findViewById(R.id.equals)
        equals.setOnClickListener{v->
            if(userInput.length()!=0) {
                //Evaluation here
                try {
                    val expression:Expression =  ExpressionBuilder(userInput.text.toString()).build();
                    val result = expression.evaluate()
                    final.text = result.toString()
                }catch (e:Exception){
                    Toast.makeText(this, "Invalid Operation", Toast.LENGTH_SHORT).show()
                }

            }

            }

        clear.setOnClickListener(){
            val total =userInput.text.toString().length
            if (total > 0) { userInput.text.delete(total - 1, total); }
        }

        userInput = findViewById(R.id.input)
        final = findViewById(R.id.res)
        //define listener in each button
        val listener:View.OnClickListener = View.OnClickListener { view->
            //typecast view into button
            val v= view as Button
            //append the text from button
            userInput.append(v.text.toString())

        }
        //through loop set listener in each buttons
        for((index,btn) in buttons.withIndex()){
            btn.setOnClickListener(listener)
        }



        clear.setOnLongClickListener{
            userInput.setText("")
            final.text = ""
            return@setOnLongClickListener true
        }



    }


}
