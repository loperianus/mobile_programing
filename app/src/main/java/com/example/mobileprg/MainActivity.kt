package com.example.mobileprg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var inputpanjang: EditText
    private lateinit var inputlebar: EditText
    private lateinit var inputtinggi: EditText
    private lateinit var btn: Button
    private lateinit var result: TextView

    companion object {
        private const val STATE_VALUE = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputpanjang = findViewById(R.id.edt_length)
        inputlebar = findViewById(R.id.edt_width)
        inputtinggi = findViewById(R.id.edt_height)
        btn = findViewById(R.id.btn_result)
        result = findViewById(R.id.result)

        btn.setOnClickListener(this)

        if (savedInstanceState != null) {
            result.text = savedInstanceState.getString(STATE_VALUE)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_VALUE, result.text.toString())
    }

    override fun onClick(p0: View?) {
        if (p0?.id==R.id.btn_result){
            var tinggi = inputtinggi.text.toString().trim()
            var panjang = inputpanjang.text.toString().trim()
            var lebar = inputlebar.text.toString().trim()
            var volume = tinggi.toDouble() * panjang.toDouble() * lebar.toDouble()
            result.text = volume.toString()
        }
    }
};