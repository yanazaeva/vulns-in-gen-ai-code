
package edu.upc.eetac.dsa.grouptalk.ejerciciosJava;

import java.io.*;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        File archivo = new File("archivo.txt");
        if(!archivo.exists()){
            System.out.println("Archivo no existe");
            return;
        }else{
            Scanner sc = null;
            try{
                sc = new Scanner(archivo);
            }catch (FileNotFoundException e){
                System.out.println("Archivo no encontrado");
            }finally {
                if (sc != null)
                    sc.close();
            }
        }
        String[] lineas = {"1,2,3,4", "5,6,7,8"};
        //int i = 0;
        for(String linea:lineas){
            System.out.println("Linea "+i);
            int posicion=0;
            String[] numeros = linea.split(",");
            Scanner scn = new Scanner(System.in);
            //while (scn.hasNextInt()) {
                for(String num:numeros){
                    System.out.println("numero "+posicion+" :"+num+"  ");
