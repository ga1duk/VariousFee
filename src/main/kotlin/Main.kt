fun main() {
    println(transfer(cardType = "Maestro", previousTransfers = 100_000_00, currentTransfer = 10_000_00))
}

fun transfer(cardType: String = "VK Pay", previousTransfers: Int = 0, currentTransfer: Int): Int {
    val feeInPercent = 0.0075
    val feeInPercentMaestro = 0.006
    val floatingFeeMaestro = (currentTransfer * feeInPercentMaestro).toInt() + 2000
    val minimalFee = 3500
    val floatingFee = (currentTransfer * feeInPercent).toInt()
    var totalFee = 0
    when (cardType) {
        "VK Pay" -> totalFee = 0
        "Visa", "Мир" -> totalFee = if (floatingFee <= minimalFee) minimalFee else floatingFee
        "MasterCard", "Maestro" -> totalFee = if (previousTransfers <= 75_000_00) 0 else floatingFeeMaestro
    }
    return totalFee
}