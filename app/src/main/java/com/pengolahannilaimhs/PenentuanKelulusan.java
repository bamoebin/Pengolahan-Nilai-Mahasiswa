package com.pengolahannilaimhs;

public class PenentuanKelulusan {
    public String tentukanKelulusan(double nilaiAkhir) {
        if (nilaiAkhir < 0 || nilaiAkhir > 100) return "Error";
        
        if (nilaiAkhir >= 60) return "Lulus";     // [cite: 84-85]
        else return "Tidak Lulus";                // [cite: 86]
    }
}