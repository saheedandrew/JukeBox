import java.util.*;
import java.io.*;



public class Jukebox3
{
    ArrayList<Song> songList = new ArrayList<Song>();

    HashMap<Song, Integer> songCount = new HashMap<Song, Integer>();

    public void countSongs(){
        int count=1;
        for(Song s : songList) {
            if (songCount.containsKey(s)){
                songCount.replace(s,songCount.get(s)+1);
            }
            else{
                songCount.put(s,count);
            }
        }


        for (Song s: songCount.keySet()) {

            System.out.print("Song is: "+s.getTitle() +", Name of Artist is: "+ s.getArtist() + ", Number of plays is:");
            System.out.println(songCount.get(s));
        }



    }


    public static void main(String[] args) {
       Jukebox3 juke = new Jukebox3();
       juke.go();
       juke.countSongs();





    }


    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println("This is  sorted by Song Title " +songList);
        Song.ArtComp artComp = new Song.ArtComp();
        Collections.sort(songList,artComp);
        System.out.println("this is sorted by Song Artist "+ songList);


    }




    void getSongs() {
        try {
            File file = new File("/Users/saheedandrew/Desktop/3115 folder/Jukebox/src/SongList");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    void addSong(String lineToParse) {
        String[]tokens = lineToParse.split("/");
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
}