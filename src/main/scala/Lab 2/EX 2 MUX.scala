package Lab2

import chisel3._
import chisel3.util._

class barrel_shift extends Module {
    val io = IO(new Bundle{
    val in = Vec(4,Input(Bool()))
    val sel = Vec(2,Input(Bool()))
    val shift_type = Input(Bool())
    val out = Vec(4,Output(Bool()))
})
// Start you code here
    val c = Wire(Bool())
    c := 0.U

val Mux2_to_1_a = Mux(io.shift_type, io.in(2), c)
val Mux2_to_1_b = Mux(io.shift_type, io.in(1), c)
val Mux2_to_1_c = Mux(io.shift_type, io.in(0), c)
val Mux4_to1_a = Mux1H(io.sel, Seq(Mux2_to_1_a, Mux2_to_1_b, Mux2_to_1_c, io.in(3)))
val Mux4_to1_b = Mux1H(io.sel, Seq(Mux2_to_1_b, Mux2_to_1_c, io.in(3), io.in(2)))
val Mux4_to1_c = Mux1H(io.sel, Seq(Mux2_to_1_c, io.in(3), io.in(2), io.in(3)))
val Mux4_to1_d = Mux1H(io.sel, Seq(io.in(3), io.in(2), io.in(1), io.in(0)))

io.out(0) := Mux4_to1_d
io.out(1) := Mux4_to1_c
io.out(2) := Mux4_to1_b
io.out(3) := Mux4_to1_a
}
// End your code here