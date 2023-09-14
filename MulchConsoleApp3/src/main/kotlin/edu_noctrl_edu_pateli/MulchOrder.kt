package edu_noctrl_edu_pateli

data class PlantingBedDimensions(val length: Int, val width: Int, val depth: Float) { //Creating a data class on the Dimensions of the planting bed
    fun cubicYards(): Float {
        return length * width * (depth / 12.0f)
    }
}


interface MulchPricer{
    fun calculatePrice(cubicYards: Int): Double{
        val money: Double = 0.0;
        return money;
    }

}

class CubicMulchPricer: MulchPricer{
    override fun calculatePrice(cubicYards: Int): Double {
        val pricePerCubicYards = when (cubicYards) {
            in 1..3 -> 33.5
            in 4..10 -> 31.5
            else -> 29.5
        }
        return cubicYards * pricePerCubicYards
    }
}

class CubicFootMulchPricer : MulchPricer {

    override fun calculatePrice(cubicYards: Int): Double {
        val cubicFeet = cubicYards * 2.0
        val pricePerBag = when {
            cubicFeet <= 5 -> 3.97
            cubicFeet <= 10 -> 3.47
            else -> 2.97
        }
        return cubicFeet / 2.0 * pricePerBag
    }

}
