package com.example.eventbus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.eventbus.databinding.ActivityMainBinding
import org.greenrobot.eventbus.EventBus
import javax.microedition.khronos.egl.EGLDisplay

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editText = binding.editTextTextPersonName
        button = binding.button

        button.setOnClickListener{
            val msg = editText.text.toString()
            EventBus.getDefault().post(MessageEvent(msg))
            startActivity(Intent(this, SeconfActivity::class.java))
        }
    }
}