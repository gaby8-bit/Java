package lab8;

import java.sql.*;
import java.util.Scanner;

public class MainApp {
    public static void adaugare(Connection connection, String nume, int varsta) {
        String sql="insert into persoane (nume,varsta) values (?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setString(1, nume);
            ps.setInt(2, varsta);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public static void adaugare_excursie(Connection connection, int id_persoana, String destinatia,int anul) {
        String sql="insert into excursii (id_persoana,destinatia,anul) values (?,?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, id_persoana);
            ps.setString(2,destinatia);
            ps.setInt(3,anul);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/lab8pj?useSSL=false&serverTimezone=Europe/Bucharest";
        String sql = "select * from persoane";
        Connection connection = DriverManager.getConnection(url, "root", "");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next())
            System.out.println("id=" + rs.getInt("id") + ", nume= "
                    + rs.getString("nume") + ",varsta=" + rs.getInt("varsta"));
        int optiune;
        Scanner sc = new Scanner(System.in);
        while (1 > 0) {
            System.out.println("0.Iesire");
            System.out.println("1.Adaugarea unei persoane in tabel");
            System.out.println("2.Adăugarea unei excursii în tabela excursii. Înainte de a efectua adăugarea se va" +
                    "verifica dacă persoana căreia îi aparține excursia a fost introdusă în tabela" +
                    "persoane. Dacă nu a fost introdusă se va afișa un mesaj corespunzător. Datele" +
                    "excursiei se vor prelua de la tastatură");
            System.out.println("3.Afișarea tuturor persoanelor şi pentru fiecare persoană a excursiilor în care a fost ");
            System.out.println("4.Afișarea excursiilor în care a fost o persoană al cărei nume se citește de la tastatură ");
            System.out.println("5.Afișarea tuturor persoanelor care au vizitat o anumita destinație.");
            System.out.println("6.Afișarea persoanelor care au făcut excursii într-un an introdus ");
            System.out.println("7.Ștergerea unei excursii");
            System.out.println("8.Ștergerea unei persoane (împreună cu excursiile în care a fost");
            System.out.println("Optiunea dvs este:");
            optiune = sc.nextInt();
            switch (optiune) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    String nume;
                    int varsta;
                    System.out.println("Introduceti numele persoanei pe care vreti sa o adaugati in tabel:");
                    nume = sc.next();
                    System.out.println("Introduceti varsta persoanei pe care vreti sa o adaugati in tabel:");
                    varsta = sc.nextInt();
                    adaugare(connection, nume, varsta);

                    statement.close();
                    rs.close();
                    break;
                case 2:
                     int id_persoana1;
                     String destinatia;
                     int anul;
                     System.out.println("Introduceti id_persoana:");
                     id_persoana1=sc.nextInt();
                     System.out.println("Introduceti destinatia");
                     destinatia=sc.next();
                     System.out.println("Introduceti anul:");
                     anul=sc.nextInt();
                     String comanda="select * from persoane where id=?";
                    PreparedStatement ps=connection.prepareStatement(comanda);
                    ps.setInt(1, id_persoana1);
                    ResultSet rss = ps.executeQuery();
               if(rss!=null)
               {
                   adaugare_excursie(connection,id_persoana1,destinatia,anul);
               }
               else
               {
                   System.out.println("Persoana careia i-ati introdus excursia nu exista in tabelul persoane");
               }
                case 3:
                    String cauta="select a.id as persoana_id, a.nume, a.varsta, b.destinatia from persoane a , excursii b where a.id = b.id_persoana";
                    PreparedStatement ps1=connection.prepareStatement(cauta);
                    ResultSet rss1=ps1.executeQuery();
                   while(rss1.next())
                   {

                       System.out.println("id=" + rss1.getInt("persoana_id") + ", nume= " + rss1.getString("nume")
                               + ", varsta=" + rss1.getInt("varsta") + ", destinatia=" + rss1.getString("destinatia"));
                   }

                    break;
                case 4:
                    String nume_cautat;
                    int nr=0;
                    System.out.println("Introduceti numele persoanei caruia vreti sa ii afisati" +
                            "excursiile:");
                    nume_cautat=sc.next();
                    String interogare="select b.id_excursie, b.destinatia, b.anul " +
                            "from persoane a, excursii b " +
                            "where a.nume = \"" + nume_cautat + "\" and a.id = b.id_persoana";
                    PreparedStatement ps2=connection.prepareStatement(interogare);
                    ResultSet rss2=ps2.executeQuery();
                    while(rss2.next())
                    {
                        System.out.println("id_excursie="+rss2.getInt("id_excursie")+", destinatia="+rss2.getString("destinatia")
                        + ", anul="+rss2.getInt("anul"));
                        nr++;

                    }
                    if(nr==0)
                        System.out.println("Persoana cautata nu exista");
                    break;
                  case 5:
                      String destinatieCautata;
                      int nr5=0;
                      System.out.println("Introduceti destinatia:");
                      destinatieCautata=sc.next();
                      String cinci="select a.nume from persoane a, excursii b where b.destinatia=\""+destinatieCautata+"\" and a.id = b.id_persoana";
                      PreparedStatement ps3=connection.prepareStatement(cinci);
                      ResultSet rss3=ps3.executeQuery();
                      while(rss3.next())
                      {
                          System.out.println("nume="+rss3.getString("nume"));
                          nr5++;
                      }
                      if(nr5==0)
                          System.out.println("Nu exista persoana care sa fi vizitat destinatia data");
                      break;
                case 6:
                    int anCaut;
                    int nr6=0;
                    System.out.println("Introduceti anul de cautare:");
                    anCaut=sc.nextInt();
                    String sase="select a.id, a.nume, a.varsta from persoane a, excursii b where b.anul = \""+anCaut+"\"and a.id = b.id_persoana";
                    PreparedStatement ps4=connection.prepareStatement(sase);
                    ResultSet rss4=ps4.executeQuery();
                    while(rss4.next())
                    {
                        System.out.println("id="+rss4.getInt("id")+" nume="+rss4.getString("nume")+
                                " varsta="+rss4.getInt("varsta"));
                        nr6++;
                    }
                    if(nr6==0)
                        System.out.println("Nu au fost excursii in acel an");

                case 7:
                    String destinatieSters;
                    System.out.println("Introduceti o excursie pe care vreti sa o stergeti:");
                    destinatieSters= sc.next();
                    String sapte="delete from excursii where destinatia=\""+destinatieSters+"\"";
                    PreparedStatement ps5=connection.prepareStatement(sapte);
                    ps5.executeUpdate();
                    break;
                    case 8:
                        String numeSters;
                        System.out.println("Introduceti nume de sters:");
                        numeSters= sc.next();
                        String opt="delete from persoane where nume=\""+numeSters+"\"";
                        PreparedStatement ps6=connection.prepareStatement(opt);
                        ps6.executeUpdate();
                        break;

            }

        }

    }}


