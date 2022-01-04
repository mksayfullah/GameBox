package com.domesoft.gameboxlibrary.quizer

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.domesoft.gameboxlibrary.interfaces.SetOnFailureListener
import com.domesoft.gameboxlibrary.interfaces.SetOnFinishedListener
import com.domesoft.gameboxlibrary.interfaces.SetOnScoreListener
import com.domesoft.gameboxlibrary.interfaces.SetOnSuccessListener
import com.domesoft.gameboxlibrary.util.RandomizeQuiz
import com.domesoft.gameboxlibrary.view.OptionView
import java.util.Collections.shuffle
import kotlin.collections.ArrayList

open class Quizer(private val context: Context) {



    private lateinit var quizList: List<Quiz>
    private lateinit var gameReports: MutableList<GameReport>

    private var viewQuestion: View? = null
    private var viewOption1: View? = null
    private var viewOption2: View? = null
    private var viewOption3: View? = null
    private var viewOption4: View? = null
    private var viewOption5: View? = null


    private var currentIndex = 0
    private var totalQuestion = 0
    private var questionCount = 1

    private var score: Long = 0
    private var cutForWrongAnswer: Long = 0
    private var finalScore: Long = 0
    private var scoreSet = false




    private lateinit var onSuccessListener: SetOnSuccessListener
    private lateinit var onFailureListener: SetOnFailureListener
    private lateinit var onFinishedListener: SetOnFinishedListener
    private lateinit var onScoreListener: SetOnScoreListener

    private var successChecked = false
    private var failureChecked = false
    private var finishedChecked = false
    private var quizFinished = false
    private var scoreListenerSet = false


    /**
     * @open fun, This function is used to set @quizList
     */
    open fun setQuizList(quizList: List<Quiz>): Quizer {
        this.quizList = decodeQuizList(quizList)
        return this
    }

    /**
     * @private fun, this function is used to decode the option and get the correct answer from the quizList.
     */
    private fun decodeQuizList(quizList: List<Quiz>): List<Quiz>{

        val decodedList = mutableListOf<Quiz>()
        for (item in quizList){
            when(item.answer){
                Option.ONE ->{
                    decodedList.add(Quiz(item.question,item.option1,item.option2,item.option3,item.option4,item.option5,item.option1))
                }
                Option.TWO ->{
                    decodedList.add(Quiz(item.question,item.option1,item.option2,item.option3,item.option4,item.option5,item.option2))
                }
                Option.THREE ->{
                    decodedList.add(Quiz(item.question,item.option1,item.option2,item.option3,item.option4,item.option5,item.option3!!))
                }
                Option.FOUR ->{
                    decodedList.add(Quiz(item.question,item.option1,item.option2,item.option3,item.option4,item.option5,item.option4!!))
                }
                Option.FIVE ->{
                    decodedList.add(Quiz(item.question,item.option1,item.option2,item.option3,item.option4,item.option5,item.option5!!))
                }
                item.option1 ->{
                    decodedList.add(Quiz(item.question,item.option1,item.option2,item.option3,item.option4,item.option5,item.option1))
                }
                item.option2 ->{
                    decodedList.add(Quiz(item.question,item.option1,item.option2,item.option3,item.option4,item.option5,item.option2))
                }
                item.option3 ->{
                    decodedList.add(Quiz(item.question,item.option1,item.option2,item.option3,item.option4,item.option5,item.option3))
                }
                item.option4 ->{
                    decodedList.add(Quiz(item.question,item.option1,item.option2,item.option3,item.option4,item.option5,item.option4))
                }
                item.option5 ->{
                    decodedList.add(Quiz(item.question,item.option1,item.option2,item.option3,item.option4,item.option5,item.option5))
                }
            }
        }

        return decodedList
    }

    /**
     * @open fun, This function is used to shuffle options in every item of the quizList
     */
    open fun setOptionRandomly(): Quizer {
        quizList = RandomizeQuiz().randomizeOption(quizList)
        return this
    }

    /**
     * @open fun, This function is used to shuffle every question of the quizList
     */
    open fun setQuestionRandomly(): Quizer{
        shuffle(quizList)
        return this
    }

