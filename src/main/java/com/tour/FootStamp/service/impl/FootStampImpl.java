package com.tour.FootStamp.service.impl;

import com.tour.FootStamp.dto.FootStampDto;
import com.tour.FootStamp.entity.FootStamp;
import com.tour.FootStamp.repository.FootStampRepository;
import com.tour.FootStamp.service.FootStampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FootStampImpl implements FootStampService {
    private final FootStampRepository footStampRepository;

    @Autowired
    public FootStampImpl(FootStampRepository footStampRepository) {
        this.footStampRepository = footStampRepository;
    }

    public FootStamp addStamp(FootStampDto footStampDto) throws Exception {
        // 파일을 저장하고 그 Board 에 대한 list 를 가지고 있는다
        FootStamp stamp = parseFileInfo( footStampDto );

/*
        if (list.isEmpty()){
            // TODO : 파일이 없을 땐 어떻게 해야할까.. 고민을 해보아야 할 것
        }
        // 파일에 대해 DB에 저장하고 가지고 있을 것
        else{
            List<FootStamp> pictureBeans = new ArrayList<>();
            for (FootStamp stamps : list) {
                pictureBeans.add(footStampRepository.save(stamps));
            }
        }
*/

        return footStampRepository.save(stamp);
    }

    public FootStamp parseFileInfo(FootStampDto footStampDto) throws Exception {

/*        // 반환을 할 파일 리스트
        List<FootStamp> fileList = new ArrayList<>();

        // 파일이 빈 것이 들어오면 빈 것을 반환
        if (multipartFiles.isEmpty()) {
            return fileList;
        }*/
        FootStamp stamp = null;
        // 파일 이름을 업로드 한 날짜로 바꾸어서 저장할 것이다
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String current_date = simpleDateFormat.format(new Date());


        // 프로젝트 폴더에 저장하기 위해 절대경로를 설정 (Window 의 Tomcat 은 Temp 파일을 이용한다)
        //String absolutePath = new File("").getAbsolutePath() + "\\";
        /*ClassPathResource resource = new ClassPathResource("classpath:file");
        String absolutePath = resource.getPath()+ "\\";*/

        //ClassPathResource resource = new ClassPathResource("static/img");


        //String webPath = "resources/images/items/";
        //String folderPath = req.getSession().getServletContext().getRealPath(webPath);


        // 경로를 지정하고 그곳에다가 저장
        String path = "registerImg/" + current_date;
        File file = new File(path);
        // 저장할 위치의 디렉토리가 존지하지 않을 경우
        if (!file.exists()) {
            // mkdir() 함수와 다른 점은 상위 디렉토리가 존재하지 않을 때 그것까지 생성
            file.mkdirs();
        }

        // 파일들을 이제 만져볼 것이다
        //for (MultipartFile multipartFile : footStampDto.getFiles() ) {
//            // 파일이 비어 있지 않을 때 작업을 시작해야 오류가 나지 않는다
//            if (!multipartFile.isEmpty()) {
            // jpeg, png, gif 파일들만 받아서 처리할 예정
            //String contentType = multipartFile.getContentType();
            String contentType = footStampDto.getFiles().getContentType();

            // 23.10.03 기본 확장자 png 설정
            String originalFileExtension = ".png";
            // 확장자 명이 없으면 이 파일은 잘 못 된 것이다
            if (ObjectUtils.isEmpty(contentType)) {
                //break;
            } else {
                if (contentType.contains("image/jpeg")) {
                    originalFileExtension = ".jpg";
                } else if (contentType.contains("image/png")) {
                    originalFileExtension = ".png";
                } else if (contentType.contains("image/gif")) {
                    originalFileExtension = ".gif";
                }
                //}
                // 각 이름은 겹치면 안되므로 나노 초까지 동원하여 지정
                String new_file_name = System.nanoTime() + originalFileExtension;
                // 생성 후 리스트에 추가
                stamp = FootStamp.builder()
                        .originalFileName(footStampDto.getFiles().getOriginalFilename())
                        .storedFileName(path + "/" + new_file_name)
                        .fileSize(footStampDto.getFiles().getSize())
                        .contents(footStampDto.getContents())
                        .mapX(footStampDto.getMapX())
                        .mapY(footStampDto.getMapY())
                        .contentId(footStampDto.getContentId())
                        .memberEmail(footStampDto.getMemberEmail())
                        .build();
                //footStampDto.getFiles().add(board);

                // 저장된 파일로 변경하여 이를 보여주기 위함
                //file = new File(absolutePath + path + "/" + new_file_name);
                //footStampDto.getFiles().transferTo(file);
                File newFileName = new File(new_file_name);
                try {
                    footStampDto.getFiles().transferTo(newFileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        //}
        //return fileList;
        return stamp;
    }
}
