package Lab6

import chisel3._
import org.scalatest._
import chiseltest._

class up_down_counterTest extends FreeSpec with ChiselScalatestTester{
    "Lab 6 up down counter" in{
        test(new up_down_counter(16)){
            C =>
            C.io.up_down.poke(0.B)
            C.clock.step(50)
        }
    }
}