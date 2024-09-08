package chapter_11

typealias DoubleConversion = (Double) -> Double

fun convert(x: Double,
            converter: DoubleConversion) : Double {
    val result = converter(x)
    println("$x is converted to $result")

    return result
}

fun convertFive(converter: (Int) -> Double): Double {
    val result = converter(5)
    println("5 is converted to $result")

    return result
}

fun getConversionLambda(srt: String) : DoubleConversion {
    if (srt == "CentigradeToFahrenheit") {
        return { it * 1.8 + 32 }
    } else if (srt == "KgsToPounds") {
        return { it * 2.204623 }
    } else if (srt == "PoundsToUSTons") {
        return { it / 2000.0 }
    } else {
        return { it }
    }
}

fun combine(lambda1: DoubleConversion, lambda2: DoubleConversion): DoubleConversion {
    return { x: Double -> lambda2(lambda1(x)) }
}

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

    convert(20.0) { it * 1.8 + 32 }
    convert(20.0, { it * 1.8 + 32 })

    convertFive { it * 1.8 + 32 }

    // Преобразовать 2.5 кг в фунты
    println("Convert 2.5kg to Pounds: ${getConversionLambda("KgsToPounds")(2.5)}")

    // Определить два лямбда-выражения для преобразований
    val kgsToPoundsLambda = getConversionLambda("KgsToPounds")
    val poundsToUSTonsLambda = getConversionLambda("PoundsToUSTons")

    // Два лямбда-выражения преобразуются в одно новое
    val kgsToUSTonsLambda = combine(kgsToPoundsLambda, poundsToUSTonsLambda)

    // Использовать новое лямбда-выражение для преобразования
    // 17,4 кг в американские тонны
    val value = 17.4
    println("$value kgs is ${convert(value, kgsToUSTonsLambda)} US tons")
}
