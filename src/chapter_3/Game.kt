package chapter_3

fun main(args: Array<String>) {
    val options = arrayOf("Камень", "Ножницы", "Бумага")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)

    printResult(userChoice, gameChoice)
}

fun getGameChoice(optionsParam: Array<String>): String {
    return optionsParam[(Math.random() * optionsParam.size).toInt()]
}

fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""

    // Выполнять цикл, пока пользователь не введет допустимый вариант
    while (!isValidChoice) {
        // Запросить у пользователя его выбор
        print("Пожалуйста, введите один из следующих вариантов:")
        for (item in optionsParam) {
            print(" '$item'")
        }
        println(".")

        // Прочитать пользовательский ввод
        val userInput = readlnOrNull()

        // Проверить пользовательский ввод
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }

        // Если выбран недопустимый вариант, сообщить пользователю
        if (!isValidChoice) {
            println("Вам необходимо сделать допустимый выбор")
        }
    }

    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    if (userChoice == gameChoice) {
        println("Ничья!")
        return
    }

    // Определить результат
    val result: String

    if (
        (userChoice == "Камень" && gameChoice == "Ножницы") ||
        (userChoice == "Бумага" && gameChoice == "Камень") ||
        (userChoice == "Ножницы" && gameChoice == "Бумага")
    ) {
        println("Вы выйграли!")
    } else {
        println("Вы проиграли!")
    }
}
