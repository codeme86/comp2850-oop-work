import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    

    "isValid returns true for a 5-letter word" {
        isValid("apple") shouldBe true
    }

    "isValid returns false for word that is too short" {
        isValid("cat") shouldBe false
    }

    "isValid returns false for word that is too long" {
        isValid("strawberry") shouldBe false
    }

    "isValid returns false for word with non-letter characters" {
        isValid("ab1de") shouldBe false
    }


    "evaluateGuess gives all 1s when guess equals target" {
        val result = evaluateGuess("apple", "apple")
        result shouldBe listOf(1, 1, 1, 1, 1)
    }

    "evaluateGuess gives mixture of 1s and 0s for partial match" {
        val result = evaluateGuess("apple", "angle")
        // a = a, p != n, p != g, l = l, e = e
        result shouldBe listOf(1, 0, 0, 1, 1)
    }

    "evaluateGuess gives all 0s when no letters match in position" {
        val result = evaluateGuess("zzzzz", "apple")
        result shouldBe listOf(0, 0, 0, 0, 0)
    }


    "pickRandomWord reduces the size of the list by one" {
        val words = mutableListOf("apple", "grape", "stone")
        val oldSize = words.size

        pickRandomWord(words)

        words.size shouldBe (oldSize - 1)
    }

    "pickRandomWord returns a word that was originally in the list" {
        val words = mutableListOf("apple", "grape", "stone")
        val copy = words.toList()

        val chosen = pickRandomWord(words)

        copy.contains(chosen) shouldBe true
    }

    // readWordList

    "readWordList loads at least one word from data file" {
        val words = readWordList("data/words.txt")
        (words.isNotEmpty()) shouldBe true
    }

    "readWordList only returns valid 5-letter words" {
        val words = readWordList("data/words.txt")

        var allValid = true
        for (w in words) {
            if (!isValid(w)) {
                allValid = false
            }
        }

        allValid shouldBe true
    }

})
