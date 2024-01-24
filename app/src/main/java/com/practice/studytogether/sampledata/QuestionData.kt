package com.practice.studytogether.sampledata

import com.practice.studytogether.Question.Question

val SampleQuestions = listOf(
    Question(
        "What is the fundamental concept of linear algebra used in machine learning?",
        "Matrix multiplication",
        "Linear Algebra",
        generateRealisticAuthor()
    ),
    Question(
        "Who is known as the father of modern programming?",
        "Alan Turing",
        "Programming History",
        generateRealisticAuthor()
    ),
    Question(
        "Which programming language is commonly used for web development?",
        "JavaScript",
        "Web Development",
        generateRealisticAuthor()
    ),
    Question(
        "In the context of operating systems, what is a context switch?",
        "A process switch from one task to another",
        "Operating Systems",
        generateRealisticAuthor()
    ),
    Question(
        "What is the purpose of an 'if' statement in programming?",
        "To conditionally execute a block of code",
        "Programming Basics",
        generateRealisticAuthor()
    ),
    Question(
        "What is the primary function of the CPU in a computer system?",
        "To execute instructions and perform calculations",
        "Computer Architecture",
        generateRealisticAuthor()
    ),
    Question(
        "Which data structure is used for fast retrieval of data based on a key?",
        "Hash table",
        "Data Structures",
        generateRealisticAuthor()
    ),
    Question(
        "What is the significance of the 'null' value in programming languages?",
        "Represents the absence of a value or a reference",
        "Programming Concepts",
        generateRealisticAuthor()
    ),
    Question(
        "What does RAID stand for in the context of data storage?",
        "Redundant Array of Independent Disks",
        "Data Storage",
        generateRealisticAuthor()
    ),
    Question(
        "What is the role of an operating system's kernel?",
        "Manages core functionalities and interacts with hardware",
        "Operating Systems",
        generateRealisticAuthor()
    ),
    Question(
        "Which programming paradigm emphasizes immutability and functional programming?",
        "Functional programming",
        "Programming Paradigms",
        generateRealisticAuthor()
    ),
    Question(
        "What is the purpose of a virtual machine in computing?",
        "To run an operating system or software on a different platform",
        "Virtualization",
        generateRealisticAuthor()
    ),
    Question(
        "Which algorithm is commonly used for sorting a list of elements?",
        "Quicksort",
        "Algorithms",
        generateRealisticAuthor()
    ),
    Question(
        "What is the primary function of an assembler in the context of programming languages?",
        "Converts assembly language code into machine code",
        "Programming Languages",
        generateRealisticAuthor()
    ),
    Question(
        "What is the role of a compiler in the software development process?",
        "Translates high-level code into machine code",
        "Software Development",
        generateRealisticAuthor()
    )
)

fun generateRealisticAuthor(): String {
    val firstName = listOf("John", "Alice", "Bob", "Emma", "David", "Olivia", "Michael", "Sophia", "Daniel", "Ava").random()
    val lastName = listOf("Smith", "Johnson", "Brown", "Lee", "Wilson", "Clark", "Jones", "Taylor", "Miller", "Davis").random()
    return "$firstName $lastName"
}