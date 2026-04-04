package com.pengolahannilaimhs;

public class PenentuanGrade {
    public String tentukanGrade(double nilaiAkhir) {
        if (nilaiAkhir < 0 || nilaiAkhir > 100) return "Error";
        
        if (nilaiAkhir >= 85) return "A";      // [cite: 75]
        else if (nilaiAkhir >= 70) return "B"; // [cite: 76]
        else if (nilaiAkhir >= 60) return "C"; // [cite: 77]
        else if (nilaiAkhir >= 50) return "D"; // [cite: 78]
        else return "E";                       // [cite: 79]
    }
}