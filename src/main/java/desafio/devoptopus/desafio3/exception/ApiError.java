package desafio.devoptopus.desafio3.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class ApiError {

    private HttpStatus status;

    private List<String> errors;

    public ApiError(final HttpStatus status, final List<String> errors) {
        super();
        this.status = status;
        this.errors = errors;
    }

    public ApiError(final HttpStatus status, final String error) {
        super();
        this.status = status;
        errors = Collections.singletonList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
