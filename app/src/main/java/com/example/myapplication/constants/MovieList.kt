package com.example.myapplication.constants

data class Movie(
    val title: String,
    val year: Number,
    val cast: List<String?>,
    val genres: List<String?>,
    val description: String
)

fun getMovies(): List<Movie> {
    return listOf(
        Movie(
            "After Dark in Central Park",
            1900,
            listOf(),
            listOf(),
            "What an amazing experience! I wish that I experience this feeling the same way, everyday!"
        ),
        Movie(
            "Boarding School Girls' Pajama Parade",
            1900,
            listOf(),
            listOf(),
            "I got noting to say about this one"
        ),
        Movie(
            "Clowns Spinning Hats",
            1900,
            listOf(),
            listOf("Silent"),
            "This is so good wow"
        ),
        Movie(
            "I like hats",
            1900,
            listOf(),
            listOf("Silent"),
            "This is so good wow"
        ),
        Movie(
            "Dreaming from the cleaning",
            1900,
            listOf(),
            listOf("Silent"),
            "This is so good wow"
        ),
        Movie(
            "Rat on a cat",
            1900,
            listOf(),
            listOf("Silent"),
            "This is so good wow"
        )
    )
}