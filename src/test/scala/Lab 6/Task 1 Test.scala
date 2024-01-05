package Lab6

import chisel3._
import org.scalatest._
import chiseltest._

class counter2Test extends FreeSpec with ChiselScalatestTester{
    "counter Test T1 lab6"in{
        test(new counter2(13)){
            C =>
            C.clock.step(50)
        }
    }
}