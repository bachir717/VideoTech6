package fr.ensup.videotech6.service;

import fr.ensup.videotech6.dao.IDao;
import fr.ensup.videotech6.domaine.Video;

import java.util.List;

public class VideoService {
    private IDao iDao;

    public VideoService() {
        super();
    }

    public VideoService(IDao iDao) {
        super();
        this.iDao = iDao;
    }

    public Video recuperationVideo(int id) {
        System.out.println("SERVICE: r�cup�ration d'une video id=" + id);

        Video videoRetour = iDao.getVideoById(id);
        return videoRetour;
    }

    public void creerVideo(Video video) {
        System.out.println("SERVICE: cr�ation d'une video " + video.toString());

        iDao.createVideo(video);
    }

    public Video mettreAJourVideo(Video video) {
        System.out.println("SERVICE: mise � jour d'une video " + video.toString());

        Video videoRetour = iDao.updateVideo(video);
        return videoRetour;
    }

    public void supprimerVideo(Video video) {
        System.out.println("SERVICE: suppression d'une video " + video.toString());

        iDao.deleteVideo(video);
    }

    public List<Video> recuperationVideoListe() {
        System.out.println("SERVICE: r�cup�ration de tous les videos");

        List<Video> compteListeRetour = iDao.getAllVideo();
        return compteListeRetour;
    }

    public void comparaisonVideo(Video v1, Video v2) {
        System.out.println("SERVICE: comparaison entre deux video");
    }

    public IDao getiDao() {
        return iDao;
    }

    public void setiDao(IDao iDao) {
        this.iDao = iDao;
    }

    public void initialisation() {
        System.out.println("SERVICE: creation spring");
    }

    public void destruction() {
        System.out.println("SERVICE: destruction spring");
    }
}
