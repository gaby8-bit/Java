package ex1;


import java.io.*;
import java.util.*;

public class MainApp {
    static void scrie(Object o,String fis)
    {
        try {
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static Object citeste(String fis)
    {
        try{
            FileInputStream f=new FileInputStream(fis);
            ObjectInputStream ois=new ObjectInputStream(f);
            Object o1=ois.readObject();
            ois.close();
            f.close();
            return o1;
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        List<Echipament> lista=new ArrayList<>();
        Scanner sc=new Scanner(System.in);


        int opt;
        String tip;
        BufferedReader br=new BufferedReader(new FileReader("src/ex1/echipament.txt"));
        String linie;
        while((linie= br.readLine())!=null)
        {
           String parti[]=linie.split(";");
           String denumire=parti[0];
           int numar_inv=Integer.parseInt(parti[1]);
           float pret=Float.parseFloat(parti[2]);
           StareEchipament stare=StareEchipament.valueOf(parti[4].toUpperCase());
           tip=parti[5];
           switch (tip)
           {
               case "imprimanta":
                   int ppm=Integer.parseInt(parti[6]);
                   String rezolutie=parti[7];
                   int p_car=Integer.parseInt(parti[8]);
                   Mod_tiparire mod=Mod_tiparire.valueOf(parti[9].toUpperCase());
                   lista.add(new Imprimante(denumire,numar_inv,pret,stare,ppm,rezolutie,p_car,mod));
                   break;
               case "copiator":
                   int ppt=Integer.parseInt(parti[6]);
                   Mod_copiatoare modd=Mod_copiatoare.valueOf(parti[7]);
                   lista.add(new Copiatoare(denumire,numar_inv,pret,stare,ppt,modd));
                   break;
               case "sistem de calcul":
                   String tip_mon=parti[6];
                   float viteza=Float.parseFloat(parti[7]);
                   float capacitate=Float.parseFloat(parti[8]);
                   Sistem_operare sistem=Sistem_operare.valueOf(parti[9].toUpperCase());
                   lista.add(new Sisteme(denumire,numar_inv,pret,stare,tip_mon,viteza,capacitate,sistem));
                   break;


           }
        }
        while(true)
        {
            System.out.println("0.Iesire");
            System.out.println("1.Afisarea tuturor echipamentelor");
            System.out.println("2.Afisarea imprimantelor");
            System.out.println("3.Afisarea copiatoarelor");
            System.out.println("4.Afisarea sistemelor de calcul");
            System.out.println("5.Modificarea stării în care se află un echipament");
            System.out.println("6.Setarea unui anumit mod de scriere pentru o imprimantă");
            System.out.println("7.Setarea unui format de copiere pentru copiatoare");
            System.out.println("8.Instalarea unui anumit sistem de operare pe un sistem de calcul ");
            System.out.println("9.Afişarea echipamentelor vândute");
            System.out.println("10.Serializarea si deserializarea colectiei de echipamente in fisierul echip.bin ");
            System.out.println("Optiunea dvs este:");
            opt= sc.nextInt();
            switch (opt) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    for (Echipament e : lista) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    for (Echipament e : lista) {
                        if (e instanceof Imprimante)
                            System.out.println(e);
                    }
                    break;
                    case 3:
                        for (Echipament e : lista) {
                            if(e instanceof Copiatoare)
                                System.out.println(e);
                        }
                        break;
                        case 4:
                            for (Echipament e : lista) {
                                if(e instanceof Sisteme)
                                    System.out.println(e);
                            }
                            break;
                            case 5:
                                System.out.println("Introduceti numele echipamentului caruia vreti sa ii modificati starea:");
                            String nume;
                            int n;
                            boolean gasit=false;
                            sc.nextLine();
                            nume=sc.nextLine();
                            for(Echipament e : lista) {
                                if (e.getDenumire().equals(nume)) {
                                    gasit = true;
                                    System.out.println("Introduceti starea pe care doriti sa i-o dati  echipamentului:0-Achizitionat,1-Expus,2-Vandut");
                                    n = sc.nextInt();
                                    e.setStare(StareEchipament.values()[n]);
                                    System.out.println("Starea echipamentului:"+nume+" a fost modificata cu succes");
                                }
                            }

                                if(gasit==false)
                                {
                                    System.out.println("Echipamentul introdus nu exista");
                                }

                            break;
                   case 6:
                       String nume_imprimanta;//Nume pentru imprimanta caruia dorim sa ii modificam modul de scriere
                       System.out.println("Introduceti numele imprimantei caruia doriti sa ii modificati modul de scriere");
                       sc.nextLine();
                       nume_imprimanta=sc.nextLine();
                       gasit=false;
                       int mod_imprimare;
                       for (Echipament e :lista)
                       {
                          if(e.getDenumire().equals(nume_imprimanta)&& e instanceof Imprimante)
                          {
                              Imprimante i=(Imprimante)e;
                              gasit=true;
                              System.out.println("Introduceti modul de tiparire pe care il va avea imprimanta 0-Color,1-Alb_Negru");
                              mod_imprimare=sc.nextInt();
                              i.setTiparire(Mod_tiparire.values()[mod_imprimare]);
                              System.out.println("Modul de tiparire al imprimantei:"+nume_imprimanta+"a fost modificat cu succes");

                          }
                       }
                       if(gasit==false)
                           System.out.println("Imprimanta introdusa nu exista");
                       break;
                       case 7:
                           String nume_copiatoare;//Numele copiatorului caruia vrem sa ii modificam modul de copiere
                           sc.nextLine();
                           System.out.println("Introduceti numele copiatorului caruia doriti sa ii modificati modul de copiere");
                           nume_copiatoare=sc.nextLine();
                           gasit=false;
                           int mod_copiatoare;//
                           for(Echipament e :lista)
                           {
                               if(e.getDenumire().equals(nume_copiatoare)&& e instanceof Copiatoare)
                               {
                                   gasit=true;
                                   Copiatoare c=(Copiatoare)e;
                                   System.out.println("Introduceti modul de copiere pe care vreti sa il dati copiatorului 0-A3,1-A4");
                                   mod_copiatoare=sc.nextInt();
                                   c.setMod(Mod_copiatoare.values()[mod_copiatoare]);
                                   System.out.println("Modul de copiere al copiatorului:"+nume_copiatoare+"a fost modificat cu succes");
                               }
                           }
                           if(gasit==false)
                               System.out.println("Copiatorul introdus nu exista");
                           break;
                           case 8:
                               String nume_sisteme;
                               int nr;
                               boolean gasit_sistem=false;
                               System.out.println("Introduceti numele sistemului de calcul caruia doriti sa ii modificati sistemul de operare");
                               sc.nextLine();
                               nume_sisteme=sc.nextLine();
                               for(Echipament e :lista)
                               {
                                   if(e.getDenumire().equals(nume_sisteme)&& e instanceof Sisteme)
                                   {
                                       gasit_sistem=true;
                                       Sisteme s=(Sisteme)e;
                                       System.out.println("Introduceti ce sistem de operare vreti sa instalati 0-Windows,1-Linux");
                                       nr=sc.nextInt();
                                       s.setSistem(Sistem_operare.values()[nr]);
                                       System.out.println("Sistemul de operare al sistemului:"+nume_sisteme+"a fost modificat cu succes");
                                   }
                               }
                               if(gasit_sistem==false)
                                   System.out.println("Sistemul introdus nu exista");
                               break;
                               case 9:
                                   String []stare;
                                   for(Echipament e :lista)
                                   {
                                       if (e.getStare()==StareEchipament.VANDUT)
                                       {
                                           System.out.println(e);
                                       }
                                   }
                                   break;
                case 10:
                    scrie(lista,"echip.bin");
                        List<Echipament> q;
                        q=(List<Echipament>) citeste("echip.bin");
                    for(Echipament e :q)
                            System.out.println(e);
                        break;
                default:
                    System.out.println("Optiunea introdusa nu exista");
            }
        }
    }
}
