/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author Putri Chasanah
 */
public class sistemKepegawaian {

    static Scanner sc = new Scanner(System.in);
    static Scanner input = new Scanner(System.in);
    static String menu[] = { "[1] Informasi Pegawai(Data Pegawai,Edit Data,Tambah Data,Cari Data) ", "[2] Penggajian ",
            "[3] Permohanan cuti", "[4] Pelaporan Gaji" };
    static String subMenu1[] = { "[1] Tampilkan Data Pegawai", "[2] Edit Data Pegawai", "[3] Tambah data pegawai",
            "[4] Cari data pegawai" };
    static String subMenu2[] = { "[1] Cari berdasarkan nama", "[2] Cari berdasarkan kode pegawai" };
    static String dataPegawai[][] = {
            { "Abima Fachrido", "Probolinggo", "Laki-laki", "Kepala Cabang", "Aktif" },
            { "Agung Rizky", "Malang", "Laki-laki", "Manajer Pemasaran", "Aktif" },
            { "Alan Naufal", "Ngawi", "Laki-laki", "Manager Operasional", "Aktif" },
            { "Firstia Aulia", "Blitar", "Perempuan", "Supervisor Pely.Kas", "Aktif" },
            { "Dea Putri", "Blitar", "Perempuan", "Supervisor Pely.Intern", "Aktif" },
            { "Arya Chandra", "Sorong", "Laki-laki", "Supervisor ADK", "Aktif" },
            { "Alhamdana Fariz", "Malang", "Laki-laki", "AO Consumer", "Aktif" },
            { "Arrmand Maulana", "Lumajang", "Laki-laki", "AO Commercial", "Aktif" },
            { "Aulia Atha", "Batu", "Laki-laki", "ADK Commercial", "Aktif" },
            { "Cindy Vira", "Probolinggo", "Perempuan", "ADK Consumer", "Aktif" },
            { "Amanda Fadila", "Malang", "Perempuan", "Funding Officier", "Aktif" },
            { "FadhluRohman", "Tangerang", "Laki-laki", "Sekretariat SDM", "Aktif" },
            { "Tryo Bagus", "Sidoarjo", "Laki-laki", "Teller", "Aktif" },
            { "Maulita Yasmin", "Pasuruan", "Perempuan", "Account Officer", "Aktif" },
            { "Nizar Mahi", "Batu", "Laki-laki", "Staf Back Office", "Aktif" },
            { "Mochamad Zakaro", "Malang", "Laki-laki", "Payment Point", "Aktif" },
            { "Muhammad Ainur", "Gresik", "Laki-laki", "Customer Service", "Aktif" },
            { "Sukadi", "Malang", "Laki-laki", "Security", "Aktif" },
            { "Sandieo", "Malang", "Laki-laki", "Office Boy", "Aktif" },
            { "Marlina intan", "Surabaya", "Perempuan", "Office Girl", "Aktif" } };
    static int gajipokok[] = { 4000000, 3500000, 3500000, 3000000, 3000000, 3000000, 2900000, 2900000, 2850000, 2850000,
            2700000, 2800000, 2500000, 2600000, 2600000,
            2500000, 2450000, 1400000, 1000000, 1000000 };
    static String tambahData[][] = new String[30][30];
    static int tambahGajiPokok[] = new int[30];
    static boolean program = true;
    static String pilihan;
    static int b, kode;
    static Date date = new Date();
    static int GPuntukPrintSlip;
    static double pajak, tunjanganJabatan;
    static int lembur;
    static int tunTransport = 1000000;
    static int tunKesehatan = 500000;
    static int tunMakan = 850000;
    static int tunLembur = lembur * 250000;
    static int gajiLembur[] = new int[50];
    static int tambahGajiLembur[] = new int[50];
    static int potCuti[] = new int[20];
    static int tambahPotCuti[] = new int[30];
    static int potBPJS = 100000;
    static int potGaji;

    public static void main(String[] args) {
        while (program) {
            menu();
        }
    }

