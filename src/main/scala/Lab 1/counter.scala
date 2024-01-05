package Lab1

import chisel3._
import chisel3.util._
import java.io.File

class Count (counterBits : UInt) extends Module {
    val io = IO (new Bundle {
        val result = Output (Bool())
    })
val max = (1.U << counterBits )
val count = RegInit (0.U(6.W))
when (count === max){
    count := 0.U
}.otherwise{
    count := count + 1.U
    when (count === max + 1.U){
        count := 0.U
    }
}
io.result := count(4.U)
println( s" counter created with max value $max ")
}