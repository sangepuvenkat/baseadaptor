package com.venkat.baseadaptor

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.venkat.baseadaptor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding?=null
    var array = arrayListOf("black","red","green","blue")
    var baseAdapterClass=BaseAdapterClass(array)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding?.listview?.adapter=baseAdapterClass
        binding?.fab?.setOnClickListener {
            var dialog=Dialog(this)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.show()

            var etName = dialog.findViewById<EditText>(R.id.etName)
            var btName=dialog.findViewById<Button>(R.id.btName)
            btName?.setOnClickListener {
                if(etName?.text.toString().isNullOrEmpty()){
                    etName?.error="enter the color"
                }else{
                    array.add(etName.text.toString())
                    dialog.dismiss()
                    baseAdapterClass.notifyDataSetChanged()
                }
            }
        }
        binding?.listview?.setOnItemClickListener { parent, view, position, id ->
            array.removeAt(position)
           baseAdapterClass.notifyDataSetChanged()

        }
        bin
        }
    }
}