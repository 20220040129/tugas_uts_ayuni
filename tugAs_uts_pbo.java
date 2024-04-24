import java.util.Scanner;

// Interface untuk pembayaran honor
interface PembayaranHonor {
    void hitungHonor();
    void displayInfo();
}


// Kelas turunan dari Pegawai untuk Karyawan
class Karyawan implements PembayaranHonor {
    private int totalHonor;
    protected String nama;
    protected int jamKerja;
    private static final int UANG_LEMBUR = 50000;
    private static final int UANG_REGULER = 25000;

    public Karyawan(String nama, int jamKerja) {
        this.nama = nama;
        this.jamKerja = jamKerja;
        hitungHonor();
    }

    @Override
    public void hitungHonor() {
        if (jamKerja > 40) {
            int jamLembur = jamKerja - 40;
            totalHonor = (jamLembur * UANG_LEMBUR) + (40 * UANG_REGULER);
        } else {
            totalHonor = jamKerja * UANG_REGULER;
        }
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Total honor: Rp" + totalHonor);
    }
}

// Kelas utama
public class Honor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama karyawan: ");
        String nama = input.nextLine();
        System.out.print("Masukkan jumlah jam kerja: ");
        int jamKerja = input.nextInt();

        PembayaranHonor pembayaranHonor = new Karyawan(nama, jamKerja);
        pembayaranHonor.displayInfo();

        input.close();
    }
}
