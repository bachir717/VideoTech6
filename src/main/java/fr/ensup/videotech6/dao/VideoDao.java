package fr.ensup.videotech6.dao;

import fr.ensup.videotech6.domaine.Video;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoDao implements IDao {


    private DataSource dataSourceSk;

    public DataSource getDataSourceSk() {
        return dataSourceSk;
    }

    public void setDataSourceSk(DataSource dataSourceSk) {
        this.dataSourceSk = dataSourceSk;
    }

    public Video getVideoById(int id) {
        System.out.println("DAO: récupération du video id=" + id);

        // Information d'accès à la base de données
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            // Etape 2 : récupération de la connexion
            cn = dataSourceSk.getConnection();

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "SELECT * FROM video WHERE id=" + id;

            // Etape 4 : exécution requête
            rs = st.executeQuery(sql);

            // Si récup données alors étapes 5 (parcours Resultset)

            while (rs.next()) {
                return new Video(rs.getInt("id"), rs.getString("titre"), rs.getString("genre"),
                        rs.getString("durree"), rs.getString("dateSortie"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // Etape 6 : libérer ressources de la mémoire.
                cn.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public void createVideo(Video video) {
        System.out.println("DAO: création du video " + video.toString());

        // Information d'accès à la base de données
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            // Etape 2 : récupération de la connexion
            cn = dataSourceSk.getConnection();

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "INSERT INTO video (titre, genre, durree, dateSortie) VALUES ('" + video.getTitre()
                    + "', '" + video.getGenre() + "', '" + video.getDurree() + "', '" + video.getDateSortie() + "' )";

            // Etape 4 : exécution requête
            st.executeUpdate(sql);

            // Si récup données alors étapes 5 (parcours Resultset)

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                // Etape 6 : libérer ressources de la mémoire.
                cn.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Video updateVideo(Video video) {
        System.out.println("DAO: mise à jour du video " + video.toString());

        // Information d'accès à la base de données
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            // Etape 2 : récupération de la connexion
            cn = dataSourceSk.getConnection();

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "UPDATE video SET titre='" + video.getTitre() + "', genre='" + video.getGenre() +"',durree='"+ video.getDurree()
                    + "', dateSortie='" + video.getDateSortie() + "' WHERE id=" + video.getId();

            // Etape 4 : exécution requête
            st.executeUpdate(sql);

            // Si récup données alors étapes 5 (parcours Resultset)

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                // Etape 6 : libérer ressources de la mémoire.
                cn.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public void deleteVideo(Video video) {
        System.out.println("DAO: suppression du video " + video.toString());
    }

    public List<Video> getAllVideo() {
        System.out.println("DAO: récupération de tous les Videos");

        // Information d'accès à la base de données
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            // Etape 2 : récupération de la connexion
            cn = dataSourceSk.getConnection();

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "SELECT * FROM video";

            // Etape 4 : exécution requête
            rs = st.executeQuery(sql);

            // Si récup données alors étapes 5 (parcours Resultset)
            List<Video> videoListe = new ArrayList<Video>();
            while (rs.next()) {
                videoListe.add(new Video(rs.getInt("id"), rs.getString("titre"), rs.getString("genre"),
                        rs.getString("durree"), rs.getString("dateSortie")));
            }
            return videoListe;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // Etape 6 : libérer ressources de la mémoire.
                cn.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public void initialisation() {
        System.out.println("DAO: creation spring");
    }

    public void destruction() {
        System.out.println("DAO: destruction spring");
    }
}
