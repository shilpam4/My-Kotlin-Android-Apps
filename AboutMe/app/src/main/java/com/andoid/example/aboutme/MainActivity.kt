package com.andoid.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.andoid.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val myName : MyName = MyName("Shilpam Rawat")
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(activity_main)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        binding.myName = myName
//        findViewById<Button>(R.id.done_button).setOnClickListener {
        binding.doneButton.setOnClickListener { addNickName(it) }
//    }
    }

    private fun addNickName(view: View) {
//      val editText = findViewById<EditText>(R.id.nickName_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nicknames_text)
//            nicknameTextView.text = editText.text
//            editText.visibility = View.GONE
//            view.visibility = View.GONE
//            nicknameTextView.visibility = View.VISIBLE

        binding.apply {
            myName?.nickName = nickNameEdit.text.toString()
            invalidateAll()
            nickNameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknamesText.visibility = View.VISIBLE
        }
            //hide keyboard
            val inn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inn.hideSoftInputFromWindow(view.windowToken, 0)
    }
}