package com.example.myapplication222

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.myapplication33.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button: Button = findViewById(R.id.btResult)
        val n1: EditText = findViewById(R.id.num1)
        val n2: EditText = findViewById(R.id.num2)
        val n3: EditText = findViewById(R.id.num3)
        val resultTV: TextView = findViewById(R.id.textResult)
        val choose: TextView = findViewById(R.id.textView5)
        val menu: TextView = findViewById(R.id.extra)
        //global variable
        var flag : String = "sum"
        //here .. create a spinner items (options)
        val spinnerVal : Spinner = findViewById(R.id.spinnerV)
        var options = arrayOf("sum")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        button.setOnClickListener{ view ->
            //code here
            var x: Int = n1.text.toString().toInt();
            var y: Int = n2.text.toString().toInt();
            var z: Int = n3.text.toString().toInt();

            if(flag =="sum")
                resultTV.text = sum(x,y,z).toString();

        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
     //Inflate the menu to use in the action bar
     val inflater = menuInflater
     inflater.inflate(R.menu.my_first_menu, menu)
     return super.onCreateOptionsMenu(menu)
      }
}
override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when(item.itemId){

        R.id.selection1->Toast.makeText(this,"Chicken Burger selected",Toast.LENGTH_SHORT).show()
        R.id.selection2 -> Toast.makeText(this, "Meat Burger selected", Toast.LENGTH_SHORT).show()
        R.id.selection3->Toast.makeText(this,"Vegan Burger selected",Toast.LENGTH_SHORT).show()
        R.id.subitem1 -> Toast.makeText(this, "Sub-item 1 selected", Toast.LENGTH_SHORT).show()
        R.id.subitem2 -> Toast.makeText(this, "Sub-item 1 selected", Toast.LENGTH_SHORT).show()
    }
    return true;
}

public fun sum(a: Int, b: Int , c:Int): Int {
    return a+b+c;
}
