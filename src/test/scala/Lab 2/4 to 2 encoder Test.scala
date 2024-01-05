package Lab2

import chisel3._
import org.scalatest._
import chiseltest._

class encoderTest extends FreeSpec with ChiselScalatestTester {
    "4 to 2 Test" in {
        test(new mux_onehot_4to1()){
            C =>
            C.io.in0.poke(2.U)
            C.io.in1.poke(5.U)
            C.io.in2.poke(6.U)
            C.io.in3.poke(8.U)
            C.io.sel.poke(2.U)
            C.clock.step(50)
        }
    }
    println((new chisel3.stage.ChiselStage).emitVerilog(new mux_onehot_4to1()))
}