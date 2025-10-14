// Task 5.2.1: geometric properties of circles

import kotlin.math.PI 

fun circleArea(radius: Double) = PI * radius * radius 
fun circleCircumfrence(radius: Double) = 2 * PI * radius 
fun realDouble(prompt: String): Double{
    print(prompt)
    return readline()!!.toDouble()
} 

fun main() {
    val radius = realDouble("Enter the circle radius:")
    val area = circleArea(radius)
    val circumfrence = circleCircumfrence(radius)
    println("Area %.4f".format(area))
    println("Circumfrence %.4f".format(circumfrence)) 
}

