package br.com.barbaridadesp.barbaridade_api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiResponseException  extends RuntimeException {
    private final HttpStatus status;

    public ApiResponseException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

}
