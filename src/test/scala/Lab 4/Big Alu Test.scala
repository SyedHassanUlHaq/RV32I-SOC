package Lab4

import chisel3._
import chiseltest._
import org.scalatest._

class BugTest extends FreeSpec with ChiselScalatestTester {
    "Bug Alu  Test" in {
        test(new ALU){
            C =>
            C.io.in_A.poke(5.U)
            C.io.in_B.poke(2.U)
            C.io.alu_Op.poke(7.U)
            C.clock.step(50)
        }
    }
}