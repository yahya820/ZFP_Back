package com.example.ZFP_Back.Exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
     @JsonProperty("status")
    private String status;
    @JsonProperty("massage")
    private String massage;
    @JsonProperty("code")
    private String code;

    public ErrorResponse(String status, String massage) {
        this.status = status;
        this.massage = massage;
    }
    
}
