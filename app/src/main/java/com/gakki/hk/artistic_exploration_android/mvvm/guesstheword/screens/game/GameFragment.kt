/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gakki.hk.artistic_exploration_android.mvvm.guesstheword.screens.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.gakki.hk.artistic_exploration_android.R
import com.gakki.hk.artistic_exploration_android.databinding.GameFragmentBinding

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {

    private lateinit var binding: GameFragmentBinding

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.game_fragment,
            container,
            false
        )
        //创建viewModel
        Log.i("GameFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        // Set the viewmodel for databinding - this allows the bound layout access to all the data in the ViewModel
        binding.gameViewModel = viewModel
        //注意：使用viewLifecycleOwner，离开当前fragment时view会销毁，而fragment可能不会销毁
        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
            binding.scoreText.text = newScore.toString()
        })
        viewModel.word.observe(viewLifecycleOwner, Observer { newWord ->
            binding.wordIsText.text = newWord
        })
        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer { isFinish ->
            if (isFinish){
                gameFinished()
            }
        })
        return binding.root
    }

    private fun gameFinished() {
        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()
        val actionGameToScore = GameFragmentDirections.actionGameToScore()
        actionGameToScore.score = viewModel.score.value ?: 0
        findNavController().navigate(actionGameToScore)
        //注意：当观察者从inactive到active时会接收到通知，所以需要重置finish状态
        viewModel.onGameFinishComplete()
    }
}
