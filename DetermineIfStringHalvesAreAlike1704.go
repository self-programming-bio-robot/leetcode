func halvesAreAlike(s string) bool {
    vowels := map[byte] int8 {
        'a': 0, 
        'e': 0, 
        'i': 0, 
        'o': 0,
        'u': 0,
        'A': 0, 
        'E': 0,
        'I': 0, 
        'O': 0, 
        'U': 0,
    }
    length := len(s) / 2
    var a int = 0
    var b int = 0
    
    for ind := 0; ind < length; ind++ {
        _, okA := vowels[s[ind]]
        _, okB := vowels[s[ind + length]]
        if okA {
            a++
        }
        if okB {
            b++
        }
    }

    return a == b
}
