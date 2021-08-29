package service;

import moduls.BlogMusic;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;

public interface IBlogMusicService {
    BlogMusic save(BlogMusic blogMusic);
    BlogMusic findById(int id);

    ArrayList<BlogMusic> findAll();

    ArrayList<BlogMusic> findAllByName(String tenBaiHat);

    Page<BlogMusic> findAll(Pageable pageable);

    void delete(BlogMusic blogMusic);

    void edit(BlogMusic blogMusic);


    ArrayList<BlogMusic> findAllByNameRemix();
    ArrayList<BlogMusic> findAllByNamePop();
    ArrayList<BlogMusic> findAllByNameUs();



}
