package service;

import moduls.BlogMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import repository.IBlogMusicRepo;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
@Transactional
public class BlogMusicService implements IBlogMusicService {
    @Autowired
    IBlogMusicRepo iBlogMusicRepo;
    @Autowired
    EntityManager entityManager;

    @Override
    public BlogMusic save(BlogMusic blogMusic) {
        return iBlogMusicRepo.save(blogMusic);
    }

    @Override
    public BlogMusic findById(int id) {
        return iBlogMusicRepo.findById(id).get();
    }

    @Override
    public ArrayList<BlogMusic> findAll() {
        return (ArrayList<BlogMusic>) iBlogMusicRepo.findAll();
    }

    @Override
    public ArrayList<BlogMusic> findAllByName(String tenBaiHat) {
        return iBlogMusicRepo.findAllByName(tenBaiHat);
    }

    @Override
    public Page<BlogMusic> findAll(Pageable pageable) {
        return iBlogMusicRepo.findAll(pageable);
    }

    @Override
    public void delete(BlogMusic blogMusic) {
        iBlogMusicRepo.delete(blogMusic);
    }

    @Override
    public void edit(BlogMusic blogMusic) {
        iBlogMusicRepo.save(blogMusic);
    }

    @Override
    public ArrayList<BlogMusic> findAllByNameRemix() {
        String queryStr = "SELECT u FROM BlogMusic u WHERE u.theLoai = :theLoai ";
        TypedQuery<BlogMusic> query = entityManager.createQuery(queryStr, BlogMusic.class).setParameter("theLoai","remix");
        query.setFirstResult(1);
        query.setMaxResults(4);
        return (ArrayList<BlogMusic>) query.getResultList();
    }

    @Override
    public ArrayList<BlogMusic> findAllByNamePop() {
        String queryStr = "SELECT u FROM BlogMusic u WHERE u.theLoai = :theLoai";
        TypedQuery<BlogMusic> query = entityManager.createQuery(queryStr, BlogMusic.class).setParameter("theLoai","pop");
        query.setFirstResult(1);
        query.setMaxResults(4);
        return (ArrayList<BlogMusic>) query.getResultList();
    }

    @Override
    public ArrayList<BlogMusic> findAllByNameUs() {
        String queryStr = "SELECT u FROM BlogMusic u WHERE u.theLoai = :theLoai";
        TypedQuery<BlogMusic> query = entityManager.createQuery(queryStr, BlogMusic.class).setParameter("theLoai","us");
        query.setFirstResult(1);
        query.setMaxResults(4);
        return (ArrayList<BlogMusic>) query.getResultList();
    }


}