    static void menu() {
        System.out.println("");
        System.out.println("|======================================================================|");
        System.out.printf("|                     %-49s|\n", date);
        System.out.println("|           SELAMAT DATANG DI SISTEM KEPEGAWAIAN BANK NUSANTARA        |");
        System.out.println("|======================================================================|");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("| %-69s|", menu[i]);
            System.out.println();
        }
        System.out.println("|======================================================================|");
        System.out.print("  Masukkan fitur yang akan anda gunakan : ");
        pilihan = sc.next();
        System.out.println();
        switch (pilihan) {
            case "1":
                informasiPegawai();
                break;
            case "2":
                penggajian();
                break;
            case "3":
                permohonanCuti();
                break;
            case "4":
                laporanGaji();
                break;
            default:
                System.out.println(" Masukkan pilihan dengan benar ");
                break;
        }
    }

    static boolean getYesorNo(String message) {
        System.out.print(message + "(y/n) ? ");
        pilihan = sc.next();
        while (!pilihan.equalsIgnoreCase("y") && (!pilihan.equalsIgnoreCase("n"))) {
            System.out.println("Masukkan pilihan dengan benar!");
            System.out.print(message + "(y/n) ? ");
            pilihan = sc.next();
        }
        return pilihan.equalsIgnoreCase("y");
    }

    static void informasiPegawai() {
        System.out.println("|====================================================================|");
        System.out.println("|                INFORMASI PEGAWAI BANK NUSANTARA                    |");
        System.out.println("|====================================================================|");
        for (int i = 0; i < subMenu1.length; i++) {
            System.out.printf("| %-67s|", subMenu1[i]);
            System.out.println();
        }
        System.out.println("|====================================================================|");
        System.out.print("  Pilihan anda :");
        pilihan = sc.next();
        System.out.println();
        switch (pilihan) {
            case "1":
                tampilData();
                break;
            case "2":
                editData();
                break;
            case "3":
                tambahData();
                break;
            case "4":
                cariData();
                break;

            default:
                System.out.println("Masukkan pilihan dengan benar!");
                break;
        }
    }

    static void penggajian() {
        System.out.println(
                "|====================================================================================================================|");
        System.out.println(
                "|                                            PENGGAJIAN PEGAWAI BANK NUSANTARA                                       |");
        int i;
        System.out.println(
                "|====================================================================================================================|");
        System.out.println(
                "|                                                       DATA PEGAWAI                                                 |");
        System.out.println(
                "|====================================================================================================================|");
        System.out.println(
                "| NO PEGAWAI |    NAMA PEGAWAI    |    ALAMAT    | JENIS KELAMIN |        JABATAN        | GAJI POKOK |    STATUS    |");
        System.out.println(
                "|============|====================|==============|===============|=======================|============|==============|");
        for (i = 0; i < dataPegawai.length; i++) {
            System.out.printf("|07354-%-5d |%-20s|%-14s|%-15s|%-23s|%-12d|%-14s|", (i + 1), dataPegawai[i][0],
                    dataPegawai[i][1], dataPegawai[i][2], dataPegawai[i][3], gajipokok[i], dataPegawai[i][4]);
            System.out.println();
        }

        int a = 0;
        int k = i + 1;
        while (tambahData[a][0] != null) {
            System.out.printf("|07354-%-5d |%-20s|%-14s|%-15s|%-23s|%-12d|%-14s|", k, tambahData[a][0],
                    tambahData[a][1], tambahData[a][2], tambahData[a][3], tambahGajiPokok[a], tambahData[a][4]);
            System.out.println();
            i++;
            a++;
            k++;
        }
        System.out.println(
                "|====================================================================================================================|");
        while (program) {
            while (program) {
                System.out.printf(" Masukkan kode pegawai :");
                kode = sc.nextInt();
                if ((kode - 1) < dataPegawai.length) {
                    pajak = 0.05 * gajipokok[kode - 1];
                    tunjanganJabatan = 0.21 * gajipokok[kode - 1];
                    GPuntukPrintSlip = gajipokok[kode - 1];

                    program = false;
                } else if ((kode <= b)) {
                    pajak = 0.05 * tambahGajiPokok[(kode - 1) - dataPegawai.length];
                    tunjanganJabatan = 0.21 * tambahGajiPokok[(kode - 1 - dataPegawai.length)];
                    GPuntukPrintSlip = tambahGajiPokok[(kode - 1 - dataPegawai.length)];
                    program = false;

                } else {
                    System.out.println(
                            " Kode pegawai tidak ditemukan!,Silakan masukkan ulang kode pegawai dengan benar.");
                }
            }
            System.out.print(" Jumlah jam lembur :");
            lembur = sc.nextInt();
            tunLembur = lembur * 20000;

            System.out.println("|====================================================================|");
            System.out.println("|                  SLIP GAJI PEGAWAI BANK NUSANTARA                  |");
            System.out.println("|====================================================================|");
            if ((kode - 1) < dataPegawai.length) {
                System.out.printf("|Nama    :%-59s|\n", dataPegawai[kode - 1][0]);
                System.out.printf("|Jabatan :%-59s|\n", dataPegawai[kode - 1][3]);
                gajiLembur[kode - 1] = tunLembur;

            } else {
                System.out.printf("|Nama    :%-59s|\n", tambahData[(kode - 1) - dataPegawai.length][0]);
                System.out.printf("|Jabatan :%-59s|\n", tambahData[(kode - 1) - dataPegawai.length][3]);
                tambahGajiLembur[(kode - 1) - dataPegawai.length] = tunLembur;
            }
            int totPenerimaan = GPuntukPrintSlip
                    + (int) (tunjanganJabatan + tunTransport + tunKesehatan + tunMakan + tunLembur);
            int totPotongan = (int) (pajak + potBPJS + potGaji);
            System.out.println("|--------------------------------------------------------------------|");
            System.out.println("|                           PENERIMAAN                               |");
            System.out.println("|--------------------------------------------------------------------|");
            System.out.printf("|Gaji Pokok            : Rp.%-41d|\n", GPuntukPrintSlip);
            System.out.printf("|Tunjangan Jabatan     : Rp.%-41d|\n", (int) tunjanganJabatan);
            System.out.printf("|Tunjangan Transportasi: Rp.%-41d|\n", tunTransport);
            System.out.printf("|Tunjangan Kesehatan   : Rp.%-41d|\n", tunKesehatan);
            System.out.printf("|Tunjangan Makan       : Rp.%-41d|\n", tunMakan);
            System.out.printf("|Tunjangan Lembur      : Rp.%-41d|\n", tunLembur);

            System.out.println("|                                                                    |");
            System.out.printf("|Total Penerimaan      : Rp.%-41d|\n", totPenerimaan);
            System.out.println("|--------------------------------------------------------------------|");
            System.out.println("|                            POTONGAN                                |");
            System.out.println("|--------------------------------------------------------------------|");
            System.out.printf("|Pajak                 : Rp.%-41d|\n", (int) pajak);
            System.out.printf("|BPJS                  : Rp.%-41d|\n", potBPJS);
            System.out.printf("|Potongan Gaji         : Rp.%-41d|\n", potGaji);
            System.out.println("|                                                                    |");
            System.out.printf("|Total Potongan        :Rp. %-41d|\n", totPotongan);
            System.out.println("|--------------------------------------------------------------------|");
            System.out.println("|                                                                    |");
            System.out.printf("|Total Dibayarkan      :Rp. %-41d|\n", totPenerimaan - totPotongan);
            System.out.println("|                                                                    |");
            System.out.printf("|%68s|\n", date);
            System.out.println("|                                                     Diterima oleh  |  ");
            System.out.println("|                                                                    |");
            System.out.println("|                                                                    |");
            if ((kode - 1) < dataPegawai.length) {
                System.out.printf("|%66s  |\n", dataPegawai[kode - 1][0]);

                System.out.println("|====================================================================|");
                program = getYesorNo(" Apakah anda ingin cetak slip gaji lagi");
            } else {
                System.out.printf("|%66s  |\n", tambahData[(kode - 1) - dataPegawai.length][0]);
                System.out.println("|====================================================================|");
                program = getYesorNo(" Apakah anda ingin cetak slip gaji lagi");
            }
        }
        program = getYesorNo(" Apakah anda ingin melanjutkan ");
    }

    static void permohonanCuti() {
        String data = " ";
        System.out.println("|====================================================================|");
        System.out.println("|              PENGAJUAN PERMOHONAN CUTI BANK NUSANTARA              |");
        System.out.println("|====================================================================|");
        int i;
        System.out.println(
                "|====================================================================================================================|");
        System.out.println(
                "|                                                  TAMPILKAN DATA PEGAWAI                                            |");
        System.out.println(
                "|====================================================================================================================|");
        System.out.println(
                "| NO PEGAWAI |    NAMA PEGAWAI    |    ALAMAT    | JENIS KELAMIN |        JABATAN        | GAJI POKOK |    STATUS    |");
        System.out.println(
                "|============|====================|==============|===============|=======================|============|==============|");
        for (i = 0; i < dataPegawai.length; i++) {
            System.out.printf("|07354-%-5d |%-20s|%-14S|%-15s|%-23s|%-12d|%-14s|", (i + 1), dataPegawai[i][0],
                    dataPegawai[i][1], dataPegawai[i][2], dataPegawai[i][3], gajipokok[i], dataPegawai[i][4]);
            System.out.println();
        }

        int a = 0;
        int k = i + 1;
        while (tambahData[a][0] != null) {
            System.out.printf("|07354-%-5d |%-20s|%-14S|%-15s|%-23s|%-12d|%-14s|", k, tambahData[a][0],
                    tambahData[a][1], tambahData[a][2], tambahData[a][3], tambahGajiPokok[a], tambahData[a][4]);
            System.out.println();
            i++;
            a++;
            k++;
        }
        System.out.println(
                "|====================================================================================================================|");
        System.out.print(" Masukkan kode pegawai : ");
        int kode = sc.nextInt();
        if ((kode - 1) < dataPegawai.length) {
            dataPegawai[kode - 1][4] = "Tidak Aktif";
        } else if ((kode) <= b) {
            tambahData[(kode - 1) - dataPegawai.length][4] = "Tidak Aktif";
        }
        if (((kode - 1) < dataPegawai.length) || ((kode - 1) < b)) {
            System.out.print(" Alasan cuti : ");
            String alasan = sc.next();
            System.out.print(" Jumlah ijin cuti :");
            int cuti = sc.nextInt();
            if (kode - 1 < dataPegawai.length) {
                potCuti[kode - 1] = cuti * 50000;
            } else {
                tambahPotCuti[(kode - 1) - dataPegawai.length] = cuti * 50000;
            }
            System.out.println();
            System.out.println(" Berikut surat permohonan cuti yang dapat anda unduh : ");
            System.out.println();
            System.out.println(
                    "|========================================================================================|");
            System.out.println(
                    "|                   SURAT PERMOHONAN CUTI PEGAWAI BANK NUSANTARA                         |");
            System.out.println(
                    "|========================================================================================|");
            System.out.printf("|Malang, %-80s| \n", date);
            System.out.printf("| %-87s| \n", data);
            System.out.printf("|Perihal : Permohonan cuti %-62s| \n", alasan);
            System.out.printf("| %-87s| \n", data);
            System.out.printf("|Kepada Yth. %-76s| \n", data);
            System.out.printf("|Kepala HRD Bank Nusantara %-62s| \n", data);
            System.out.printf("|Ditempat %-79s| \n", data);
            System.out.printf("| %-87s| \n", data);
            System.out.printf("| %-87s| \n", data);
            System.out.printf("|Dengan hormat, %-73s| \n", data);
            System.out.printf("|Yang bertanda tangan dibawah ini : %-53s| \n", data);
            if (kode - 1 < dataPegawai.length) {
                System.out.printf("|Nama    :%-79s| \n", dataPegawai[kode - 1][0]);
            } else {
                System.out.printf("|Nama    :%-79s| \n", tambahData[(kode - 1) - dataPegawai.length][0]);
            }
            System.out.printf("|No      :07354%-74d| \n", kode);
            if (kode - 1 < dataPegawai.length) {
                System.out.printf("|Jabatan :%-79s| \n", dataPegawai[kode - 1][3]);
            } else {
                System.out.printf("|Jabatan :%-79s| \n", tambahData[(kode - 1) - dataPegawai.length][3]);

            }
            System.out.printf("| %-87s| \n", data);
            System.out.printf("|Bermaksud mengajukan cuti %s selama %d hari, terhitung mulai hari ini. %-14s | \n",
                    alasan,
                    cuti, data);
            System.out.printf("| %-87s| \n", data);
            System.out.printf("| %-87s| \n", data);
            System.out.printf(
                    "|Demikian surat permohonan cuti ini saya ajukan, Terimakasih atas perhatian Bapak/Ibu. %-2s|\n",
                    data);
            System.out.printf("| %-87s| \n", data);
            System.out.printf("| %-87s| \n", data);
            System.out.printf(
                    "|                                                                         Hormat Saya%-4s|\n",
                    data);
            System.out.printf("| %-87s| \n", data);
            System.out.printf("| %-87s| \n", data);
            if (kode - 1 < dataPegawai.length) {
                System.out.printf("|                                                                         %-15s|\n",
                        dataPegawai[kode - 1][0]);
            } else {
                System.out.printf("|                                                                         %-15s|\n",
                        tambahData[(kode - 1) - dataPegawai.length][0]);

            }
            System.out
                    .println(
                            "|========================================================================================|");
        } else {
            System.out.println(" Data pegawai tidak tersedia, silahkan masukkan kode dengan benar!");
        }
        System.out.println();
        program = getYesorNo("Apakah anda ingin melanjutkan aplikasi ini");

    }

    static void tampilData() {
        int i;
        System.out.println(
                "|====================================================================================================================|");
        System.out.println(
                "|                                                  TAMPILKAN DATA PEGAWAI                                            |");
        System.out.println(
                "|====================================================================================================================|");
        System.out.println(
                "| NO PEGAWAI |    NAMA PEGAWAI    |    ALAMAT    | JENIS KELAMIN |        JABATAN        | GAJI POKOK |    STATUS    |");
        System.out.println(
                "|============|====================|==============|===============|=======================|============|==============|");
        for (i = 0; i < dataPegawai.length; i++) {
            System.out.printf("|07354-%-5d |%-20s|%-14S|%-15s|%-23s|%-12d|%-14s|", (i + 1), dataPegawai[i][0],
                    dataPegawai[i][1], dataPegawai[i][2], dataPegawai[i][3], gajipokok[i], dataPegawai[i][4]);
            System.out.println();
        }

        int a = 0;
        int k = i + 1;
        while (tambahData[a][0] != null) {
            System.out.printf("|07354-%-5d |%-20s|%-14S|%-15s|%-23s|%-12d|%-14s|", k, tambahData[a][0],
                    tambahData[a][1], tambahData[a][2], tambahData[a][3], tambahGajiPokok[a], tambahData[a][4]);
            System.out.println();
            i++;
            a++;
            k++;
        }
        System.out.println(
                "|====================================================================================================================|");
        program = getYesorNo(" Apakah anda ingin melanjutkan aplikasi ini");
    }

    static void editData() {
        Scanner input1 = new Scanner(System.in);
        int i;
        System.out.println(
                "|====================================================================================================================|");
        System.out.println(
                "|                                                  TAMPILKAN DATA PEGAWAI                                            |");
        System.out.println(
                "|====================================================================================================================|");
        System.out.println(
                "| NO PEGAWAI |    NAMA PEGAWAI    |    ALAMAT    | JENIS KELAMIN |        JABATAN        | GAJI POKOK |    STATUS    |");
        System.out.println(
                "|============|====================|==============|===============|=======================|============|==============|");
        for (i = 0; i < dataPegawai.length; i++) {
            System.out.printf("|07354-%-5d |%-20s|%-14S|%-15s|%-23s|%-12d|%-14s|", (i + 1), dataPegawai[i][0],
                    dataPegawai[i][1], dataPegawai[i][2], dataPegawai[i][3], gajipokok[i], dataPegawai[i][4]);
            System.out.println();
        }

        int a = 0;
        int k = i + 1;

        while (tambahData[a][0] != null) {
            System.out.printf("|07354-%-5d |%-20s|%-14S|%-15s|%-23s|%-12d|%-14s|", (k),
                    tambahData[a][0], tambahData[a][1],
                    tambahData[a][2], tambahData[a][3], tambahGajiPokok[a], tambahData[a][4]);
            System.out.println();
            i++;
            a++;
            k++;
        }
        System.out.println(
                "|====================================================================================================================|");

        while (program) {

            System.out.print(" Masukkan kode pegawai : ");
            int edit = sc.nextInt();

            if ((edit - 1) < dataPegawai.length) {
                System.out.print(" Nama Lengkap        : ");
                dataPegawai[edit - 1][0] = input.nextLine();
                System.out.print(" Alamat              : ");
                dataPegawai[edit - 1][1] = input.nextLine();
                System.out.print(" Jenis Kelamin       : ");
                dataPegawai[edit - 1][2] = input.nextLine();
                System.out.print(" Jabatan             : ");
                dataPegawai[edit - 1][3] = input.nextLine();
                System.out.print(" Masukkan gaji pokok :");
                gajipokok[edit - 1] = sc.nextInt();
            } else if ((edit) <= b) {
                System.out.print(" Nama Lengkap  j      : ");
                tambahData[(edit - 1) - dataPegawai.length][0] = input.nextLine();
                System.out.print(" Alamat              : ");
                tambahData[(edit - 1) - dataPegawai.length][1] = input.nextLine();
                System.out.print(" Jenis Kelamin       : ");
                tambahData[(edit - 1) - dataPegawai.length][2] = input.nextLine();
                System.out.print(" Jabatan             : ");
                tambahData[(edit - 1) - dataPegawai.length][3] = input.nextLine();
                System.out.print(" Masukkan gaji pokok :");
                tambahGajiPokok[(edit - 1) - dataPegawai.length] = sc.nextInt();
            } else {
                System.out.println(" Masukkan kode dengan benar!");
            }
            program = getYesorNo(" Apakah anda ingin mengedit data pegawai lagi");
        }
        program = getYesorNo(" Apakah anda ingin melanjutkan aplikasi ini");
    }

    static void tambahData() {
        b = dataPegawai.length;
        System.out.println("|====================================================================|");
        System.out.println("|                     TAMBAH DATA PEGAWAI BARU                       |");
        System.out.println("|====================================================================|");
        int i = 0;
        while (program) {
            System.out.print(" Nama Lengkap        : ");
            tambahData[i][0] = input.nextLine();
            System.out.print(" Alamat              : ");
            tambahData[i][1] = input.nextLine();
            System.out.print(" Jenis Kelamin       : ");
            tambahData[i][2] = input.nextLine();
            System.out.print(" Jabatan             : ");
            tambahData[i][3] = input.nextLine();
            System.out.print(" Masukkan gaji pokok :");
            tambahGajiPokok[i] = sc.nextInt();
            System.out.print(" Status              :");
            tambahData[i][4] = input.nextLine();
            i++;
            b++;
            program = getYesorNo(" Apakah anda ingin menambah pegawai baru");
        }
        program = getYesorNo(" Apakah anda ingin melanjutkan aplikasi ini ");
    }

    static void cariData() {
        while (program) {
            System.out.println("|====================================================================|");
            System.out.println("|                            CARI DATA PEGAWAI                       |");
            System.out.println("|====================================================================|");

            for (int i = 0; i < subMenu2.length; i++) {
                System.out.printf("| %-67s|", subMenu2[i]);
                System.out.println();
            }
            System.out.println("|====================================================================|");
            System.out.print(" Pilihan anda :");
            int pilih = sc.nextInt();
            if (pilih == 1) {
                System.out.printf(" Masukkan nama yang ingin dicari : ");
                String nama = input.nextLine();
                System.out.println();
                boolean cari = true;
                boolean searchA = false;
                boolean searchB = false;
                if (cari == true) {
                    for (int i = 0; i < dataPegawai.length; i++) {
                        if (dataPegawai[i][0].equalsIgnoreCase(nama)) {
                            searchA = true;
                            System.out
                                    .println("|====================================================================|");
                            System.out
                                    .println("|                          DATA YANG ANDA CARI                       |");
                            System.out
                                    .println("|====================================================================|");
                            System.out.printf("| Nomor pegawai  : 07354%-45d|\n", (i + 1));
                            System.out.printf("| Nama           : %-50s|\n", dataPegawai[i][0]);
                            System.out.printf("| Alamat         : %-50s|\n", dataPegawai[i][1]);
                            System.out.printf("| Jenis Kelamin  : %-50s|\n", dataPegawai[i][2]);
                            System.out.printf("| Jabatan        : %-50s|\n", dataPegawai[i][3]);
                            System.out.printf("| Gaji Pokok     : %-50d|\n", gajipokok[i]);
                            System.out.printf("| Status         : %-50s|\n", dataPegawai[i][4]);
                            System.out
                                    .println("|====================================================================|");
                            break;
                        } else if (tambahData[0][0] != null) {
                            if (tambahData[i][0].equalsIgnoreCase(nama)) {
                                searchB = true;
                                System.out.println(
                                        "|====================================================================|");
                                System.out.println(
                                        "|                         DATA YANG ANDA CARI                        |");
                                System.out.println(
                                        "|====================================================================|");
                                System.out.printf("| Nomor pegawai  : 07354%-45d|\n", ((i + 1) + dataPegawai.length));
                                System.out.printf("| Nama           : %-50s|\n", tambahData[i][0]);
                                System.out.printf("| Alamat         : %-50s|\n", tambahData[i][1]);
                                System.out.printf("| Jenis Kelamin  : %-50s|\n", tambahData[i][2]);
                                System.out.printf("| Jabatan        : %-50s|\n", tambahData[i][3]);
                                System.out.printf("| Gaji Pokok     : %-50d|\n", tambahGajiPokok[i]);
                                System.out.printf("| Status         : %-50s|\n", tambahData[i][4]);
                                System.out.println(
                                        "|====================================================================|");
                                break;
                            }
                        }
                    }
                }
                if (searchA == false && searchB == false) {
                    System.out.println(" Mohon maaf data tidak ditemukan!");
                }
                program = getYesorNo(" Apakah anda ingin mencari data pegawai lagi");
            } else if (pilih == 2) {
                System.out.print(" Masukkan kode pegawai :");
                int kode = sc.nextInt();
                if ((kode - 1) < dataPegawai.length) {
                    System.out.println("|====================================================================|");
                    System.out.println("|                          DATA YANG ANDA CARI                       |");
                    System.out.println("|====================================================================|");
                    System.out.printf("| Nomor pegawai  : 07354%-45d|\n", kode);
                    System.out.printf("| Nama           : %-50s|\n", dataPegawai[(kode - 1)][0]);
                    System.out.printf("| Alamat         : %-50s|\n", dataPegawai[(kode - 1)][1]);
                    System.out.printf("| Jenis Kelamin  : %-50s|\n", dataPegawai[(kode - 1)][2]);
                    System.out.printf("| Jabatan        : %-50s|\n", dataPegawai[(kode - 1)][3]);
                    System.out.printf("| Gaji Pokok     : %-50d|\n", gajipokok[kode - 1]);
                    System.out.printf("| Status         : %-50s|\n", dataPegawai[(kode - 1)][4]);
                    System.out.println("|====================================================================|");
                } else if ((kode) <= b) {
                    System.out.println("|====================================================================|");
                    System.out.println("|                         DATA YANG ANDA CARI                        |");
                    System.out.println("|====================================================================|");
                    System.out.printf("| Nomor pegawai  : 07354%-45d|\n", kode);
                    System.out.printf("| Nama           : %-50s|\n", tambahData[(kode - 1) - dataPegawai.length][0]);
                    System.out.printf("| Alamat         : %-50s|\n", tambahData[(kode - 1) - dataPegawai.length][1]);
                    System.out.printf("| Jenis Kelamin  : %-50s|\n", tambahData[(kode - 1) - dataPegawai.length][2]);
                    System.out.printf("| Jabatan        : %-50s|\n", tambahData[(kode - 1) - dataPegawai.length][3]);
                    System.out.printf("| Gaji Pokok     : %-50d|\n", tambahGajiPokok[(kode - 1) - dataPegawai.length]);
                    System.out.printf("| Status         : %-50s|\n", tambahData[(kode - 1) - dataPegawai.length][4]);
                    System.out.println("|====================================================================|");
                } else {
                    System.out.println(" Mohon maaf data tidak ditemukan!");
                }
                program = getYesorNo(" Apakah anda ingin mencari data pegawai lagi");
            }
        }
        program = getYesorNo(" Apakah anda ingin melanjutkan aplikasi ini");
    }

    static void laporanGaji() {
        System.out.println(
                "|==================================================================================================================================================================================|");
        System.out.println(
                "|                                                                     LAPORAN PENGGAJIAN BANK NUSANTARA                                                                            |");
        System.out.println(
                "|==================================================================================================================================================================================|");
        System.out.println(
                "|            |                    |                       |            |                          TUNJANGAN                        |              POTONGAN           |             |");
        System.out.println(
                "| NO PEGAWAI |    NAMA PEGAWAI    |        JABATAN        | GAJI POKOK |-----------------------------------------------------------|---------------------------------| GAJI BERSIH |");
        System.out.println(
                "|            |                    |                       |            |  JABATAN | TRANSPORTASI | KESEHATAN |  MAKAN  |   LEMBUR  |   PAJAK   |   BPJS   |   CUTI   |             |");
        System.out.println(
                "|============|====================|=======================|============|==========|==============|===========|=========|===========|===========|==========|==========|=============|");
        int Tunjangan = tunTransport + tunKesehatan + tunMakan + tunLembur;
        int i;
        int totalSemua = 0;
        int totalS;
        for (i = 0; i < dataPegawai.length; i++) {
            System.out.printf(
                    "|07354-%-5d |%-20s|%-23s|Rp.%-9d|Rp.%-7d|Rp.%-11d|Rp.%-8d|Rp.%-5d|Rp.%-8d|Rp.%-8d|Rp.%-7d|Rp.%-7d|Rp.%-10d|",
                    (i + 1), dataPegawai[i][0], dataPegawai[i][3], gajipokok[i], ((int) (0.21 * gajipokok[i])),
                    tunTransport, tunKesehatan, tunMakan, gajiLembur[i],
                    ((int) (0.05 * gajipokok[i])), potBPJS, potCuti[i],
                    (int) ((Tunjangan + gajipokok[i] + (0.21 * gajipokok[i])) - potBPJS - potCuti[i]
                            - (0.05 * gajipokok[i])));
            System.out.println();
            totalS = (int) ((Tunjangan + gajipokok[i] + (0.21 * gajipokok[i])) - potBPJS - potCuti[i]
                    - (0.05 * gajipokok[i]));
            totalSemua += totalS;
        }
        System.out.println(
                "|==================================================================================================================================================================================|");

        System.out.println("Total semua pengeluaran perusahaan = " + totalSemua);
        int a = 0;
        int k = i;
        while (tambahData[a][0] != null) {
            System.out.printf(
                    "|07354-%-5d |%-20s|%-23s|Rp.%-9d|Rp.%-7d|Rp.%-11d|Rp.%-8d|Rp.%-5d|Rp.%-8d|Rp.%-8d|Rp.%-7d|Rp.%-7d|Rp.%-10d|",
                    (k + 1), tambahData[a][0], tambahData[a][3], tambahGajiPokok[a],
                    ((int) (0.21 * tambahGajiPokok[a])),
                    tunTransport, tunKesehatan, tunMakan, tambahGajiLembur[i],
                    ((int) (0.05 * tambahGajiPokok[a])), potBPJS, tambahPotCuti[a],
                    (int) ((Tunjangan + tambahGajiPokok[a] + (0.21 * tambahGajiPokok[i])) - potBPJS - tambahPotCuti[a]
                            - (0.05 * tambahGajiPokok[i])));
            System.out.println();
            totalS = (int) ((Tunjangan + tambahGajiPokok[a] + (0.21 * tambahGajiPokok[i])) - potBPJS - tambahPotCuti[a]
                    - (0.05 * tambahGajiPokok[i]));
            totalSemua += totalS;
            a++;
            System.out.println(totalSemua);
        }

        System.out.println(
                "|==================================================================================================================================================================================|");
        program = getYesorNo("Apakah anda ingin melanjutkan aplikasi ini");
    }
}
