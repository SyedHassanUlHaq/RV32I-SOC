package Lab7

import chisel3._
import chisel3.util._

class Arbiter_Queue extends Module{
    val io = IO(new Bundle{
        val in1 = Flipped(Decoupled(UInt(16.W)))
        val in2 = Flipped(Decoupled(UInt(16.W)))
        val out = Decoupled(UInt(32.W))
    })
    io.in1.ready := 1.B
    io.in2.ready := 1.B
    val Q1 = Queue(io.in1, 5)
    val Q2 = Queue(io.in2, 5)
    val arb_priority = Module(new Arbiter(UInt(), 2))
    arb_priority.io.in(0) <> Q1
    arb_priority.io.in(1) <> Q2
    io.out <> arb_priority.io.out
}