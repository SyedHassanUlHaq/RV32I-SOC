package pipelining

import chisel3._
import chisel3.util._

class if_id extends Module{
    val io = IO(new Bundle{
        val in_pc = Input(SInt(32.W))
        val in_pc4 = Input(SInt(32.W))
        val in_inst = Input(UInt(32.W))

        val pc_out = Output(SInt(32.W))
        val pc4_out = Output(SInt(32.W))
        val inst_out = Output(UInt(32.W))
    })
   // val reg_inst = RegInit(0.U(32.W))
    val reg_opCode = RegInit(0.U(32.W))
    val reg_pc = RegInit(0.S(32.W))
    val reg_pc4 = RegInit(0.S(32.W))
    val reg_imm = RegInit(0.U(32.W))
    val reg_inst = RegInit(0.U(32.W))

    reg_inst := io.in_inst
    reg_pc := io.in_pc
    reg_pc4 := io.in_pc4

    io.inst_out := reg_inst
    io.pc_out := reg_pc
    io.pc4_out := reg_pc4
}