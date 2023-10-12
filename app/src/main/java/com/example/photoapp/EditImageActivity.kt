package com.example.photoapp

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.photoapp.databinding.ActivityEditImageBinding
import org.koin.android.ext.android.bind
import kotlin.math.log


class EditImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditImageBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEditImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
        displayImage()
        backButton()
    }

    private fun backButton() {
        binding.arrowBack.setOnClickListener{
            startActivity(Intent(applicationContext,MainActivity::class.java))

        }

    }


    private fun displayImage() {
        // get image uri
        val imageUri:Uri=Uri.parse(intent.getStringExtra(MainActivity.KEY_IMAGE_URI))
        val bitmap=BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri))
        binding.imagePreview.setImageBitmap(bitmap)
        binding.imagePreview.visibility= View.VISIBLE

    }
    private fun setListener() {
       binding.imagePreview.setOnClickListener{
           // onBackPressed()  is dedicated
           onBackPressedDispatcher.onBackPressed()
       }
    }


}