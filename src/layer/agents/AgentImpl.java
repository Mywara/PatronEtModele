package layer.agents;

import java.util.Date;
/**
 * 
 * @author Hamid Mcheick
 *
 */
public class AgentImpl implements Agent {
	
	public Object data;
	public String name;
	
	public AgentImpl(String name) {
		this.name = name;
	}

	public void forwardData() {
		data = new String("forwarding @ " + new Date());
	}
	
	public Object getData() {
		return data;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public void collectData(Object data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDataAbnormal() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
