package com.tour.FootStamp.service;

import com.tour.FootStamp.dto.CommonDto;
import com.tour.FootStamp.dto.DetailDto;

import java.util.List;

public interface SearchService {

    public List<CommonDto> searchTourApi(final String operationName, final String contentTypeId);

    public DetailDto searchDetailTourApi(final CommonDto commonDto);
}
