package com.aid.interview.web.util;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;

public class PaginationUtil {
    public static <T> HttpHeaders generatePaginationHeaders(Page<T> page) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", Long.toString(page.getTotalElements()));
        return headers;
    }
}
