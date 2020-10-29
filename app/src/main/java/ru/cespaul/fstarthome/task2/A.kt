package ru.cespaul.fstarthome.task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_a.*
import ru.cespaul.fstarthome.R

class A : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController: NavController = Navigation.findNavController(view)

        to_main_screen_button.setOnClickListener {
            navController.navigate(R.id.action_a_to_mainFragment)
        }

        to_b_button.setOnClickListener {
            navController.navigate(R.id.action_a_to_b)
        }
    }
}