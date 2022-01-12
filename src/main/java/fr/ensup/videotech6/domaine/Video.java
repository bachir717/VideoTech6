package fr.ensup.videotech6.domaine;

public class Video {
    private int id;
    private String titre;
    private String genre;
    private String durree;
    private String dateSortie;

    public Video(int id, String titre, String genre, String durree, String dateSortie) {
        this.id = id;
        this.titre = titre;
        this.genre = genre;
        this.durree = durree;
        this.dateSortie = dateSortie;
    }
    public Video(String titre, String genre, String durree, String dateSortie) {
        this.titre = titre;
        this.genre = genre;
        this.durree = durree;
        this.dateSortie = dateSortie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDurree() {
        return durree;
    }

    public void setDurree(String durree) {
        this.durree = durree;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", genre='" + genre + '\'' +
                ", durree=" + durree +
                ", dateSortie=" + dateSortie +
                '}';
    }
}
