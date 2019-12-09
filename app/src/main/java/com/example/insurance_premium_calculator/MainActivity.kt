package com.example.insurance_premium_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myData: PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData = ViewModelProviders.of(this).get(PremiumModel::class.java)

        display()

        btn_cal.setOnClickListener(){
            myData.premiumAmount = getPremium();
            display();
        }
        btn_reset.setOnClickListener() {
            spr_age.setSelection(0)
            rdrG_gender.clearCheck()
            chk_smoker.setChecked(false)
            myData.premiumAmount = 0.0
        }
    }

    fun display(){
        if (myData.premiumAmount != 0.0)
            txt_premium.text = myData.premiumAmount.toString();
    }


    fun getPremium(): Double{
        return when(spr_age.selectedItemPosition){
            0 -> 60.00
            1 -> 70.00 +
                    (if(rbtn_m.isChecked) 50.00 else 0.0) +
                    (if(chk_smoker.isChecked) 100.00 else 0.0)
            2 -> 90.00 +
                    (if(rbtn_m.isChecked) 100.00 else 0.0) +
                    (if(chk_smoker.isChecked) 150.00 else 0.0)
            3 -> 120.00 +
                    (if(rbtn_m.isChecked) 150.00 else 0.0) +
                    (if(chk_smoker.isChecked) 200.00 else 0.0)
            4 -> 150.00 +
                    (if(rbtn_m.isChecked) 200.00 else 0.0) +
                    (if(chk_smoker.isChecked) 250.00 else 0.0)
            else -> 150.00 +
                    (if(rbtn_m.isChecked) 200.00 else 0.0) +
                    (if(chk_smoker.isChecked) 300.00 else 0.0)
        }
    }
}
