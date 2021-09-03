package service;

import moduls.TheLoai;
import org.springframework.beans.factory.annotation.Autowired;

import repository.ITheLoaiRepo;

import java.util.Optional;

public class TheLoaiService implements ITheLoaiService{
    @Autowired
    ITheLoaiRepo iTheLoaiRepo;

    @Override
    public Iterable<TheLoai> findAll() {
        return iTheLoaiRepo.findAll();
    }

    @Override
    public Optional<TheLoai> findById(int id) {
        return iTheLoaiRepo.findById(id);
    }
}
