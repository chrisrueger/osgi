package org.osgi.service.zigbee;

import org.osgi.util.function.Predicate;

/**
 * This type represents a stream of responses to a broadcast operation. It can
 * be closed by the client using the {@link #close} method is called.
 * 
 * The {@link ZCLCommandResponseStream} is used to process a stream of responses
 * from a ZigBee network. Responses are consumed by registering a handler with
 * {@link #forEach(Predicate)}. Responses received before a handler is
 * registered are buffered until a handler is registered, or until the close
 * method is called.
 * 
 * A handler consumes events returning <code>true</code> to continue delivery.
 * At some point the ZigBee service invocation will terminate event delivery by
 * sending a close event (a {@link ZCLCommandResponse} which returns
 * <code>true</code> from {@link ZCLCommandResponse#isEnd()}. After a close
 * event the handler function will be dereferenced.
 */
public interface ZCLCommandResponseStream {

	/**
	 * Close this response, indicating that no further responses are needed.
	 * 
	 * Any buffered responses will be discarded, and a close event will be sent
	 * to a handler if it is registered.
	 * 
	 */
	void close();
	
	/**
	 * Register a handler that will be called for each of the received
	 * responses. Only one handler may be registered. Any responses that arrive
	 * before a handler is registered will be buffered and pushed into the
	 * handler when it is registered.
	 * 
	 * If the handler returns <code>false</code> from its accept method then the
	 * handler will be released and no further events will be delivered. Any
	 * remaining buffered events will be discarded, and this object marked as
	 * closed.
	 * 
	 * If the handler does not close the stream early then the ZigBee service
	 * implementation will eventually send a close event
	 * 
	 * @param handler A handler to process ZCLCommandResponse objects
	 * @throws IllegalStateException if a handler has already been registered,
	 *         or if this object has been closed (a {@link ZCLCommandResponse}
	 *         which returns <code>true</code> from
	 *         {@link ZCLCommandResponse#isEnd()}. After a close event the
	 *         handler function will be dereferenced.
	 *
	 */
	void forEach(Predicate/* <ZCLCommandResponse> */ handler) throws IllegalStateException;
}