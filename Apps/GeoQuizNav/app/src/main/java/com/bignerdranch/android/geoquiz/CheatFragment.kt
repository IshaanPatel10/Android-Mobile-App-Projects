package com.bignerdranch.android.geoquiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.bignerdranch.android.geoquiz.databinding.FragmentCheatBinding

private const val ARG_CORRECT_ANSWER = "correct_answer"
private const val TAG = "CheatFragment"

/**
 * The Cheat Fragment.
 */
class CheatFragment : Fragment() {
    /**
     * Provides global access to these variables from anywhere in the app
     * via CheatFragment.<variable> without needing to create
     * a CheatFragment instance.
     */
    companion object {
        val CHEAT_RESULT_KEY = "cheatResultKey"
        val IS_CHEATER = "isCheater"
    }

    // This is the argument to the CheatFragment
    private var correctAnswer: Boolean = false

    private var _binding: FragmentCheatBinding? = null

    // This allows us to use the binding without dealing with the null ugliness
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "arguments in onCreate: $arguments")
        arguments?.let {
            correctAnswer = it.getBoolean(ARG_CORRECT_ANSWER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCheatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Show the answer if the user decides to see it
        binding.showAnswerButton.setOnClickListener {
            val textVal = when {
                correctAnswer -> R.string.true_button
                else -> R.string.false_button
            }
            binding.answerTextView.setText(textVal)

            // Send the cheat result when the answer is shown
            setFragmentResult(CHEAT_RESULT_KEY, bundleOf(IS_CHEATER to true))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}