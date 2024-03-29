WeChat: cstutorcs
QQ: 749389476
Email: tutorcs@163.com
package cs131.pa3.Abstract;

import java.util.Objects;

import cs131.pa3.Abstract.Log.EventType;
import cs131.pa3.Abstract.Log.Log;


/**
 * A Tunnel is an object which can be entered by vehicles. Vehicles
 * themselves are responsible for indicating when they want to enter
 * and when they are ready to leave. Tunnels are responsible for
 * indicating if it is safe for a Vehicle to enter.
 *
 * When a Vehicle wants to enter a Tunnel, it calls tryToEnter on the
 * Tunnel instance. If the Vehicle managed to enter the Tunnel
 * successfully, tryToEnter returns true; otherwise it
 * returns false. Then, the Vehicle simulates the time spent in the tunnel,
 * and finally must call exitTunnel on the same Tunnel instance it
 * entered.
 * 
 * @author cs131a
 */
public abstract class Tunnel {
	
	/**
	 * The name of the tunnel
	 */
	private final String name;
	/**
	 * The default log
	 */
	public static Log DEFAULT_LOG = new Log();
	/**
	 * The log used for this tunnel (used by the tests to analyze the logged actions)
	 */
    private final Log log;
    
    /**
     * Constructs an instance of a Tunnel with the given name and log
     * @param name the name of the tunnel to create
     * @param log the log to be used for logging
     */
    public Tunnel(String name, Log log) {
        this.name = name;
        this.log = log;
    }

    /**
     *  Constructs an instance of a Tunnel with the given name and the default log stored in this class
     * @param name the name of the tunnel to create
     */
    public Tunnel(String name) {
        this(name, Tunnel.DEFAULT_LOG);
    }
    
    /**
     * Checks whether the given vehicle should enter this tunnel, based on the vehicles currently in the tunnel.
     * It calls the tryToEnterInner which is implemented by the subclass, and also adds entries for enter attempt and enter result in the log.
     * @param vehicle the vehicle attempting to enter this tunnel
     * @return true if the vehicle enters this tunnel successfully, false otherwise
     */
    public final boolean tryToEnter(Vehicle vehicle) {
        //Do not overwrite this function, you should be implementing tryToEnterInner in the subclass
        int sig = log.nextLogEventNumber();
        log.addToLog(vehicle, this, EventType.ENTER_ATTEMPT, sig);
        if (this.tryToEnterInner(vehicle)) {
            log.addToLog(vehicle, this, EventType.ENTER_SUCCESS, sig);
            return true;
        } else {
            log.addToLog(vehicle, this, EventType.ENTER_FAILED, sig);
            return false;
        }
    }
    
    /**
     * Vehicle tries to enter a tunnel. Implemented by the subclass
     *
     * @param  vehicle The vehicle that is attempting to enter
     * @return true if the vehicle was able to enter, false otherwise
     */
    protected abstract boolean tryToEnterInner(Vehicle vehicle);
    
    /**
     * Vehicle exits this tunnel. This method calls exitTunnelInner and adds appropriate 
     * entries in the log.
     * @param vehicle the vehicle exiting the tunnel
     */
    public final void exitTunnel(Vehicle vehicle) {
        //Do not overwrite this function, you should be implementing exitTunnelInner in the subclass
        int sig = log.nextLogEventNumber();
        this.log.addToLog(vehicle, this, EventType.LEAVE_START, sig);
        this.exitTunnelInner(vehicle);
        this.log.addToLog(vehicle, this, EventType.LEAVE_END, sig);
    }
    
    /**
     * Vehicle exits the tunnel. Implemented by the subclass
     * 
     * @param vehicle The vehicle that is exiting the tunnel
     */
    protected abstract void exitTunnelInner(Vehicle vehicle);


    /**
     * Returns the name of this tunnel
     * @return The name of this tunnel
     */
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tunnel other = (Tunnel) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}
