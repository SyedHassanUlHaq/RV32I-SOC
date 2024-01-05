package Lab6

import chisel3._
import chisel3.util._

class up_down_counter ( val max : Int) extends Module {
    val io = IO(new Bundle{
        val out = Output(UInt(log2Ceil(max).W))
        val up_down = Input(Bool())
    })
    val count = RegInit(0.U(log2Ceil(max).W))
    when((io.up_down === 1.B) && (count =/= (max.U - 1.U))){
        count := count + 1.U
    }.elsewhen((io.up_down === 0.B) || (count =/= 0.U)){
        count := count - 1.U
    }
    io.out := count
}