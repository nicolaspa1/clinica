package com.ufps.clinica.domain.utilidades.error;

public class ErrorMensaje {
    private static final String CITA_NO_EXISTE = "La cita con el id %d no esta registrada";
    private static final String MEDICO_NO_EXISTE = "El medico con el id %d no esta registrado";

    public static String citaNoExiste(Long idCita) {
        return String.format(CITA_NO_EXISTE,idCita);
    }

    public static String medicoNoExiste(Long idMedico) {
        return String.format(MEDICO_NO_EXISTE,idMedico);
    }
}
