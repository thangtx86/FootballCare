package com.apps.footballcare.view.home

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.apps.footballcare.R
import com.apps.footballcare.base.view.BaseFragment
import com.apps.footballcare.databinding.FragmentHomeBinding
import com.apps.footballcare.utils.Resource
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
const val BUNDLE_IMAGE_TYPE: String = "BUNDLE_IMAGE_TYPE"

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val layoutResourceId: Int = R.layout.fragment_home
    override val classTypeOfViewModel: Class<HomeViewModel>
        get() = HomeViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        super.initView()
    }


    override fun initStartRequest() {
        super.initStartRequest()
//        viewModel.getLeaguesBySeasons()
    }

    override fun setUpViewModelStateObservers() {
        super.setUpViewModelStateObservers()

        viewModel.hits.observe(this, { hit ->
            when (hit.status) {
                Resource.Status.SUCCESS -> {
                    dismissProgress()
                    Timber.e("" + hit.data)
                }
                Resource.Status.LOADING -> {
                    showProgress()
                }
                Resource.Status.ERROR -> {
                    dismissProgress()
                    Timber.e(hit.message)
                    Toast.makeText(context, hit.message, Toast.LENGTH_LONG).show()
                }
            }

        })

    }

    override fun setupClickListeners() {
        super.setupClickListeners()
//        hitsAdapter.onPhotoItemClick = { item ->
//            val mainNavController =
//                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
//            val action = ViewPagerContainerFragmentDirections.actionViewPagerToPhotoDetail(item)
//            mainNavController.navigate(action)
//        }
    }

    private fun setupRecyclerView() {
//        binding.list.apply {
//            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//            setHasFixedSize(true)
//            adapter = hitsAdapter
//        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(BUNDLE_IMAGE_TYPE, param)
                }
            }
    }
}