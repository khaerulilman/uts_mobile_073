package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity(), FoodAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample data for the food list
        val foodList = listOf(
            Food("batagor", "Delicious cheese batagor", R.drawable.batagor),
            Food("black salad", "Juicy beef black salad", R.drawable.black_salad),
            Food("capucino", "Italian pasta with cappuccino", R.drawable.cappuchino),
            Food("cheesecake", "Rich and creamy cheesecake topped with berries", R.drawable.cheesecake),
            Food("cireng", "Crispy tapioca fritters, served with spicy sauce", R.drawable.cireng),
            Food("donut", "Soft and sweet donuts, perfect for dessert", R.drawable.donut),
            Food("kopi hitam", "Strong black coffee with a rich aroma", R.drawable.kopi_hitam),
            Food("mie goreng", "Fried noodles with vegetables and spices", R.drawable.mie_goreng),
            Food("nasi goreng", "Fried rice with chicken and vegetables", R.drawable.nasigoreng),
            Food("sparkling tea", "Refreshing sparkling tea with lemon", R.drawable.sparkling_tea)
        )


        val adapter = FoodAdapter(foodList, this)
        recyclerView.adapter = adapter

        // Set up "Pesanan Terakhir" button
        val lastOrderButton: Button = findViewById(R.id.lastOrder)
        lastOrderButton.setOnClickListener {
            val intent = Intent(this, ConfirmationActivity::class.java)
            // Optionally, pass data about the last order if available
            startActivity(intent)
        }
    }

    override fun onItemClick(food: Food) {
        // Start OrderActivity and pass the selected food name
        val intent = Intent(this, OrderActivity::class.java)
        intent.putExtra("FOOD_NAME", food.name)
        startActivity(intent)
    }
}
