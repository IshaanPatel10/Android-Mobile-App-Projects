package com.bignerdranch.android.geoquiz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.geoquiz.databinding.FragmentQuestionBinding

private const val TAG = "QuestionFragment"
private const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

/**
 * The QuestionFragment is the start destination.
 */
class QuestionFragment : Fragment() {
    // TODO Use view binding in fragments:
    //  https://developer.android.com/topic/libraries/view-binding#fragments
    private var _binding: FragmentQuestionBinding? = null
    private var isQuestionAnswered = false

    // TODO This property is only valid between onCreateView and
    //  onDestroyView.
    private val binding get() = _binding!!

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true),
        Question(R.string.question_amazon, true),
        Question(R.string.question_greatWall, false),
        Question(R.string.question_antartica, true),
        Question(R.string.question_sahara, true),
        Question(R.string.question_everest, true),
        Question(R.string.question_equator, true),
        Question(R.string.question_russia, true),
        Question(R.string.question_us, true),
        Question(R.string.question_pacific, true),
        Question(R.string.question_deadSea, true),
        Question(R.string.question_nile, true),
        Question(R.string.question_australia2, true),
    )
    private var currentIndex = 0
    private var correct = 0
    private var isCheater = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO Pass results between fragments
        //  https://developer.android.com/guide/fragments/communicate#fragment-result
        //  The listener will receive the result from the CheatFragment
        //  The request key must be the same in both fragments
        setFragmentResultListener(CheatFragment.CHEAT_RESULT_KEY) { _, bundle ->
            // We use a Boolean here, but any type that can be put in a Bundle is supported.
            isCheater = bundle.getBoolean(CheatFragment.IS_CHEATER)
            Log.d(TAG, "isCheater: $isCheater")
        }
    }

    // TODO It is recommended to only inflate the layout in this method
    //  and move logic that operates on the returned View to onViewCreated(View, Bundle).
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    // TODO This gives subclasses a chance to initialize themselves once
    //  they know their view hierarchy has been completely created.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO Saved instance state should be restored here after view is created.
        if (savedInstanceState != null) {
            Log.d(TAG, "savedInstanceState is set.")
            currentIndex = savedInstanceState.getInt(CURRENT_INDEX_KEY, 0)
        }
        binding.questionText.setText(questionBank[currentIndex].testResId)

        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            binding.questionText.setText(questionBank[currentIndex].testResId)
            binding.trueButton.isEnabled = true;
            binding.falseButton.isEnabled = true;


        }
        binding.previousButton.setOnClickListener {
            currentIndex = (currentIndex - 1) % questionBank.size
            binding.questionText.setText(questionBank[currentIndex].testResId)
            binding.trueButton.isEnabled = false;
            binding.falseButton.isEnabled = false;

        }

        binding.questionText.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            binding.questionText.setText(questionBank[currentIndex].testResId)

        }

        binding.trueButton.setOnClickListener {
            checkAnswer(true)
            binding.trueButton.isEnabled = false;
            binding.falseButton.isEnabled = false;
            binding.correct.text = "Correct: " + correct + "/22";
        }

        binding.falseButton.setOnClickListener {
            checkAnswer(false)
            binding.falseButton.isEnabled = false;
            binding.trueButton.isEnabled = false;
            binding.correct.text = "Correct: " + correct + "/22";
        }

        binding.cheatButton.setOnClickListener {
            // TODO Navigate to the CheatFragment passing the answer as an argument
            val answer = questionBank[currentIndex].answer
            val action =
                QuestionFragmentDirections.actionQuestionFragmentToCheatFragment(answer)
            this.findNavController().navigate(action)
        }

    }

    // TODO Called when the view previously created by onCreateView
    //  has been detached from the fragment.
    override fun onDestroyView() {
        super.onDestroyView()
        // The view binding is no longer valid because the view is detached from the fragment
        _binding = null
    }

    // Save data between configuration changes.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
        outState.putInt(CURRENT_INDEX_KEY, this.currentIndex)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val resId = when {
            isCheater -> R.string.judgment_toast
            userAnswer == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
        }
        isCheater = false
        if(userAnswer == correctAnswer){
            correct++;

        }

        Toast.makeText(this.context, resId, Toast.LENGTH_SHORT).show()
    }

}