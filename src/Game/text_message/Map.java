package Game.text_message;

import static Game.text_message.Color.magenta;
import static Game.text_message.Color.reset;

/**Diese Klasse wird verwendet, um die Karte auf der Console auszugeben.
 *Dazu wird folgende Methode genutzt: {@link #printMap()}
 */
public class Map
{
    /**Die Methode gibt die Karte auf der Console aus.
     * Die Karte hat keinerlei Logik, sie ist rein optisch und zum verständnis des Spielers.
     */
    private static void printMap()
    {
        System.out.print(magenta);
        System.out.println("""
                                  ┌──────┐
                                  │CAM 1A├─────────────┐
                                  └─┬────┘             │
                                    │                  │
                   ┌─────┐ ┌────┬───┴──┬───────────────┴─────────┐
                   │     ├─┤    │CAM 1B│                         │ ┌───┐
                   │     ├─┤    └──────┘                         ├─┤ ┌─┴────┐
                ┌──┴───┐ │ │                                     ├─┤ │CAM 7 ├┐
                │CAM 5 │ │ │                                     │ │ └─┬─┬──┘│
                └──┬───┘ │ │                                     │ │   ├─┤   │
                   └─────┘┌┴─────┐                               │ │   │ └───┘
                     ┌────┤CAM 1C│                               │ │   │ ┌───┐
                     │    └┬─────┘                               │ │   ├─┤   │
                     └─────┴───────┬┬─────────────┬┬────┬┬───────┘ └───┘ └───┘
                                 ┌─┴┴─┐         ┌─┴┴─┐ ┌┴┴───────────┐
                        ┌─────┐  │    │         │    │ │        ┌────┴─┐
                     ┌──┴───┐ ├─┬┴────┴┐       ┌┴────┴┐│        │CAM 6 │
                     │CAM 3 │ ├─┤CAM 2A│       │CAM 4A││        └────┬─┘
                     └──┬───┘ │ ├──────┤       ├──────┤└─────────────┘
                        │     │ ├──────┤┌─────┐├──────┤
                        └─────┘ │CAM 2B├┤ YOU ├┤CAM 4B│
                                └┬────┬┴┤  ▓  ├┴┬────┬┘
                                 └────┘ └─────┘ └────┘
                """);
        System.out.print(reset);
//        Folgende Zeichen wurden für die Map genutzt:
// ┼,┬,┴,├,┤,═,║,┌,┐,└,┘,─,│,
    }
}
