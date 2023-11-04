import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Agence agence = new Agence("Agence");

        Client client1 = new Client(1, "xx", "xx");
        Client client2 = new Client(2, "y", "y");
        Voiture x1 = new Voiture(1, "zzz", 74);
        Voiture x2 = new Voiture(2, "hhh", 22);

        try {
            agence.ajoutVoiture(x1);
            agence.ajoutVoiture(x2);
        } catch (VoitureException e) {
            System.out.println(e.getMessage());
        }


        try {
            agence.ajoutVoiture(x1);
            agence.ajoutVoiture(x2);
        } catch (VoitureException e) {
            System.out.println("Erreur d'ajout: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur d'ajout:: " + e.getMessage());
        }

        try {
            agence.loueClientVoiture(client1, x1);
            agence.loueClientVoiture(client2, x2);
        } catch (VoitureException e) {
            System.out.println(e.getMessage());
        }
        try {
            agence.loueClientVoiture(client1, x1);
            agence.loueClientVoiture(client2, x2);
        } catch (VoitureException e) {
            System.out.println("Erreur de louer: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur de louer " + e.getMessage());
        }

        agence.afficheLesClientsEtLeursListesVoitures();

        Map<Client, ListVoitures> sortedClientsByCode = agence.triCodeCroissant();
        System.out.println("clients tries:");
        for (Client client : sortedClientsByCode.keySet()) {
            System.out.println(client.toString());
        }

        Map<Client, ListVoitures> sortedClientsByName = agence.triNomCroissant();
        System.out.println("Clients tries:");
        for (Client client : sortedClientsByName.keySet()) {
            System.out.println(client.toString());
        }
    }


}
