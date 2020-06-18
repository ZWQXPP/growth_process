package com.leyou.common.msg.v2.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 492954844889904924L;

    private String traceId;

    private int code = 200;

    private String msg;

    private T data;

    public static class Builder<T> {

        private String traceId;

        private int code = 200;

        private String msg;

        private T data;

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

        public Builder<T> data(T d) {
            data = d;
            return this;
        }

        public Result<T> build() {
            return new Result<T>(this);
        }
    }

    private Result(Builder<T> builder) {
        traceId = builder.traceId;
        code = builder.code;
        msg = builder.msg;
        data = builder.data;
    }
}
