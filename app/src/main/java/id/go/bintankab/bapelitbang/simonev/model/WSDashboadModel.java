package id.go.bintankab.bapelitbang.simonev.model;

public class WSDashboadModel {
    private Integer paguDana1=0;
    private Integer paguDana2=0;
    private Integer JumlahProgram1=0;
    private Integer JumlahProgram2=0;
    private Integer JumlahKegiatan1=0;
    private Integer JumlahKegiatan2=0;
    private Integer realisasiKeuangan1=0;
    private Integer realisasiKeuangan2=0;
    private Double fisik1=0.00;
    private Double fisik2=0.00;

    public WSDashboadModel(Integer paguDana1, Integer paguDana2, Integer jumlahProgram1, Integer jumlahProgram2, Integer jumlahKegiatan1, Integer jumlahKegiatan2, Integer realisasiKeuangan1, Integer realisasiKeuangan2, Double fisik1, Double fisik2) {
        this.paguDana1 = paguDana1;
        this.paguDana2 = paguDana2;
        JumlahProgram1 = jumlahProgram1;
        JumlahProgram2 = jumlahProgram2;
        JumlahKegiatan1 = jumlahKegiatan1;
        JumlahKegiatan2 = jumlahKegiatan2;
        this.realisasiKeuangan1 = realisasiKeuangan1;
        this.realisasiKeuangan2 = realisasiKeuangan2;
        this.fisik1 = fisik1;
        this.fisik2 = fisik2;
    }
}
