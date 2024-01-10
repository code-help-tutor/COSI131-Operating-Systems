WeChat: cstutorcs
QQ: 749389476
Email: tutorcs@163.com
package cs131.pa3.CarsTunnels;

import cs131.pa3.Abstract.Direction;
import cs131.pa3.Abstract.Factory;
import cs131.pa3.Abstract.Tunnel;
import cs131.pa3.Abstract.Vehicle;

/**
 * The class implementing the Factory interface for creating instances of classes
 * @author cs131a
 *
 */
public class ConcreteFactory implements Factory {

    @Override
    public Tunnel createNewBasicTunnel(String name){
    		throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Vehicle createNewCar(String name, Direction direction){
    		throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Vehicle createNewSled(String name, Direction direction){
    		throw new UnsupportedOperationException("Not supported yet.");
    }
}
