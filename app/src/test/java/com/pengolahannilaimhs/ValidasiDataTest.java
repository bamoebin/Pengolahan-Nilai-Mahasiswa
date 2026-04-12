package com.pengolahannilaimhs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidasiDataTest {

    private Nilai validator;

    @BeforeEach
    public void setup() {
        validator = new Nilai();
    }

    // --- GROUP 1: Uji Blok Kondisi && (Anggap Belum Input) ---
    
    @Test
    public void testTC01_SemuaNol() {
        // (1) setup (arrange, build)
        double tugas = 0, uts = 0, uas = 0;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal di N3: Harusnya false");
    }

    @Test
    public void testTC02_UasBukanNol() {
        // (1) setup (arrange, build)
        double tugas = 0, uts = 0, uas = 50;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertTrue(actual, "Lolos Blok 2: Harusnya true");
    }

    @Test
    public void testTC03_UtsBukanNol() {
        // (1) setup (arrange, build)
        double tugas = 0, uts = 50, uas = 0;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertTrue(actual, "Lolos Blok 2: Harusnya true");
    }

    @Test
    public void testTC04_SkenarioNormalValid() {
        // (1) setup (arrange, build)
        double tugas = 50, uts = 50, uas = 50;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertTrue(actual, "Lolos Blok 2: Harusnya true");
    }

    // --- GROUP 2: Uji Blok Kondisi || (Di Luar Rentang) ---
    
    @Test
    public void testTC05_TugasNegatif() {
        // (1) setup (arrange, build)
        double tugas = -1, uts = 50, uas = 50;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal N5 (Tugas < 0)");
    }

    @Test
    public void testTC06_TugasLebihDari100() {
        // (1) setup (arrange, build)
        double tugas = 101, uts = 50, uas = 50;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal N6 (Tugas > 100)");
    }

    @Test
    public void testTC07_UtsNegatif() {
        // (1) setup (arrange, build)
        double tugas = 50, uts = -1, uas = 50;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal N7 (UTS < 0)");
    }

    @Test
    public void testTC08_UtsLebihDari100() {
        // (1) setup (arrange, build)
        double tugas = 50, uts = 101, uas = 50;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal N8 (UTS > 100)");
    }

    @Test
    public void testTC09_UasNegatif() {
        // (1) setup (arrange, build)
        double tugas = 50, uts = 50, uas = -1;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal N9 (UAS < 0)");
    }

    @Test
    public void testTC10_UasLebihDari100() {
        // (1) setup (arrange, build)
        double tugas = 50, uts = 50, uas = 101;
        boolean actual;

        // (2) exercise (act, operate)
        actual = validator.validasi(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse(actual, "Gagal N10 (UAS > 100)");
    }
}