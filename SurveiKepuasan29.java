import java.util.Scanner;

public class SurveiKepuasan29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int JUMLAH_RESPONDEN = 10;
        final int JUMLAH_PERTANYAAN = 6;

        int[][] survei = new int[JUMLAH_RESPONDEN][JUMLAH_PERTANYAAN];
        int total = 0;

        System.out.println("=== A. INPUT HASIL SURVEI ===");
        System.out.println("Masukkan nilai survei (skala 1 sampai 5) untuk setiap responden dan pertanyaan:\n");

        for (int i = 0; i < JUMLAH_RESPONDEN; i++) {
            System.out.println("Responden ke-" + (i + 1) + ":");
            for (int j = 0; j < JUMLAH_PERTANYAAN; j++) {
                do {
                    System.out.print("  Pertanyaan ke-" + (j + 1) + " (1-5): ");
                    survei[i][j] = scanner.nextInt();
                    if (survei[i][j] < 1 || survei[i][j] > 5) {
                        System.out.println("  [Peringatan] Nilai harus antara 1 sampai 5. Silakan ulangi.");
                    }
                } while (survei[i][j] < 1 || survei[i][j] > 5);
            }
            System.out.println();
        }

        System.out.println("==================================================");
        System.out.println("=== B. NILAI RATA-RATA UNTUK SETIAP RESPONDEN ===");
        System.out.println("==================================================");
        
        for (int i = 0; i < JUMLAH_RESPONDEN; i++) {
            double jumlahResponden = 0;
            for (int j = 0; j < JUMLAH_PERTANYAAN; j++) {
                jumlahResponden += survei[i][j];
            }
            double rataResponden = jumlahResponden / JUMLAH_PERTANYAAN;
            System.out.printf("Rata-rata Responden ke-%d : %.2f\n", (i + 1), rataResponden);

            total += jumlahResponden;
        }

        System.out.println("\n==================================================");
        System.out.println("=== C. NILAI RATA-RATA UNTUK SETIAP PERTANYAAN ===");
        System.out.println("==================================================");
        
        for (int j = 0; j < JUMLAH_PERTANYAAN; j++) {
            double jumlahPertanyaan = 0;
            for (int i = 0; i < JUMLAH_RESPONDEN; i++) {
                jumlahPertanyaan += survei[i][j];
            }
            double rataPertanyaan = jumlahPertanyaan / JUMLAH_RESPONDEN;
            System.out.printf("Rata-rata Pertanyaan ke-%d : %.2f\n", (j + 1), rataPertanyaan);
        }

        System.out.println("\n==================================================");
        System.out.println("=== D. NILAI RATA-RATA KESELURUHAN ==============");
        System.out.println("==================================================");
        
        double rataTotal = (double) total / (JUMLAH_RESPONDEN * JUMLAH_PERTANYAAN);
        System.out.printf("Rata-rata Keseluruhan      : %.2f\n", rataTotal);
        System.out.println("==================================================");

        scanner.close();
    }
}