package com.techand.sampleapp.ui.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.techand.sampleapp.R
import com.techand.sampleapp.databinding.FragmentAlbumBinding
import com.techand.sampleapp.ui.ViewModel
import com.techand.sampleapp.utils.Resource
import com.techand.sampletest.data.models.Album
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumFragment : Fragment(), AlbumAdapter.Listener {

    private val viewModel by viewModels<ViewModel>()
    private lateinit var viewDataBinding: FragmentAlbumBinding
    private lateinit var adapter: AlbumAdapter
    var albumId: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = FragmentAlbumBinding.inflate(inflater, container, false)
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setTitle()
        setUpListAdapter()
        setData()

    }


    private fun setTitle() {
        if (arguments != null) {
            albumId = arguments?.getInt("ID")!!
        }
        val toolbar = (requireActivity() as AppCompatActivity).supportActionBar
        toolbar?.title = "Album ID: $albumId"
        toolbar?.show()
    }

    private fun setUpListAdapter() {
        val recyclerView = viewDataBinding.recyclrAlbum
        recyclerView.layoutManager = LinearLayoutManager(this.requireActivity())
        adapter = AlbumAdapter(arrayListOf(), this)
        recyclerView.adapter = adapter
    }

    private fun setData() {
        viewModel.getPhotos(albumId).observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        resource.data?.let {
                            retrieveList(it.body()!!)
                            viewDataBinding.progressBar.visibility = View.GONE
                        }
                    }
                    Resource.Status.ERROR -> {
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                        viewDataBinding.progressBar.visibility = View.GONE

                    }
                    Resource.Status.LOADING -> {
                        viewDataBinding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun retrieveList(albums: List<Album>) {
        adapter.apply {
            addPhotos(albums)
            notifyDataSetChanged()
        }
    }

    override fun onItemClick(album: Album, position: Int) {
        val bundle = bundleOf(Pair("detail", album))
        findNavController().navigate(R.id.action_Album_to_Deatil, bundle)
    }
}