/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.thrift;

import org.apache.thrift.protocol.TNativeJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TMemoryBuffer;

/**
 * Generic utility for easily serializing objects into a byte array or Java
 * String.
 *
 */
public class TSerializer {

  /**
   * Serialize the Thrift object into a byte array. The process is simple,
   * just clear the byte array output, write the object into it, and grab the
   * raw bytes.
   *
   * @param base The object to serialize
   * @return Serialized object in byte[] format
   */
  public static String serialize(TBase base) throws TException {
    TMemoryBuffer transport = new TMemoryBuffer();
    TProtocol protocol = new TNativeJSONProtocol.Factory().getProtocol(transport);
    
    base.write(protocol);
    return new String(transport.getTrimmedArray());
  }
  
}

