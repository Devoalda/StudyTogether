package com.practice.studytogether.question

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.practice.studytogether.Title

@Composable
fun QuestionListScreen(questions: List<Question>) {
    var selectedTopic by remember { mutableStateOf<String?>(null) }

    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme,
        content = {
            val backgroundColor = MaterialTheme.colorScheme.background
            val contentColor = if (backgroundColor == Color.White) {
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
                Title("Question List")

                // Dropdown filter based on topics
                DropdownFilter(
                    topics = getDistinctTopics(questions),
                    selectedTopic = selectedTopic,
                    onTopicSelected = { topic -> selectedTopic = topic }
                )

                // List of Questions based on filter with QuestionList
                // QuestionList(questions = filterQuestionsByTopic(questions, selectedTopic))
                QuestionList(
                    questions = filterQuestionsByTopic(questions, selectedTopic),
                    onTopicClick = { topic -> selectedTopic = topic }
                )
            }
        }
    )
}

@Composable
fun DropdownFilter(
    topics: List<String>,
    selectedTopic: String?,
    onTopicSelected: (String?) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        TextButton(
            onClick = { expanded = !expanded },
            colors = ButtonDefaults.textButtonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Text("Filter: ${selectedTopic ?: "All Topics"}")
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier.padding(start = 4.dp)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
        ) {
            DropdownMenuItem(
                onClick = {
                    onTopicSelected(null)
                    expanded = false
                },
                text = { Text("All Topics", color = MaterialTheme.colorScheme.onSurface) },
                modifier = Modifier
                    .clickable { }
                    .padding(4.dp)
            )
            topics.forEach { topic ->
                DropdownMenuItem(
                    onClick = {
                        onTopicSelected(topic)
                        expanded = false
                    },
                    modifier = Modifier
                        .clickable { }
                        .padding(4.dp),
                    text = { Text(topic, color = MaterialTheme.colorScheme.onSurface) }
                )
            }
        }
    }
}

@Composable
fun getDistinctTopics(questions: List<Question>): List<String> {
    return questions.map { it.topic }.distinct()
}

@Composable
fun filterQuestionsByTopic(questions: List<Question>, topic: String?): List<Question> {
    return if (topic.isNullOrEmpty()) {
        questions
    } else {
        questions.filter { it.topic == topic }
    }
}
