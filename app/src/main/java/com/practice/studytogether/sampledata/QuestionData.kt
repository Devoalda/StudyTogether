package com.practice.studytogether.sampledata

import com.practice.studytogether.question.Question
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.random.Random

val linearAlgebraQuestions = listOf(
    Question(
        "What is the fundamental concept of linear algebra used in machine learning?",
        "Matrix multiplication",
        "Linear Algebra",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "How is eigenvalue decomposition utilized in machine learning applications?",
        "To analyze the dominant modes of variation in data",
        "Linear Algebra",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "What role does the determinant play in linear algebra and machine learning?",
        "Determines the scaling factor of transformations in space",
        "Linear Algebra",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "Explain the concept of vector spaces in the context of linear algebra.",
        "Sets of vectors with defined addition and scalar multiplication operations",
        "Linear Algebra",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "In machine learning, how is the concept of rank used in feature selection?",
        "Higher-rank features are often more informative",
        "Linear Algebra",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    )
)

val programmingHistoryQuestions = listOf(
    Question(
        "Who is known as the father of modern programming?",
        "Alan Turing",
        "Programming History",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "What pivotal role did Grace Hopper play in the early days of programming?",
        "Developed the first compiler for a programming language",
        "Programming History",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "In what year was the first high-level programming language, Fortran, introduced?",
        "1957",
        "Programming History",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "How did the invention of the transistor influence the history of programming?",
        "Enabled the development of smaller and more efficient computers",
        "Programming History",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "Explain the significance of the ENIAC computer in the context of programming history.",
        "One of the earliest electronic general-purpose computers",
        "Programming History",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    )
)

val webDevelopmentQuestions = listOf(
    Question(
        "Which programming language is commonly used for web development?",
        "JavaScript",
        "Web Development",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "What is the role of HTML in web development?",
        "Markup language used for structuring content on the web",
        "Web Development",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "How does a web browser interpret and render CSS stylesheets?",
        "Applies styling rules to HTML elements for presentation",
        "Web Development",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "Explain the concept of AJAX in the context of web development.",
        "Asynchronous JavaScript and XML, used for dynamic content loading",
        "Web Development",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "What is the purpose of responsive design in web development?",
        "Ensures a consistent user experience across different devices and screen sizes",
        "Web Development",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    )
)

val CQuestions = listOf(
    Question(
        "What is the difference between a compiler and an interpreter?",
        "A compiler translates code before runtime, while an interpreter translates code during runtime",
        "C",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "What is the purpose of the preprocessor in C?",
        "Performs text substitution before compilation",
        "C",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "What is the difference between a static and dynamic library?",
        "Static libraries are linked at compile time, while dynamic libraries are linked at runtime",
        "C",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "What is the purpose of the 'volatile' keyword in C?",
        "Instructs the compiler to not optimize the variable",
        "C",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "What is the purpose of the 'const' keyword in C?",
        "Instructs the compiler to not allow the variable to be modified",
        "C",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    )
)

val PythonQuestions = listOf(
    Question(
        "What is the difference between a list and a tuple in Python?",
        "Lists are mutable, while tuples are immutable",
        "Python",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "What is the difference between 'is' and '==' in Python?",
        "'is' checks for object identity, while '==' checks for equality",
        "Python",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "What is the difference between 'range' and 'xrange' in Python 2?",
        "'range' returns a list, while 'xrange' returns a generator",
        "Python",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "What is the difference between 'cmp' and 'key' in Python?",
        "'cmp' compares two objects, while 'key' specifies a function to be used for sorting",
        "Python",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    ),
    Question(
        "What is the difference between 'iteritems' and 'items' in Python?",
        "'iteritems' returns an iterator, while 'items' returns a list",
        "Python",
        generateRealisticAuthor(),
        generateRandomTimestamp()
    )
)

val SampleQuestions =
    linearAlgebraQuestions + programmingHistoryQuestions + webDevelopmentQuestions + CQuestions + PythonQuestions


fun generateRandomTimestamp(): LocalDateTime {
    val now = LocalDateTime.now()
    var randomPastDate = now.minus(Random.nextLong(1, 365), ChronoUnit.DAYS)
    randomPastDate = randomPastDate.minus(Random.nextLong(1, 24), ChronoUnit.HOURS)
    randomPastDate = randomPastDate.minus(Random.nextLong(1, 60), ChronoUnit.MINUTES)
    randomPastDate = randomPastDate.minus(Random.nextLong(1, 60), ChronoUnit.SECONDS)
    return randomPastDate.truncatedTo(ChronoUnit.SECONDS)
}

fun generateRealisticAuthor(): String {
    val firstName = listOf(
        "John",
        "Alice",
        "Bob",
        "Emma",
        "David",
        "Olivia",
        "Michael",
        "Sophia",
        "Daniel",
        "Ava"
    ).random()
    val lastName = listOf(
        "Smith",
        "Johnson",
        "Brown",
        "Lee",
        "Wilson",
        "Clark",
        "Jones",
        "Taylor",
        "Miller",
        "Davis"
    ).random()
    return "$firstName $lastName"
}