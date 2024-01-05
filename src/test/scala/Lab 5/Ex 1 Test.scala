package Lab5

import chisel3._
import chiseltest._
import org.scalatest._

class ALUTest extends FreeSpec with ChiselScalatestTester {
    "ALU test" in{
        test(new ALU(4)){
            C => 
            C.io.arg_x.poke(5.U)
            C.io.arg_y.poke(6.U)
            C.io.alu_oper.poke("b0011".U)
            C.clock.step(50)
        }
    }
}