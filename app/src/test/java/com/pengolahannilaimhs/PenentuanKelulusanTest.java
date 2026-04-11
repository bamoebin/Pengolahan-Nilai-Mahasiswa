package com.pengolahannilaimhs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PenentuanKelulusanTest {

    private Nilai penentu;

    @BeforeEach
    public void setup() {
        penentu = new Nilai();
    }

    @Test
    public void testPath1_NilaiNegatif() {
        // (1) setup
        double nilaiAkhir = -1;
        String actual;

        // (2) exercise
        actual = penentu.tentukanKelulusan(nilaiAkhir);

        // (3) verify
        assertEquals("Error", actual, "Gagal di Jalur 1 (nilai < 0)");
    }

    @Test
    public void testPath2_NilaiLebih100() {
        // (1) setup
        double nilaiAkhir = 101;
        String actual;

        // (2) exercise
        actual = penentu.tentukanKelulusan(nilaiAkhir);

        // (3) verify
        assertEquals("Error", actual, "Gagal di Jalur 2 (nilai > 100)");
    }

    @Test
    public void testPath3_Lulus() {
        // (1) setup
        double nilaiAkhir = 60;
        String actual;

        // (2) exercise
        actual = penentu.tentukanKelulusan(nilaiAkhir);

        // (3) verify
        assertEquals("Lulus", actual, "Gagal di Jalur 3 (nilai >= 60)");
    }

    @Test
    public void testPath4_TidakLulus() {
        // (1) setup
        double nilaiAkhir = 59.9;
        String actual;

        // (2) exercise
        actual = penentu.tentukanKelulusan(nilaiAkhir);

        // (3) verify
        assertEquals("Tidak Lulus", actual, "Gagal di Jalur 4 (nilai < 60)");
    }
}