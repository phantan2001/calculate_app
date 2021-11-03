package iuh_ad.phannguyentrongtan.msv_19502821.a16_phannguyentrongtan_ad_midtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private var gross: Double = 0.0
    private var taxRate: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun calcTax() {
            val txtInput = gross_income_edit_text.text.toString()

            if (txtInput != "") {
                gross = txtInput.toDouble()

                taxRate = when {
                    radio1.isChecked -> 0.25
                    radio2.isChecked -> 0.2
                    else -> 0.15
                }

                val net_income = gross * (1 - taxRate)
                val formattedNetIncome =
                    NumberFormat.getCurrencyInstance().format(net_income)


                income.text = "Net Income: $${net_income.toString()}"
            } else {
                Toast.makeText(this, "Input gross income", Toast.LENGTH_SHORT).show()
            }


        }

        button.setOnClickListener() {
            calcTax()
            Toast.makeText(this, gross.toString(), Toast.LENGTH_SHORT).show()
        }


    }

}