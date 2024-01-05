package Lab6
import chisel3._
class shift_register(val init: Int = 1) extends Module {
    val io = IO(new Bundle {
        val in = Input(UInt(4.W))
        val out = Output(Bool())
    })
    io.out := 0.B
    val state = RegInit(0.U(4.W))
    val flag = RegInit(0.U(4.W))
    when(flag =/= 0.U){
        io.out := state
        state := state >> 1
    }.otherwise{
        flag := flag + 1.U
        state := io.in
    }
}