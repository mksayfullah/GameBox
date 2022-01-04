package com.domesoft.gameboxlibrary.util

import com.domesoft.gameboxlibrary.quizer.Option
import com.domesoft.gameboxlibrary.quizer.Quiz
import java.util.*
import java.util.Collections.shuffle
import kotlin.random.Random

class RandomizeQuiz {

    private val randomizeOptionList = mutableListOf<Quiz>()
    private val randomizedQuestionList = mutableListOf<Quiz>()

    fun randomizeOption(quizList: List<Quiz>): List<Quiz>{

        for (item in quizList) {
            val requiredOptionSequence = createOptionSequence()
            val requiredOption1 = requiredOptionSequence[0]
            val requiredOption2 = requiredOptionSequence[1]
            val requiredOption3 = requiredOptionSequence[2]
            val requiredOption4 = requiredOptionSequence[3]
            val requiredOption5 = requiredOptionSequence[4]
            addItem(
                requiredOption1,
                requiredOption2,
                requiredOption3,
                requiredOption4,
                requiredOption5,
                item
            )
        }

        return randomizeOptionList
    }

    private fun createOptionSequence(): MutableList<Int> {
        val options = mutableListOf<Int>()


        when (val option1 = Random.nextInt(1, 5)) {
            1 -> {
                options.add(0, 1)
                val option2 = add2ndOptions(1)
                options.add(1, option2)
                val option3 = add3rdOption(option1, option2)
                options.add(2, option3)
                val option4 = add4thOption(option1, option2, option3)
                options.add(3, option4)
                val option5 = add5thOption(option1, option2, option3, option4)
                options.add(4, option5)

            }
            2 -> {
                options.add(0, 2)
                val option2 = add2ndOptions(2)
                options.add(1, option2)
                val option3 = add3rdOption(option1, option2)
                options.add(2, option3)
                val option4 = add4thOption(option1, option2, option3)
                options.add(3, option4)
                val option5 = add5thOption(option1, option2, option3, option4)
                options.add(4, option5)
            }
            3 -> {
                options.add(0, 3)
                val option2 = add2ndOptions(3)
                options.add(1, option2)
                val option3 = add3rdOption(option1, option2)
                options.add(2, option3)
                val option4 = add4thOption(option1, option2, option3)
                options.add(3, option4)
                val option5 = add5thOption(option1, option2, option3, option4)
                options.add(4, option5)
            }
            4 -> {
                options.add(0, 4)
                val option2 = add2ndOptions(4)
                options.add(1, option2)
                val option3 = add3rdOption(option1, option2)
                options.add(2, option3)
                val option4 = add4thOption(option1, option2, option3)
                options.add(3, option4)
                val option5 = add5thOption(option1, option2, option3, option4)
                options.add(4, option5)
            }
            5 -> {
                options.add(0, 5)
                val option2 = add2ndOptions(5)
                options.add(1, option2)
                val option3 = add3rdOption(option1, option2)
                options.add(2, option3)
                val option4 = add4thOption(option1, option2, option3)
                options.add(3, option4)
                val option5 = add5thOption(option1, option2, option3, option4)
                options.add(4, option5)
            }
        }
        return options
    }

    private fun add2ndOptions(option1: Int): Int {
        val option2 = when (option1) {
            1 -> {
                Random.nextInt(2, 5)
            }
            2 -> {
                Random.nextInt(3, 5)
            }
            3 -> {
                Random.nextInt(1, 2)
            }
            4 -> {
                Random.nextInt(1, 3)
            }
            5 -> {
                Random.nextInt(1,4)
            }
            else -> 0
        }
        return option2
    }

