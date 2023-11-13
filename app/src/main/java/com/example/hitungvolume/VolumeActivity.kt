package com.example.hitungvolume

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class VolumeActivity : ComponentActivity(), View.OnClickListener {

    private lateinit var  tvResult: TextView
    private lateinit var etWidth: EditText
    private lateinit var etLength: EditText
    private lateinit var etHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var btnCalculate2: Button
    private lateinit var btnCalculate3: Button

    private val KEY_RESULT = "key_result"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        tvResult = findViewById<TextView>(R.id.tv_result)
        etWidth = findViewById<EditText>(R.id.et_width)
        etLength = findViewById<EditText>(R.id.et_length)
        etHeight = findViewById<EditText>(R.id.et_height)
        btnCalculate = findViewById<Button>(R.id.btn_calculate)
        btnCalculate2 = findViewById<Button>(R.id.btn_calculate2)
        btnCalculate3 = findViewById<Button>(R.id.btn_calculate3)

        btnCalculate.setOnClickListener(this)
        btnCalculate2.setOnClickListener(this)
        btnCalculate3.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(KEY_RESULT)
            tvResult.text = result
        }
    }

    override fun onClick(view: View?) {
        if (view != null) {
            // Perintah hanya akan dieksekusi jika btn_calculate ditekan
            if (view.id == R.id.btn_calculate) {

                // Ambil nilai yang diberikan pengguna pada seluruh EditText
                val inputLength: String = etLength.text.toString().trim();
                val inputWidth: String = etWidth.text.toString().trim();
                val inputHeight: String = etHeight.text.toString().trim();

                // Validasi input
                var isEmptyFields = false
                if (inputLength.isEmpty()) {
                    isEmptyFields = true
                    etLength.error = "Field ini tidak boleh kosong"
                }
                if (inputWidth.isEmpty()) {
                    isEmptyFields = true
                    etWidth.error = "Field ini tidak boleh kosong"
                }
                if (inputHeight.isEmpty()) {
                    isEmptyFields = true
                    etHeight.error = "Field ini tidak boleh kosong"
                }
                if(!isEmptyFields) {
                    // Hitung volume balok
                    val volume: Double =
                        inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble();

                    // Tampilkan hasil perhitungan volume ke TextView -> tvResult
                    tvResult.text = String.format("Volume: %s", volume.toString());
                }
            }
            else if (view.id == R.id.btn_calculate2) {

                // Ambil nilai yang diberikan pengguna pada seluruh EditText
                val inputLength: String = etLength.text.toString().trim();
                val inputWidth: String = etWidth.text.toString().trim();
                val inputHeight: String = etHeight.text.toString().trim();

                // Validasi input
                var isEmptyFields = false
                if (inputLength.isEmpty()) {
                    isEmptyFields = true
                    etLength.error = "Field ini tidak boleh kosong"
                }
                if (inputWidth.isEmpty()) {
                    isEmptyFields = true
                    etWidth.error = "Field ini tidak boleh kosong"
                }
                if (inputHeight.isEmpty()) {
                    isEmptyFields = true
                    etHeight.error = "Field ini tidak boleh kosong"
                }
                if(!isEmptyFields) {
                    // Hitung luas permukaan
                    val luasPermukaan: Double =
                       2 * (inputLength.toDouble() * inputWidth.toDouble()  +
                                inputLength.toDouble() * inputHeight.toDouble()  +
                                inputHeight.toDouble() * inputWidth.toDouble()) ;

                    // Tampilkan hasil perhitungan luas permukaan ke TextView -> tvResult
                    tvResult.text = String.format("Luas Permukaan: %s", luasPermukaan.toString());
                }
            }
            else if (view.id == R.id.btn_calculate3) {

                // Ambil nilai yang diberikan pengguna pada seluruh EditText
                val inputLength: String = etLength.text.toString().trim();
                val inputWidth: String = etWidth.text.toString().trim();
                val inputHeight: String = etHeight.text.toString().trim();

                // Validasi input
                var isEmptyFields = false
                if (inputLength.isEmpty()) {
                    isEmptyFields = true
                    etLength.error = "Field ini tidak boleh kosong"
                }
                if (inputWidth.isEmpty()) {
                    isEmptyFields = true
                    etWidth.error = "Field ini tidak boleh kosong"
                }
                if (inputHeight.isEmpty()) {
                    isEmptyFields = true
                    etHeight.error = "Field ini tidak boleh kosong"
                }
                if(!isEmptyFields) {
                    // Hitung keliling
                    val keliling: Double =
                        (4 * inputLength.toDouble() )+ (4 * inputWidth.toDouble()) + (4 * inputHeight.toDouble());

                    // Tampilkan hasil perhitungan keliling ke TextView -> tvResult
                    tvResult.text = String.format("Keliling: %s", keliling.toString());
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val calculationResult = tvResult.text.toString()
        outState.putString(KEY_RESULT, calculationResult)
    }
}


