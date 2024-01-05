package Lab6

import chisel3._
import chisel3.util._

class counter_with_xor(val max: Int) extends Module {
    val io = IO(new Bundle{
        val out = Output(UInt((log2Ceil(max).W)))
    })
    val count = RegInit(0.U(log2Ceil(max).W))
    when(((max - 1).U ^ 1.U) =/= 1.U){
        count := count + 1.U
    }.otherwise{
        count := 0.U
    }
    io.out := count
}