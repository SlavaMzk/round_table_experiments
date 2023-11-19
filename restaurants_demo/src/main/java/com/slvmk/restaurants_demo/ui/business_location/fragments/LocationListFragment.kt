package com.slvmk.restaurants_demo.ui.business_location.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.slvmk.R
import com.slvmk.databinding.LocationBusinessListBinding
import com.slvmk.restaurants_demo.ui.business_location.LocationListViewModelV2
import com.slvmk.restaurants_demo.ui.business_location.adapter.LocationBusinessAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by SlavaMk on 2/14/22.
 */
@AndroidEntryPoint
class LocationListFragment : Fragment(R.layout.location_business_list) {

    private val viewModel: LocationListViewModelV2 by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = LocationBusinessListBinding.bind(view)

        val locationListAdapter = LocationBusinessAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = locationListAdapter
            }
            searchButton.setOnClickListener {
                viewModel.fetchData(binding.searchEdittext.text.toString())
            }
            searchButton.performClick()
        }
        viewModel.apply {
            data.observe(viewLifecycleOwner) {
                locationListAdapter.submitList(it)
            }
            messageData.observe(viewLifecycleOwner) {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
            dataLoading.observe(viewLifecycleOwner) { value ->
                binding.progressBar.visibility = if (value) View.VISIBLE else View.GONE
            }
        }
    }
}

/*class GetAllBooksAndAuthorsUseCase(
    private val booksRepository: BooksRepository,
    private val authorsRepository: AuthorsRepository,
) {
    suspend fun getBookAndAuthors(): BookAndAuthors {
        // In parallel, fetch books and authors and return when both requests
        // complete and the data is ready
        return coroutineScope {
            ensureActive()
            val books = async { booksRepository.getAllBooks() }
            val authors = async { authorsRepository.getAllAuthors() }
            BookAndAuthors(books.await(), authors.await())
        }
    }
}*/
