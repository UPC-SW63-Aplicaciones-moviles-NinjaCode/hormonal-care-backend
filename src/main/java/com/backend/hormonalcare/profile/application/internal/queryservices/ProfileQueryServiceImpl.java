package com.backend.hormonalcare.profile.application.internal.queryservices;

import com.backend.hormonalcare.profile.domain.model.aggregates.Profile;
import com.backend.hormonalcare.profile.domain.model.queries.*;
import com.backend.hormonalcare.profile.domain.model.queries.*;
import com.backend.hormonalcare.profile.domain.services.ProfileQueryService;
import com.backend.hormonalcare.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return List.of();
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.id());
    }

    @Override
    public Optional<Profile> handle(GetProfileByNameQuery query) {
        return profileRepository.findByName(query.name());
    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmail(query.email());
    }

    @Override
    public boolean doesProfileExist(GetProfileByUserIdQuery query) {
        return profileRepository.existsByUserId(query.userId());
    }
}