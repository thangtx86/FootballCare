package com.apps.footballcare.view.league.choose_league

import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.apps.footballcare.R
import com.apps.footballcare.base.view.BaseFragment
import com.apps.footballcare.data.remote.model.Response
import com.apps.footballcare.databinding.FragmentChooseLeagueBinding
import com.apps.footballcare.utils.Resource
import com.apps.footballcare.view.league.choose_league.adapter.LeagueAdapter
import timber.log.Timber
import java.sql.Time

class ChooseLeagueFragment : BaseFragment<FragmentChooseLeagueBinding, ChooseLeagueViewModel>() {
    private val leagueAdapter by lazy { LeagueAdapter() }
//    private var leaguesSelected: MutableList<Response> = mutableListOf()

    override val layoutResourceId: Int = R.layout.fragment_choose_league
    override val classTypeOfViewModel: Class<ChooseLeagueViewModel> =
        ChooseLeagueViewModel::class.java

    private fun setupRecyclerView() {
        binding.rvLeagues.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = leagueAdapter
        }
    }

    override fun initView() {
        super.initView()
        binding.viewModel = viewModel
        setupRecyclerView()
    }

    override fun initStartRequest() {
        super.initStartRequest()
    }

    override fun setupClickListeners() {
        super.setupClickListeners()
        leagueAdapter.onLeagueItemClick = {
            viewModel.onLeagueItemSelected(it)
        }
    }

    override fun setUpViewModelStateObservers() {
        super.setUpViewModelStateObservers()

        viewModel.response.observe(this, { response ->
            when (response.status) {
                Resource.Status.SUCCESS -> {
                    dismissProgress()
                    response.data?.let {
                        leagueAdapter.submitList(response.data)
                    }
                }
                Resource.Status.LOADING -> {
                    showProgress()
                }
                Resource.Status.ERROR -> {
                    dismissProgress()
                    Timber.e(response.message)
                    Toast.makeText(context, response.message, Toast.LENGTH_LONG).show()
                }
            }

        })
        viewModel.events.observe(this, { event ->
            event.getContentIfNotHandled()?.let {
                handleAction(it)
            }
        })

    }

    private fun handleAction(response: List<Response>) {
        Toast.makeText(context, "" + response.size, Toast.LENGTH_LONG).show()
    }


}