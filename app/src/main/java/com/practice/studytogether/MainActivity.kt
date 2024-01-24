package com.practice.studytogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.practice.studytogether.question.QuestionBankScreen
import com.practice.studytogether.question.QuestionListScreen
import com.practice.studytogether.ui.theme.AppTheme
import com.practice.studytogether.sampledata.SampleQuestions as sampleQuestions

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val questions = sampleQuestions // Use questions from QuestionData.kt

        setContent {
            AppTheme {
                val navController = rememberNavController()

                // Set up navigation
                NavHost(navController = navController, startDestination = "main") {
                    composable("main") {
                        MainScreen(navController = navController)
                    }
                    composable("questionBank") {
                        QuestionBankScreen(questions = questions)
                    }
                    composable("questionList") {
                        QuestionListScreen(questions = questions)
                    }
                }
            }
        }
    }
}