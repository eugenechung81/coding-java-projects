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

import java.io.UnsupportedEncodingException;


/**
 * Class that allows access to the underlying buf without doing deep
 * copies on it.
 *
 */
public class TByteArrayOutputStream {
  
  private byte[] buf;
  private int count;
  
  public TByteArrayOutputStream(int size) {
    buf = new byte[size];
  }

  public TByteArrayOutputStream() {
    super();
  }

  public byte[] get() {
    return buf;
  }

  public int len() {
    return count;
  }
  
  public synchronized void write(int b) {
    int newcount = count + 1;
    if (newcount > buf.length) {
      buf = arraysDotCopyOf(buf, Math.max(buf.length << 1, newcount));
    }
    buf[count] = (byte)b;
    count = newcount;
      }
  
  public void write(byte[] b, int off, int len) {
    if ((off < 0) || (off > b.length) || (len < 0) || ((off + len) > b.length)
        || ((off + len) < 0)) {
      throw new IndexOutOfBoundsException();
    } else if (len == 0) {
      return;
    }
    int newcount = count + len;
    if (newcount > buf.length) {
      buf = arraysDotCopyOf(buf, Math.max(buf.length << 1, newcount));
    }
    System.arraycopy(b, off, buf, count, len);
    count = newcount;
  }

  public int size() {
    return count;
  }

  public synchronized String toString(String charsetName)
      throws UnsupportedEncodingException {
    return new String(buf, 0, count, charsetName);
  }

  private byte[] arraysDotCopyOf(byte[] arr, int len) {
    byte[] copy = new byte[len];
    System.arraycopy(buf, 0, copy, 0, Math.min(arr.length, len));
    return copy;
  }
  
}
