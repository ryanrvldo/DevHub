package com.ryanrvldo.devhub.main.home

import android.content.Context
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ryanrvldo.devhub.BaseApplication
import com.ryanrvldo.devhub.R
import com.ryanrvldo.devhub.core.ui.BaseFragment
import com.ryanrvldo.devhub.core.ui.ViewModelFactory
import com.ryanrvldo.devhub.databinding.FragmentHomeBinding
import com.ryanrvldo.devhub.main.MainViewModel
import com.ryanrvldo.devhub.util.GreetingsUtil
import javax.inject.Inject

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding()

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: MainViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as BaseApplication).appComponent.inject(this)
    }

    override fun initLoadingContent() {
        super.loadingContent = binding.contentLoading.root
    }

    override fun observeLiveData() {
        viewModel.userDetails.observe(requireActivity()) { value ->
            onHandleLiveDataValue(value) { user ->
                binding.tvUserFullName.text = user.name
                binding.tvGreetings.text = GreetingsUtil.getGreetings(requireContext())
            }
        }
    }

}