    private fun add3rdOption(option1: Int, option2: Int): Int {
        val option3 = when (option1) {
            1 -> {
                when (option2) {
                    2 -> {
                        Random.nextInt(3, 5)
                    }
                    3 -> {
                        Random.nextInt(4, 5)
                    }
                    4 -> {
                        Random.nextInt(2, 3)
                    }
                    5 -> {
                        Random.nextInt(2,4)
                    }
                    else -> 0
                }
            }
            2 -> {
                when (option2) {
                    1 -> {
                        Random.nextInt(3, 5)
                    }
                    3 -> {
                        Random.nextInt(4, 5)
                    }
                    4 -> {
                        3
                    }
                    5 -> {
                        Random.nextInt(3, 4)
                    }
                    else -> 0
                }
            }
            3 -> {
                when (option2) {
                    1 -> {
                        Random.nextInt(4, 5)
                    }
                    2 -> {
                        Random.nextInt(4, 5)
                    }
                    4 -> {
                        Random.nextInt(1, 2)
                    }
                    5 -> {
                        Random.nextInt(1, 2)
                    }
                    else -> 0
                }
            }
            4 -> {
                when (option2) {
                    1 -> {
                        Random.nextInt(2, 3)
                    }
                    2 -> {
                        1
                    }
                    3 -> {
                        Random.nextInt(1, 2)
                    }
                    5 -> {
                        Random.nextInt(1, 3)
                    }
                    else -> 0
                }
            }
            5 -> {
                when (option2) {
                    1 -> {
                        Random.nextInt(2, 4)
                    }
                    2 -> {
                        Random.nextInt(3, 4)
                    }
                    3 -> {
                        Random.nextInt(1, 2)
                    }
                    4 -> {
                        Random.nextInt(1, 3)
                    }
                    else -> 0
                }
            }
            else -> 0
        }
        return option3
    }

    private fun add4thOption(option1: Int, option2: Int, option3: Int): Int {
        val option4 = when (option1) {
            1 -> {
                when (option2) {
                    2 -> {
                        when (option3) {
                            3 -> {
                                Random.nextInt(4,5)
                            }
                            4 -> {
                                3
                            }
                            5 -> {
                                Random.nextInt(3,4)
                            }
                            else -> 0
                        }
                    }
                    3 -> {
                        when (option3) {
                            2 -> {
                                Random.nextInt(4,5)
                            }
                            4 -> {
                                2
                            }
                            5 -> {
                                4
                            }
                            else -> 0
                        }
                    }
                    4 -> {
                        when (option3) {
                            2 -> {
                                3
                            }
                            3 -> {
                                5
                            }
                            5 -> {
                                Random.nextInt(2,3)
                            }
                            else -> 0
                        }
                    }
                    5 -> {
                        when (option3) {
                            2 -> {
                                Random.nextInt(3,4)
                            }
                            3 -> {
                                4
                            }
                            4 -> {
                                Random.nextInt(2,3)
                            }
                            else -> 0
                        }
                    }
                    else -> 0
                }

            }
            2 -> {
                when (option2) {
                    1 -> {
                        when (option3) {
                            3 -> {
                                Random.nextInt(4,5)
                            }
                            4 -> {
                                3
                            }
                            5 -> {
                                Random.nextInt(3,4)
                            }
                            else -> 0
                        }
                    }
                    3 -> {
                        when (option3) {
                            1 -> {
                                Random.nextInt(4,5)
                            }
                            4 -> {
                                5
                            }
                            5 -> {
                                1
                            }
                            else -> 0
                        }
                    }
                    4 -> {
                        when (option3) {
                            1 -> {
                                3
                            }
                            3 -> {
                                5
                            }
                            5 -> {
                                1
                            }
                            else -> 0
                        }
                    }
                    5 -> {
                        when (option3) {
                            1 -> {
                                Random.nextInt(3,4)
                            }
                            3 -> {
                                4
                            }
                            4 -> {
                                1
                            }
                            else -> 0
                        }
                    }
                    else -> 0
                }
            }
            3 -> {
                when (option2) {
                    1 -> {
                        when (option3) {
                            2 -> {
                                Random.nextInt(4,5)
                            }
                            4 -> {
                                5
                            }
                            5 -> {
                                2
                            }
                            else -> 0
                        }
                    }
                    2 -> {
                        when (option3) {
                            1 -> {
                                Random.nextInt(4,5)
                            }
                            4 -> {
                                5
                            }
                            5 -> {
                                1
                            }
                            else -> 0
                        }
                    }
                    4 -> {
                        when (option3) {
                            1 -> {
                                2
                            }
                            2 -> {
                                5
                            }
                            5 -> {
                                Random.nextInt(1,2)
                            }
                            else -> 0
                        }
                    }
                    5 -> {
                        when (option3) {
                            1 -> {
                                2
                            }
                            2 -> {
                                4
                            }
                            4 -> {
                                Random.nextInt(1,2)
                            }
                            else -> 0
                        }
                    }
                    else -> 0
                }
            }
            4 -> {
                when (option2) {
                    1 -> {
                        when (option3) {
                            2 -> {
                                3
                            }
                            3 -> {
                                5
                            }
                            5 -> {
                                Random.nextInt(2,3)
                            }
                            else -> 0
                        }
                    }
                    2 -> {
                        when (option3) {
                            1 -> {
                                3
                            }
                            3 -> {
                                5
                            }
                            5 -> {
                                1
                            }
                            else -> 0
                        }
                    }
                    3 -> {
                        when (option3) {
                            1 -> {
                                2
                            }
                            2 -> {
                                5
                            }
                            5 -> {
                                Random.nextInt(1,2)
                            }
                            else -> 0
                        }
                    }
                    5 -> {
                        when (option3) {
                            1 -> {
                                Random.nextInt(2,3)
                            }
                            2 -> {
                                3
                            }
                            3 -> {
                                Random.nextInt(1,2)
                            }
                            else -> 0
                        }
                    }
                    else -> 0
                }
            }
            5 -> {
                when (option2) {
                    1 -> {
                        when (option3) {
                            2 -> {
                                Random.nextInt(3,4)
                            }
                            3 -> {
                                4
                            }
                            4 -> {
                                Random.nextInt(2,3)
                            }
                            else -> 0
                        }
                    }
                    2 -> {
                        when (option3) {
                            1 -> {
                                Random.nextInt(3,4)
                            }
                            3 -> {
                                1
                            }
                            4 -> {
                                1
                            }
                            else -> 0
                        }
                    }
                    3 -> {
                        when (option3) {
                            1 -> {
                                2
                            }
                            2 -> {
                                4
                            }
                            4 -> {
                                Random.nextInt(1,2)
                            }
                            else -> 0
                        }
                    }
                    4 -> {
                        when (option3) {
                            1 -> {
                                Random.nextInt(2,3)
                            }
                            2 -> {
                                3
                            }
                            3 -> {
                                Random.nextInt(1,2)
                            }
                            else -> 0
                        }
                    }
                    else -> 0
                }
            }
            else -> 0

        }
        return option4
    }

