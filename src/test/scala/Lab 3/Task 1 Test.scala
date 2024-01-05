package Lab3

import chisel3._
import org.scalatest._
import chiseltest._

class branchTest extends FreeSpec with ChiselScalatestTester{
    "branch test" in {
        test(new BranchControl){
            C =>
            C.io.arg_x.poke(4.U)
            C.io.arg_y.poke(4.U)
            C.io.branch.poke(1.B)
            C.io.fnct3.poke("b001".U)
            C.clock.step(50)
        }
    }
}