package com.pengolahannilaimhs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Path Testing - PerhitunganNilai")
public class PerhitunganNilaiTest {

    private PerhitunganNilai calculator;

    @BeforeEach
    public void setup() {
        calculator = new PerhitunganNilai();
    }

    // ===== PATH 1: Valid Input - Normal Result (1-3-4-6) =====
    
    @Test
    @DisplayName("TC1: P1 - Normal calculation with valid input (tugas=30, UTS=40, UAS=50)")
    public void testTC01_P1_NormalCalculation() {
        // Arrange
        double tugas = 30, uts = 40, uas = 50;
        double expected = 41.0;

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(expected, actual, 0.01, "Perhitungan nilai akhir tidak sesuai");
    }

    @Test
    @DisplayName("TC2: P1 - Upper boundary calculation (tugas=100, UTS=100, UAS=100)")
    public void testTC02_P1_UpperBoundary() {
        // Arrange
        double tugas = 100, uts = 100, uas = 100;
        double expected = 100.0;

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(expected, actual, 0.01, "Perhitungan pada batas atas tidak sesuai");
    }

    @Test
    @DisplayName("TC3: P1 - Lower boundary calculation (tugas=0, UTS=0, UAS=0)")
    public void testTC03_P1_LowerBoundary() {
        // Arrange
        double tugas = 0, uts = 0, uas = 0;
        double expected = -1.0; // Validation fails due to all zeros

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(expected, actual, "Input nol seharusnya gagal validasi");
    }

    @Test
    @DisplayName("TC10: P4 - Boundary test with equal values (tugas=50, UTS=50, UAS=50)")
    public void testTC10_P4_BoundaryEqual() {
        // Arrange
        double tugas = 50, uts = 50, uas = 50;
        double expected = 50.0;

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(expected, actual, 0.01, "Perhitungan dengan nilai sama tidak sesuai");
    }

    // ===== PATH 2: Validation Failed (1-2) =====

    @Test
    @DisplayName("TC4: P2 - Validation fails: All values = 0 (not input yet)")
    public void testTC04_P2_ValidationFails_AllZero() {
        // Arrange
        double tugas = 0, uts = 0, uas = 0;

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(-1.0, actual, "Validasi (0,0,0) seharusnya gagal dengan return -1");
    }

    @Test
    @DisplayName("TC5: P2 - Validation fails: tugas < 0")
    public void testTC05_P2_ValidationFails_NegativeTugas() {
        // Arrange
        double tugas = -10, uts = 50, uas = 50;

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(-1.0, actual, "Input nilai negatif seharusnya gagal validasi");
    }

    @Test
    @DisplayName("TC6: P2 - Validation fails: UTS > 100")
    public void testTC06_P2_ValidationFails_UTS_OutOfRange() {
        // Arrange
        double tugas = 50, uts = 105, uas = 50;

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(-1.0, actual, "Input UTS > 100 seharusnya gagal validasi");
    }

    @Test
    @DisplayName("TC7: P2 - Validation fails: UAS > 100")
    public void testTC07_P2_ValidationFails_UAS_OutOfRange() {
        // Arrange
        double tugas = 50, uts = 50, uas = 150;

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(-1.0, actual, "Input UAS > 100 seharusnya gagal validasi");
    }

    @Test
    @DisplayName("TC5b: P2 - Validation fails: tugas > 100")
    public void testTC05b_P2_ValidationFails_TugasOutOfRange() {
        // Arrange
        double tugas = 110, uts = 50, uas = 50;

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(-1.0, actual, "Input tugas > 100 seharusnya gagal validasi");
    }

    // ===== PATH 3: Valid Input but nilaiAkhir > 100 (1-3-4-5) =====
    // Note: Path ini secara logic tidak dapat dicapai dengan formula (0.3*t)+(0.3*u)+(0.4*a) 
    // ketika semua input dalam range 0-100. Hasil maksimal = 100.
    // Test ini untuk dokumentasi bahwa edge case check ada di kode.

    @Test
    @DisplayName("TC8: P3 - Edge case: Verify formula never exceeds 100 with valid input")
    public void testTC08_P3_EdgeCase_MaxValidInput() {
        // Arrange: Try to exceed 100 (impossible with this formula and valid inputs)
        double tugas = 100, uts = 100, uas = 100;
        // Expected: 0.3*100 + 0.3*100 + 0.4*100 = 30 + 30 + 40 = 100

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertTrue(actual >= 0 && actual <= 100.0, 
            "Hasil perhitungan harus dalam range 0-100 dengan input valid");
        assertEquals(100.0, actual, 0.01, "Nilai maksimal seharusnya = 100");
    }

    // ===== Additional Boundary Tests =====

    @Test
    @DisplayName("Additional: Minimum valid values (tugas=1, UTS=1, UAS=1)")
    public void testAdditional_MinimumValidValues() {
        // Arrange
        double tugas = 1, uts = 1, uas = 1;
        double expected = 0.3 + 0.3 + 0.4; // 1.0

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(expected, actual, 0.01, "Perhitungan nilai minimum valid tidak sesuai");
    }

    @Test
    @DisplayName("Additional: Mid-range values (tugas=70, UTS=80, UAS=75)")
    public void testAdditional_MidRangeValues() {
        // Arrange
        double tugas = 70, uts = 80, uas = 75;
        double expected = (0.3 * 70) + (0.3 * 80) + (0.4 * 75); // 21 + 24 + 30 = 75

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(expected, actual, 0.01, "Perhitungan mid-range tidak sesuai");
    }

    @Test
    @DisplayName("Additional: Validation fails - tugas negative")
    public void testAdditional_NegativeTugas() {
        // Arrange
        double tugas = -5, uts = 50, uas = 50;

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(-1.0, actual, "Input tugas negatif harus gagal validasi");
    }

    @Test
    @DisplayName("Additional: Validation fails - UTS negative")
    public void testAdditional_NegativeUTS() {
        // Arrange
        double tugas = 50, uts = -5, uas = 50;

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(-1.0, actual, "Input UTS negatif harus gagal validasi");
    }

    @Test
    @DisplayName("Additional: Validation fails - UAS negative")
    public void testAdditional_NegativeUAS() {
        // Arrange
        double tugas = 50, uts = 50, uas = -5;

        // Act
        double actual = calculator.hitungNilaiAkhir(tugas, uts, uas);

        // Assert
        assertEquals(-1.0, actual, "Input UAS negatif harus gagal validasi");
    }
}
