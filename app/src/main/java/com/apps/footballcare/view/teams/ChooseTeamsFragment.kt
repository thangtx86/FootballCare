package com.apps.footballcare.view.teams

import com.apps.footballcare.R
import com.apps.footballcare.base.view.BaseFragment
import com.apps.footballcare.databinding.FragmentChooseTeamsBinding

class ChooseTeamsFragment : BaseFragment<FragmentChooseTeamsBinding, ChooseTeamsViewModel>() {


    override val layoutResourceId: Int
        get() = R.layout.fragment_choose_teams
    override val classTypeOfViewModel: Class<ChooseTeamsViewModel>
        get() = ChooseTeamsViewModel::class.java


}