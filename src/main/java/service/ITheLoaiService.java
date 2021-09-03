package service;

import moduls.TheLoai;

import java.util.Optional;

public interface ITheLoaiService {
    Iterable<TheLoai> findAll();

    Optional<TheLoai> findById(int id);

}
