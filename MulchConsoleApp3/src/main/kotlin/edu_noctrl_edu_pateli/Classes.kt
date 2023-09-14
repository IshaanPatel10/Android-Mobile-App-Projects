package edu_noctrl_edu_pateli


class MulchOrder(val plantingBedDimensions: PlantingBedDimensions) {
    private val plantingBedDimensionsList = mutableListOf(plantingBedDimensions)

    fun addPlantingBedDimensions(plantingBedDimensions: PlantingBedDimensions) {
        plantingBedDimensionsList.add(plantingBedDimensions)
    }

    val cubicYards: Float
        get() = plantingBedDimensions.length * plantingBedDimensions.width * (plantingBedDimensions.depth / 12.0f / 3.0f)

    val cubicFeet: Float
        get() = cubicYards * 27.0f

    var mulchPricer: MulchPricer = CubicMulchPricer()
        set(value) {
            field = value
        }
    fun printOrderDetails() {
        for (dimensions in plantingBedDimensionsList) {
            println("Planting Bed Dimensions: ${dimensions.length} x ${dimensions.length} x ${dimensions.length}")
        }
        println("Total Cubic Yards: ${cubicYards}")
        println("Total Cubic Yards: ${cubicFeet}")
        println("Total Cubic Yards: ${mulchPricer.calculatePrice(cubicYards.toInt())}")
    }
}



