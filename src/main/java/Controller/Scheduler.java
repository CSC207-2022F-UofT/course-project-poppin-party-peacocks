package Controller;

import java.util.Timer;
import java.util.TimerTask;

/** A class that runs timer tasks on a scheduled basis */
public class Scheduler {

    /** The timer to schedule tasks */
    private Timer timer;
    /** The timer task to execute */
    private TimerTask timerTask;
    /** The time per execution */
    private int timerDuration;

    public Scheduler(TimerTask timerTask, int timerDuration) {
        this.timer = new Timer();
        this.timerTask = timerTask;
        this.timerDuration = timerDuration;
    }

    /** Starts the timer to execute timer tasks */
    public void enableTimer() {
        this.timer.schedule(this.timerTask, 0L, this.timerDuration);
    }

    /** Disables the timer */
    public void disableTimer() {
        this.timer.cancel();
    }
}