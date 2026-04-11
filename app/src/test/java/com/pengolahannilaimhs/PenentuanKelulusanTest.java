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
    public void testPath1_Lulus() {
        // (1) setup
        double nilaiAkhir = 60;
        String actual;

        // (2) exercise
        actual = penentu.tentukanKelulusan(nilaiAkhir);

        // (3) verify
        assertEquals("Lulus", actual, "Gagal di Jalur 1 (nilai >= 60)");
    }

    @Test
    public void testPath2_TidakLulus() {
        // (1) setup
        double nilaiAkhir = 59.9;
        String actual;

        // (2) exercise
        actual = penentu.tentukanKelulusan(nilaiAkhir);

        // (3) verify
        assertEquals("Tidak Lulus", actual, "Gagal di Jalur 2 (nilai < 60)");
    }
}