package ru.cespaul.fstarthome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        to_task2_button.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_a)
        }

        to_task3_button.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_task3)
        }

        to_task5_button.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_task5)
        }
    }
}