package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val foodName = intent.getStringExtra("FOOD_NAME")
        val etFoodName: TextView = findViewById(R.id.etFoodName)
        etFoodName.text = foodName ?: "No Food Selected"

        val etServings: EditText = findViewById(R.id.etServings)
        val etName: EditText = findViewById(R.id.etName)
        val etNotes: EditText = findViewById(R.id.etNotes)
        val btnOrder: Button = findViewById(R.id.btnOrder)

        btnOrder.setOnClickListener {
            // Store order details in the singleton object
            OrderData.foodName = foodName
            OrderData.servings = etServings.text.toString()
            OrderData.orderName = etName.text.toString()
            OrderData.notes = etNotes.text.toString()

            // Create intent to navigate to ConfirmationActivity
            val intent = Intent(this, ConfirmationActivity::class.java)
            startActivity(intent)
        }


    }
}

object OrderData {
    var foodName: String? = null
    var servings: String? = null
    var orderName: String? = null
    var notes: String? = null
}