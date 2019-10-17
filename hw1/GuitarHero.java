import edu.princeton.cs.algs4.StdAudio;
import es.datastructur.synthesizer.GuitarString;

public class GuitarHero {
    private static final double CONCERT_A = 440.0;
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static void main(String[] args) {
        GuitarString[] stringArray = new GuitarString[37];
        for (int i = 0; i < 37; ++i) {
            stringArray[i] = new GuitarString(CONCERT_A * Math.pow(2, (i - 24.0) / 12.0));
        }

        while(true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index != -1) {
                    stringArray[index].pluck();
                }
            }

            double sample = 0.0;
            for (int i = 0; i < 37; ++i) {
                sample += stringArray[i].sample();
            }
            StdAudio.play(sample);
            for (int i = 0; i < 37; ++i) {
                stringArray[i].tic();
            }

        }
    }
}
