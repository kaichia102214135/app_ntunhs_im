package com.example.a0314

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spnCity = findViewById<Spinner>(R.id.spnCity)
        val city = arrayListOf("請選擇","台北市","新北市","桃園市","新竹縣","新竹市")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,city)
        spnCity.adapter = adapter

        spnCity.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long){
                if (pos>0)
                    Toast.makeText(this@MainActivity, "你選的是" +city[pos],
                                                                Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>){}
        }
        val rapGrp_Gender = findViewById<RadioGroup>(R.id.radGrpGender)
        val radBtn_Male = findViewById<RadioButton>(R.id.radBtn_Male)
        val radBtn_Female = findViewById<RadioButton>(R.id.radBtn_Female)
        var gender = ""

        val numPicker = findViewById<NumberPicker>(R.id.numPicker_age)
        numPicker.setMinValue(0)
        numPicker.setMaxValue(100)
        numPicker.setValue(50)

        rapGrp_Gender.setOnCheckedChangeListener { _, checkedId ->
            gender = rapGrp_Gender.findViewById<RadioButton>(checkedId).text.toString()
            Toast.makeText(this,gender+numPicker.getValue(),Toast.LENGTH_LONG).show()
        }

        val chkbox1 = findViewById<CheckBox>(R.id.chkb1)
        val chkbox2 = findViewById<CheckBox>(R.id.chkb2)
        val chkbox3 = findViewById<CheckBox>(R.id.chkb3)
        val chkbox4 = findViewById<CheckBox>(R.id.chkb4)

        val btn_send = findViewById<Button>(R.id.btn_send)


        btn_send.setOnClickListener {
            var msg=""
            if (chkbox1.isChecked()) {
                msg=msg+ chkbox1.getText().toString()
            }
            if (chkbox2.isChecked()) {
                msg=msg+ "、" + chkbox2.getText().toString()
            }
            if (chkbox3.isChecked()) {
                msg=msg+ "、" + chkbox3.getText().toString()
            }
            if (chkbox4.isChecked()) {
                msg=msg+ "、" + chkbox4.getText().toString()
            }
            Toast.makeText(this@MainActivity, "你選的是" + msg,
                Toast.LENGTH_SHORT).show()

        }

    }
}