    /**
     * @open fun, This function is used to set primary viewGroup which needed to show quiz in an activity.
     */
    open fun setPrimaryElement(viewQuestion: View, viewOption1: View, viewOption2: View, viewOption3: View? = null, viewOption4: View? = null, viewOption5: View? = null): Quizer {

        this.viewQuestion = viewQuestion
        this.viewOption1 = viewOption1
        this.viewOption2 = viewOption2

        if (viewOption3 != null){
            this.viewOption3 = viewOption3
        }

        if (viewOption4 != null){
            this.viewOption4 = viewOption4
        }

        if (viewOption5 != null){
            this.viewOption5 = viewOption5
        }

        return this
    }


    /**
     * @open fun, This function is called when user clicked to a correct option. You can do any custom task when the function is called
     * via a listener.
     */
    open fun setOnSuccessListener(onSuccessListener: SetOnSuccessListener):Quizer{
        this.onSuccessListener = onSuccessListener
        successChecked = true
        return this
    }

    /**
     * @open fun, This function is called when user clicked to a wrong option. You can do any custom task when the function is called
     * via a listener.
     */
    open fun setOnFailureListener(onFailureListener: SetOnFailureListener):Quizer{
        this.onFailureListener = onFailureListener
        failureChecked = true
        return this
    }

    /**
     * @open fun, This function is called when the question set is finished. You can do any custom task when the function is called
     * via a listener.
     */
    open fun setOnFinishedListener(onFinishedListener: SetOnFinishedListener):Quizer{
        this.onFinishedListener = onFinishedListener
        finishedChecked = true
        gameReports = ArrayList()
        return this
    }




    /**
     * @open fun, this function is the final touch of this library. you have to call this function to start your quiz.
     * Or it will crash...
     */
    open fun build(){
        setCurrentQuiz(currentIndex)
        totalQuestion = quizList.size
        setClickListener()
    }


    /**
     * @private fun, this function is used to set click listener to the primary elements which provided by you.
     * if you click the option view this fun will call
     * another fun called @checkAnswer() and pass the option user clicked.
     */
    private fun setClickListener() {
        if (viewOption1 != null && viewOption2 != null){
            viewOption1!!.setOnClickListener {
                checkAnswer(quizList[currentIndex].option1)
            }
            viewOption2!!.setOnClickListener {
                checkAnswer(quizList[currentIndex].option2)
            }
            if (viewOption3 != null){
                viewOption3!!.setOnClickListener {
                    checkAnswer(quizList[currentIndex].option3!!)
                }
                if (viewOption4 != null){
                    viewOption4!!.setOnClickListener {
                        checkAnswer(quizList[currentIndex].option4!!)
                    }

                    if (viewOption5 != null){
                        viewOption5!!.setOnClickListener {
                            checkAnswer(quizList[currentIndex].option5!!)
                        }
                    }
                }
            }
        }

    }

    /**
     * @private fun, this function is called when @create() function will set.
     * it gets current quiz position and connect quiz data with the quiz element provided.
     */
    private fun setCurrentQuiz(currentIndex: Int) {

        val currentQuestion = quizList[currentIndex].question
        val currentOption1 = quizList[currentIndex].option1
        val currentOption2 = quizList[currentIndex].option2
        val currentOption3 = quizList[currentIndex].option3
        val currentOption4 = quizList[currentIndex].option4
        val currentOption5 = quizList[currentIndex].option5

        setQuestion(currentQuestion)

        if (viewOption1 != null){
            if (viewOption1!!.visibility == View.GONE){
                viewOption1!!.visibility = View.VISIBLE
            }
            setOption1(currentOption1)
        }

        if (viewOption2 != null){
            if (viewOption2!!.visibility == View.GONE){
                viewOption2!!.visibility = View.VISIBLE
            }
            setOption2(currentOption2)
        }


        if (currentOption3 == null){
            if (viewOption3 != null){
                viewOption3!!.visibility = View.GONE
            }
        } else{
            if (viewOption3 != null){
                if (viewOption3!!.visibility == View.GONE){
                    viewOption3!!.visibility = View.VISIBLE
                }
                setOption3(currentOption3)
            }
        }

        if (currentOption4 == null){
            if (viewOption4 != null){
                viewOption4!!.visibility = View.GONE
            }
        } else{
            if (viewOption4 != null){
                if (viewOption4!!.visibility == View.GONE){
                    viewOption4!!.visibility = View.VISIBLE
                }
                setOption4(currentOption4)
            }
        }

        if (currentOption5 == null){
            if (viewOption5 != null){
                viewOption5!!.visibility = View.GONE
            }
        } else{
            if (viewOption5 != null){
                if (viewOption5!!.visibility == View.GONE){
                    viewOption5!!.visibility = View.VISIBLE
                }
                setOption5(currentOption5)
            }
        }

    }


