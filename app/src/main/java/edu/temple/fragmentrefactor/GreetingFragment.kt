package edu.temple.fragmentrefactor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.temple.fragmentrefactor.databinding.FragmentGreetingBinding


class GreetingFragment : Fragment() {

    private var _binding: FragmentGreetingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_greeting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentGreetingBinding.bind(view)

        val message = arguments?.getString(ARG_MESSAGE) ?: "Hello World"
        binding.displayTextView.text = message
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
       private const val ARG_MESSAGE = "Message"

        fun newInstance(message: String) = GreetingFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_MESSAGE, message)
            }
        }


    }
}