package noticia;

import noticia.NoticiaStub;
import noticia.NoticiaStub.GetUrl;
import noticia.NoticiaStub.GetUrlResponse;
import noticia.NoticiaStub.GetTitular;
import noticia.NoticiaStub.GetTitularResponse;
import noticia.NoticiaStub.GetDescripcion;
import noticia.NoticiaStub.GetDescripcionResponse;

import noticia.NoticiaStub.SetUrl;
import noticia.NoticiaStub.SetTitular;
import noticia.NoticiaStub.SetDescripcion;

import java.util.Scanner;
import java.io.InputStreamReader;

public class Client{

    public static void display_options() {
        System.out.println("1) Obtener titular");
        System.out.println("2) Cambiar titular");
        System.out.println("3) Obtener descripcion");
        System.out.println("4) Cambiar descripcion");
        System.out.println("5) Obtener URL");
        System.out.println("6) Cambiar URL");
        System.out.println("7) Salir");
        System.out.println("Introduzca una opción:");

    }

    public static void main(java.lang.String args[]){
        try{
            System.out.println("Starting client...");
            NoticiaStub stub =
                new NoticiaStub
                ("http://localhost:8080/axis2/services/Noticia");
            
            int option = 0;
            Scanner scan = new Scanner(new InputStreamReader(System.in));
            
            while(option != 7) {
                display_options();

                option = scan.nextInt();
                scan.nextLine();

                switch(option) {
                    case 1:
                        GetTitularResponse titular = stub.getTitular(new GetTitular());
                        System.out.println("Titular: " + titular.get_return());
                        break;

                    case 2:
                        SetTitular setT = new SetTitular();
                        System.out.println("Introduzca el nuevo titular:");
                        String new_titular = scan.nextLine();

                        setT.setTitular(new_titular);
                        stub.setTitular(setT);

                        break;

                    case 3:
                        GetDescripcionResponse descripcion = stub.getDescripcion(new GetDescripcion());
                        System.out.println("Descripcion: " + descripcion.get_return());
                        break;

                    case 4:
                        SetDescripcion setD = new SetDescripcion();
                        System.out.println("Introduzca la nueva descripcion:");
                        String new_descripcion = scan.nextLine();

                        setD.setDescripcion(new_descripcion);
                        stub.setDescripcion(setD);
                        break;

                    case 5:
                        GetUrlResponse url = stub.getUrl(new GetUrl());
                        System.out.println("Url: " + url.get_return());
                        break;
                    
                    case 6:
                        SetUrl setU = new SetUrl();
                        System.out.println("Introduzca la nueva url:");
                        String new_url = scan.nextLine();

                        setU.setUrl(new_url);
                        stub.setUrl(setU);
                        break;
                    
                    default:
                        break;
                }
            }

        } catch(Exception e){
            e.printStackTrace();
            System.out.println("\n\n\n");
        }
    }

}
