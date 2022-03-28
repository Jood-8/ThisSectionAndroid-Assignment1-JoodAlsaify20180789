package com.example.myapplication222

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        //global variable
        var flag : String = "sum"
        //here .. create a spinner items (options)
        val spinnerVal : Spinner = findViewById(R.id.spinnerV)
        var options = arrayOf("sum","divide")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        button.setOnClickListener{ view ->
            //code here
            var x: Int = n1.text.toString().toInt();
            var y: Int = n2.text.toString().toInt();
            var z: Int = n3.text.toString().toInt();

            if(flag =="sum")
                resultTV.text = sum(x,y,z).toString();
            else
                resultTV.text = divide(x,y,z).toString();
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


    }
}

public fun sum(a: Int, b: Int , c:Int): Int {
    return a+b+c;
}
public fun divide(a: Int, b: Int , c:Int): Int {
    var ad=sum(a,b,c);
    return ad/3;
}