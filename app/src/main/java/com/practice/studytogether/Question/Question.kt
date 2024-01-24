package com.practice.studytogether.Question

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.studytogether.sampledata.SampleQuestions
import com.practice.studytogether.ui.theme.ComposePracticeTheme

class Question(
    val question: String,
    val answer: String,
    val topic: String,
    val author: String
) {
    override fun toString(): String {
        return "Question(question='$question', answer='$answer', topic='$topic', author='$author')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Question

        if (question != other.question) return false
        if (answer != other.answer) return false
        if (topic != other.topic) return false
        return author == other.author
    }

    override fun hashCode(): Int {
        var result = question.hashCode()
        result = 31 * result + answer.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + topic.hashCode()
        return result
    }

}

@Composable
fun QuestionItem(
    question: Question,
    onItemClick: () -> Unit
) {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme,
        content = {
            val borderColor = MaterialTheme.colorScheme.primary
            val borderWidth by animateDpAsState(
                targetValue = if (borderColor == MaterialTheme.colorScheme.primary) 2.dp else 0.dp,
                label = "borderWidth"
            )

            Box(
                modifier = Modifier
                    .border(width = borderWidth, color = borderColor)
                    .background(color = MaterialTheme.colorScheme.background)
                    .clickable { onItemClick() }
                    .animateContentSize(), // Animated content size change
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    // Question
                    Text(
                        text = question.question,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    // Answer
                    Text(
                        text = question.answer,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    // Topic
                    Text(
                        text = question.topic,
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    // Author
                    Text(
                        text = "By ${question.author}",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    )
                }
            }
        }
    )
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

