package desafio.devoptopus.desafio3.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorAdvicce extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(final NoHandlerFoundException ex,
                                                                   final HttpHeaders headers,
                                                                   final HttpStatus status, final WebRequest request) {
        logger.info(ex.getClass().getName());
        final String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();

        final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, error);
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error("error", ex);
        final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "error occurred");
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }


}
