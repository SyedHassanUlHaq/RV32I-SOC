package Lab3

import chisel3._
import chisel3.util._


class LM_IO_Interface_decoder_with_valid extends Bundle {
    val in = Input(UInt(2.W))
    val out = Output(UInt(4.W))
    val in_valid = Flipped(Valid(UInt(4.W))) 
    val out_valid = Valid(UInt(4.W))
}

class decoder_with_valid extends Module {
    val io = IO(new LM_IO_Interface_decoder_with_valid)

    io.out := 0.U
    io.in_valid := 1.U
    if (io.out_valid == 1.U){
        switch (io.in){
            is ("b00".U) {
                io.out := "b0001".U
            }
            is ("b01".U){
                io.out := "b0010".U
            }
            is ("b10".U) {
                io.out := "b0011".U
            }
            is ("b11".U) {
                io.out := "b0100".U
            }
        }
    }
}