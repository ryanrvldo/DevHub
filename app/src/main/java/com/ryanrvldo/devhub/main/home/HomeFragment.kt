package com.ryanrvldo.devhub.main.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.ryanrvldo.devhub.BaseApplication
import com.ryanrvldo.devhub.core.ui.BaseFragment
import com.ryanrvldo.devhub.core.ui.EventsAdapter
import com.ryanrvldo.devhub.core.ui.ViewModelFactory
import com.ryanrvldo.devhub.core.util.Constants
import com.ryanrvldo.devhub.databinding.FragmentHomeBinding
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory
    private val homeViewModel: HomeViewModel by viewModels { factory }

    private lateinit var eventsAdapter: EventsAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as BaseApplication).appComponent.inject(this)
        val username = arguments?.getString(Constants.USERNAME_EXTRA) ?: ""
        if (username.isNotEmpty()) {
            homeViewModel.setUsernameValue(username)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSwipeRefreshLayout()
        setupEventsRecyclerView()
    }

    private fun setupEventsRecyclerView() {
        with(binding.rvEvents) {
            eventsAdapter = EventsAdapter()
            layoutManager = LinearLayoutManager(requireContext())
            adapter = eventsAdapter
        }
        eventsAdapter.addLoadStateListener { loadStates ->
            when (loadStates.refresh) {
                is LoadState.Loading -> binding.swipeRefreshLayout.isRefreshing = true
                is LoadState.NotLoading -> binding.swipeRefreshLayout.isRefreshing = false
                is LoadState.Error -> {
                    val state = loadStates.refresh as LoadState.Error
                    showSnackbar(state.error.message.toString())
                    if (binding.root.isRefreshing) {
                        binding.root.isRefreshing = false
                    }
                }
            }
        }
    }

    private fun setupSwipeRefreshLayout() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = true
            eventsAdapter.retry()
            eventsAdapter.refresh()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    override fun initLoadingContent() {
        super.loadingContent = binding.swipeRefreshLayout
    }

    override fun observeLiveData() {
        homeViewModel.events.observe(viewLifecycleOwner) { value ->
            value?.let {
                eventsAdapter.submitData(lifecycle, it)
            }
        }
    }

}
