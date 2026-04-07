package com.pengolahannilaimhs;

public class PerhitunganNilai {
    // Instansiasi modul validasi untuk dipanggil di dalam modul ini
    private ValidasiData validator = new ValidasiData();

    public double hitungNilaiAkhir(double tugas, double uts, double uas) {
        // Jika nilai tidak valid, return error (-1) [cite: 68]
        if (!validator.validasi(tugas, uts, uas)) { // Node 1: Entry & Pemanggilan validator.validasi
            return -1; // Node 2: Exit (Data tidak valid)
        }
        
        // Node 3: Proses perhitungan sekuensial
        // nilai_akhir = (0.3* tugas) + (0.3* uts) + (0.4* uas) [cite: 67]
        double nilaiAkhir = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);
        
        // Node 4: Keputusan pengecekan batas atas nilaiAkhir
        // Jika nilai akhir > 100, dianggap error [cite: 69]
        if (nilaiAkhir > 100) {
            return -1; // Node 5: Exit (Nilai melebihi batas)
        }
        
        return nilaiAkhir; // Node 6: Exit (Hasil normal)
    }
}