package com.bosc.assessment.dto;

import java.util.List;

public class PageResultDto<T> {
    private long total;
    private List<T> rows;
    private List<T> footer;

    public PageResultDto() {}

    public PageResultDto(long total, List<T> rows) {
        this(total, rows, null);
    }

    public PageResultDto(long total, List<T> rows, List<T> footer) {
        this.total = total;
        this.rows = rows;
        this.footer = footer;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public List<T> getFooter() {
        return footer;
    }

    public void setFooter(List<T> footer) {
        this.footer = footer;
    }
}
