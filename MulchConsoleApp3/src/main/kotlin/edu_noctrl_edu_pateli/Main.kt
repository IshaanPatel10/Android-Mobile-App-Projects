package edu_noctrl_edu_pateli



fun main() {
    fun main(args: Array<String>) {
        val mulchOrder = MulchOrder(PlantingBedDimensions(10, 10, 6.0f))
        mulchOrder.printOrderDetails()

        val mulchOrder2 = MulchOrder(PlantingBedDimensions(10, 10, 6.0f))
        mulchOrder2.addPlantingBedDimensions(PlantingBedDimensions(10, 10, 6.0f))
        mulchOrder2.printOrderDetails()

    }

}