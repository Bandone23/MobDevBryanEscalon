package com.example.bryanescalonamobdev.ui.fragment


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.example.bryanescalonamobdev.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_img.*

/**
 * A simple [Fragment] subclass.
 */
class ImgFragment : DialogFragment() {
    private var imageUrl: String? = null

    companion object {

        fun newInstance(content: String): ImgFragment {
            val dialogFragment = ImgFragment()
            val args = Bundle()
            args.putString(URL, content)
            dialogFragment.arguments = args

            return dialogFragment
        }

        private const val URL = "imageUrl"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageUrl = arguments?.getString(URL)
        val style = STYLE_NO_FRAME
        val theme = R.style.FullScreenDialogStyle
        setStyle(style, theme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_img, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (imageUrl != null) {
            progress_circular_img.visibility = View.VISIBLE
            Picasso.get()
                .load(Uri.parse(imageUrl))
                .resize(300, 300)//size not yet defined
                .centerCrop()
                .into(userPicture, object : Callback {

                    override fun onSuccess() {
                        progress_circular_img.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        progress_circular_img.visibility = View.GONE
                    }
                })

        }
        ivClose.setOnClickListener { dismiss() }
    }



}
