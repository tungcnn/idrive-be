package com.hanoi.heat.idrive.service.image;

import com.hanoi.heat.idrive.model.Image;
import com.hanoi.heat.idrive.model.Vehicle;
import com.hanoi.heat.idrive.service.IGeneralService;

public interface ImageService extends IGeneralService<Image> {
    Iterable<Image> findAllByVehicle(Long id);
    void deletePhotoOfVehicle(Long id);
}