    /**
     * @private fun, this function is used to check the user selection.
     * it takes user selected option and match it with correct answer and check it is correct or wrong.
     */
    private fun checkAnswer(option: Any) {

        if (option == quizList[currentIndex].answer){

            if (scoreSet){
                finalScore += score
            }
            if (scoreListenerSet){
                onScoreListener.instantScore(finalScore)
            }
            if (successChecked) {
                onSuccessListener.onSuccess(quizList[currentIndex])
            } else{

                Toast.makeText(context, "Correct Answer", Toast.LENGTH_SHORT).show()
                nextQuestion()

            }
            if(finishedChecked){
                if (scoreSet){
                    gameReports.add(GameReport(quizList[currentIndex].question,option,quizList[currentIndex].answer,score))
                } else{
                    gameReports.add(GameReport(quizList[currentIndex].question,option,quizList[currentIndex].answer,0))
                }
            }

        } else
        {
            if (scoreSet){
                finalScore -= cutForWrongAnswer
            } else{
                gameReports.add(GameReport(quizList[currentIndex].question,option,quizList[currentIndex].answer,cutForWrongAnswer))
            }
            if (scoreListenerSet){
                onScoreListener.instantScore(finalScore)
            }
            if (failureChecked) {
                onFailureListener.onFailure(quizList[currentIndex])
            } else{
                Toast.makeText(context, "Wrong Answer", Toast.LENGTH_SHORT).show()
            }

            if(finishedChecked){
                if (scoreSet){
                    gameReports.add(GameReport(quizList[currentIndex].question,option,quizList[currentIndex].answer,cutForWrongAnswer))
                } else{
                    gameReports.add(GameReport(quizList[currentIndex].question,option,quizList[currentIndex].answer,0))
                }
            }

        }


    }

    /**
     * @open fun, you can call this function if you want to change the current question and
     * want to go forward
     */
    open fun nextQuestion(){
        questionCount += 1
        updateQuestion()
    }

    /**
     * @open fun, you can call this function if you want to change the current question and
     * want to go backward
     */
    open fun previousQuestion(){
        if (questionCount > 1){
            questionCount -= 1
            updateQuestion()
        }
//        currentIndex = (currentIndex - 1) % quizList.size
//        setQuiz(currentIndex)
    }

    /**
     * @private fun, this function is used to update the question whatever it is forward or backward
     */
    private fun updateQuestion(){

        if (questionCount > totalQuestion) {
                finishQuiz()
        } else {
            currentIndex = (currentIndex + 1) % quizList.size
            setCurrentQuiz(currentIndex)
        }
    }

    /**
     * @open fun, this function is used to finish the quiz.
     */
    open fun finishQuiz(){
        if (finishedChecked) {
            onFinishedListener.onFinished()
            onFinishedListener.finalScore(finalScore)
            onFinishedListener.gameReport(gameReports)
        } else {
            setVisibility(View.INVISIBLE)
        }
    }

    /**
     * @open fun, using this function, you can make your element visible, invisible or gone at any time.
     */
    open fun setVisibility(visibility: Int) {
        viewQuestion?.visibility = visibility
        viewOption1?.visibility = visibility
        viewOption2?.visibility = visibility
        viewOption3?.visibility = visibility
        viewOption4?.visibility = visibility
        viewOption5?.visibility = visibility
    }


