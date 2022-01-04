package com.domesoft.gamebox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.domesoft.gameboxlibrary.games.quickquiz.QuickQuiz
import com.domesoft.gameboxlibrary.interfaces.SetOnFinishedListener
import com.domesoft.gameboxlibrary.interfaces.SetOnSuccessListener
import com.domesoft.gameboxlibrary.interfaces.SetOnTimerListener
import com.domesoft.gameboxlibrary.quizer.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvQ: TextView = findViewById(R.id.tvQ)
        val tvO1: TextView = findViewById(R.id.tvO1)
        val tvO2: TextView = findViewById(R.id.tvO2)
        val tvO3: TextView = findViewById(R.id.tvO3)
        val tvO4: TextView = findViewById(R.id.tvO4)
        val tvO5: TextView = findViewById(R.id.tvO5)
        val tvT: TextView = findViewById(R.id.tvT)


        /**
         * quiz list for quizer
         */
        val quizList: List<Quiz> = listOf(Quiz(question = "question 1", option1 = "option 1", option2 = "option 2", option3 = 3, option4 = 4, option5 = "five", answer = Option.ONE),
            Quiz(question = "question 2", option1 = "option 1", option2 = "option 2", option3 = 3, option4 = 4, option5 = "five", answer = Option.TWO),
            Quiz(question = "question 3", option1 = "option 1", option2 = "option 2", option3 = 3, option5 = "five", answer = Option.THREE),
            Quiz(question = "question 4", option1 = "option 1", option2 = "option 2", option3 = 3, option4 = 4, option5 = "five", answer = Option.FOUR)
        )

//        val demo: Int = R.layout.activity_main
//
//        tvQ.setOnClickListener {
//            val resources: Resources = this.resources
//            val res: String = resources.getResourceTypeName(demo);
//            if (res == "drawable") {
//                Toast.makeText(this, "This is an image", Toast.LENGTH_SHORT).show()
//            } else                 Toast.makeText(this, res, Toast.LENGTH_SHORT).show()
//
//
//        }


        /**
         * quickQuiz setup
         */
        val quickQuiz = QuickQuiz(this)

        quickQuiz.setQuizList(quizList).setPrimaryElement(tvQ,tvO1,tvO2,tvO3, tvO4, tvO5).setOptionRandomly().setQuestionRandomly()

        quickQuiz.setTime(1,0)
        quickQuiz.getInstantTime(object : SetOnTimerListener{
            override fun onCountDown(time: String, timesInMillis: Long) {
                tvT.text = time
            }
            override fun onFinish() {
                quickQuiz.finishQuiz()
                Toast.makeText(this@MainActivity, "finished",Toast.LENGTH_SHORT).show()
            }
        }).setOnSuccessListener(object : SetOnSuccessListener{
            override fun onSuccess(currentQuestion: Quiz) {
                Toast.makeText(this@MainActivity, "Wow",Toast.LENGTH_SHORT).show()
                quickQuiz.nextQuestion()
            }

        }).setOnFinishedListener(object : SetOnFinishedListener{
            override fun onFinished() {
                quickQuiz.setVisibility(View.INVISIBLE)
            }
            override fun finalScore(finalScore: Long) {
            }
            override fun gameReport(gameReport: List<GameReport>) {
                Toast.makeText(this@MainActivity, gameReport.toString(),Toast.LENGTH_LONG).show()
            }
        })
        quickQuiz.build()

        //val optionView: OptionView = findViewById(R.id.optionView)
        //quick.setOptionView(optionView)

    }

}