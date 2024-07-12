package com.inventory.management.inventorymanager.exception;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

    private int status;
    private String errMsg;
    private List<String> errDetails = new ArrayList<>();

    public int getStatus() {
        return status;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public List<String> getErrDetails() {
        return errDetails;
    }

    public static class ErrorResponseBuilder {

        private ErrorResponse errorResponseBuild;

        public ErrorResponseBuilder() {
            this.errorResponseBuild = new ErrorResponse();
        }

        public ErrorResponseBuilder withErrCode(int status) {
            this.errorResponseBuild.status = status;
            return this;
        }

        public ErrorResponseBuilder withErrMsg(String errMsg) {
            this.errorResponseBuild.errMsg = errMsg;
            return this;
        }

        public ErrorResponseBuilder withErrMsgDetails(String errMsgDetails) {
            this.errorResponseBuild.errDetails.add(errMsgDetails);
            return this;
        }

        public ErrorResponse build() {
            ErrorResponse apiErrorResponse = this.errorResponseBuild;
            this.errorResponseBuild = new ErrorResponse();
            return apiErrorResponse;
        }
    }
}
