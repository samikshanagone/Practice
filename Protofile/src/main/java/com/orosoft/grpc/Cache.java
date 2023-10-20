// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cache.proto

package com.orosoft.grpc;

public final class Cache {
  private Cache() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetLoginAttemptsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetLoginAttemptsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetLoginAttemptsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetLoginAttemptsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StoreOTP_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StoreOTP_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StoreOTPResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StoreOTPResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ValidateOTPRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ValidateOTPRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ValidateOTPResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ValidateOTPResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StoreUserResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StoreUserResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RemoveUserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RemoveUserRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RemoveUserResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RemoveUserResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RemoveOTPRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RemoveOTPRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RemoveOTPResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RemoveOTPResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserSessionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserSessionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserSession_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserSession_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StoreSessionResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StoreSessionResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RemoveSessionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RemoveSessionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RemoveSessionResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RemoveSessionResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013cache.proto\"*\n\027GetLoginAttemptsRequest" +
      "\022\017\n\007user_id\030\001 \001(\t\"2\n\030GetLoginAttemptsRes" +
      "ponse\022\026\n\016login_attempts\030\001 \001(\005\"\'\n\010StoreOT" +
      "P\022\016\n\006userId\030\001 \001(\t\022\013\n\003OTP\030\002 \001(\t\"#\n\020StoreO" +
      "TPResponse\022\017\n\007success\030\001 \001(\010\"A\n\022ValidateO" +
      "TPRequest\022\016\n\006userId\030\001 \001(\t\022\013\n\003otp\030\002 \001(\t\022\016" +
      "\n\006maxTry\030\003 \001(\005\"S\n\023ValidateOTPResponse\022\022\n" +
      "\noptMatched\030\001 \001(\010\022\023\n\013MaxTryReach\030\002 \001(\010\022\023" +
      "\n\013userIdValid\030\003 \001(\010\"\035\n\013UserRequest\022\016\n\006us" +
      "erId\030\001 \001(\t\"g\n\010UserData\022\016\n\006userId\030\001 \001(\t\022\014" +
      "\n\004name\030\002 \001(\t\022\r\n\005email\030\003 \001(\t\022\017\n\007contact\030\004" +
      " \001(\t\022\013\n\003dob\030\005 \001(\t\022\020\n\010password\030\006 \001(\t\"$\n\021S" +
      "toreUserResponse\022\017\n\007success\030\001 \001(\010\"#\n\021Rem" +
      "oveUserRequest\022\016\n\006userId\030\001 \001(\t\"%\n\022Remove" +
      "UserResponse\022\017\n\007success\030\001 \001(\010\"\"\n\020RemoveO" +
      "TPRequest\022\016\n\006userId\030\001 \001(\t\"$\n\021RemoveOTPRe" +
      "sponse\022\017\n\007success\030\001 \001(\010\"$\n\022UserSessionRe" +
      "quest\022\016\n\006userId\030\001 \001(\t\"U\n\013UserSession\022\016\n\006" +
      "userId\030\001 \001(\t\022\021\n\tsessionId\030\002 \001(\005\022\r\n\005token" +
      "\030\003 \001(\t\022\024\n\014deviceString\030\004 \001(\t\"\'\n\024StoreSes" +
      "sionResponse\022\017\n\007success\030\001 \001(\010\"&\n\024RemoveS" +
      "essionRequest\022\016\n\006userId\030\001 \001(\t\"(\n\025RemoveS" +
      "essionResponse\022\017\n\007success\030\001 \001(\0102\252\004\n\016Cach" +
      "ingService\022\"\n\007getUser\022\014.UserRequest\032\t.Us" +
      "erData\022*\n\tstoreUser\022\t.UserData\032\022.StoreUs" +
      "erResponse\0225\n\nremoveUser\022\022.RemoveUserReq" +
      "uest\032\023.RemoveUserResponse\022(\n\010storeOTP\022\t." +
      "StoreOTP\032\021.StoreOTPResponse\0228\n\013validateO" +
      "TP\022\023.ValidateOTPRequest\032\024.ValidateOTPRes" +
      "ponse\0222\n\tremoveOTP\022\021.RemoveOTPRequest\032\022." +
      "RemoveOTPResponse\022G\n\020GetLoginAttempts\022\030." +
      "GetLoginAttemptsRequest\032\031.GetLoginAttemp" +
      "tsResponse\0223\n\016getUserSession\022\023.UserSessi" +
      "onRequest\032\014.UserSession\0227\n\020storeUserSess" +
      "ion\022\014.UserSession\032\025.StoreSessionResponse" +
      "\022B\n\021removeUserSession\022\025.RemoveSessionReq" +
      "uest\032\026.RemoveSessionResponseB\024\n\020com.oros" +
      "oft.grpcP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_GetLoginAttemptsRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_GetLoginAttemptsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetLoginAttemptsRequest_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_GetLoginAttemptsResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_GetLoginAttemptsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetLoginAttemptsResponse_descriptor,
        new java.lang.String[] { "LoginAttempts", });
    internal_static_StoreOTP_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_StoreOTP_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StoreOTP_descriptor,
        new java.lang.String[] { "UserId", "OTP", });
    internal_static_StoreOTPResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_StoreOTPResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StoreOTPResponse_descriptor,
        new java.lang.String[] { "Success", });
    internal_static_ValidateOTPRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ValidateOTPRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ValidateOTPRequest_descriptor,
        new java.lang.String[] { "UserId", "Otp", "MaxTry", });
    internal_static_ValidateOTPResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ValidateOTPResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ValidateOTPResponse_descriptor,
        new java.lang.String[] { "OptMatched", "MaxTryReach", "UserIdValid", });
    internal_static_UserRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_UserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserRequest_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_UserData_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_UserData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserData_descriptor,
        new java.lang.String[] { "UserId", "Name", "Email", "Contact", "Dob", "Password", });
    internal_static_StoreUserResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_StoreUserResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StoreUserResponse_descriptor,
        new java.lang.String[] { "Success", });
    internal_static_RemoveUserRequest_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_RemoveUserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RemoveUserRequest_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_RemoveUserResponse_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_RemoveUserResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RemoveUserResponse_descriptor,
        new java.lang.String[] { "Success", });
    internal_static_RemoveOTPRequest_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_RemoveOTPRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RemoveOTPRequest_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_RemoveOTPResponse_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_RemoveOTPResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RemoveOTPResponse_descriptor,
        new java.lang.String[] { "Success", });
    internal_static_UserSessionRequest_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_UserSessionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserSessionRequest_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_UserSession_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_UserSession_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserSession_descriptor,
        new java.lang.String[] { "UserId", "SessionId", "Token", "DeviceString", });
    internal_static_StoreSessionResponse_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_StoreSessionResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StoreSessionResponse_descriptor,
        new java.lang.String[] { "Success", });
    internal_static_RemoveSessionRequest_descriptor =
      getDescriptor().getMessageTypes().get(16);
    internal_static_RemoveSessionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RemoveSessionRequest_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_RemoveSessionResponse_descriptor =
      getDescriptor().getMessageTypes().get(17);
    internal_static_RemoveSessionResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RemoveSessionResponse_descriptor,
        new java.lang.String[] { "Success", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
