package com.example.fitnesskit.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnesskit.databinding.FragmentTimetableBinding
import com.example.fitnesskit.presentation.FitnessApp
import com.example.fitnesskit.presentation.TimetableViewModel
import com.example.fitnesskit.presentation.ViewModelFactory
import com.example.fitnesskit.presentation.adapter.TimetableAdapter
import javax.inject.Inject

class TimetableFragment : Fragment() {

    private var _binding: FragmentTimetableBinding? = null
    private val binding: FragmentTimetableBinding
        get() = _binding ?: throw RuntimeException("FragmentTimetableBinding == null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: TimetableViewModel

    private lateinit var adapter: TimetableAdapter

    private val component by lazy {
        (requireActivity().application as FitnessApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTimetableBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[TimetableViewModel::class.java]

        viewModel.getFitnessTimetable()

        viewModel.timetableInfo.observe(viewLifecycleOwner) {
            adapter = TimetableAdapter()
            with(binding){
                rvTimetable.layoutManager = LinearLayoutManager(context)
                rvTimetable.adapter = adapter
                adapter.submitList(it)
            }
        }

        viewModel.progressBar.observe(viewLifecycleOwner){
            binding.progressBar.isVisible = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): Fragment {
            return TimetableFragment()
        }
    }
}