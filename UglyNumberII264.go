package main

import (
    "fmt"
)

func main() {
    var num int

    fmt.Scan(&num)
    fmt.Println("answer", isUgly(num))
}

func isUgly(n int) bool {
    if n <= 0 {
        return false
    }    
    if n == 1 {
        return true
    }

    primeFactors := []int {2, 3, 5}
    for _, pf := range primeFactors {
        for n % pf == 0 {
            n /= pf
        }
    }

    return n == 1
}
