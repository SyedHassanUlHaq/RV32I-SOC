package Lab6

import chisel3._
import chisel3.util._
class counter2 (val max: Int, val min: Int = 0) extends Module {
    val io = IO(new Bundle{
        val out = Output(UInt(log2Ceil(max).W))
    })
    val counter = RegInit(min.U(log2Ceil(max).W))
    val count_buffer = if(isPow2(max) && (min == 0)) counter + 1.U
    else Mux(counter === max.U, min.U, counter + 1.U)
    counter := count_buffer
    io.out := counter
}