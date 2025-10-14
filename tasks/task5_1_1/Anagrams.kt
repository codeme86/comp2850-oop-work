// Task 5.1.1: anagram checking using a function

fun anagrams(frist: String, second: String): Boolean {
    val sorted1 = word1.lowercase().toCharArray().sorted()
    val sorted2 = word2.lowercase().toCharArray().sorted()
    return sorted1 == sorted2 
} 

fun main() {
    print("Enter your first word")
    val first = readln()

    print("Enter your second word")
    val second = readln() 

    if (anagrams(first, second)) {
        println("The Words are anagrams")
    } else { 
        println("The words are not anagrams") 
    }
}
