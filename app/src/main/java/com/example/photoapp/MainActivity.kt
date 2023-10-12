package com.example.photoapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.photoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        private const val REQUEST_CODE_PICK_IMAGE=1
        const val KEY_IMAGE_URI="imageUri"
    }
    // create binding
    private lateinit var binding: ActivityMainBinding
    //using registerForActivityResult
    private val startActivityForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->

        if(result.resultCode==Activity.RESULT_OK && result.data !=null){
            val selectedFileUri = result.data?.data // get uri
            Intent(applicationContext,EditImageActivity::class.java).also {
                //put uri to intent
                    editImageIntent->editImageIntent.putExtra(KEY_IMAGE_URI,selectedFileUri.toString())
                    startActivity(editImageIntent)
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);
        setListeners();
    }
    private fun setListeners() {
        binding.buttonEditNewImage.setOnClickListener{
            val intent:Intent=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult.launch(intent)
        }
    }


}


