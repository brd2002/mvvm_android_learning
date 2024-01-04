package com.example.mvvmapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.mvvmapp.R
import com.example.mvvmapp.databinding.FragmentFirstBinding
import com.example.mvvmapp.viewmodel.CountViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val countViewModel: CountViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // initialization
        // connect xml of fragment with Java  / Kotlin code
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }
    // after Fragment  / view is created you add logic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        // change YT video
        countViewModel.getMutableLiveData().observe(viewLifecycleOwner, Observer { incomingValue ->
//            Log.i("harry" , "recive value : " + incomingValue)
//            Toast.makeText(view.context , "Recieve value "+ incomingValue, Toast.LENGTH_SHORT).show()
            // Update the list UI.
            binding.textviewFirst.text = "count : " + incomingValue
        })
        binding.increment.setOnClickListener {
            countViewModel.increment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}