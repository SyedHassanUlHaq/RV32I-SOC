package Lab5

import chisel3._
import chisel3.util

class Operator[T <: Data](n: Int, generic: T)(op: (T, T) => T) extends Module {
    require (n > 0)
    val io = IO(new Bundle {
    val in = Input(Vec(n, generic))
    val out = Output(Vec(n, generic))
    })
    for (x <- 0 until n)
    io.out(x) := io.in.reduce(op)
}