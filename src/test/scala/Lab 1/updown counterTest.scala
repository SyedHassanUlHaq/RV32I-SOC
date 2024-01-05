package Lab1

import chisel3._
import org.scalatest._
import chiseltest._

class updownCounterTest extends FreeSpec with ChiselScalatestTester{
    "up down test" in {
        test(new counter_up_down(4.U)){
            C=>
            C.clock.step(50)
        }
    }
}