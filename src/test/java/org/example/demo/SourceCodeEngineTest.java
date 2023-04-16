package org.example.demo;

import com.bosc.assessment.sourceGen.engine.SimpleObj;
import com.bosc.assessment.sourceGen.engine.SourceCodeEngine;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SourceCodeEngineTest {

    @Test
    public void pageTest() {
        List<String> list = new ArrayList<>();
        int page = 1, rows = 10;
        PageHelper.startPage(page, rows);
        PageInfo<String> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        System.out.println(total);
    }

    @Test
    public void readFile() throws Exception {
        SourceCodeEngine.generate();
    }

    @Test
    public void jsonTest() {
        String json = "{\"name\": \"Alice\",\"age\": 12}";
        SimpleObj obj = new Gson().fromJson(json, SimpleObj.class);
        System.out.println(obj);
    }
}
