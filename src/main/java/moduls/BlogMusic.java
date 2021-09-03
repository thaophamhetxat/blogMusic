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
    int likes;
    int dislike;

    @ManyToOne
    private TheLoai theLoai;

    @ManyToOne
    private Person person;

    public BlogMusic() {
    }

    public BlogMusic(int id, String tenBaiHat, String tenCaSy, String tenNhacSy, String fileMusic, String fileImage,
                     int views, int likes, int dislike, TheLoai theLoai, Person person) {
        this.id = id;
        this.tenBaiHat = tenBaiHat;
        this.tenCaSy = tenCaSy;
        this.tenNhacSy = tenNhacSy;
        this.fileMusic = fileMusic;
        this.fileImage = fileImage;
        this.views = views;
        this.likes = likes;
        this.dislike = dislike;
        this.theLoai = theLoai;
        this.person = person;
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

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
