package chapter_11

fun main(args: Array<String>) {
    var addFive = { x: Int -> x + 5 }
    println("Pass 6 to addFive: ${addFive(5)}")

    val addInts = { x: Int, y: Int -> x + y }
    val result = addInts(6, 7)
    println("Press 6, 7 to addInts: $result")

    val intLambda: (Int, Int) -> Int = { x, y -> x * y }
    println("Pass 10, 11 to intLambdas: ${intLambda(10, 11)}")

    val addSeven: (Int) -> Int = { it + 7 }
    println("Pass 12 to addSeven: ${addSeven(12)}")

    val myLambda: () -> Unit = { println("Hi!") }
    myLambda()
}