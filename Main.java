// Parent class (Inheritance)
class Barang {
    String kodeBarang;
    String namaBarang;
    double hargaBarang;

    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }               

    public void displayBarang() {
        System.out.println("Kode Barang : " + kodeBarang);
        System.out.println("Nama Barang : " + namaBarang);
        System.out.printf("Harga Barang: %.2f\n", hargaBarang); // Format harga dua desimal
    }
}

// Child class (Inheritance)
class Transaksi extends Barang {
    String noFaktur;
    int jumlahBeli;
    double total;

    public Transaksi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang);
        this.noFaktur = noFaktur;
        this.jumlahBeli = jumlahBeli;
    }

    // Method untuk menghitung total harga
    public void hitungTotal() {
        total = hargaBarang * jumlahBeli;
    }

    // Override displayBarang untuk menampilkan detail transaksi
    @Override
    public void displayBarang() {
        System.out.println("No Faktur   : " + noFaktur);
        super.displayBarang();
        System.out.println("Jumlah Beli : " + jumlahBeli);
        System.out.printf("Total Harga : %.2f\n", total); // Format total dua desimal
    }
}

// Exception class untuk validasi input
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            // Simulasi input data
            String noFaktur = "F12345";
            String kodeBarang = "B001";
            String namaBarang = "Laptop";
            double hargaBarang = 7500000.0;
            int jumlahBeli = 2;

            // Validasi input
            if (hargaBarang <= 0 || jumlahBeli <= 0) {
                throw new InvalidInputException("Harga atau jumlah beli tidak valid!");
            }

            // Membuat objek transaksi
            Transaksi transaksi = new Transaksi(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);
            transaksi.hitungTotal();

            // Menampilkan detail transaksi
            transaksi.displayBarang();

        } catch (InvalidInputException e) {
            System.out.println("Kesalahan Input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
