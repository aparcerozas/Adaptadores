package adaptadores;

public class Adaptadores {

    public static void main(String[] args) {
        MediaPlayer player = new MP3();
        player.play("file.mp3");
        player = new FormatAdapter(new MP4());
        player.play("file.mp4");
        player = new FormatAdapter(new VLC());
        player.play("file.avi");
        player = new FormatAdapter(new DivX());
        player.play("file.divx");
    }

    private static class FormatAdapter implements MediaPlayer {

        private MediaPackage media1;
        private MediaDivX media2;

        public FormatAdapter(MediaPackage m) {
            media1 = m;
        }
        
        public FormatAdapter(MediaDivX m){
            media2 = m;
        }

        @Override
        public void play(String filename) {
            System.out.print("Using Adapter --> ");
            if(media1!=null){
                media1.playFile(filename);
            }
            else if(media2!=null){
                media2.playFilm(filename);
            }
        }
    }
}
