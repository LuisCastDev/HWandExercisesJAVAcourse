package edu.aluismarte.diplomado.week2;

import edu.aluismarte.diplomado.model.week2.Holiday;
import edu.aluismarte.diplomado.utils.Data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Crear una mejora de cualquiera de los algoritmos optimizados para pasarle los dÃ­as laborales (no asumir, que llegue como parÃ¡metro)
 *
 * @author aluis on 3/27/2022.
 * @implNote Debe tener sus test
 */
public class Homework {

    /**
     * Hacer una implementaciÃ³n propia basado en los ejemplos explicados en clase.
     *
     * @param laborDays Los dias que son laborables, es decir, podemos trabajar de lunes a viernes, de lunes a sÃ¡bado, o la semana entera, o solo 3 dias a la semana
     * @param holidays  Todos los dias feriados que serÃ¡n relevantes para el cÃ¡lculo, tomar en cuenta diciembre para esto, puede que necesites los feriados del aÃ±o siguiente
     * @param startDate Fecha de inicio para calcular las vacaciones, esta fecha es incluyente, es decir, desde aquÃ­ se inicia la vacaciÃ³n
     * @param vacation  La cantidad de dÃ­a a vacacionar
     * @return La fecha que debe retornar el trabajador
     * @implNote El Ãºltimo dÃ­a de vacaciÃ³n tambiÃ©n cuenta, es decir, que regresa el siguiente dia laboral
     */
    public LocalDate calculateDueDate(List<DayOfWeek> laborDays, List<Holiday> holidays, LocalDate startDate, int vacation) {
        LocalDate resultDueDate = startDate;
        int totalLaborDays = 0;

        while (true) {
            if (isHoliday(holidays, resultDueDate)) {
                resultDueDate = resultDueDate.plusDays(1);
            } else if (isLaborDays(laborDays, resultDueDate)){
                totalLaborDays += 1;
            }

            if (totalLaborDays <= vacation) {
                resultDueDate = resultDueDate.plusDays(1);
            } else {
                break;
            }
        }

        return resultDueDate;
    }

    private boolean isHoliday(List<Holiday> holidays, LocalDate date) {
        return holidays.stream().anyMatch(holiday -> holiday.getDate().isEqual(date));
    }

    private boolean isLaborDays(List<DayOfWeek> laborDays, LocalDate date) {
        return laborDays.stream().anyMatch(laborDay -> laborDay.getValue() == date.getDayOfWeek().getValue());
    }
}
