package com.ufps.clinica.domain.utilidades.error;

public class ErrorMensaje {
    private static final String CITA_NO_EXISTE = "La cita con el id %d no esta registrada";

    public static String citaNoExiste(Long idCita) {
        return String.format(CITA_NO_EXISTE,idCita);
    }
}
