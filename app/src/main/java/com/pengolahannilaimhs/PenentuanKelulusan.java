package com.pengolahannilaimhs;

public class PenentuanKelulusan {
    public String tentukanKelulusan(double nilaiAkhir) {

        if (nilaiAkhir < 0 || nilaiAkhir > 100) return "Error";
        
        if (nilaiAkhir >= 60) return "Lulus";    
        
        else return "Tidak Lulus";                
    }
}