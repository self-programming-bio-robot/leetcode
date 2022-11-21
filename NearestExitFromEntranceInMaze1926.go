package main

import (
    "fmt"
)

var testCases = []TestCase {
    TestCase {
        maze: [][]byte {{ 43, 43, 46, 43 },  {46, 46, 46, 43}, {43, 43, 43, 46}},
        entrance: []int { 1, 2 },
        expected: 1,
    },
}

type TestCase struct {
    maze [][]byte
    entrance []int
    expected int
}

func main() {
    for _, c := range testCases {
        fmt.Println("Test case:", c)
        answer := nearestExit(c.maze, c.entrance)
        fmt.Println("Your answer:", answer)
        if (answer != c.expected) {
            break
        }
    }
}

type Point struct {
    x int
    y int
    step int
}

var EMPTY_CELL byte = 46
var VISITED_CELL byte = 47

func nearestExit(maze [][]byte, entrance []int) int {
    n := len(maze)
    m := len(maze[0])

    var queue = make([]Point, 1, n)
    queue[0] = Point {
        y: entrance[0],
        x: entrance[1],
        step: 0,
    }

    var p Point

    for len(queue) > 0 {
        p, queue = queue[0], queue[1:]

        if (p.x != entrance[1] || p.y != entrance[0]) &&
            (p.x == 0 || p.x == m-1 || p.y == 0 || p.y == n-1) {
            return p.step
        }

        if (p.x > 0 && maze[p.y][p.x-1] == EMPTY_CELL) {
            queue = append(queue, 
                Point {
                    x: p.x - 1,
                    y: p.y,
                    step: p.step + 1,
                })
            maze[p.y][p.x-1] = VISITED_CELL
        }
        if (p.y > 0 && maze[p.y-1][p.x] == EMPTY_CELL) {
            queue = append(queue, 
                Point {
                    x: p.x,
                    y: p.y - 1,
                    step: p.step + 1,
                })
            maze[p.y-1][p.x] = VISITED_CELL
        }
        if (p.x < m - 1 && maze[p.y][p.x+1] == EMPTY_CELL) {
            queue = append(queue, 
                Point {
                    x: p.x + 1,
                    y: p.y,
                    step: p.step + 1,
                })
            maze[p.y][p.x+1] = VISITED_CELL
        }
        if (p.y < n - 1 && maze[p.y+1][p.x] == EMPTY_CELL) {
            queue = append(queue, 
                Point {
                    x: p.x,
                    y: p.y + 1,
                    step: p.step + 1,
                })
            maze[p.y+1][p.x] = VISITED_CELL
        }
    }

    return -1
}
