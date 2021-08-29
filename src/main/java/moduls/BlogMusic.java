package moduls;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class BlogMusic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String tenBaiHat;
    String tenCaSy;
    String tenNhacSy;
    String fileMusic;
    String fileImage;
    int views;

    @ManyToOne
    private TheLoai theLoai;

    public BlogMusic() {
    }

    public BlogMusic(int id, String tenBaiHat, String tenCaSy,
                     String tenNhacSy, String fileMusic, String fileImage, String theLoai, String binhLuan) {
        this.id = id;
        this.tenBaiHat = tenBaiHat;
        this.tenCaSy = tenCaSy;
        this.tenNhacSy = tenNhacSy;
        this.fileMusic = fileMusic;
        this.fileImage = fileImage;
        this.theLoai = theLoai;
        this.binhLuan = binhLuan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getTenCaSy() {
        return tenCaSy;
    }

    public void setTenCaSy(String tenCaSy) {
        this.tenCaSy = tenCaSy;
    }

    public String getTenNhacSy() {
        return tenNhacSy;
    }

    public void setTenNhacSy(String tenNhacSy) {
        this.tenNhacSy = tenNhacSy;
    }

    public String getFileMusic() {
        return fileMusic;
    }

    public void setFileMusic(String fileMusic) {
        this.fileMusic = fileMusic;
    }

    public String getFileImage() {
        return fileImage;
    }

    public void setFileImage(String fileImage) {
        this.fileImage = fileImage;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getBinhLuan() {
        return binhLuan;
    }

    public void setBinhLuan(String binhLuan) {
        this.binhLuan = binhLuan;
    }
}
