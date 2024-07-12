package com.inventory.management.inventorymanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@CrossOrigin(origins = "*", allowedHeaders = {"authorization", "content-type", "accept", "x-requested-with"},
        methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST, RequestMethod.PUT})
public class InventoryExcpeptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InventoryException.class)
    @CrossOrigin("*")
    public final ResponseEntity<ErrorResponse> handleInventoryException(InventoryException inventoryException) {
            ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder()
                    .withErrCode(inventoryException.getStatusCode())
                    .withErrMsg(inventoryException.getExpMsg())
                    .withErrMsgDetails(inventoryException.getExpDetails())
                    .build();
            return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(errorResponse.getStatus()));
    }

    @ExceptionHandler(Exception.class)
    @CrossOrigin("*")
    public final ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder()
                .withErrCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withErrMsg(exception.getMessage())
                .withErrMsgDetails(exception.getStackTrace().toString())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(errorResponse.getStatus()));
    }
}
