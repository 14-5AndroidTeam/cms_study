package com.nise.paste.UI.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nise.paste.R
import com.nise.paste.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.layout.id, ListFragment())
            .commit()
    }
}