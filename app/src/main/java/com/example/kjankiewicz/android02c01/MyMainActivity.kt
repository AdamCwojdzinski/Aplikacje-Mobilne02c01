package com.example.kjankiewicz.android02c01

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button


class MyMainActivity : Activity() {
    private var activityTag = "MainActivityTag"
    private lateinit var button2: Button
    private lateinit var button1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_main)
        Log.i(activityTag, "OnCreate()")
        /* DONE: Korzystając z metody setContentView();, której parametrem
        *  jest plik z definicją układu activity_my_main.xml załaduj widoki aktywności */

        /* DONE: Za pomocą metody findViewById znajdź i przypisz do zmiennej button2 przycisk posiadający taki sam identyfikator
        *  button2 = (Button) findViewById(identyfikator);*/
        button2 = findViewById(R.id.button2)
        button2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?){
                incrementButton()
            }
        })

        button1 = findViewById(R.id.button1)
        button1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                runSecondActivity()
            }
        })
    }

    override fun onStart() {
        super.onStart()
        Log.i(activityTag, "OnStart()")
        // The activity is about to become visible.
    }

    override fun onResume() {
        super.onResume()
        Log.i(activityTag, "onResume()")
        // The activity has become visible (it is now "resumed").
    }

    override fun onPause() {
        super.onPause()
        Log.i(activityTag, "onPause()")
        // Another activity is taking focus (this activity is about to be "paused").
    }

    override fun onStop() {
        super.onStop()
        Log.i(activityTag, "onStop()")
        // The activity is no longer visible (it is now "stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(activityTag, "onDestroy()")
        // The activity is about to be destroyed.
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(activityTag, "onSaveInstanceState()")

        /* DONE: Zapamiętaj treść przycisku button2 celem późniejszego przywrócenia jego stanu.
        *  Treść widniejącą na przycisku możesz pobrać za pomocą metody getText() - patrz metoda incrementButton*/
        savedInstanceState.putString("incrementButton", button2.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(activityTag, "onRestoreInstanceState()")
        /* DONE: Przywróć treść przycisku button2 - odtwórz jego stan.
        *  Treść widniejącą na przycisku możesz ustawić za pomocą metody setText() - patrz metoda incrementButton*/
        button2.text = savedInstanceState.getString("incrementButton")
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.my_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }


    fun runSecondActivity() {
        /* DONE: Za pomocą jawnej intencji wywołaj aktywność zdefniowaną w klasie MySecondActivity */
        val myIntent = Intent(this@MyMainActivity, MySecondActivity::class.java)
        startActivity(myIntent)
    }

    fun incrementButton() {
        // Do something in response to button
        val button2Val: Int? = Integer.parseInt(button2.text.toString())
        button2.text = button2Val?.let {
            it + 1
        }.toString()
    }

}
