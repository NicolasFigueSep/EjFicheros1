/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejfichero1;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Alumno Tarde
 */
public class Ejercicios {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        ejercicio3();
    }

    public static void ejercicio1() {
        String elemento;
        String nombreDirectorio;
        String nuevoNombre;
        System.out.println("Introduce nombre del elemento");
        elemento = sc.nextLine();
        System.out.println("Introduce ruta del directorio");
        nombreDirectorio = sc.nextLine();
        /*
            No se si esto se hace olbigatoriamente en 2 pasos o 
            se puede hacer directamente.->Respuesta: si que se puede
            hacer de una
        
         */
//        File directorio = new File(nombreDirectorio);
//        File f = new File(directorio,nombreFichero);
        File cosita = new File(nombreDirectorio, elemento);
        if (cosita.exists()) {
            if (cosita.isFile()) {
                System.out.println("Es un fichero si señor jaja");
                System.out.println("Fichero existe");
                System.out.println("El tamaño del fichero es " + cosita.length());
                System.out.println("Nombre nuevo del fichero ");
                nuevoNombre = sc.nextLine();
                File nuevaCosita = new File(nombreDirectorio,nuevoNombre);
                System.out.println((cosita.renameTo(nuevaCosita) ? "Renombrado correctamente" : "No se ha podido renombrar"));
                 
            }
            //Si entra es que es un directorio
            if (cosita.isDirectory()) {
                File direct = cosita;
                File[] ficheros = direct.listFiles();
                System.out.println("Es un directorio y tiene esto dentro : ");
                listarDirectorio(ficheros);
            }
        }
        else{
            System.out.println("No existe este elemento man");
        }

    }

    public static void ejercicio2() {
        String elemento;
        String nombreDirectorio;
        System.out.println("Introduce nombre del elemento");
        elemento = sc.nextLine();
        System.out.println("Introduce ruta del directorio");
        nombreDirectorio = sc.nextLine();
        
        File cosa = new File(nombreDirectorio,elemento);
        if(cosa.exists()){
            System.out.println("El elemento existe");
            if(cosa.canRead()){
                System.out.println("Se puede leer");
            }
            else{
                System.out.println("No se puede leer");
            }
            if(cosa.canWrite()){
                System.out.println("Se puede escribir");
            }
            else{
                System.out.println("No se puede escribir");
            }
            System.out.println("El fichero mide " + cosa.length());
            System.out.println((cosa.delete() ? "Borrado correctamente" : "No se puede borrar"));
            
        }
        else{
            System.out.println("El elemento no existe. \nCerrando programa....");
        }
    }
    public static void ejercicio3(){
        String elemento;
        String nombreDirectorio;
        double tam;
        System.out.println("Introduce nombre del elemento");
        elemento = sc.nextLine();
        System.out.println("Introduce ruta del directorio");
        nombreDirectorio = sc.nextLine();
        
        File dir =  new File(nombreDirectorio);
        if(dir.exists()){
            System.out.println("Existe la ruta del directorio");
            File cosa =  new File(dir, elemento);
            if(cosa.exists()){
                System.out.println("Existe el fichero dentro del directorio");
                System.out.println("Subdirectorios...");
                listarSubdirs(dir.listFiles()); 
                System.out.println("Ficheros...");
                tam = listarDirectorio2(dir.listFiles());
                System.out.println("Tamaño de todos los ficheros " + tam);
            }
        }
        
    }

    public static void listarDirectorio(File[] ficheros) {
        for (int i = 0; i < ficheros.length; i++) {
            if(ficheros[i].isFile()){
                System.out.println(i + ": " + ficheros[i].getName());;
            }
            
        }
    }
    public static double listarDirectorio2(File[] ficheros) {
        double tamanio = 0;
        for (int i = 0; i < ficheros.length; i++) {
            if(ficheros[i].isFile()){
                System.out.println(i + ": " + ficheros[i].getName());;
                tamanio +=ficheros[i].length();
            }
            
        }
        return tamanio;
    }
    public static void listarSubdirs(File[] ficheros){
        for (int i = 0; i < ficheros.length; i++) {
            if(ficheros[i].isDirectory()){
                System.out.println("Directorio " + i+" : "  + ficheros[i].getName());
            }
        }
    }
}
