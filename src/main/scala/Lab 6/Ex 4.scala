package Lab6

import chisel3._
import chisel3.util._

class My_Queue extends Module {
    val io = IO(new Bundle{
        val in = Flipped(Decoupled(UInt(8.W)))
        val out = Decoupled(UInt(8.W))
    })
    val q1 = Queue(io.in, 5)
    q1.deq()
    val q2 = Queue(q1, 5)
    q2.ready := 0.B
    when (q2.valid && io.out.ready){
        io.out.enq(q2.deq)
    }.otherwise{
        io.out.bits := 0.U
        io.out.valid := 0.B
    }
}