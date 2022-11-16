package main

import (
    "fmt"
    "math/rand"
)

var hiddenNumber int

func main() {
    for i := 0; i < 10; i++ {
        hiddenNumber = rand.Intn(1000)
        answer := guessNumber(1000)
        fmt.Println("Picked number", hiddenNumber, "| your answer", answer)
    }
}

func guessNumber(n int) int {
    l := 0
    r := n

    for l < r {
        m := (r + l) / 2
        g := guess(m)

        if g == 0 {
            return m
        } else {
            if g == 1 {
                l = m + 1
            } else {
                r = m - 1
            }
        }
    }

    return r
}

func guess(num int) int {
    if (num == hiddenNumber) {
        return 0
    } else if (num < hiddenNumber) {
        return 1
    } else {
        return -1
    }
}
