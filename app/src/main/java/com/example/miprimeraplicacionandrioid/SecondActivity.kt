package com.example.miprimeraplicacionandrioid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.miprimeraplicacionandrioid.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id:Int = intent.getIntExtra("Id",0)
        val nombre:String?  = intent.getStringExtra("Name")

        Toast.makeText(this@SecondActivity,"$id $nombre", Toast.LENGTH_SHORT).show()


        binding.btnUrl.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW).apply { data= Uri.parse("http://www.google.com") }

            if(intent.resolveActivity(packageManager)!=null) {
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity, "No hay aplicación asociada para abrir esta petición",Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnMapa.setOnClickListener {


            var intent = Intent(Intent.ACTION_VIEW).apply { data= Uri.parse("geo:19.28958619366017,-99.13938537622406?z=21&q=19.28958619366017,-99.13938537622406") }

            if(intent.resolveActivity(packageManager)!=null) {
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity, "No hay aplicación asociada para abrir esta petición",Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnLlamada.setOnClickListener {

            var intent = Intent(Intent.ACTION_DIAL).apply { data= Uri.parse("tel:5523280941") }

            if(intent.resolveActivity(packageManager)!=null) {
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity, "No hay aplicación asociada para abrir esta petición",Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnEmail.setOnClickListener {

            val emails = arrayOf("angelestradamx@hotmail.com")

            var intent = Intent(Intent.ACTION_SEND).apply {

                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL,emails)
                putExtra(Intent.EXTRA_SUBJECT,"Correo de Ángel")
                putExtra(Intent.EXTRA_TEXT,"Hola, este es un correo de prueba")
            }

            if(intent.resolveActivity(packageManager)!=null) {
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity, "No hay aplicación asociada para abrir esta petición",Toast.LENGTH_SHORT).show()
            }


        }


    }


}