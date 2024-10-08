package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val adapter = ContactListAdapter()
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
            .apply {
                orientation = LinearLayoutManager.VERTICAL
            }


        adapter.submitList(contacts)

        ivGrid.setOnClickListener{
            rvList.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener{
            rvList.layoutManager = LinearLayoutManager(this)
        }

adapter.setOnClickListener { contact ->
    val intent = Intent(this, ContactDetailActivity:: class.java)
    intent.putExtra("name", contact.name)
    intent.putExtra("phone", contact.phone)
    intent.putExtra("icon", contact.icon)


    startActivity(intent)
    Log.d("Mateus", contact.toString())
}


}
    }



val contacts = listOf(
    Contact(
        name = "Roque",
        phone = "(55) 11 987479834",
        icon = R.drawable.sample12
    ),
    Contact(
        name = "Mateus",
        phone = "(55) 11 987472835",
        icon = R.drawable.sample1
    ),
    Contact(
        name = "Malu",
        phone = "(55) 11 987359834",
        icon = R.drawable.sample2
    ),
    Contact(
        name = "Teia",
        phone = "(55) 11 977459834",
        icon = R.drawable.sample3
    ),
    Contact(
        name = "Abraao",
        phone = "(55) 11 987479829",
        icon = R.drawable.sample4
    ),
    Contact(
        name = "Beatriz",
        phone = "(55) 11 987479815",
        icon = R.drawable.sample5
    ),
    Contact(
        name = "Caio",
        phone = "(55) 11 987479800",
        icon = R.drawable.sample6
    ),
    Contact(
        name = "Sr Moura",
        phone = "(55) 11 987479822",
        icon = R.drawable.sample7
    ),
    Contact(
        name = "Dona Loura",
        phone = "(55) 11 987479811",
        icon = R.drawable.sample8
    ),
    Contact(
        name = "Beninho",
        phone = "(55) 11 985579834",
        icon = R.drawable.sample9
    ),
    Contact(
        name = "Julia",
        phone = "(55) 11 987479866",
        icon = R.drawable.sample10
    ),
    Contact(
        name = "Boquinha",
        phone = "(55) 11 957479839",
        icon = R.drawable.sample11
    ),
    Contact(
        name = "Silvestre",
        phone = "(55) 11 987475534",
        icon = R.drawable.sample13
    ),
    Contact(
        name = "Adriel",
        phone = "(55) 11 987477899",
        icon = R.drawable.sample14
    ),
    Contact(
        name = "Alfred",
        phone = "(55) 11 987479855",
        icon = R.drawable.sample15
    ),
    Contact(
        name = "Nick",
        phone = "(55) 11 987479888",
        icon = R.drawable.sample16
    ),
)