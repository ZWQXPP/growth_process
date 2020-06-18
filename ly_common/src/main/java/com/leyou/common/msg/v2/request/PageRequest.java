package com.leyou.common.msg.v2.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest extends BaseRequest {

    /**
     *
     */
    private static final long serialVersionUID = -4085395136699285911L;

    private int limit = 10;

    private int page = 1;

}
