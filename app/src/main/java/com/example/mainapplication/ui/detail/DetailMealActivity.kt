package com.example.mainapplication.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mainapplication.R
import com.example.mainapplication.core.DetailMealModel
import com.example.mainapplication.domain.DetailRepository
import com.example.mainapplication.utils.State
import kotlinx.android.synthetic.main.activity_detail_meal.*

class DetailMealActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_meal)

        viewModel = ViewModelProvider(this, DetailViewModelFactory(DetailRepository())).get(DetailViewModel::class.java)
        val i = intent.getStringExtra(ID)
        i?.let {
            viewModel.getDetailMeal(it)
            init()
        }
    }

    private fun init() {
        observers()
    }

    private fun observers() {
        viewModel.meal.observe(this, Observer {
            when(val state = it) {
                is State.DetailSuccessState -> {
                    setIngredient(state.value.meals[0])
                }
                is State.ErrorState -> {
                    //Nothing here
                }
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun setIngredient(model: DetailMealModel) {
        textName.text = "Name: ${model.strMeal}"

        if (model.strYoutube.isNotEmpty()) {
            textVideo.text = "Youtube: ${model.strYoutube}"
            textVideo.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(model.strYoutube)
                intent.setPackage("com.google.android.youtube")
                startActivity(intent)
            }
        }

        textIngredients.visibility = View.VISIBLE

        model.strIngredient1?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient2?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient3?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient4?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient5?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient6?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient7?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient8?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient9?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient10?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient11?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient12?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient13?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient14?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient15?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient16?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient17?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient18?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient19?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }

        model.strIngredient20?.let {
            val textView = TextView(this).apply {
                text = "- $it"
            }
            linearContainer.addView(textView)
        }
    }

    companion object {
        private const val ID = "ID"
    }
}