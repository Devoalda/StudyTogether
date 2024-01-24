package com.practice.studytogether.question

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.studytogether.sampledata.SampleQuestions
import com.practice.studytogether.ui.theme.ComposePracticeTheme
import java.time.LocalDateTime

class Question(
    val question: String,
    val answer: String,
    val topic: String,
    val author: String,
    val time: LocalDateTime
) {
    override fun toString(): String {
        return "Question(question='$question', answer='$answer', topic='$topic', author='$author', time=$time)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Question

        if (question != other.question) return false
        if (answer != other.answer) return false
        if (topic != other.topic) return false
        if (author != other.author) return false
        return time == other.time
    }

    override fun hashCode(): Int {
        var result = question.hashCode()
        result = 31 * result + answer.hashCode()
        result = 31 * result + topic.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + time.hashCode()
        return result
    }

}

@Composable
fun QuestionItem(
    question: Question,
    onItemClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.surface)
            .clickable { onItemClick() }
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // Question
            Text(
                text = question.question,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Answer
            Text(
                text = question.answer,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Topic in a pill or medal
            Surface(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(50),
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    text = question.topic,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Author
                Text(
                    text = "By ${question.author}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )

                // Time (less significant)
                Text(
                    // Format time to human-readable format
                    text = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")
                        .format(question.time),
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun QuestionCardPreview() {
    ComposePracticeTheme {
        QuestionItem(
            question = SampleQuestions[0],
            onItemClick = { /* Do nothing */ }
        )
    }
}

@Composable
fun QuestionList(questions: List<Question>) {
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

