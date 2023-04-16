package com.bosc.assessment.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bosc.assessment.dto.TagOpDto;
import com.bosc.assessment.dto.TagOwnerDto;
import com.bosc.assessment.util.CommonUtil;

@Service
public class TestService {

    public List<TagOpDto> mockTagOpList() {
        List<TagOpDto> list = new ArrayList<>();
        List<Date> dateList = CommonUtil.getLatestNDates(30);
        for(Date date: dateList) {
            TagOpDto tag = new TagOpDto();
            list.add(tag);
            tag.setDate(CommonUtil.formatDate(date, "MMdd"));
            tag.setCount((int) (Math.random() * 30));
        }
        return list;
    }

    public Map<String, List<TagOwnerDto>> mockOwnerList() {
        Map<String, List<TagOwnerDto>> resultMap = new HashMap<>();
        List<TagOwnerDto> departmentList = new ArrayList<>();
        List<TagOwnerDto> subBranchList = new ArrayList<>();
        resultMap.put("departmentList", departmentList);
        resultMap.put("subBranchList", subBranchList);
        departmentList.add(new TagOwnerDto("公司部", 10));
        departmentList.add(new TagOwnerDto("政集部", 3));
        departmentList.add(new TagOwnerDto("同业部", 4));
        departmentList.add(new TagOwnerDto("普惠部", 6));
        subBranchList.add(new TagOwnerDto("浦西支行", 6));
        subBranchList.add(new TagOwnerDto("白玉支行", 3));
        subBranchList.add(new TagOwnerDto("福民支行", 4));
        subBranchList.add(new TagOwnerDto("浦东大道支行", 2));
        subBranchList.add(new TagOwnerDto("武定路支行", 3));
        return resultMap;
    }
}
