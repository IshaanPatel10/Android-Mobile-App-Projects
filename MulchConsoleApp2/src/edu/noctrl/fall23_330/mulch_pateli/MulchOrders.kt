package edu.noctrl.fall23_330.mulch_pateli



class MulchOrder1(val plantingBedDimensions: PlantingBedDimensions){
    private val plantingBedDimensionsList = mutableListOf(plantingBedDimensions)

    fun addPlantingBedDimensions(plantingBedDimensions: PlantingBedDimensions) {
        plantingBedDimensionsList.add(plantingBedDimensions)
    }

    val cubicYards: Float
        get() = plantingBedDimensionsList.map { it.cubicYards() }.sum()

    val cubicFeet: Float
        get() = cubicYards * 27.0f

    var mulchPricer: MulchPricer = CubicYardMulchPricer()
        set(value) {
            field = value
        }

    fun printOrderDetails() {
        println("Order details:")
        plantingBedDimensionsList.forEach {
            println("- ${it.length} feet by ${it.width} feet by ${it.depth} inches")
        }
        println("Total cubic yards: ${cubicYards}")
        println("Total cubic feet: ${cubicFeet}")
        println("Total price: ${calculatePrice()}")
    }

    fun calculatePrice(): Double {
        return mulchPricer.calculatePrice(cubicYards)
    }

    init {
        if (plantingBedDimensions == null) {
            throw IllegalArgumentException("PlantingBedDimensions cannot be null")
        }
    }
}

