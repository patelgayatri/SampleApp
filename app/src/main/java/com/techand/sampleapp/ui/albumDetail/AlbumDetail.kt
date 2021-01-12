package com.techand.sampleapp.ui.albumDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.techand.sampleapp.databinding.FragmentDetailBinding
import com.techand.sampletest.data.models.Album
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumDetail : Fragment() {

    private lateinit var viewDataBinding: FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return viewDataBinding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        hideTitle()
        setData()
    }

    private fun hideTitle() {
        val toolbar = (requireActivity() as AppCompatActivity).supportActionBar
        toolbar?.hide()
    }


    private fun setData() {
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        if (arguments != null) {
            val album = arguments?.getSerializable("detail") as Album
            viewDataBinding.album = album
        }
    }

}