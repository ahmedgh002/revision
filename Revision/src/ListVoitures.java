import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListVoitures {
    private List<Voiture> voitures;

    public ListVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public ListVoitures() {
        this.voitures = new ArrayList<>();
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }


    public void setVoitures(List<Voiture> voitures) {
        this.voitures= voitures;
    }
    public void ajoutVoiture(Voiture v) throws VoitureException{
        if (v != null) {
            voitures.add(v);
        } else {
            throw new VoitureException("impossible d'jouter la voiture");
        }
    }
    public void supprimeVoiture(Voiture v) throws VoitureException{
        if (v != null) {
            voitures.remove(v);
        } else {
            throw new VoitureException("impossible de supprimer la voiture");
        }
    }

    public Iterator<Voiture> iterateur(){

        return voitures.iterator();
    }
    public int size(){

        return voitures.size();
    }
    public void affiche(){

            for (Voiture v : voitures) {
                System.out.println(v.toString());
            }
        }
}