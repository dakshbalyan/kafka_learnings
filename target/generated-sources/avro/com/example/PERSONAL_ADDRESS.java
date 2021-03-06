/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class PERSONAL_ADDRESS extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6853133705648114435L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PERSONAL_ADDRESS\",\"namespace\":\"com.example\",\"fields\":[{\"name\":\"STREET\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"CITY\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"STATE\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<PERSONAL_ADDRESS> ENCODER =
      new BinaryMessageEncoder<PERSONAL_ADDRESS>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PERSONAL_ADDRESS> DECODER =
      new BinaryMessageDecoder<PERSONAL_ADDRESS>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<PERSONAL_ADDRESS> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<PERSONAL_ADDRESS> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<PERSONAL_ADDRESS>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this PERSONAL_ADDRESS to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a PERSONAL_ADDRESS from a ByteBuffer. */
  public static PERSONAL_ADDRESS fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String STREET;
   private java.lang.String CITY;
   private java.lang.String STATE;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PERSONAL_ADDRESS() {}

  /**
   * All-args constructor.
   * @param STREET The new value for STREET
   * @param CITY The new value for CITY
   * @param STATE The new value for STATE
   */
  public PERSONAL_ADDRESS(java.lang.String STREET, java.lang.String CITY, java.lang.String STATE) {
    this.STREET = STREET;
    this.CITY = CITY;
    this.STATE = STATE;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return STREET;
    case 1: return CITY;
    case 2: return STATE;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: STREET = (java.lang.String)value$; break;
    case 1: CITY = (java.lang.String)value$; break;
    case 2: STATE = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'STREET' field.
   * @return The value of the 'STREET' field.
   */
  public java.lang.String getSTREET() {
    return STREET;
  }


  /**
   * Gets the value of the 'CITY' field.
   * @return The value of the 'CITY' field.
   */
  public java.lang.String getCITY() {
    return CITY;
  }


  /**
   * Gets the value of the 'STATE' field.
   * @return The value of the 'STATE' field.
   */
  public java.lang.String getSTATE() {
    return STATE;
  }


  /**
   * Creates a new PERSONAL_ADDRESS RecordBuilder.
   * @return A new PERSONAL_ADDRESS RecordBuilder
   */
  public static com.example.PERSONAL_ADDRESS.Builder newBuilder() {
    return new com.example.PERSONAL_ADDRESS.Builder();
  }

  /**
   * Creates a new PERSONAL_ADDRESS RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PERSONAL_ADDRESS RecordBuilder
   */
  public static com.example.PERSONAL_ADDRESS.Builder newBuilder(com.example.PERSONAL_ADDRESS.Builder other) {
    return new com.example.PERSONAL_ADDRESS.Builder(other);
  }

  /**
   * Creates a new PERSONAL_ADDRESS RecordBuilder by copying an existing PERSONAL_ADDRESS instance.
   * @param other The existing instance to copy.
   * @return A new PERSONAL_ADDRESS RecordBuilder
   */
  public static com.example.PERSONAL_ADDRESS.Builder newBuilder(com.example.PERSONAL_ADDRESS other) {
    return new com.example.PERSONAL_ADDRESS.Builder(other);
  }

  /**
   * RecordBuilder for PERSONAL_ADDRESS instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PERSONAL_ADDRESS>
    implements org.apache.avro.data.RecordBuilder<PERSONAL_ADDRESS> {

    private java.lang.String STREET;
    private java.lang.String CITY;
    private java.lang.String STATE;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.PERSONAL_ADDRESS.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.STREET)) {
        this.STREET = data().deepCopy(fields()[0].schema(), other.STREET);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.CITY)) {
        this.CITY = data().deepCopy(fields()[1].schema(), other.CITY);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.STATE)) {
        this.STATE = data().deepCopy(fields()[2].schema(), other.STATE);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing PERSONAL_ADDRESS instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.PERSONAL_ADDRESS other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.STREET)) {
        this.STREET = data().deepCopy(fields()[0].schema(), other.STREET);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.CITY)) {
        this.CITY = data().deepCopy(fields()[1].schema(), other.CITY);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.STATE)) {
        this.STATE = data().deepCopy(fields()[2].schema(), other.STATE);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'STREET' field.
      * @return The value.
      */
    public java.lang.String getSTREET() {
      return STREET;
    }

    /**
      * Sets the value of the 'STREET' field.
      * @param value The value of 'STREET'.
      * @return This builder.
      */
    public com.example.PERSONAL_ADDRESS.Builder setSTREET(java.lang.String value) {
      validate(fields()[0], value);
      this.STREET = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'STREET' field has been set.
      * @return True if the 'STREET' field has been set, false otherwise.
      */
    public boolean hasSTREET() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'STREET' field.
      * @return This builder.
      */
    public com.example.PERSONAL_ADDRESS.Builder clearSTREET() {
      STREET = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'CITY' field.
      * @return The value.
      */
    public java.lang.String getCITY() {
      return CITY;
    }

    /**
      * Sets the value of the 'CITY' field.
      * @param value The value of 'CITY'.
      * @return This builder.
      */
    public com.example.PERSONAL_ADDRESS.Builder setCITY(java.lang.String value) {
      validate(fields()[1], value);
      this.CITY = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'CITY' field has been set.
      * @return True if the 'CITY' field has been set, false otherwise.
      */
    public boolean hasCITY() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'CITY' field.
      * @return This builder.
      */
    public com.example.PERSONAL_ADDRESS.Builder clearCITY() {
      CITY = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'STATE' field.
      * @return The value.
      */
    public java.lang.String getSTATE() {
      return STATE;
    }

    /**
      * Sets the value of the 'STATE' field.
      * @param value The value of 'STATE'.
      * @return This builder.
      */
    public com.example.PERSONAL_ADDRESS.Builder setSTATE(java.lang.String value) {
      validate(fields()[2], value);
      this.STATE = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'STATE' field has been set.
      * @return True if the 'STATE' field has been set, false otherwise.
      */
    public boolean hasSTATE() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'STATE' field.
      * @return This builder.
      */
    public com.example.PERSONAL_ADDRESS.Builder clearSTATE() {
      STATE = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PERSONAL_ADDRESS build() {
      try {
        PERSONAL_ADDRESS record = new PERSONAL_ADDRESS();
        record.STREET = fieldSetFlags()[0] ? this.STREET : (java.lang.String) defaultValue(fields()[0]);
        record.CITY = fieldSetFlags()[1] ? this.CITY : (java.lang.String) defaultValue(fields()[1]);
        record.STATE = fieldSetFlags()[2] ? this.STATE : (java.lang.String) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PERSONAL_ADDRESS>
    WRITER$ = (org.apache.avro.io.DatumWriter<PERSONAL_ADDRESS>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PERSONAL_ADDRESS>
    READER$ = (org.apache.avro.io.DatumReader<PERSONAL_ADDRESS>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
