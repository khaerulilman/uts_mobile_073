package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        // Retrieve order details from the OrderData object
        val foodName = OrderData.foodName
        val servings = OrderData.servings
        val orderName = OrderData.orderName
        val notes = OrderData.notes

        // Set the values in the TextViews
        findViewById<TextView>(R.id.tvFoodName).text = "Food Name: $foodName"
        findViewById<TextView>(R.id.tvServings).text = "Number of Servings: $servings"
        findViewById<TextView>(R.id.tvOrderName).text = "Ordering Name: $orderName"
        findViewById<TextView>(R.id.tvNotes).text = "Additional Notes: $notes"

        // Handle "Back to Menu" button click
        findViewById<Button>(R.id.backtoMenu).setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish() // Close ConfirmationActivity
        }
    }
}
