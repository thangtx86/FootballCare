package com.apps.footballcare.view.search

import androidx.recyclerview.widget.GridLayoutManager
import com.apps.footballcare.R
import com.apps.footballcare.base.view.BaseFragment
import com.apps.footballcare.databinding.FragmentSearchBinding
import com.apps.footballcare.view.video.CategoryAdapter


class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    private val categoriesAdapter: CategoryAdapter by lazy { CategoryAdapter() }

    override val layoutResourceId: Int = R.layout.fragment_search
    override val classTypeOfViewModel: Class<SearchViewModel> = SearchViewModel::class.java


    override fun initView() {
        super.initView()
        setRecycleView()
        viewModel.categories.observe(this, { categories ->
            categoriesAdapter.setCategories(categories)
        })
    }

    private fun setRecycleView() {
        binding.rvCategories.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = categoriesAdapter
        }
    }

}