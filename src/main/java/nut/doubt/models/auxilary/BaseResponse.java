package nut.doubt.models.auxilary;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseResponse<T> extends ResponseEntity<T> {
    public BaseResponse(T data) {
        super(data, HttpStatus.OK);
    }
}
