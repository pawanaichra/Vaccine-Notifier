package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    private List<Center> centers;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Center {

        @JsonProperty(value = "center_id")
        private String centerId;

        private String name;

        @JsonProperty("block_name")
        private String blockName;

        private String pincode;

        private List<Session> sessions;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Session {
        private String date;

        @JsonProperty(value = "available_capacity")
        private int capacity;

        @JsonProperty(value = "available_capacity_dose1")
        private int dose1;
    }
}
