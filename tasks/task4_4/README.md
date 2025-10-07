# Task 4.4

//Copy your solution to Task 4.2 into this directory.

//Modify it so that it repeatedly prompts for input until a valid option
//has been supplied by the user.

//You should use a `while` or `do`...`while` loop to achieve this. 

fun main() {
    println("PIZZA MENU")
    println("(a) Margherita")
    println("(b) Quattro Stagioni")
    println("(c) Seafood")
    println("(d) Hawaiian") 

    var choice: String

    do {

        print("Choose your pizza (a-d): ")
        choice = readln().lowercase() 

        if (choice.length == 1 && choice[0] in 'a'..'d') {
            println("Order accepted")
        } else {
        println("invalid choice") 
        }
    } while (choice.length != || choice[0] !in 'a'..'d')
}
    

