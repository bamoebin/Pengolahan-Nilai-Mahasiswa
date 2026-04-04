package com.pengolahannilaimhs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidasiDataTest {

    private ValidasiData validator;

    @BeforeEach
    public void setup() {
        validator = new ValidasiData();
    }

    // --- GROUP 1: Uji Blok Kondisi && (Anggap Belum Input) ---
    
    @Test
    public void testTC01_SemuaNol() {
    assertFalse(validator.validasi(0, 0, 0), "Gagal di N3: Harusnya false");
    }

    @Test
    public void testTC02_UasBukanNol() {
    assertTrue(validator.validasi(0, 0, 50), "Lolos Blok 2: Harusnya true");
    }

    @Test
    public void testTC03_UtsBukanNol() {
    assertTrue(validator.validasi(0, 50, 0), "Lolos Blok 2: Harusnya true");
    }

    @Test
    public void testTC04_SkenarioNormalValid() {
    assertTrue(validator.validasi(50, 50, 50), "Lolos Blok 2: Harusnya true");
    }

    // --- GROUP 2: Uji Blok Kondisi || (Di Luar Rentang) ---
    
    @Test
    public void testTC05_TugasNegatif() {
    assertFalse(validator.validasi(-1, 50, 50), "Gagal N5 (Tugas < 0)");
    }

    @Test
    public void testTC06_TugasLebihDari100() {
    assertFalse(validator.validasi(101, 50, 50), "Gagal N6 (Tugas > 100)");
    }

    @Test
    public void testTC07_UtsNegatif() {
    assertFalse(validator.validasi(50, -1, 50), "Gagal N7 (UTS < 0)");
    }

    @Test
    public void testTC08_UtsLebihDari100() {
    assertFalse(validator.validasi(50, 101, 50), "Gagal N8 (UTS > 100)");
    }

    @Test
    public void testTC09_UasNegatif() {
    assertFalse(validator.validasi(50, 50, -1), "Gagal N9 (UAS < 0)");
    }

    @Test
    public void testTC10_UasLebihDari100() {
    assertFalse(validator.validasi(50, 50, 101), "Gagal N10 (UAS > 100)");
    }
}