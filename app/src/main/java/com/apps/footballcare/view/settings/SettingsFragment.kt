package com.apps.footballcare.view.settings

import com.apps.footballcare.R
import com.apps.footballcare.base.view.BaseFragment
import com.apps.footballcare.databinding.FragmentSettingsBinding


class SettingsFragment : BaseFragment<FragmentSettingsBinding, SettingsViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_settings
    override val classTypeOfViewModel: Class<SettingsViewModel> = SettingsViewModel::class.java

}