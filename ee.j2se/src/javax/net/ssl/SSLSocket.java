/*
 * Copyright (c) OSGi Alliance (2001, 2013). All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package javax.net.ssl;
public abstract class SSLSocket extends java.net.Socket {
	protected SSLSocket() { } 
	protected SSLSocket(java.lang.String var0, int var1) throws java.io.IOException { } 
	protected SSLSocket(java.lang.String var0, int var1, java.net.InetAddress var2, int var3) throws java.io.IOException { } 
	protected SSLSocket(java.net.InetAddress var0, int var1) throws java.io.IOException { } 
	protected SSLSocket(java.net.InetAddress var0, int var1, java.net.InetAddress var2, int var3) throws java.io.IOException { } 
	public abstract void addHandshakeCompletedListener(javax.net.ssl.HandshakeCompletedListener var0);
	public abstract boolean getEnableSessionCreation();
	public abstract java.lang.String[] getEnabledCipherSuites();
	public abstract java.lang.String[] getEnabledProtocols();
	public javax.net.ssl.SSLSession getHandshakeSession() { return null; }
	public abstract boolean getNeedClientAuth();
	public javax.net.ssl.SSLParameters getSSLParameters() { return null; }
	public abstract javax.net.ssl.SSLSession getSession();
	public abstract java.lang.String[] getSupportedCipherSuites();
	public abstract java.lang.String[] getSupportedProtocols();
	public abstract boolean getUseClientMode();
	public abstract boolean getWantClientAuth();
	public abstract void removeHandshakeCompletedListener(javax.net.ssl.HandshakeCompletedListener var0);
	public abstract void setEnableSessionCreation(boolean var0);
	public abstract void setEnabledCipherSuites(java.lang.String[] var0);
	public abstract void setEnabledProtocols(java.lang.String[] var0);
	public abstract void setNeedClientAuth(boolean var0);
	public void setSSLParameters(javax.net.ssl.SSLParameters var0) { }
	public abstract void setUseClientMode(boolean var0);
	public abstract void setWantClientAuth(boolean var0);
	public abstract void startHandshake() throws java.io.IOException;
}
