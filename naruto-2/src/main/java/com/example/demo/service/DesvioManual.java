package com.example.demo.service;

import com.example.demo.service.Desviador;

import java.util.Scanner;

public class DesvioManual implements Desviador {
    @Override
    public boolean desviar() {
        System.out.println("Deseja desviar do ataque? (S/N)");
        Scanner scanner= new Scanner(System.in);
        String resposta = scanner.nextLine();
        scanner.close();

        return resposta.equalsIgnoreCase("S");
    }
}
