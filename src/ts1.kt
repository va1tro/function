import kotlin.random.Random

fun main() {
    while (true) {
        val comp = Random.nextInt(1, 4)

        println("Выберите: 1 - Камень, 2 - Ножницы, 3 - Бумага")
        val user = readLine()?.toIntOrNull()

        if (user == null || user !in 1..3) {
            println("Некорректный ввод, попробуйте снова.")
            continue
        }

        println("Вы выбрали: ${translateChoice(user)}")
        println("Компьютер выбрал: ${translateChoice(comp)}")

        when {
            user == comp -> {
                println("Ничья! Играем ещё раз.")
            }
            isUserWinner(user, comp) -> {
                println("Вы победили!")
                break
            }
            else -> {
                println("Компьютер победил!")
                break
            }
        }
    }
}

fun translateChoice(choice: Int): String {
    return when (choice) {
        1 -> "Камень"
        2 -> "Ножницы"
        3 -> "Бумага"
        else -> "Неизвестный выбор"
    }
}

fun isUserWinner(user: Int, comp: Int): Boolean {
    return (user == 1 && comp == 2) || // Камень побеждает ножницы
            (user == 2 && comp == 3) || // Ножницы побеждают бумагу
            (user == 3 && comp == 1)    // Бумага побеждает камень
}
