package com.pengolahannilaimhs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("White Box Path Testing - PerhitunganNilai")
public class PerhitunganNilaiTest {

    private Nilai calculator;

    @BeforeEach
    public void setup() {
        calculator = new Nilai();
    }
    
    @Test
    @DisplayName("TC1: P1 - 1→2→3 Kalkulasi nilaiAkhir dengan nilai normal (tugas=80, uts=75, uas=100)")
    public void testTC01_P1_NormalCalculation() {
        
        double tugas = 80, uts = 75, uas = 100;
        double expected = 86.5;
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);
        assertEquals(expected, actual, 0.01, "Perhitungan nilai akhir tidak sesuai");
    }

    @Test
    @DisplayName("TC2: P1 - 1→2→3 Kalkulasi nilaiAkhir pada batas atas (tugas=100, uts=100, uas=100)")
    public void testTC02_P1_UpperBoundary() {
        
        double tugas = 100, uts = 100, uas = 100;
        double expected = 100.0;
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);
        assertEquals(expected, actual, 0.01, "Perhitungan pada batas atas tidak sesuai");
    }

    @Test
    @DisplayName("TC3: P1 - 1→2→3 Kalkulasi nilaiAkhir pada batas bawah (tugas=0, uts=0, uas=0)")
    public void testTC03_P1_LowerBoundary() {
        
        double tugas = 0, uts = 0, uas = 0;
        double expected = 0.0;
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);
        assertEquals(expected, actual, 0.01, "Perhitungan dengan nilai 0 harus = 0");
    }

    @Test
    @DisplayName("TC4: P1 - 1→2→3 Kalkulasi nilaiAkhir dengan bobot tugas dominan (tugas=100, uts=0, uas=0)")
    public void testTC04_P1_DominantTugas() {
        
        double tugas = 100, uts = 0, uas = 0;
        double expected = 30.0;
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);
        assertEquals(expected, actual, 0.01, "Perhitungan dengan bobot tugas dominan tidak sesuai");
    }

    @Test
    @DisplayName("TC5: P1 - 1→2→3 Kalkulasi nilaiAkhir dengan bobot uas dominan (tugas=0, uts=0, uas=100)")
    public void testTC05_P1_DominantUAS() {
        
        double tugas = 0, uts = 0, uas = 100;
        double expected = 40.0;
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);
        assertEquals(expected, actual, 0.01, "Perhitungan dengan bobot UAS dominan tidak sesuai");
    }

    @Test
    @DisplayName("TC6: P1 - 1→2→3 Kalkulasi nilaiAkhir dengan nilai desimal (tugas=75.5, uts=80.5, uas=90.0)")
    public void testTC06_P1_DecimalValues() {
        
        double tugas = 75.5, uts = 80.5, uas = 90.0;
        double expected = 82.8;
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);
        assertEquals(expected, actual, 0.01, "Perhitungan dengan nilai desimal tidak sesuai");
    }
}
