package com.example.popcorn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.popcorn.adapters.*
import com.example.popcorn.databinding.FilmItemBinding
import com.example.popcorn.databinding.FragmentFavouriteBinding
import com.example.popcorn.viewmodels.FavouriteViewModel
import com.example.popcorn.viewmodels.ItemsModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movies.view.*

@AndroidEntryPoint
class FavouriteFragment : Fragment() {

    private val favouriteViewModel : FavouriteViewModel by viewModels()
    private lateinit var binding: FragmentFavouriteBinding

    private val adapter =
        SimpleListAdapter(
            HolderCreator(::createHolder),
            HolderBinder(::bindHolder),
            ArticleDiffCallback()
        )


    private fun createHolder(parent: ViewGroup) : Holder<FilmItemBinding> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FilmItemBinding.inflate(inflater, parent, false)
        return Holder(binding)
    }

    private fun bindHolder(model: ItemsModel, holder: Holder<FilmItemBinding>) {
        holder.binding.viewModel = model
        holder.binding.favouriteViewModel = favouriteViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourite, container, false)
        binding.viewModel = favouriteViewModel
        binding.lifecycleOwner =  viewLifecycleOwner
        binding.newsList.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var allArticles = listOf<ItemsModel>()
        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.sort,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinner.adapter = adapter
            }
        }

        binding.deleteButton.setOnClickListener{
            favouriteViewModel.clearTable()
            favouriteViewModel.articles.observe(viewLifecycleOwner) {
                adapter.submitList(allArticles)
            }
        }

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                favouriteViewModel.articles.observe(viewLifecycleOwner) { articles ->
                    allArticles = articles.sortedBy {
                        when (position) {
                            0 -> (it.rank)              // по популярности
                            1 -> (it.fullTitle)         // по алфавиту
                            2 -> (it.rank)              // по рейтингу
                            3 -> (it.imDbRatingCount)   // по количеству оценок
                            else -> {
                                (it.rank)
                            }
                        }
                    }
                    adapter.submitList(allArticles)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.newsSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if (query != null) {
                    adapter.submitList(allArticles.filter { article ->
                        article.fullTitle.contains(query, ignoreCase = true)
                    })
                } else adapter.submitList(allArticles)
                return true
            }
        })
    }

}