    /**
     * @open fun, this function is used to set score functionality to the quiz.
     */
//    open fun setScore(score: Long): Quizer{
//        this.score = score
//        scoreSet = true
//        return this
//    }
    open fun setScore(score: Long, cutForWrongAnswer: Long? = 0L): Quizer{
        this.score = score
        if (cutForWrongAnswer != null) {
            this.cutForWrongAnswer = cutForWrongAnswer
        }
        scoreSet = true
        return this
    }

    /**
     * @open fun, this function is used to get instant score user is collecting by playing the quiz.
     */
    open fun setInstantScoreListener(onScoreListener: SetOnScoreListener){
        this.onScoreListener = onScoreListener
        scoreListenerSet = true
    }

//    open fun setOptionView(optionView: OptionView){
//        createOptionView(optionView)
//    }


//    private fun createOptionView(optionView: OptionView){
//
//
//        val optionList: List<OptionList> = listOf(
//            OptionList(quizList[currentIndex].option1),
//            OptionList(quizList[currentIndex].option2),
//            OptionList(quizList[currentIndex].option3),
//            OptionList(quizList[currentIndex].option4),
//            OptionList(quizList[currentIndex].option5)
//        )
//
////        optionView.apply {
////            adapter = OptionsAdapter(context, optionView.childView, optionList)
////            layoutManager = LinearLayoutManager(context)
////        }
//
//    }


    /**
     * @private fun, this function is used to connect question with the element provided for showing the question.
     */
    private fun setQuestion(currentQuestion: Any) {

        if ((viewQuestion is TextView || viewQuestion is Button) && (currentQuestion is String || currentQuestion is Int)){

            (viewQuestion as TextView).text = currentQuestion.toString()

        } else if (viewQuestion is ImageView && currentQuestion is Int){
            (viewQuestion as ImageView).setBackgroundResource(currentQuestion)
        }
    }

    /**
     * @private fun, this function is used to connect option1 with the element provided for showing the option1.
     */
    private fun setOption1(currentOption1: Any) {

        if (viewOption1 is TextView || viewOption1 is Button){

            (viewOption1 as TextView).text = currentOption1.toString()

        } else if (viewOption1 is ImageView && currentOption1 is Int){
            (viewOption1 as ImageView).setImageResource(currentOption1)
        }

    }

    /**
     * @private fun, this function is used to connect option2 with the element provided for showing the option2.
     */
    private fun setOption2(currentOption2: Any) {
        if (viewOption2 is TextView || viewOption2 is Button){

            (viewOption2 as TextView).text = currentOption2.toString()

        } else if (viewOption2 is ImageView && currentOption2 is Int){
            (viewOption2 as ImageView).setImageResource(currentOption2)
        }
    }

    /**
     * @private fun, this function is used to connect option3 with the element provided for showing the option3.
     */
    private fun setOption3(currentOption3: Any?) {
        if (viewOption3 is TextView || viewOption3 is Button){

            (viewOption3 as TextView).text = currentOption3.toString()

        } else if (viewOption3 is ImageView && currentOption3 is Int){
            (viewOption3 as ImageView).setImageResource(currentOption3)
        }
    }

    /**
     * @private fun, this function is used to connect option4 with the element provided for showing the option4.
     */
    private fun setOption4(currentOption4: Any?) {

        if (viewOption4 is TextView || viewOption4 is Button){

            (viewOption4 as TextView).text = currentOption4.toString()

        } else if (viewOption4 is ImageView && currentOption4 is Int){
            (viewOption4 as ImageView).setImageResource(currentOption4)
        }
    }

    /**
     * @private fun, this function is used to connect option5 with the element provided for showing the option5.
     */
    private fun setOption5(currentOption5: Any?) {

        if (viewOption5 is TextView || viewOption5 is Button){

            (viewOption5 as TextView).text = currentOption5.toString()

        } else if (viewOption5 is ImageView && currentOption5 is Int){
            (viewOption5 as ImageView).setImageResource(currentOption5)
        }
    }


}