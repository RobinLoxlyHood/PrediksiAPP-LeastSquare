package com.rizki.dwh.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rizki.dwh.R
import kotlinx.android.synthetic.main.activity_hasil.*

class HasilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)
        var actionBar = getSupportActionBar()
        actionBar!!.title = "Hasil Prediksi"
        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val intent = intent
        var tanggal =intent.getStringExtra("tanggal")
        var bulan =intent.getStringExtra("bulan")
        var tahun =intent.getStringExtra("tahun")
        var hasil = intent.getStringExtra("hasil")

        tvTanggal.text = tanggal + "/" + bulan + "/" + tahun
        tvHasilPrediksi.text = hasil.toString()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}