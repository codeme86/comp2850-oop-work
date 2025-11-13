fun main() { 
    // Load all valid words from file
    val words = readWordList("data/words.txt")

    if (words.isEmpty()) {
        println("No valid words found in data/words.txt")
        return
    }

    val target = pickRandomWord(words)

    println("Welcome to Wordle!")
    println("Guess the 5-letter word. You have 10 attempts.\n")

    val maxAttempts = 10
    var attempt = 1
    var guessed = false

    while (attempt <= maxAttempts && !guessed) {
        val guess = obtainGuess(attempt)

        val matches = evaluateGuess(guess, target)

        displayGuess(guess, matches)

        // Check if all 5 positions matched (all 1s)
        var allCorrect = true
        for (m in matches) {
            if (m != 1) {
                allCorrect = false
            }
        }

        if (allCorrect) {
            println("Correct! You guessed the word in $attempt attempts.")
            guessed = true
        } else {
            attempt++
        }
    }

    if (!guessed) {
        println("You ran out of attempts! The word was: $target")
    }
}
