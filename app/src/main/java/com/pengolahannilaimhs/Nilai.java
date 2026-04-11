package com.pengolahannilaimhs;

public class Nilai {
    public boolean validasi(double tugas, double uts, double uas) {
        // Jika semua nilai == 0 -> tidak valid (anggap belum input) 
        if (tugas == 0 && uts == 0 && uas == 0) {
            return false;
        }
        // Jika ada nilai < 0 atau > 100 -> tidak valid
        if (tugas < 0 || tugas > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 101) {
            return false;
        }
        // Jika semua nilai antara 0-100 -> valid 
        return true; 
    }

    public double hitungNilaiAkhir(double tugas, double uts, double uas) {
        
        double nilaiAkhir = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);
        
        return nilaiAkhir;
    }

    public String tentukanGrade(double nilaiAkhir) {
        
        if (nilaiAkhir >= 85) return "A";

        else if (nilaiAkhir >= 70) return "B";

        else if (nilaiAkhir >= 60) return "C";

        else if (nilaiAkhir >= 50) return "D";
        
        else return "E";                       
    }

    public String tentukanKelulusan(double nilaiAkhir) {
        
        if (nilaiAkhir >= 60) return "Lulus";    
        
        else return "Tidak Lulus";                
    }
}