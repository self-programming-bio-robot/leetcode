package main

import (
    "fmt"
)

type Rect struct {
    x1 int
    x2 int
    y1 int
    y2 int
}

type Req struct {
    r1 Rect
    r2 Rect
    expected int
}

var cases = []Req {
    Req {
        r1: Rect {
            x1: -3,
            x2: 3,
            y1: 0,
            y2: 4,
        },
        r2: Rect {
            x1: 0,
            x2: 9,
            y1: -1,
            y2: 2,
        },
        expected: 45,
    },
}

func main() {
    for _, req := range cases {
        fmt.Println("case:", req)
        answer := computeArea(req.r1.x1, req.r1.y1, req.r1.x2, req.r1.y2,
                              req.r2.x1, req.r2.y1, req.r2.x2, req.r2.y2)
        fmt.Println("Your answer:", answer)
        if answer != req.expected {
            break;
        }
    }
}

func computeArea(ax1 int, ay1 int, ax2 int, ay2 int, bx1 int, by1 int, bx2 int, by2 int) int {
    area1 := (ax2 - ax1) * (ay2 - ay1)
    area2 := (bx2 - bx1) * (by2 - by1)
    cross := intersectArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)

    return area1 + area2 - cross
}

func intersectArea(ax1 int, ay1 int, ax2 int, ay2 int, bx1 int, by1 int, bx2 int, by2 int) int {
    if ax1 >= bx2 || bx1 >= ax2 || ay1 >= by2 || by1 >= ay2 {
        return 0
    } else {
        width := min(ax2, bx2) - max(ax1, bx1)
        height := min(ay2, by2) - max(ay1, by1)
        return width * height
    }
}

func min(a, b int) int {
    if a <= b {
        return a
    }
    return b
}

func max(a, b int) int {
    if a >= b {
        return a
    }
    return b
}
