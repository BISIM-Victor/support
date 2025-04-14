package TI.support.Enums;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public enum MessageEnum {

    OK("OK", HttpStatus.OK),
    SUCCESS("Operación completada con éxito", HttpStatus.OK),
    ERROR("Se ha producido un error", HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_FOUND("El recurso no fue encontrado", HttpStatus.NOT_FOUND),
    UNAUTHORIZED("No tienes autorización para acceder a este recurso", HttpStatus.UNAUTHORIZED),
    USERVALIDATION("Usuario y/o contraseña no válidos", HttpStatus.UNAUTHORIZED),
    VALIDATION_FAILED("Validación fallida, revise los datos", HttpStatus.BAD_REQUEST),
    TELEPHONE_VALIDATION_FAILED("Verifique el formato de teléfono, debe contener 10 dígitos", HttpStatus.BAD_REQUEST),
    EVENTO_GESTION_COBRANZA_ACEPTADO("Autorización de cobranza aceptada", HttpStatus.ACCEPTED),
    EVENTO_GESTION_COBRANZA_RECHAZADO("Rechazo de cobranza", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus status;

    MessageEnum(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
