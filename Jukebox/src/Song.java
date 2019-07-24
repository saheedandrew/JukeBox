import java.util.Comparator;

public class Song implements Comparable <Song>
{
    String title;
    String artist;
    String rating;
    String bpm;


    public Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }
    public boolean equals(Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle()) && getArtist().equals(s.getArtist());
    }

    public int hashCode() {
        return title.hashCode() & artist.hashCode();
    }

    public int compareTo(Song s)
    {
        return title.compareTo(s.getTitle());
    }

    public static class ArtComp implements Comparator<Song>{
        public int compare(Song first, Song second) {
            return first.getArtist().compareTo(second.getArtist());
        }
    }






    public String getArtist()
    {
        return artist;
    }

    public String getBpm()
    {
        return bpm;
    }

    public String getRating()
    {
        return rating;
    }

    public String getTitle()
    {
        return title;
    }

    public String toString() {
        return title ;
    }

}