    private fun add5thOption(option1: Int, option2: Int, option3: Int, option4: Int): Int {
        val option5 = when (option1) {
            1 -> {
                when (option2) {
                    2 -> {
                        when (option3) {
                            3 -> {
                                when(option4){
                                    4 -> {
                                        5
                                    }
                                    5 -> {
                                        4
                                    }
                                    else -> 0
                                }
                            }
                            4 -> {
                                when(option4){
                                    3 -> {
                                        5
                                    }
                                    5 -> {
                                        3
                                    }
                                    else -> 0
                                }
                            }
                            5 -> {
                                when(option4){
                                    3 -> {
                                        4
                                    }
                                    4 -> {
                                        3
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    3 -> {
                        when (option3) {
                            2 -> {
                                when(option4){
                                    4 -> {
                                        5
                                    }
                                    5 -> {
                                        4
                                    }
                                    else -> 0
                                }
                            }
                            4 -> {
                                when(option4){
                                    2 -> {
                                        5
                                    }
                                    5 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            5 -> {
                                when(option4){
                                    2 -> {
                                        4
                                    }
                                    4 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    4 -> {
                        when (option3) {
                            2 -> {
                                when(option4){
                                    3 -> {
                                        5
                                    }
                                    5 -> {
                                        3
                                    }
                                    else -> 0
                                }
                            }
                            3 -> {
                                when(option4){
                                    2 -> {
                                        5
                                    }
                                    5 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            5 -> {
                                when(option4){
                                    2 -> {
                                        3
                                    }
                                    3 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    5 -> {
                        when (option3) {
                            2 -> {
                                when(option4){
                                    3 -> {
                                        4
                                    }
                                    4 -> {
                                        3
                                    }
                                    else -> 0
                                }
                            }
                            3 -> {
                                when(option4){
                                    2 -> {
                                        4
                                    }
                                    4 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            4 -> {
                                when(option4){
                                    2 -> {
                                        3
                                    }
                                    3 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    else -> 0
                }

            }
            2 -> {
                when (option2) {
                    1 -> {
                        when (option3) {
                            3 -> {
                                when(option4){
                                    4 -> {
                                        5
                                    }
                                    5 -> {
                                        4
                                    }
                                    else -> 0
                                }
                            }
                            4 -> {
                                when(option4){
                                    3 -> {
                                        5
                                    }
                                    5 -> {
                                        3
                                    }
                                    else -> 0
                                }
                            }
                            5 -> {
                                when(option4){
                                    3 -> {
                                        4
                                    }
                                    4 -> {
                                        3
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    3 -> {
                        when (option3) {
                            1 -> {
                                when(option4){
                                    4 -> {
                                        5
                                    }
                                    5 -> {
                                        4
                                    }
                                    else -> 0
                                }
                            }
                            4 -> {
                                when(option4){
                                    1 -> {
                                        5
                                    }
                                    5 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            5 -> {
                                when(option4){
                                    1 -> {
                                        4
                                    }
                                    4 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    4 -> {
                        when (option3) {
                            1 -> {
                                when(option4){
                                    3 -> {
                                        5
                                    }
                                    5 -> {
                                        3
                                    }
                                    else -> 0
                                }
                            }
                            3 -> {
                                when(option4){
                                    1 -> {
                                        5
                                    }
                                    5 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            5 -> {
                                when(option4){
                                    1 -> {
                                        3
                                    }
                                    3 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    5 -> {
                        when (option3) {
                            1 -> {
                                when(option4){
                                    3 -> {
                                        4
                                    }
                                    4 -> {
                                        3
                                    }
                                    else -> 0
                                }
                            }
                            3 -> {
                                when(option4){
                                    1 -> {
                                        4
                                    }
                                    4 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            4 -> {
                                when(option4){
                                    1 -> {
                                        3
                                    }
                                    3 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    else -> 0
                }
            }
            3 -> {
                when (option2) {
                    1 -> {
                        when (option3) {
                            2 -> {
                                when(option4){
                                    4 -> {
                                        5
                                    }
                                    5 -> {
                                        4
                                    }
                                    else -> 0
                                }
                            }
                            4 -> {
                                when(option4){
                                    2 -> {
                                        5
                                    }
                                    5 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            5 -> {
                                when(option4){
                                    2 -> {
                                        4
                                    }
                                    4 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    2 -> {
                        when (option3) {
                            1 -> {
                                when(option4){
                                    4 -> {
                                        5
                                    }
                                    5 -> {
                                        4
                                    }
                                    else -> 0
                                }
                            }
                            4 -> {
                                when(option4){
                                    1 -> {
                                        5
                                    }
                                    5 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            5 -> {
                                when(option4){
                                    1 -> {
                                        4
                                    }
                                    4 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    4 -> {
                        when (option3) {
                            1 -> {
                                when(option4){
                                    2 -> {
                                        5
                                    }
                                    5 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            2 -> {
                                when(option4){
                                    1 -> {
                                        5
                                    }
                                    5 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            5 -> {
                                when(option4){
                                    1 -> {
                                        2
                                    }
                                    2 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    5 -> {
                        when (option3) {
                            1 -> {
                                when(option4){
                                    2 -> {
                                        4
                                    }
                                    4 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            2 -> {
                                when(option4){
                                    1 -> {
                                        4
                                    }
                                    4 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            4 -> {
                                when(option4){
                                    1 -> {
                                        2
                                    }
                                    2 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    else -> 0
                }
            }
            4 -> {
                when (option2) {
                    1 -> {
                        when (option3) {
                            2 -> {
                                when(option4){
                                    3 -> {
                                        5
                                    }
                                    5 -> {
                                        3
                                    }
                                    else -> 0
                                }
                            }
                            3 -> {
                                when(option4){
                                    2 -> {
                                        5
                                    }
                                    5 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            5 -> {
                                when(option4){
                                    2 -> {
                                        3
                                    }
                                    3 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    2 -> {
                        when (option3) {
                            1 -> {
                                when(option4){
                                    3 -> {
                                        5
                                    }
                                    5 -> {
                                        3
                                    }
                                    else -> 0
                                }
                            }
                            3 -> {
                                when(option4){
                                    1 -> {
                                        5
                                    }
                                    5 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            5 -> {
                                when(option4){
                                    1 -> {
                                        3
                                    }
                                    3 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    3 -> {
                        when (option3) {
                            1 -> {
                                when(option4){
                                    2 -> {
                                        5
                                    }
                                    5 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            2 -> {
                                when(option4){
                                    1 -> {
                                        5
                                    }
                                    5 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            5 -> {
                                when(option4){
                                    1 -> {
                                        2
                                    }
                                    2 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    5 -> {
                        when (option3) {
                            1 -> {
                                when(option4){
                                    2 -> {
                                        3
                                    }
                                    3 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            2 -> {
                                when(option4){
                                    1 -> {
                                        3
                                    }
                                    3 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            3 -> {
                                when(option4){
                                    1 -> {
                                        2
                                    }
                                    2 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    else -> 0
                }
            }
            5 -> {
                when (option2) {
                    1 -> {
                        when (option3) {
                            2 -> {
                                when(option4){
                                    3 -> {
                                        4
                                    }
                                    4 -> {
                                        3
                                    }
                                    else -> 0
                                }
                            }
                            3 -> {
                                when(option4){
                                    2 -> {
                                        4
                                    }
                                    4 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            4 -> {
                                when(option4){
                                    2 -> {
                                        3
                                    }
                                    3 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    2 -> {
                        when (option3) {
                            1 -> {
                                when(option4){
                                    3 -> {
                                        4
                                    }
                                    4 -> {
                                        3
                                    }
                                    else -> 0
                                }
                            }
                            3 -> {
                                when(option4){
                                    1 -> {
                                        4
                                    }
                                    4 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            4 -> {
                                when(option4){
                                    1 -> {
                                        3
                                    }
                                    3 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    3 -> {
                        when (option3) {
                            1 -> {
                                when(option4){
                                    2 -> {
                                        4
                                    }
                                    4 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            2 -> {
                                when(option4){
                                    1 -> {
                                        4
                                    }
                                    4 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            4 -> {
                                when(option4){
                                    1 -> {
                                        2
                                    }
                                    2 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    4 -> {
                        when (option3) {
                            1 -> {
                                when(option4){
                                    2 -> {
                                        3
                                    }
                                    3 -> {
                                        2
                                    }
                                    else -> 0
                                }
                            }
                            2 -> {
                                when(option4){
                                    1 -> {
                                        3
                                    }
                                    3 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            3 -> {
                                when(option4){
                                    1 -> {
                                        2
                                    }
                                    2 -> {
                                        1
                                    }
                                    else -> 0
                                }
                            }
                            else -> 0
                        }
                    }
                    else -> 0
                }
            }
            else -> 0

        }
        return option5
    }

    private fun addItem(o1: Int, o2: Int, o3: Int, o4: Int, o5: Int, item: Quiz){
        var option1: Any = Any()
        var option2: Any = Any()
        var option3: Any? = null
        var option4: Any? = null
        var option5: Any? = null



        when(o1){
            1 -> option1 = item.option1
            2 -> option2 = item.option1
            3 -> option3 = item.option1
            4 -> option4 = item.option1
            5 -> option5 = item.option1
        }
        when(o2){
            1 -> option1 = item.option2
            2 -> option2 = item.option2
            3 -> option3 = item.option2
            4 -> option4 = item.option2
            5 -> option5 = item.option2
        }


        if (item.option3 != null){
            when(o3){
                1 -> option1 = item.option3
                2 -> option2 = item.option3
                3 -> option3 = item.option3
                4 -> option4 = item.option3
                5 -> option5 = item.option3
            }
        }

        if (item.option4 != null){
            when(o4){
                1 -> option1 = item.option4
                2 -> option2 = item.option4
                3 -> option3 = item.option4
                4 -> option4 = item.option4
                5 -> option5 = item.option4
            }
        }
        if (item.option5 != null){
            when(o5){
                1 -> option1 = item.option5
                2 -> option2 = item.option5
                3 -> option3 = item.option5
                4 -> option4 = item.option5
                5 -> option5 = item.option5
            }
        }


        randomizeOptionList.add( Quiz(item.question, option1, option2, option3, option4, option5, item.answer) )

    }



//    fun randomizeQuestion(quizList: List<Quiz>): List<Quiz>{
//
//        val size = quizList.size
//        var integerList = mutableListOf<Int>()
//        Collections.shuffle(quizList)
//
//
//        var i: Int = 0
//        while (i < size){
//            val random = Random.nextInt(i, size)
//            if (!integerList.contains(random)){
//                integerList.add(i,random)
//                i++
//            }
//        }
//
//        return randomizedQuestionList
//    }


//    fun randomOption(quizList: List<Quiz>): List<Quiz>{
//        quizList.forEach{
//            val options: List<Any> = listOf(
//                it.option1,
//                it.option2,
//                it.option3?,
//                it.option4?,
//                it.option5?,
//            )
//            shuffle(options)
//            randomizeOptionList.add(
//                Quiz(
//                question = it.question,
//                option1 = options[0],
//                option2 = options[1],
//                option3 = options[2],
//                option4 = options[3],
//                option5 = options[4],
//                answer = it.answer
//            )
//            )
//        }
//
//        return randomizeOptionList
//    }

}