package Lab2

import chisel3._
import org.scalatest._
import chiseltest._

class MuxTest extends FreeSpec with ChiselScalatestTester{
    "MUX Test" in {
        test(new Mux_5to1()){
            C =>
            C.io.in0.poke(5.U)
            C.io.in1.poke(8.U)
            C.io.in2.poke(16.U)
            C.io.in3.poke(24.U)
            C.io.in4.poke(30.U)
            C.io.s0.poke(0.B)
            C.io.s1.poke(1.B)
            C.io.s2.poke(0.B)
            C.clock.step(10)
        }
    }
println((new chisel3.stage.ChiselStage).emitVerilog ( new Mux_5to1 ))
}