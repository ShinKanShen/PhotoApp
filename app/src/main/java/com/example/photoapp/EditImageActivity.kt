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
import kotlin.math.log


class EditImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditImageBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEditImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListener()
        displayImage()
    }

    private fun displayImage() {
        val image_path=intent.getStringExtra(MainActivity.KEY_IMAGE_URI)
        val imageUri:Uri=Uri.parse(image_path)
        val inputStream =contentResolver.openInputStream(imageUri)
        val bitmap=BitmapFactory.decodeStream(inputStream)
        binding.imagePreview.setImageBitmap(bitmap)
        binding.imagePreview.visibility= View.VISIBLE



    }

    private fun setListener() {
       binding.imagePreview.setOnClickListener{
           onBackPressedDispatcher.onBackPressed()
       }
    }


}