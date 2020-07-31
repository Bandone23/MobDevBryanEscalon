package com.example.bryanescalonamobdev.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bryanescalonamobdev.R
import com.example.bryanescalonamobdev.domain.model.Breeds
import com.example.bryanescalonamobdev.domain.model.BreedsImg
import com.example.bryanescalonamobdev.presentation.viewmodel.BreedsViewModel
import com.example.bryanescalonamobdev.ui.adapter.BreedsAdapter
import com.example.bryanescalonamobdev.ui.adapter.name
import com.example.bryanescalonamobdev.ui.fragment.ImgFragment
import com.example.bryanescalonamobdev.ui.interfaces.onClikViewModel
import com.example.core.coroutines.Result
import com.example.core.extension.observe
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_breeds.*
import org.jetbrains.anko.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    private val viewModel: BreedsViewModel by viewModel()
    private val animals: ArrayList<String> = ArrayList()
    lateinit var mBreedsAdapter: BreedsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //  viewModel.initAdapter {animals, viewId: Int -> breedsClicked(animals, viewId) }
        with(viewModel) {
            observe(breedsLiveData, ::breedsObserver)
            observe(breedsImgLiveData, ::breedsImgObserver)
        }

        viewModel.getBreeds()

    }

    private fun breedsObserver(result: Result<Breeds>?) {
        when (result) {
            is Result.OnSuccess -> {
                progress_circular_img.visibility = View.GONE
                rv_animal_list.visibility = View.VISIBLE


                if (result.value.message.isNotEmpty()) {
                    addAnimals(result.value.message)

                    initBreedsAdapter()

                } else {

                }
            }
            is Result.OnLoading -> {

                progress_circular_img.visibility = View.VISIBLE
            }
            is Result.OnError -> onError()
            else -> onUnexpectedError()
        }
    }

    private fun breedsImgObserver(result: Result<BreedsImg>?) {
        when (result) {
            is Result.OnSuccess -> {
                progress_circular_img.visibility = View.GONE
                if (result.value.message.isNotEmpty()) {

                    showFullScreenImage(result.value.message)

                } else {

                }
            }
            is Result.OnLoading -> {
                progress_circular_img.visibility = View.VISIBLE
            }
            is Result.OnError -> onError()
            else -> onUnexpectedError()
        }
    }

    private fun  addAnimals(breeds: List<String>) {
        for (item in breeds.indices) {
            animals.add(breeds[item])
        }
    }

    private fun initBreedsAdapter() {
        mBreedsAdapter = BreedsAdapter(animals) { animals, viewId: Int -> breedsClicked(animals, viewId) }
        rv_animal_list.layoutManager = LinearLayoutManager(this)
        rv_animal_list.adapter = mBreedsAdapter

    }

    private fun showFullScreenImage(photoUrl: String) {
        val dialog = ImgFragment.newInstance(photoUrl)
        dialog.show(supportFragmentManager, "showImage")
    }



    private fun breedsClicked(breeds: String, viewId: Int) {
        when (viewId) {
            R.id.container_card -> {
                toast("dato :$breeds")
                viewModel.getBreedsImg(breeds)

            }
        }
    }
}
