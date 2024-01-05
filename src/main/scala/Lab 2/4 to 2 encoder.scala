package Lab2

import chisel3._
import chisel3.util._
class mux_onehot_4to1 extends Module {
    val io = IO(new Bundle{
    val in0 = Input(UInt(16.W))
    val in1 = Input(UInt(16.W))
    val in2 = Input(UInt(16.W))
    val in3 = Input(UInt(16.W))
    val sel = Input(UInt(4.W))
    val out1 = Output(UInt(32.W))
    val out2 = Output(UInt(32.W))
    val out = Output(UInt(32.W))
})
    io.out1 := Mux1H (io.sel, Seq(io.in0, io.in1, io.in2, io.in3))
    io.out2 := Mux1H (io.sel, Seq(io.in3, io.in2, io.in1, io.in0))
    io.out := io.out1 + io.out2
}