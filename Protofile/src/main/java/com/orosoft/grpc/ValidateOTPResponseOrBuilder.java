// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cache.proto

package com.orosoft.grpc;

public interface ValidateOTPResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ValidateOTPResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool optMatched = 1;</code>
   */
  boolean getOptMatched();

  /**
   * <code>bool MaxTryReach = 2;</code>
   */
  boolean getMaxTryReach();

  /**
   * <code>bool userIdValid = 3;</code>
   */
  boolean getUserIdValid();
}