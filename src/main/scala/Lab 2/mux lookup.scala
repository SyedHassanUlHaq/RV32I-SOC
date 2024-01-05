package Lab2

import chisel3._
import chisel3.util._

class MuxLookup extends Module {
    val io = IO(new Bundle{
        val in0 = Input(UInt(32.W))
        val in1 = Input(UInt(32.W))
        val in2 = Input(UInt(32.W))
        val in3 = Input(UInt(32.W))
        val in4 = Input(UInt(32.W))
        val in5 = Input(UInt(32.W))
        val in6 = Input(UInt(32.W))
        val in7 = Input(UInt(32.W))
        val sel = Input(UInt(3.W))
        val out = Output(UInt(32.W))
    })
        val out_a = Wire(UInt(32.W))
        val out_b = Wire(UInt(32.W))
        val out_c = Wire(UInt(32.W))
        val out_d = Wire(UInt(32.W))
        val out_e = Wire(UInt(32.W))
        val out_f = Wire(UInt(32.W))
    out_a := MuxLookup(io.sel, 0.B, Array(
        (0.U) -> io.in0,
        (1.U) -> io.in1)
    )
    out_b := MuxLookup(io.sel, 0.B, Array(
        (0.U) -> io.in2,
        (1.U) -> io.in3)
    )
    out_c := MuxLookup(io.sel, 0.B, Array(
        (0.U) -> io.in4,
        (1.U) -> io.in5)
    )
    out_d := MuxLookup(io.sel, 0.B, Array(
        (0.U) -> io.in6,
        (1.U) -> io.in7)
    )
    out_e := MuxLookup(io.sel, 0.B, Array(
        (0.U) -> out_a,
        (1.U) -> out_b)
    )
    out_f := MuxLookup(io.sel, 0.B, Array(
        (0.U) -> out_c,
        (1.U) -> out_d)
    )
    io.out := MuxLookup(io.sel, 0.B, Array(
        (0.U) -> out_e,
        (1.U) -> out_f)
    )
}