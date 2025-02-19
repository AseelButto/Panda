package Model;

/**
 * 
 * @author firas
 * This class describes a timer that is used in a game.
 * It can be used for total game time, turn time
 */
public class Timer {

	private long startTime;
	private long anonStartTime;
	private long pauseTime;
	
	/**
	 * Class Constructor
	 */
	public Timer() {
		setPauseTime(-1);
		setStartTime(-1);
		setAnonStartTime(-1);
	}

	/**
	 * Start timer
	 */
	public void startTimer() {
		setStartTime(System.currentTimeMillis());
		setAnonStartTime(System.currentTimeMillis());
		setPauseTime(-1);
	}
	
	/**
	 * set time count in seconds and start timer
	 * @param seconds
	 */
	public void startTimer(float seconds) {
		setStartTime((long) (System.currentTimeMillis() - seconds*(1000)));
		setAnonStartTime((long) (System.currentTimeMillis() - seconds*(1000)));
		setPauseTime(-1);
	}
	/**
	 * set time count in seconds and start timer
	 * @param seconds
	 */
	public void startTimer(int seconds) {
		setStartTime((long) (System.currentTimeMillis() - seconds*(1000)));
		setAnonStartTime((long) (System.currentTimeMillis() - seconds*(1000)));
		setPauseTime(-1);
	}
	/**
	 * reset timer
	 */
	public void resetTimer() {
		setPauseTime(-1);
		startTimer();
	}
	/**
	 * resets the timer and stops it
	 */
	public void stopTimer() {
		setStartTime(-1);
		setPauseTime(-1);
	}
	/**
	 * pause timer
	 */
	public void pauseTimer() {
		setPauseTime(System.currentTimeMillis());
	}
	
	/**
	 * unpause timer
	 */
	public void unpauseTimer() {
		if(getPauseTime() == -1) return;
		long temp = anonStartTime + (System.currentTimeMillis() - getPauseTime());
		setAnonStartTime(temp);
		setPauseTime(-1);
	}
	/**
	 * get time count in seconds (float)
	 * @return seconds count
	 */
	public float getSeconds() {
		if(startTime == -1) return -1;
		if(getPauseTime() != -1) {
			long temp = anonStartTime + (System.currentTimeMillis() - getPauseTime());
			return ( System.currentTimeMillis() -  temp) / 1000F;
		}else {
			return ( System.currentTimeMillis() -  getAnonStartTime() ) / 1000F;
		}
	}
	
	//getters/setters for internal use 
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getPauseTime() {
		return pauseTime;
	}
	private void setPauseTime(long pauseTime) {
		this.pauseTime = pauseTime;
	}
	private long getAnonStartTime() {
		return anonStartTime;
	}
	private void setAnonStartTime(long anonStartTime) {
		this.anonStartTime = anonStartTime;
	}
}
