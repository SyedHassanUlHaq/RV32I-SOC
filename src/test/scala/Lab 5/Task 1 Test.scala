package Lab5

import chisel3._
import org.scalatest._
import chiseltest._

class par_adderTest extends FreeSpec with ChiselScalatestTester{
    "parameterized adder" in{
        test(new Adder(16)){
            C => 
            C.io.in0.poke(3.U)
            C.io.in1.poke(6.U)
            C.clock.step(20)
        }
    }
}