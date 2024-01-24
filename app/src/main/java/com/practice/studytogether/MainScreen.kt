package com.practice.studytogether

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.practice.studytogether.ui.theme.AppTheme


@Composable
fun MainScreen(navController: NavHostController) {
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
        Title(
            "Study Together!", modifier = Modifier
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Question List Button
        AnimatedButton(
            onClick = { navController.navigate("questionList") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(48.dp)
        ) {
            Text("Question List", fontWeight = FontWeight.Bold, color = contentColor)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Question Bank Button
        AnimatedButton(
            onClick = { navController.navigate("questionBank") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(48.dp)
        ) {
            Text("Question Bank", fontWeight = FontWeight.Bold, color = contentColor)
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Composable
fun AnimatedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val backgroundColor = MaterialTheme.colorScheme.background
    val buttonShape = RoundedCornerShape(20.dp)
    val contentColor = if (backgroundColor == Color.White) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    val borderColor = MaterialTheme.colorScheme.primary
    val borderWidth by animateDpAsState(
        targetValue = if (borderColor == MaterialTheme.colorScheme.primary) 2.dp else 0.dp,
        label = "borderWidth"
    )

    Box(
        modifier = modifier
            .clip(buttonShape)
            .border(width = borderWidth, color = borderColor, shape = buttonShape)
            .background(backgroundColor, shape = buttonShape)
            .clickable { onClick() }
            .animateContentSize(), // Animated content size change
        contentAlignment = Alignment.Center
    ) {
        content()
        // Apply the inverted text color to the content
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            content()
        }
    }
}


@Composable
fun Title(title: String, modifier: Modifier = Modifier) {
    AppTheme {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = modifier
        )
    }
}
