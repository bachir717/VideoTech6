package fr.ensup.videotech6.launcher;

import fr.ensup.videotech6.domaine.Video;
import fr.ensup.videotech6.service.VideoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {

        // 1. Chargement du conteneur en 4.0.0 Spring
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("demo-beans.xml");

        // 2. Recuperation d'un bean du conteneur
        VideoService videoService = (VideoService) applicationContext.getBean("videoService");

        // 3. Manipulation du bean avec injection de dependances
        Video v1 = new Video("Ville nouvelle", "Documentaire", "1.5", "29/30/2020");
        videoService.creerVideo(v1);

        v1.setDurree("4.5");
        videoService.mettreAJourVideo(v1);

        Video v2 = videoService.recuperationVideo(2);
        if (v2 != null) {
            System.out.println("LAUNCHER: Récuperation du compte réussie " + v2.toString());
        } else {
            System.out.println("LAUNCHER: Récuperation du compte échouée");
        }

        for (Video videoCourant : videoService.recuperationVideoListe()) {
            System.out.println(videoCourant.toString());
        }

//		applicationContext.close();
    }
}
