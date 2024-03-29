/********************************************************************************
 * 
 *  Copyright 2012 Synapse SCADA team
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  
 *******************************************************************************/
package com.synapse.scada.proxy.dummy;

import org.apache.log4j.Logger;

import com.synapse.scada.config.SubArea;
import com.synapse.scada.core.SynapseException;
import com.synapse.scada.core.proxy.Proxy;

/**
 * The Class DummyProxy.
 *
 * @author Tomek Kozlowski (rysiekblah)
 * @version 1.00 (Nov 22, 2012)
 */
public class DummyProxy implements Proxy {

	/** The log. */
	static Logger LOG = Logger.getLogger(DummyProxy.class);
	/** The demo printout. */
	private final String DEMO_PRINTOUT = "Proxy DEMO: ";
	/** The state. */
	private int state;
	/** The value. */
	private int value;

	/**
	 * Instantiates a new dummy proxy.
	 */
	public DummyProxy() {
		state = 0;
		value = 1;
	}

	/**
	 * This method shall implements connection establishment to dedicated
	 * device.
	 *
	 * @throws SynapseException the synapse exception
	 */
	@Override
	public void connect() throws SynapseException {
		LOG.debug(DEMO_PRINTOUT + " connect");
	}

	/**
	 * This method shall implements connection dropping with dedicated device.
	 *
	 * @throws SynapseException the synapse exception
	 */
	@Override
	public void disconnect() throws SynapseException {
		LOG.debug(DEMO_PRINTOUT + " disconnect");

	}

	/**
	 * This method sends request to managed device to check state of unit with
	 * given id.
	 *
	 * @param arg0 the arg0
	 * @return the state
	 * @throws SynapseException the synapse exception
	 */
	@Override
	public int getState(int arg0) throws SynapseException {
		// Dummy work :)
		state = state == 0 ? 1 : 0;
		LOG.debug(DEMO_PRINTOUT + " getState : " + state);
		return state;
	}

	/**
	 * This method sends request to managed device to check state of unit with
	 * given id. Because synapse-core supports two types of devices i.e. with
	 * binary state (like switches) and with value (like temperature meter),
	 * proxy provides this method if the requesting mechanism looks different as
	 * it is in getState method.
	 *
	 * @param arg0 the arg0
	 * @return the value
	 * @throws SynapseException the synapse exception
	 */
	@Override
	public int getValue(int arg0) throws SynapseException {
		// Dummy work :)
		LOG.debug(DEMO_PRINTOUT + " getValue : " + value++);
		return 0;
	}

	/**
	 * Initialization of the proxy i.e. create sockets, establish rs-232 port
	 * and so on.
	 *
	 * @param arg0 the arg0
	 * @throws SynapseException the synapse exception
	 */
	@Override
	public void initialize(SubArea arg0) throws SynapseException {
		LOG.debug(DEMO_PRINTOUT + " initialize");

	}

	/**
	 * Returns connection status.
	 *
	 * @return true, if is connected
	 */
	@Override
	public boolean isConnected() {
		LOG.debug(DEMO_PRINTOUT + " isConnected");
		return true;
	}

	/**
	 * This method sends request to managed device to set state with given value
	 * of unit with given id.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 * @throws SynapseException the synapse exception
	 */
	@Override
	public void setState(int arg0, int arg1) throws SynapseException {

	}

	/**
	 * This method sends request to managed device to set state with given value
	 * of unit with given id. Because synapse-core supports two types of devices
	 * i.e. with binary state (like switches) and with value (like temperature
	 * meter), proxy provides this method if the requesting mechanism looks
	 * different as it is in setState method.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 * @throws SynapseException the synapse exception
	 */
	@Override
	public void setValue(int arg0, int arg1) throws SynapseException {

	}

}
