package Lab1

import chisel3._
import org.scalatest._
import chiseltest._

class countTest extends FreeSpec with ChiselScalatestTester{
    "count test" in {
        test(new Counter(4, 16)) {
            C =>
            C.clock.step(80)
        }
    }
}