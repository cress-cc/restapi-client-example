package cc.cress.dto;

import com.google.api.client.util.Key;

import lombok.Data;

@Data
public class Response {
    @Key
    private Integer status;
    @Key
    private String message;
    @Key
    private Result[] results;

    @Data
    public static class Result {
        @Key
        private String zipcode;
        @Key
        private String prefcode;
        @Key
        private String address1;
        @Key
        private String address2;
        @Key
        private String address3;
        @Key
        private String kana1;
        @Key
        private String kana2;
        @Key
        private String kana3;
    }
}
