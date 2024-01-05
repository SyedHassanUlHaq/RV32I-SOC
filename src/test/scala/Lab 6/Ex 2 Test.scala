package Lab6

import chisel3._
import org.scalatest._
import chiseltest._

class counter1Test extends FreeSpec with ChiselScalatestTester{
    "lab 6 counter test" in{
        test(new counter1(9)){
            C =>
            C.clock.step(50)
        }
    }
}