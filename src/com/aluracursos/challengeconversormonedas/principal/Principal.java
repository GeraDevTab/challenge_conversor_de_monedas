package com.aluracursos.challengeconversormonedas.principal;

import com.aluracursos.challengeconversormonedas.modelos.Monedas;
import com.aluracursos.challengeconversormonedas.modelos.Monedas2;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        var opcion = -1;

        Scanner entrada = new Scanner(System.in);

        List<Monedas> monedas = new ArrayList<>();

        Gson gson = new GsonBuilder()
                //.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (opcion!=0) {
            System.out.println("Bienvenido al sistema de conversion de monedas USD:");
            System.out.println(" a la moneda que Usted especifique");
            var opciones = """
                    1 - USD a ARS - Peso argentino
                    2 - USD a BRL - Real brasileño
                    3 - USD a COP - Peso colombiano
                    4 - USD a MXN - Peso mexicano
                    
                    0- Salir
                    """;
            System.out.println(opciones);
            opcion = entrada.nextInt();
            entrada.nextLine();
            System.out.println(opcion);

            switch (opcion){
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodiosPorSerie();
                    break;
                case 3:
                    mostrarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriesPorTitulo();
                    break;
                case 0:
                    System.out.println("Cerrando aplicacion");
                    break;
                default:
                    System.out.println("Opcion invalida o no puede ser procesada en este momento");

            String direccionAPI = "https://v6.exchangerate-api.com/v6/823aa6303afbb5bf621cafd8/latest/USD";

            try {
                //uso de la clase httpcliente
                HttpClient client = HttpClient.newHttpClient();

                //uso de la clase httprequest
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccionAPI))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());


                String json = response.body();
                //impresion del json completo recibido de la api
                //System.out.println(json);

                Monedas2 moneda = gson.fromJson(json, Monedas2.class);
                System.out.println(moneda);

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            break;
        }

    }
}
