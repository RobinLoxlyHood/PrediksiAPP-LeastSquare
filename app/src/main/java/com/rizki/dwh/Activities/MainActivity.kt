package com.rizki.dwh.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rizki.dwh.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar?.hide()
        prediksi()

    }

    override fun onStart() {
        etDay.text = null
        etMonth.text = null
        etYear.text = null
        super.onStart()
    }
    fun prediksi(){
        btnPrediksi.setOnClickListener {
            if(etDay.text.toString().isEmpty()){
                etDay.error = "Tanggal tidak boleh kosong"
            }else if(etMonth.text.toString().isEmpty()){
                etMonth.error = "Bulan tidak boleh kosong"
            }else if (etYear.text.toString().isEmpty()){
                etYear.error = "Tahun tidak boleh kosong"
            }else if(etYear.text.toString().length <4){
                etYear.error = "Tahun diisi dengan 4 angka"
            }else if(etYear.text.toString().toInt()<=2003 || etYear.text.toString().toInt()>=2040){
                etYear.error = "Prediksi tidak terjangkau"
            }
            else{
            perhitungan()
            }
        }
    }
    fun perhitungan(){
        var tanggal = etDay.text.toString()
        var bulan = etMonth.text.toString()
        var tahun = etYear.text.toString()


        var date:String = (tanggal+bulan+tahun)
        var A = Integer.parseInt(date)
        var m = -0.0003758148911106377
        var c = 37018.21500930723



        var pred = (m*A)+c
        var hasil = pred.toInt().toString()

        val intent = Intent(this,HasilActivity::class.java)
        intent.putExtra("tanggal",tanggal)
        intent.putExtra("bulan",bulan)
        intent.putExtra("tahun",tahun)
        intent.putExtra("hasil",hasil)

        startActivity(intent)

    }
}