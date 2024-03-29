WeChat: cstutorcs
QQ: 749389476
Email: tutorcs@163.com
package cs131.pa3.CarsTunnels;

import cs131.pa3.Abstract.Tunnel;
import cs131.pa3.Abstract.Vehicle;

/**
 * 
 * The class for the Basic Tunnel, extending Tunnel.
 * @author cs131a
 *
 */
public class BasicTunnel extends Tunnel{

	/**
	 * Creates a new instance of a basic tunnel with the given name
	 * @param name the name of the basic tunnel
	 */
	public BasicTunnel(String name) {
		super(name);
	}

	@Override
	protected boolean tryToEnterInner(Vehicle vehicle) {
		return false;
	}

	@Override
	protected void exitTunnelInner(Vehicle vehicle) {
		
	}
	
}
