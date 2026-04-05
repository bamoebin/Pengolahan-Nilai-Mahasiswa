package com.pengolahannilaimhs;

public class PenentuanGrade {
    public String tentukanGrade(double nilaiAkhir) {

        if (nilaiAkhir < 0 || nilaiAkhir > 100) return "Error";
        
        if (nilaiAkhir >= 85) return "A";

        else if (nilaiAkhir >= 70) return "B";

        else if (nilaiAkhir >= 60) return "C";

        else if (nilaiAkhir >= 50) return "D";
        
        else return "E";                       
    }
}