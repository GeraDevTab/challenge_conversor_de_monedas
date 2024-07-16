package com.aluracursos.challengeconversormonedas.modelos;

import java.util.Map;

public record Monedas2(String base_code,
                       Map<String, Double> conversion_rates) {
}
