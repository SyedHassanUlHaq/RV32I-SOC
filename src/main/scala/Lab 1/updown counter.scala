package Lab1

import chisel3._
import chisel3.util._
import java.io.File

class counter_up_down (n:UInt) extends Module {
    val io = IO (new Bundle {
        val out = Output (Bool())
})
    val max = RegInit((1.U << n) - 1.U(16.W))
    val counter = RegInit (0.U(6.W))
    var flag = (RegInit(0.U))
    io.out := 0.U
    when (counter === 0.U){
        flag := 0.U
    }
        when (flag === 0.U & counter =/= max){
            counter := counter + 1.U
        }
    when(counter === max){
        flag := 1.U
    }
        when(flag === 1.U & counter =/= 0.U){
            counter := counter-1.U
        }
    io.out := counter(4.U)
}