package com.practice.studytogether.Question

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.studytogether.Title
import com.practice.studytogether.sampledata.SampleQuestions as sampleQuestions

@Composable
fun QuestionBankScreen(questions: List<Question>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Title
        Title("Question Bank")

        // QuestionsList
        QuestionBank(questions = questions)
    }
}

@Composable
fun QuestionBank(questions: List<Question>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(questions) { question ->
            QuestionItem(
                question = question,
                onItemClick = { /* Navigate to Question Detail */ }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun QuestionBankPreview() {
    QuestionBankScreen(questions = sampleQuestions)
}