package miw.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import miw.resources.exceptions.ErrorMessage;
import miw.resources.exceptions.MalformedHeaderException;
import miw.resources.exceptions.NotFoundUserIdException;
import miw.resources.exceptions.UnauthorizedException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundUserIdException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception, request.getRequestURI().toString());
        return errorMessage;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MalformedHeaderException.class})
    @ResponseBody
    public ErrorMessage badRequest(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception, "");
        return errorMessage;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseBody
    public ErrorMessage conflictRequest(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception, "");
        return errorMessage;
    }

}
