package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Nelson
 */
public class AudioPlayer implements Runnable {

    private Player audioPlayer;
    private String fileName;
    private Thread playerThread;
    private boolean fileRunning;

    public AudioPlayer(String pFileName) {
        this.fileName = pFileName;
        this.fileRunning = false;
    }

    public void play() {
        if (!fileRunning) {
            try {
                audioPlayer = new Player(new FileInputStream(new File(fileName)));
                playerThread = new Thread(this);
                playerThread.start();

                fileRunning = true;
            } catch (FileNotFoundException | JavaLayerException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void finalizar() {
        audioPlayer.close();
        fileRunning = false;
    }

    @Override
    public void run() {
        while (fileRunning) {
            try {
                audioPlayer.play();
            } catch (JavaLayerException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
