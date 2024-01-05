package Lab7

import chisel3._
import chisel3.util._

class My_Queue extends Module {
    val io = IO(new Bundle{
        val f1 = Input(Bool())
        val f2 = Input(Bool())
        val r1 = Input(Bool())
        val r2 = Input(Bool())
        val out = Output(UInt(3.W))
    })
    val s0 :: s1 :: s2 :: s3 :: s4 :: s5 :: Nil = Enum(6)
    val state = RegInit(s4)
    io.out := 0.U
    switch(state){
        is (s0){
            when(!io.f1 && !io.f2){
                io.out := 0.U
                state := s0
            }.elsewhen(io.f1 && !io.f2){
                io.out := 0.U
                state := s1
            }.elsewhen(!io.f1 && io.f2){
                io.out := 0.U
                state := s5
            }.elsewhen(io.f1 && io.f2){
                io.out := 0.U
                state := s1
            }
        }
        is(s1){
            when(!io.f1 && !io.r1){
                io.out := 0.U
                state := s1
            }.elsewhen(io.f1){
                io.out := 0.U
                state := s2
            }.elsewhen(!io.f1 && io.r1){
                io.out := 0.U
                state := s0
            }
        }
        is(s2){
            when (!io.f1 && !io.r1){
                io.out := 3.U
                state := s2
            }.elsewhen(io.f1){
                io.out := 3.U
                state := s3            
            }.elsewhen(!io.f1 && io.r1){
                io.out := 3.U
                state := s1
            }
        }
        is (s3){
            io.out := 0.U
            state := s0
        }
        is(s4){
            when(io.f2){
                io.out :=  7.U
                state := s3
            }.elsewhen(!io.f2 && !io.r2){
                io.out := 7.U
                state := s4
            }.elsewhen(!io.f2 && io.r2){
                io.out := 7.U
                state := s5
            }
        }
        is(s5){
            when(io.f2){
                io.out := 0.U
                state := s4
            }.elsewhen(!io.f2 && !io.r2){
                io.out := 0.U
                state := s5
            }.elsewhen(!io.f2 && io.r2){
                io.out := 0.U
                state := s0
            }
        }
    }
}