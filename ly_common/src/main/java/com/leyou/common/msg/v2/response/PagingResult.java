package com.leyou.common.msg.v2.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingResult<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1868687887197264648L;

    private String traceId;

    private int code;

    private String msg;

    private PagingData<T> data;

    public static class Builder<T> {

        private String traceId;

        private int code = 200;

        private String msg;

        private PagingData<T> data;

        public Builder<T> traceId(String t) {
            traceId = t;
            return this;
        }

        public Builder<T> code(int c) {
            code = c;
            return this;
        }

        public Builder<T> msg(String m) {
            msg = m;
            return this;
        }

        public Builder<T> data(long total, List<T> rows) {
            data = new PagingData<T>(total, rows);
            return this;
        }

        public PagingResult<T> build() {
            return new PagingResult<T>(this);
        }
    }

    private PagingResult(Builder<T> builder) {
        traceId = builder.traceId;
        code = builder.code;
        msg = builder.msg;
        data = builder.data;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class PagingData<T> {
        long total;

        List<T> rows;
    }
}
