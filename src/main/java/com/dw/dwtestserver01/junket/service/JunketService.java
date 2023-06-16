package com.dw.dwtestserver01.junket.service;

import com.dw.dwtestserver01.junket.dto.JunketDto;
import com.dw.dwtestserver01.junket.entity.JunketEntity;
import com.dw.dwtestserver01.junket.mapper.JunketMapper;
import com.dw.dwtestserver01.junket.repository.JunketRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class JunketService {
    private final JunketRepository junketRepository;
    private final JunketMapper junketMapper;

    public JunketService(JunketRepository junketRepository,
                         JunketMapper junketMapper) {
        this.junketRepository = junketRepository;
        this.junketMapper = junketMapper;
    }

    public JunketEntity createJunket(JunketDto.Post junketPostDto) {
        JunketEntity savedJunket = junketRepository.save(junketMapper.junketPostToJunket(junketPostDto));
        return savedJunket;
    }

    public Page<JunketEntity> findJunkets(int page, int size) {
        return junketRepository.findAll(PageRequest.of(page, size,
                Sort.by("junketName").ascending()));
    }
    public JunketEntity updateJunket(JunketDto.Patch junketPatchDto){
        JunketEntity updateJunket = junketMapper.junketPatchToJunket(junketPatchDto);
        JunketEntity updatedJunket = junketRepository.save(updateJunket);
        return updatedJunket;
    }

    public void deleteJunket(Long junketId){
        junketRepository.deleteById(junketId);
    }
}
