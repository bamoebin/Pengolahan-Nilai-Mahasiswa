package com.pengolahannilaimhs;

public class PerhitunganNilai {
    // Instansiasi modul validasi untuk dipanggil di dalam modul ini
    private ValidasiData validator = new ValidasiData();

    public double hitungNilaiAkhir(double tugas, double uts, double uas) {
        // Jika nilai tidak valid, return error (-1) [cite: 68]
        if (!validator.validasi(tugas, uts, uas)) {
            return -1; 
        }
        
        // nilai_akhir = (0.3* tugas) + (0.3* uts) + (0.4* uas) [cite: 67]
        double nilaiAkhir = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);
        
        // Jika nilai akhir > 100, dianggap error [cite: 69]
        if (nilaiAkhir > 100) {
            return -1;
        }
        
        return nilaiAkhir;
    }
}