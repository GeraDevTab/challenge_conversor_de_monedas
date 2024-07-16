package com.aluracursos.challengeconversormonedas.modelos;
import java.util.Map;

import com.google.gson.Gson;


public record Monedas (String result,
                       String base_code,
                       Map<String, Double> conversionRates){

}
