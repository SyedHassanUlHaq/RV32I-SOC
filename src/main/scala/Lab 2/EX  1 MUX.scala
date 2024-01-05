package Lab2

import chisel3 . _
import chisel3.util._
import chisel3.util._
class LM_IO_Interface extends Bundle{
  val in0 = Input(UInt(5.W))
  val in1 = Input(UInt(5.W))
  val in2 = Input(UInt(5.W))
  val in3 = Input(UInt(5.W))
  val in4 = Input(UInt(5.W))
  val s0 = Input(Bool()) 
  val s1 = Input(Bool())
  val s2 = Input(Bool())
  val out = Output (UInt(32.W))
}
class Mux_5to1 extends Module{
  val io = IO (new LM_IO_Interface)

val Mux2_to_1_a = Mux(io.s0, io.in1, io.in0)
val Mux2_to_1_b = Mux(io.s0, io.in3, io.in2)
val Mux2_to_1_c = Mux(io.s1, Mux2_to_1_b, Mux2_to_1_a)
val Mux2_to_1 = Mux(io.s2, io.in4, Mux2_to_1_c)

io.out := Mux2_to_1

}
