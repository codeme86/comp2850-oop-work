import kotlin.system.exitProcess
import kotlin.math.roundToInt

fun main(args: Array<String>) { 
    if (args.size != 3) {
        println("Error please enter exactly three marks.")
        exitProcess(1)
    }

    val mark1 = args[0].toInt()
    val mark2 = args[1].toInt() 
    val mark3 = args[2].toInt()
    val average = ((mark1 + mark2 + mark3) / 3).roundToInt()

    val grade = when (average) {
        in 0..39   -> "Fail"
        in 40..69  -> "Pass"
        in 70..100 -> "Distinction"
        else       -> "Invalid mark"
    } 

    println("Average mark: $average")
    println("Grade: $grade")
}


    
