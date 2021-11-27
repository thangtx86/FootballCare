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
    private var leaguesSelected: MutableList<Response> = mutableListOf()

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
        setupRecyclerView()
    }

    override fun initStartRequest() {
        super.initStartRequest()
        viewModel.getLeaguesBySeasons()
    }

    override fun setupClickListeners() {
        super.setupClickListeners()
        leagueAdapter.onLeagueItemClick = {
            if (leaguesSelected.isNotEmpty()) {
                leaguesSelected.clear()
            }
            leaguesSelected.addAll(it)
        }
        binding.buttonNext.setOnClickListener {
            Timber.e("" + leaguesSelected?.size)
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
                    Timber.e("" + response.data)
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

    }


}