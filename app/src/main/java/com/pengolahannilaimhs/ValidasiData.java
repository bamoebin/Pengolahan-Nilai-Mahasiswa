package com.pengolahannilaimhs; // Sesuaikan dengan nama package di VS Code kamu

public class ValidasiData {
    public boolean validasi(double tugas, double uts, double uas) {
        // Jika semua nilai == 0 -> tidak valid (anggap belum input) [cite: 60]
        if (tugas == 0 && uts == 0 && uas == 0) {
            return false;
        }
        // Jika ada nilai < 0 atau > 100 -> tidak valid [cite: 58-59]
        if (tugas < 0 || tugas > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 100) {
            return false;
        }
        // Jika semua nilai antara 0-100 -> valid [cite: 57]
        return true; 
    }
}