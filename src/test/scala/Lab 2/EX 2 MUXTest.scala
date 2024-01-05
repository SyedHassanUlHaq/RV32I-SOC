package Lab2

import chisel3._
import org.scalatest._
import chiseltest._

class barrelTest extends FreeSpec with ChiselScalatestTester {
    "Mux test" in {
        test(new barrel_shift()){
            C =>
            C.io.in(0).poke(0.B)
            C.io.in(1).poke(1.B)
            C.io.in(2).poke(1.B)
            C.io.in(3).poke(0.B)
            C.io.sel(0).poke(1.B)
            C.io.sel(1).poke(0.B)
            C.io.shift_type.poke(1.B)
            C.clock.step(50)

        }

    }
}

