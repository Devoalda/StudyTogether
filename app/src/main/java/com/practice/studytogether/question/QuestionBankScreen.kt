package com.practice.studytogether.question

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.studytogether.Title
import com.practice.studytogether.sampledata.SampleQuestions as sampleQuestions

@Composable
fun QuestionBankScreen(questions: List<Question>) {
    val backgroundColor = MaterialTheme.colorScheme.background
    if (backgroundColor == Color.White) {
        MaterialTheme.colorScheme.onPrimary
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Title("Question Bank")

        // QuestionsList sorted by time (most recent first)
        QuestionList(
            questions = questions.sortedByDescending { it.time },
            onTopicClick = {})
    }
}


@Preview
@Composable
fun QuestionBankPreview() {
    QuestionBankScreen(questions = sampleQuestions)
}