class SquareHole(private val sideLength: Double) {
    fun canFit(square: Square): Boolean {
        return sideLength >= square.getSideLength()
    }
}

open class Square(private val sideLength: Double = 0.0) {
    open fun getSideLength(): Double = sideLength
}

class Circle(private val radius: Double) {
    fun getRadius(): Double = radius
}

class CircleToSquareAdapter(circle: Circle) : Square() {
    // Write your code here
    val diameter = circle.getRadius() * 2

    override fun getSideLength(): Double {
        // Write your code here
        return diameter
    }
}
