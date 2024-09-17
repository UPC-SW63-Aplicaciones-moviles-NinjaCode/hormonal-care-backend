package com.backend.hormonalcare.profile.interfaces.rest.transform;

import com.backend.hormonalcare.profile.domain.model.aggregates.Profile;
import com.backend.hormonalcare.profile.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity){
        return new ProfileResource(
                entity.getName().getFullName(),
                entity.getGender().getGender(),
                entity.getAge().age(),
                entity.getPhoneNumber(),
                entity.getEmail().email(),
                entity.getImage(),
                entity.getBirthday().birthday(),
                entity.getUser().getId()
        );
    }
}