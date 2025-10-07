// Task 4.5: summing odd integers with a for loop 
fun main() {
    print("Enter the upper limit: ")
    val limit = readln().toInt()

    var sum: Long = 0

    for(i in 1..limit) {
        if (i % 2 != 0) {
            sum += i 
        } 
    } 
    println("Sum off odd numbers from 1 to $limit is $sum")
}

