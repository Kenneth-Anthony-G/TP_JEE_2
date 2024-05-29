package GLSIAGROUPE13.TP_JEE.model;


import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseModel {
    private HttpStatus status;
    private int statusCode;
    private boolean success;
    private Object data;
    private Object errors;
}