package com.apps.footballcare.view.video

import com.apps.footballcare.R
import com.apps.footballcare.base.view.BaseFragment
import com.apps.footballcare.databinding.FragmentVideoBinding


class VideoFragment : BaseFragment<FragmentVideoBinding, VideoViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_video
    override val classTypeOfViewModel: Class<VideoViewModel> = VideoViewModel::class.java

}