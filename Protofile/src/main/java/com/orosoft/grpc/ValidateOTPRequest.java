// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cache.proto

package com.orosoft.grpc;

/**
 * Protobuf type {@code ValidateOTPRequest}
 */
public  final class ValidateOTPRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ValidateOTPRequest)
    ValidateOTPRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ValidateOTPRequest.newBuilder() to construct.
  private ValidateOTPRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ValidateOTPRequest() {
    userId_ = "";
    otp_ = "";
    maxTry_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ValidateOTPRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            userId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            otp_ = s;
            break;
          }
          case 24: {

            maxTry_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.orosoft.grpc.Cache.internal_static_ValidateOTPRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.orosoft.grpc.Cache.internal_static_ValidateOTPRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.orosoft.grpc.ValidateOTPRequest.class, com.orosoft.grpc.ValidateOTPRequest.Builder.class);
  }

  public static final int USERID_FIELD_NUMBER = 1;
  private volatile java.lang.Object userId_;
  /**
   * <code>string userId = 1;</code>
   */
  public java.lang.String getUserId() {
    java.lang.Object ref = userId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      userId_ = s;
      return s;
    }
  }
  /**
   * <code>string userId = 1;</code>
   */
  public com.google.protobuf.ByteString
      getUserIdBytes() {
    java.lang.Object ref = userId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      userId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OTP_FIELD_NUMBER = 2;
  private volatile java.lang.Object otp_;
  /**
   * <code>string otp = 2;</code>
   */
  public java.lang.String getOtp() {
    java.lang.Object ref = otp_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      otp_ = s;
      return s;
    }
  }
  /**
   * <code>string otp = 2;</code>
   */
  public com.google.protobuf.ByteString
      getOtpBytes() {
    java.lang.Object ref = otp_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      otp_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MAXTRY_FIELD_NUMBER = 3;
  private int maxTry_;
  /**
   * <code>int32 maxTry = 3;</code>
   */
  public int getMaxTry() {
    return maxTry_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getUserIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, userId_);
    }
    if (!getOtpBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, otp_);
    }
    if (maxTry_ != 0) {
      output.writeInt32(3, maxTry_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getUserIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, userId_);
    }
    if (!getOtpBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, otp_);
    }
    if (maxTry_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, maxTry_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.orosoft.grpc.ValidateOTPRequest)) {
      return super.equals(obj);
    }
    com.orosoft.grpc.ValidateOTPRequest other = (com.orosoft.grpc.ValidateOTPRequest) obj;

    boolean result = true;
    result = result && getUserId()
        .equals(other.getUserId());
    result = result && getOtp()
        .equals(other.getOtp());
    result = result && (getMaxTry()
        == other.getMaxTry());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + USERID_FIELD_NUMBER;
    hash = (53 * hash) + getUserId().hashCode();
    hash = (37 * hash) + OTP_FIELD_NUMBER;
    hash = (53 * hash) + getOtp().hashCode();
    hash = (37 * hash) + MAXTRY_FIELD_NUMBER;
    hash = (53 * hash) + getMaxTry();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.orosoft.grpc.ValidateOTPRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.orosoft.grpc.ValidateOTPRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.orosoft.grpc.ValidateOTPRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.orosoft.grpc.ValidateOTPRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.orosoft.grpc.ValidateOTPRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.orosoft.grpc.ValidateOTPRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.orosoft.grpc.ValidateOTPRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.orosoft.grpc.ValidateOTPRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.orosoft.grpc.ValidateOTPRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.orosoft.grpc.ValidateOTPRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.orosoft.grpc.ValidateOTPRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.orosoft.grpc.ValidateOTPRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.orosoft.grpc.ValidateOTPRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ValidateOTPRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ValidateOTPRequest)
      com.orosoft.grpc.ValidateOTPRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.orosoft.grpc.Cache.internal_static_ValidateOTPRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.orosoft.grpc.Cache.internal_static_ValidateOTPRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.orosoft.grpc.ValidateOTPRequest.class, com.orosoft.grpc.ValidateOTPRequest.Builder.class);
    }

    // Construct using com.orosoft.grpc.ValidateOTPRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      userId_ = "";

      otp_ = "";

      maxTry_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.orosoft.grpc.Cache.internal_static_ValidateOTPRequest_descriptor;
    }

    @java.lang.Override
    public com.orosoft.grpc.ValidateOTPRequest getDefaultInstanceForType() {
      return com.orosoft.grpc.ValidateOTPRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.orosoft.grpc.ValidateOTPRequest build() {
      com.orosoft.grpc.ValidateOTPRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.orosoft.grpc.ValidateOTPRequest buildPartial() {
      com.orosoft.grpc.ValidateOTPRequest result = new com.orosoft.grpc.ValidateOTPRequest(this);
      result.userId_ = userId_;
      result.otp_ = otp_;
      result.maxTry_ = maxTry_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.orosoft.grpc.ValidateOTPRequest) {
        return mergeFrom((com.orosoft.grpc.ValidateOTPRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.orosoft.grpc.ValidateOTPRequest other) {
      if (other == com.orosoft.grpc.ValidateOTPRequest.getDefaultInstance()) return this;
      if (!other.getUserId().isEmpty()) {
        userId_ = other.userId_;
        onChanged();
      }
      if (!other.getOtp().isEmpty()) {
        otp_ = other.otp_;
        onChanged();
      }
      if (other.getMaxTry() != 0) {
        setMaxTry(other.getMaxTry());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.orosoft.grpc.ValidateOTPRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.orosoft.grpc.ValidateOTPRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object userId_ = "";
    /**
     * <code>string userId = 1;</code>
     */
    public java.lang.String getUserId() {
      java.lang.Object ref = userId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        userId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string userId = 1;</code>
     */
    public com.google.protobuf.ByteString
        getUserIdBytes() {
      java.lang.Object ref = userId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        userId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string userId = 1;</code>
     */
    public Builder setUserId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      userId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string userId = 1;</code>
     */
    public Builder clearUserId() {
      
      userId_ = getDefaultInstance().getUserId();
      onChanged();
      return this;
    }
    /**
     * <code>string userId = 1;</code>
     */
    public Builder setUserIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      userId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object otp_ = "";
    /**
     * <code>string otp = 2;</code>
     */
    public java.lang.String getOtp() {
      java.lang.Object ref = otp_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        otp_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string otp = 2;</code>
     */
    public com.google.protobuf.ByteString
        getOtpBytes() {
      java.lang.Object ref = otp_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        otp_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string otp = 2;</code>
     */
    public Builder setOtp(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      otp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string otp = 2;</code>
     */
    public Builder clearOtp() {
      
      otp_ = getDefaultInstance().getOtp();
      onChanged();
      return this;
    }
    /**
     * <code>string otp = 2;</code>
     */
    public Builder setOtpBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      otp_ = value;
      onChanged();
      return this;
    }

    private int maxTry_ ;
    /**
     * <code>int32 maxTry = 3;</code>
     */
    public int getMaxTry() {
      return maxTry_;
    }
    /**
     * <code>int32 maxTry = 3;</code>
     */
    public Builder setMaxTry(int value) {
      
      maxTry_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 maxTry = 3;</code>
     */
    public Builder clearMaxTry() {
      
      maxTry_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ValidateOTPRequest)
  }

  // @@protoc_insertion_point(class_scope:ValidateOTPRequest)
  private static final com.orosoft.grpc.ValidateOTPRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.orosoft.grpc.ValidateOTPRequest();
  }

  public static com.orosoft.grpc.ValidateOTPRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ValidateOTPRequest>
      PARSER = new com.google.protobuf.AbstractParser<ValidateOTPRequest>() {
    @java.lang.Override
    public ValidateOTPRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ValidateOTPRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ValidateOTPRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ValidateOTPRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.orosoft.grpc.ValidateOTPRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

