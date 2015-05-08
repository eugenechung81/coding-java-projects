package org.apache.thrift.protocol;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TMemoryInputTransport;
import org.apache.thrift.transport.TTransport;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

/**
 * JSON protocol implementation for thrift-gwt.
 *
 * This is a read-only protocol that runs much faster in a browser.
 * It uses the eval() JavaScript function.
 *
 * Please see the C++ class header for a detailed description of the
 * protocol's wire format.
 *
 */
public class TNativeJSONProtocol extends TJSONProtocol {

	@SuppressWarnings("serial")
	public static class Factory implements TProtocolFactory {

		public TProtocol getProtocol(TTransport trans) {
			return new TNativeJSONProtocol(trans);
		}

	}

	private static final TStruct ANONYMOUS_STRUCT = new TStruct();

	private JsArrayMixed flatJSON = (JsArrayMixed) JavaScriptObject.createArray();
	private int flatJSONIndex = 0;
	
	public TNativeJSONProtocol(TTransport trans) {
		super(trans);

		if (trans.getBuffer() != null) {

			if (trans.getBuffer() != null) {
			  // Parse JSON
				JSONValue json = JSONParser.parseLenient(trans.getBuffer());

				// Flatten JSON for faster read
				if (json != null) {
					initFlatJSON(json);
				}
			}
		}
	}

	private void initFlatJSON(JSONValue json) {
	  JSONString str;
	  JSONArray arr;
		JSONObject obj;
		JSONNumber num;

		if ((str = json.isString()) != null) {
      flatJSON.push(str.stringValue());
    }
		else if ((obj = json.isObject()) != null) {
      for (String key : obj.keySet()) {
        flatJSON.push(key);
        initFlatJSON(obj.get(key));
      }
      flatJSON.push(-1); // End of object flag for readFieldBegin()
    }
		else if ((arr = json.isArray()) != null) {
			for (int i = 0; i < arr.size(); ++i) {
				initFlatJSON(arr.get(i));
			}
		} 
		else if ((num = json.isNumber()) != null) {
			flatJSON.push(num.doubleValue());
		} 
		else {
			assert (false) : "Oops, this type should not be used in JSON protocol...";
		}

	}

	@Override
	public TMessage readMessageBegin() throws TException {
		readI32(); // Version number

		// Message description
		String name = readString();
		byte type = readByte();
		int seqid = readI32();

		return new TMessage(name, type, seqid);
	}

	@Override
	public void readMessageEnd() throws TException {
	  /* Do nothing */
	}

	@Override
	public TStruct readStructBegin() throws TException {
		return ANONYMOUS_STRUCT;
	}

	@Override
	public void readStructEnd() throws TException {
		flatJSONIndex++;
	}

	@Override
	public TField readFieldBegin() throws TException {
		double id = flatJSON.getNumber(flatJSONIndex);
		byte type = TType.STOP;

		if (id != -1) {
			flatJSONIndex++;
			type = getTypeIDForTypeName(readString());
		}

		return new TField(null, type, (short) id);
	}

	@Override
	public void readFieldEnd() throws TException {
		flatJSONIndex++;
	}

	@Override
	public TMap readMapBegin() throws TException {
		byte keyType = getTypeIDForTypeName(readString());
		byte valueType = getTypeIDForTypeName(readString());
		int size = readI32();

		return new TMap(keyType, valueType, size);
	}

	@Override
	public void readMapEnd() throws TException {
		flatJSONIndex++;
	}

	@Override
	public TList readListBegin() throws TException {
		byte elemType = getTypeIDForTypeName(readString());
		int size = readI32();

		return new TList(elemType, size);
	}

	@Override
	public void readListEnd() throws TException {
	  /* Do nothing */
	}

	@Override
	public TSet readSetBegin() throws TException {
		byte elemType = getTypeIDForTypeName(readString());
		int size = readI32();

		return new TSet(elemType, size);
	}

	@Override
	public void readSetEnd() throws TException {
	  /* Do nothing */
	}

	@Override
	public boolean readBool() throws TException {
		return flatJSON.getBoolean(flatJSONIndex++);
	}

	@Override
	public byte readByte() throws TException {
		return (byte) readDouble();
	}

	@Override
	public short readI16() throws TException {
		return (short) readDouble();
	}

	@Override
	public int readI32() throws TException {
		return (int) readDouble();
	}

	@Override
	public long readI64() throws TException {
		return (long) readDouble();
	}

	@Override
	public double readDouble() throws TException {
		return flatJSON.getNumber(flatJSONIndex++);
	}

	@Override
	public String readString() throws TException {
		return flatJSON.getString(flatJSONIndex++);
	}

  private static final byte getTypeIDForTypeName(String name) throws TException {
    byte result = TType.STOP;

    if (name.length() > 1) {
      switch (name.charAt(0)) {
      case 'd':
        result = TType.DOUBLE;
        break;
      case 'i':
        switch (name.charAt(1)) {
        case '8':
          result = TType.BYTE;
          break;
        case '1':
          result = TType.I16;
          break;
        case '3':
          result = TType.I32;
          break;
        case '6':
          result = TType.I64;
          break;
        }
        break;
      case 'l':
        result = TType.LIST;
        break;
      case 'm':
        result = TType.MAP;
        break;
      case 'r':
        result = TType.STRUCT;
        break;
      case 's':
        if (name.charAt(1) == 't') {
          result = TType.STRING;
        } else if (name.charAt(1) == 'e') {
          result = TType.SET;
        }
        break;
      case 't':
        result = TType.BOOL;
        break;
      }
    }

    if (result == TType.STOP) {
      throw new TProtocolException(TProtocolException.NOT_IMPLEMENTED,
          "Unrecognized type");
    }

    return result;
  }
	
  private interface JSONValueWriter {
    void write(JSONValue val);
  }
  
}
