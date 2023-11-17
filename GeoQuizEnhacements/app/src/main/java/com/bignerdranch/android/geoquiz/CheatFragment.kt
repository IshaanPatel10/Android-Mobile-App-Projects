package com.example.wordsapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.geoquiz.R
import com.bignerdranch.android.geoquiz.databinding.ActivityMainBinding
import com.bignerdranch.android.geoquiz.databinding.FragmentCheatBinding

class CheatFragment : Fragment() {

    companion object{
        val CHEAT_RESULT_KEY = "cheatResultKey"
        val IS_CHEATER = "isCheater"
    }

    private var _binding: FragmentCheatBinding? = null

    private lateinit var recyclerView: RecyclerView
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheatBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        chooseLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    binding.showAnserButton.setOnClickListerner{
        val textVal = when {
            correctAnswer -> R.string.false_button
        }
        setFragmentResult(CHEAT_RESULT_KEY, bundleOf(IS_CHEATER to true))
    }





}
