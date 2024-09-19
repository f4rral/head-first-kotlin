package my_examples

import kotlin.math.*

fun main() {
    val a: Double = 2.0
    val b: Double = 4.0
    val c: Double = -2.0
    val x1: Double?
    val x2: Double?

    val d: Double = b.pow(2.0) - 4 * a * c

    if (d > 0) {
        x1 = (-b + sqrt(d)) / (2 * a)
        x2 = (-b - sqrt(d)) / (2 * a)
    } else if (d == 0.0) {
        x1 = -b / (2 * a)
        x2 = x1
    } else {
        x1 = null
        x2 = null
    }

    println("D = $d, x1 = $x1, x2 = $x2")
}