import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures vs;
    private Map<Client, ListVoitures> ClientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        vs = new ListVoitures();
        ClientVoitureLoue = new HashMap<>();
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        vs.ajoutVoiture(v);
    }

    public void suppVoiture(Voiture v) throws VoitureException {
        vs.supprimeVoiture(v);
    }

    public void loueClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (ClientVoitureLoue.containsKey(cl)) {
            ClientVoitureLoue.get(cl).ajoutVoiture(v);
        } else {
            ListVoitures voituresLouees = new ListVoitures();
            voituresLouees.ajoutVoiture(v);
            ClientVoitureLoue.put(cl, voituresLouees);
        }
    }

    public void retourClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (ClientVoitureLoue.containsKey(cl)) {
            ClientVoitureLoue.get(cl).supprimeVoiture(v);
        }
    }

    public List<Voiture> selectVoitureSelonCritere(Critere c) {
        List<Voiture> voituresFiltrees = new ArrayList<>();
        for (Voiture voiture : vs.getVoitures()) {
            if (c.estSatisfaitPar(voiture)) {
                voituresFiltrees.add(voiture);
            }
        }
        return voituresFiltrees;
    }

    public Set<Client> ensembleClientsLoueurs() {
        return ClientVoitureLoue.keySet();
    }

    public Collection<ListVoitures> collectionVoituresLouees() {
        return ClientVoitureLoue.values();
    }

    public void afficheLesClientsEtLeursListesVoitures() {
        for (Map.Entry<Client, ListVoitures> entry : ClientVoitureLoue.entrySet()) {
            Client client = entry.getKey();
            ListVoitures voituresLouees = entry.getValue();
            System.out.println("Client: " + client.getNom() + " " + client.getPrenom());
            voituresLouees.affiche();
        }
    }

    public Map<Client, ListVoitures> triCodeCroissant() {
        Map<Client, ListVoitures> sortedMap = new TreeMap<>(new Comparator<Client>() {
            @Override
            public int compare(Client client1, Client client2) {
                return Integer.compare(client1.getCode(), client2.getCode());
            }
        });
        sortedMap.putAll(ClientVoitureLoue);
        return sortedMap;
    }

    public Map<Client, ListVoitures> triNomCroissant() {
        Map<Client, ListVoitures> sortedMap = new TreeMap<>(new Comparator<Client>() {
            @Override
            public int compare(Client client1, Client client2) {
                return client1.getNom().compareTo(client2.getNom());
            }
        });
        sortedMap.putAll(ClientVoitureLoue);
        return sortedMap;
    }
}
