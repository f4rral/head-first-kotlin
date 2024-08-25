package chapter_2

fun main() {
    println("Переменные")

    var a = 31
    var b = 23
    var c = a
    println("a = $a, b = $b, c = $c")

    a = 44
    println("a = $a, b = $b, c = $c")


    println("Массивы")

    var arrA = arrayOf<Int>(1, 2, 3, 4, 5)
    var arrB = arrA

    println("arrA: = [${arrA.joinToString(", ")}]")
    println("arrB: = [${arrB.joinToString(", ")}]")

    arrA[0] = 100

    println("arrA: = [${arrA.joinToString(", ")}]")
    println("arrB: = [${arrB.joinToString(", ")}]")
}
