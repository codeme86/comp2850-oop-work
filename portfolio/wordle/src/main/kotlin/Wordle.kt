// Implement the six required functions here

import java.io.File
import kotlin.random.Random

// Checks if a word is valid for Wordle (exactly 5 letters)
fun isValid(word: String): Boolean {
    val w = word.trim()

    if (w.length != 5) {          // must be 5 characters
        return false
    }

    for (ch in w) {               // check all characters are letters
        if (!ch.isLetter()) {
            return false
        }
    }

    return true
}

// Reads valid 5-letter words from a file and returns them as a list
fun readWordList(filename: String): MutableList<String> {
    val file = File(filename)
    val words = mutableListOf<String>()

    val lines = file.readLines()  // read all lines

    for (line in lines) {
        val w = line.trim().lowercase()
        if (isValid(w)) {         // only store valid words
            words.add(w)
        }
    }

    return words
}

// Chooses a random word from the list and removes it
fun pickRandomWord(words: MutableList<String>): String {
    val index = Random.nextInt(words.size)
    val chosen = words[index]
    words.removeAt(index)         // so it can’t be picked again
    return chosen
}

// Repeatedly asks the user for a valid guess
fun obtainGuess(attempt: Int): String {
    while (true) {
        print("Attempt $attempt: ")
        val input = readLine()

        if (input != null && isValid(input)) {
            return input.trim().lowercase()   // valid guess
        } else {
            println("Invalid guess, please enter a 5-letter word.")
        }
    }
}

// Compares guess to target: 1 = match, 0 = no match
fun evaluateGuess(guess: String, target: String): List<Int> {
    val matches = mutableListOf<Int>()

    for (i in 0..4) {
        if (guess[i] == target[i]) {
            matches.add(1)
        } else {
            matches.add(0)
        }
    }

    return matches
}

// Shows correct letters and hides others with '?'
fun displayGuess(guess: String, matches: List<Int>) {
    var result = ""

    for (i in 0..4) {
        result += if (matches[i] == 1) guess[i] else '?'
    }

    println(result)
}