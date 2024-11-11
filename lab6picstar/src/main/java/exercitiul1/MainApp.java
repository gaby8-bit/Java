package exercitiul1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainApp {
    static void afisare_filtrata2(List<Angajat> pers, Predicate<Angajat> f) {
        for(Angajat p:pers)
            if(f.test(p))
                System.out.println(p);
    }
    public static void scriere(List<Angajat> angajati) {
        /**
         * serializare a datelor
         * in fisierul angajati.json
         */
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            File file=new File("src/main/resources/angajati.json");
            mapper.writeValue(file,angajati);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Angajat> citire() {
        try {
            File file=new File("src/main/resources/angajati.json");
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            List<Angajat> angajati = mapper.readValue(file, new TypeReference<List<Angajat>>(){});
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        List<Angajat> angajati=citire();
        System.out.println(angajati);
        for(Angajat p:angajati){
            System.out.println(p);
        }
        //Cerinta 2
      // angajati.add(new Angajat("Ion","Inginer", LocalDate.parse("2024-05-10"), 1500.20F));
       scriere(angajati);
        System.out.println("Angajatii cu salariul mai mare decat 2500:"+'\n');
        afisare_filtrata2(angajati, new Predicate<Angajat>() {
            @Override
            public boolean test(Angajat p) {
                return p.getSalariul()>2500;
            }
        });
        afisare_filtrata2(angajati, p->p.getSalariul()>2500); //cu expresie Lambda
        System.out.println("Angajati care au salariul mai mare decat 2500:"+'\n');
        angajati.stream().filter((lista) -> lista.getSalariul()>2500).forEach(System.out::println);
        System.out.println();
        //Cerinta 3
        List<Angajat> aprilie=angajati.stream().filter((a)->a.getPostul().toLowerCase().contains("sef")||(a.getPostul().toLowerCase().contains("director"))&&(a.getData_angajarii().getMonth().equals(Month.APRIL))).collect(Collectors.toList());
        for(Angajat a:aprilie)
        {
            System.out.println(a);
        }
        //Cerinta 4
        System.out.println("Cerinta 4");
                        angajati.stream()
                                .filter(p -> !p.getPostul().equalsIgnoreCase("sef") && !p.getPostul().equalsIgnoreCase("director"))
                                .sorted(Comparator.comparing(Angajat::getSalariul).reversed())
                                .forEach(System.out::println);


        //Cerinta 5
        System.out.println("Cerinta 5");
        List<String> nume=angajati.stream().map(Angajat::getNumele)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        for(String n:nume)
        {
            System.out.println(n+" ");
        }
        //Cerinta 6
        System.out.println("Cerinta 6");
        angajati.stream().filter(p->p.getSalariul()<3000)
                .map(Angajat::getSalariul)
                .forEach(System.out::println);
//Cerinta 7
        System.out.println("Cerinta 7");
        Optional<Angajat> primul_angajat=angajati.stream().findFirst();
        if (primul_angajat.isPresent())
            System.out.println(primul_angajat.get());
        else
            System.out.println("Lista nu contine angajati");
        //Cerinta 8
        System.out.println("Cerinta 8");
        Optional<Angajat> sal_max=angajati.stream().max(Comparator.comparing(Angajat::getSalariul));
        if(sal_max.isPresent())
            System.out.println("Salariul maxim este:"+sal_max.get().getSalariul());
            else
                System.out.println("Lista nu contine angajati");
            Optional<Angajat>sal_min=angajati.stream().min(Comparator.comparing(Angajat::getSalariul));
            if(sal_min.isPresent())
                System.out.println("Salariul minim este:"+sal_min.get().getSalariul());
            else
                System.out.println("Lista nu contine angajati");
           //angajati.stream().forEach(System.out::println); afisare cu stream
           DoubleSummaryStatistics suma_salarii=angajati.stream().collect(Collectors.summarizingDouble(Angajat::getSalariul));
              double sal_mediu=suma_salarii.getAverage();
              System.out.println("Salariul mediu este:"+sal_mediu);
              //Cerinta 9
        System.out.println("Cerinta 9");
        Optional<Angajat> ion=angajati.stream().filter(p->p.getNumele().equalsIgnoreCase("ion")).findAny();
      ion.ifPresentOrElse(angajat -> System.out.println("Firma are cel putin un Ion angajat"),()->System.out.println("Firma nu are" +
              "niciun Ion angajat"));
      //Cerinta 10
        System.out.println("Cerinta 10");
       long nr=angajati.stream().count();
       System.out.println("Momentan sunt "+nr+" angajati");
    }
}
