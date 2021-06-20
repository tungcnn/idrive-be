package com.hanoi.heat.idrive.service.image;

import com.hanoi.heat.idrive.model.Image;
import com.hanoi.heat.idrive.model.Vehicle;
import com.hanoi.heat.idrive.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepo imageRepo;

    @Override
    public Page<Image> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Image> findAll() {
        return imageRepo.findAll();
    }

    @Override
    public Image save(Image image) {
        return imageRepo.save(image);
    }

    @Override
    public Optional<Image> findById(Long id) {
        return imageRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        imageRepo.deleteById(id);
    }

    @Override
    public Iterable<Image> findAllByVehicle(Long id) {
        return imageRepo.findAllByVehicle(id);
    }

    @Override
    public void deletePhotoOfVehicle(Long id) {
        imageRepo.deletePhotoOfVehicle(id);
    }
}
