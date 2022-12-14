package Controller;

import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {
    private final Timer timer;
    private final TimerTask timerTask;
    private final int timerDuration;

    public Scheduler(TimerTask timerTask, int timerDuration) {
        this.timer = new Timer();
        this.timerTask = timerTask;
        this.timerDuration = timerDuration;
    }

    /** Starts the timer */
    public void enableTimer() {
        this.timer.schedule(this.timerTask, 0L, this.timerDuration);
    }

    /** Disables the timer */
    public void disableTimer() {
        this.timer.cancel();
    }
}
