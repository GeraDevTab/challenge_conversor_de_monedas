package com.aluracursos.challengeconversormonedas.modelos;

public record ResultadoConversion(String base_code,
                                  String target_code,
                                  Double conversion_result) {
}
