package com.tour.FootStamp.service;

//import com.tour.FootStamp.model.aws.dao.TestMapper;
import com.tour.FootStamp.model.aws.dao.TestMapper;
import com.tour.FootStamp.model.aws.dto.portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    @Autowired
    private final TestMapper testMapper;

    @Override
    public List<portfolio> getAllDataList() {
        return testMapper.getAllDataList();
    }
}