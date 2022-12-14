package edu.aluismarte.diplomado.week5;

import lombok.*;

import java.util.List;

/**
 * ¿Como probar estos métodos?
 *
 * Hacer los test principalmente de los métodos privados (Se hace de forma indirecta)
 *
 * Arreglar la lógica de la función, no siempre lo que el cliente pide o la primera implementación funciona adecuadamente
 *
 * @author aluis on 4/3/2022.
 */
public class Homework {

    public String prepareTemplate(List<VarsReplace> varsReplaces, String template) {
        for (VarsReplace varsReplace : varsReplaces) {
            template = replaceVar(template, varsReplace);
        }
        return template;
    }

    // TODO test this method
    private String replaceVar(String template, VarsReplace varsReplace) {
        String var = "\\$\\{" + varsReplace.getVarReplace() + "\\}";
        return template.replaceAll(var, varsReplace.getValue());
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class VarsReplace {
        private String varReplace;
        private String value;
    }
}