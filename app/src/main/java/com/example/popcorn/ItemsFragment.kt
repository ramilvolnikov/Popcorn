package com.example.popcorn

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.popcorn.databinding.FragmentItemsBinding
import com.example.popcorn.viewmodels.FavouriteViewModel
import com.example.popcorn.viewmodels.InfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_items.view.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ItemsFragment : Fragment() {

    private val args: ItemsFragmentArgs by navArgs()
    private val infoViewModel : InfoViewModel by viewModels()
    val favouriteViewModel : FavouriteViewModel by viewModels()

    private lateinit var binding: FragmentItemsBinding

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_items, container, false)
        binding.lifecycleOwner =  viewLifecycleOwner
        binding.viewModel = args.item
        var trailerLink = ""

        lifecycleScope.launch {
            binding.plot = infoViewModel.getPlot(args.item.id)
            binding.releaseDate = infoViewModel.getReleaseDate(args.item.id)
            trailerLink = infoViewModel.getTrailer(args.item.id)
        }

        binding.root.trailerBtn.setOnClickListener{
            val watchTrailer = Intent(Intent.ACTION_VIEW, Uri.parse(trailerLink))
            requireContext().startActivity(watchTrailer)
        }

        return binding.root
    }
}