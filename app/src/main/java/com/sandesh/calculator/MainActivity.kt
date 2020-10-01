package com.sandesh.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.hussein.startup.R
import  kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // so we make functions here. And wondered where they are called? They are called on the Xml file.
    // you can check, If we don't write value of onClick the fun name still appears grey
    fun buNumberEvent(view:View){

          val buSelect = view as Button
          var buClickValue = etShowNumber.text.toString()
          when (buSelect.id){
              bu0.id -> {
                  buClickValue +="0"
              }
              bu1.id -> {
                  buClickValue +="1"
              }
              bu2.id -> {
                  buClickValue +="2"
              }
              bu3.id -> {
                  buClickValue +="3"
              }
              bu4.id -> {
                  buClickValue +="4"
              }
              bu5.id -> {
                  buClickValue +="5"
              }
              bu6.id -> {
                  buClickValue +="6"
              }
              bu7.id -> {
                  buClickValue +="7"
              }
              bu8.id -> {
                  buClickValue +="8"
              }
              bu9.id -> {
                  buClickValue +="9"
              }
              buPlusMinus.id -> {
                  buClickValue +="6"
              }
              buDot.id -> {
                  buClickValue +="."
              }
          }
          etShowNumber.setText(buClickValue)
    }
}
