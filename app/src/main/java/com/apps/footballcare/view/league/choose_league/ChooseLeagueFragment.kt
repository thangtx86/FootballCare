package com.apps.footballcare.view.league.choose_league

import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
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

const val NEXT_ACTION: String = "NEXT"
const val SKIP_ACTION: String = "SKIP"

class ChooseLeagueFragment : BaseFragment<FragmentChooseLeagueBinding, ChooseLeagueViewModel>() {
    private val leagueAdapter by lazy { LeagueAdapter() }

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
        viewModel.getLeaguesBySeasons()
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

    private fun handleAction(action: String) {
        when (action) {
            NEXT_ACTION -> {
                val actionNav = ChooseLeagueFragmentDirections.actionNavigateChooseTeam()
                findNavController().navigate(actionNav)
            }
            SKIP_ACTION ->{
                val actionNav = ChooseLeagueFragmentDirections.actionNavigateChooseTeam()
                findNavController().navigate(actionNav)
            }

        }
    }


}