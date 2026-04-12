package com.pengolahannilaimhs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("White Box Path Testing - PenentuanKelulusan")
public class PenentuanKelulusanTest {

    private Nilai penentu;

    @BeforeEach
    public void setup() {
        penentu = new Nilai();
    }

    @Test
    @DisplayName("TC1: P1 - 1→2→4 Kalkulasi status kelulusan nilaiAkhir di antara range Lulus (nilaiAkhir=75.0)")
    public void testTC01_P1_Lulus_MidRange() {
        
        double nilaiAkhir = 75.0;
        String expected = "Lulus";
        String actual = penentu.tentukanKelulusan(nilaiAkhir);
        assertEquals(expected, actual, "Perhitungan status kelulusan di range Lulus tidak sesuai");
    }

    @Test
    @DisplayName("TC2: P1 - 1→2→4 Kalkulasi status kelulusan pada batas bawah Lulus (nilaiAkhir=60.0)")
    public void testTC02_P1_Lulus_LowerBoundary() {
        
        double nilaiAkhir = 60.0;
        String expected = "Lulus";
        String actual = penentu.tentukanKelulusan(nilaiAkhir);
        assertEquals(expected, actual, "Perhitungan status kelulusan pada batas 60 tidak sesuai");
    }

    @Test
    @DisplayName("TC3: P1 - 1→2→4 Kalkulasi status kelulusan pada batas atas nilai valid (nilaiAkhir=100.0)")
    public void testTC03_P1_Lulus_UpperBoundary() {
        
        double nilaiAkhir = 100.0;
        String expected = "Lulus";
        String actual = penentu.tentukanKelulusan(nilaiAkhir);
        assertEquals(expected, actual, "Perhitungan status kelulusan pada nilai 100 tidak sesuai");
    }

    @Test
    @DisplayName("TC4: P2 - 1→3→4 Kalkulasi status kelulusan nilaiAkhir di antara range Tidak Lulus (nilaiAkhir=45.0)")
    public void testTC04_P2_TidakLulus_MidRange() {
        
        double nilaiAkhir = 45.0;
        String expected = "Tidak Lulus";
        String actual = penentu.tentukanKelulusan(nilaiAkhir);
        assertEquals(expected, actual, "Perhitungan status kelulusan di range Tidak Lulus tidak sesuai");
    }

    @Test
    @DisplayName("TC5: P2 - 1→3→4 Kalkulasi status kelulusan pada batas atas Tidak Lulus (nilaiAkhir=59.0)")
    public void testTC05_P2_TidakLulus_UpperBoundary() {
        
        double nilaiAkhir = 59.0;
        String expected = "Tidak Lulus";
        String actual = penentu.tentukanKelulusan(nilaiAkhir);
        assertEquals(expected, actual, "Perhitungan status kelulusan pada nilai 59 tidak sesuai");
    }

    @Test
    @DisplayName("TC6: P2 - 1→3→4 Kalkulasi status kelulusan pada batas bawah nilai minimum (nilaiAkhir=0.0)")
    public void testTC06_P2_TidakLulus_LowerBoundary() {
        
        double nilaiAkhir = 0.0;
        String expected = "Tidak Lulus";
        String actual = penentu.tentukanKelulusan(nilaiAkhir);
        assertEquals(expected, actual, "Perhitungan status kelulusan pada nilai 0 tidak sesuai");
    }
}