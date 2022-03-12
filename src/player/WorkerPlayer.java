package player;
import util.Ressources;

public class WorkerPlayer extends Player {

    public WorkerPlayer(String name) {
        super(name);
        super.ressources.put(Ressources.Gold, 15);
    }

}
