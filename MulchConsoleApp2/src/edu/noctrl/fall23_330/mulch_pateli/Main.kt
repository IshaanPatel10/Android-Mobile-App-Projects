package edu.noctrl.fall23_330.mulch_pateli

fun main(){
    val cubicYardPricer = CubicMulchPricer()
    val cubicFootPricer = CubicFootMulchPricer()

    val mulchOrder1 = MulchOrder(cubicYardPricer, PlantingBedDimensions(25, 8, 4))
    mulchOrder1.printOrderDetails()

    println()

    val mul

}