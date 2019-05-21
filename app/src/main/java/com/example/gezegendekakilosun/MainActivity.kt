package com.example.gezegendekakilosun

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val pound=2.2045
    val kilo=0.45359237
    val mars=0.38
    val jubiter=2.34
    val venus = 0.91
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Glide.with(this).load(R.drawable.maxresdefault).into(imageView).view
        checkBoxMars.setOnClickListener(this)
        checkBoxVenus.setOnClickListener(this)
        checkBoxJubiter.setOnClickListener(this)
        /*
        button3.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.e("RIDVAN","BUTONA BASILDI")
            }
        })
        */
    }

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked:Boolean=v.isChecked

        if (!TextUtils.isEmpty(type.text.toString())){
            var kullaniciKilo=type.text.toString().toDouble()
            var kullaniciPound = kiloToPound(kullaniciKilo)

            when(v.id){
                R.id.checkBoxMars ->    if(isChecked){
                    checkBoxVenus.isChecked=false
                    checkBoxJubiter.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound,v)
                }
                R.id.checkBoxVenus ->    if(isChecked){
                    checkBoxMars.isChecked=false
                    checkBoxJubiter.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound,v)
                }
                R.id.checkBoxJubiter ->    if(isChecked){
                    checkBoxMars.isChecked=false
                    checkBoxVenus.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound,v)
                }
            }
        }
    }

    fun hesaplaAgirlikPound(pound:Double,checkBox: CheckBox){
        var sonuc:Double=0.0
        when(checkBox.id){
            R.id.checkBoxMars -> sonuc = pound*this.mars
            R.id.checkBoxJubiter -> sonuc = pound*this.jubiter
            R.id.checkBoxVenus -> sonuc = pound*this.venus
            else -> sonuc = 0.0
        }

        var sonucToKilo = poundToKilo(sonuc)
        tvsonuc.text=sonucToKilo.formatla(2).toString()
    }

    fun kiloToPound(kilo:Double):Double{
        return kilo*pound
    }

    fun poundToKilo(pound:Double):Double{
        return pound*kilo
    }

    @SuppressLint("DefaultLocale")
    fun Double.formatla(kacrakam:Int) = java.lang.String.format("%.${kacrakam}f",this)
}
