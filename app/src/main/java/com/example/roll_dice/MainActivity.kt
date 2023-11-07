package com.example.roll_dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.example.roll_dice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding(layoutInflater)
        setContentView(binding.root)
        var items = mutableListOf<ItemEmail>()
        repeat(20) {
            items.add(
                ItemEmail(
                    "Support",
                    "12:34 PM",
                    "Siêu mạnh mẽ với chip M3, M3 Pro hoặc M3 Max — dòng chip tiên tiến nhất từng được thiết kế cho máy tính cá nhân. Màn hình máy tính xách tay cực đỉnh. Thời lượng pin lên đến 22 giờ.1 Nay có màu Đen Không Gian."
                )
            )
        }
        val adapter = Adapter(items)
        binding.rcv.adapter = adapter
    }


    private fun getViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }
}