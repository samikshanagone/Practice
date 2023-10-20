package com.orosoft.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: cache.proto")
public final class CachingServiceGrpc {

  private CachingServiceGrpc() {}

  public static final String SERVICE_NAME = "CachingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.orosoft.grpc.UserRequest,
      com.orosoft.grpc.UserData> getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUser",
      requestType = com.orosoft.grpc.UserRequest.class,
      responseType = com.orosoft.grpc.UserData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.orosoft.grpc.UserRequest,
      com.orosoft.grpc.UserData> getGetUserMethod() {
    io.grpc.MethodDescriptor<com.orosoft.grpc.UserRequest, com.orosoft.grpc.UserData> getGetUserMethod;
    if ((getGetUserMethod = CachingServiceGrpc.getGetUserMethod) == null) {
      synchronized (CachingServiceGrpc.class) {
        if ((getGetUserMethod = CachingServiceGrpc.getGetUserMethod) == null) {
          CachingServiceGrpc.getGetUserMethod = getGetUserMethod = 
              io.grpc.MethodDescriptor.<com.orosoft.grpc.UserRequest, com.orosoft.grpc.UserData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CachingService", "getUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.UserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.UserData.getDefaultInstance()))
                  .setSchemaDescriptor(new CachingServiceMethodDescriptorSupplier("getUser"))
                  .build();
          }
        }
     }
     return getGetUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.orosoft.grpc.UserData,
      com.orosoft.grpc.StoreUserResponse> getStoreUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "storeUser",
      requestType = com.orosoft.grpc.UserData.class,
      responseType = com.orosoft.grpc.StoreUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.orosoft.grpc.UserData,
      com.orosoft.grpc.StoreUserResponse> getStoreUserMethod() {
    io.grpc.MethodDescriptor<com.orosoft.grpc.UserData, com.orosoft.grpc.StoreUserResponse> getStoreUserMethod;
    if ((getStoreUserMethod = CachingServiceGrpc.getStoreUserMethod) == null) {
      synchronized (CachingServiceGrpc.class) {
        if ((getStoreUserMethod = CachingServiceGrpc.getStoreUserMethod) == null) {
          CachingServiceGrpc.getStoreUserMethod = getStoreUserMethod = 
              io.grpc.MethodDescriptor.<com.orosoft.grpc.UserData, com.orosoft.grpc.StoreUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CachingService", "storeUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.UserData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.StoreUserResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CachingServiceMethodDescriptorSupplier("storeUser"))
                  .build();
          }
        }
     }
     return getStoreUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.orosoft.grpc.RemoveUserRequest,
      com.orosoft.grpc.RemoveUserResponse> getRemoveUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "removeUser",
      requestType = com.orosoft.grpc.RemoveUserRequest.class,
      responseType = com.orosoft.grpc.RemoveUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.orosoft.grpc.RemoveUserRequest,
      com.orosoft.grpc.RemoveUserResponse> getRemoveUserMethod() {
    io.grpc.MethodDescriptor<com.orosoft.grpc.RemoveUserRequest, com.orosoft.grpc.RemoveUserResponse> getRemoveUserMethod;
    if ((getRemoveUserMethod = CachingServiceGrpc.getRemoveUserMethod) == null) {
      synchronized (CachingServiceGrpc.class) {
        if ((getRemoveUserMethod = CachingServiceGrpc.getRemoveUserMethod) == null) {
          CachingServiceGrpc.getRemoveUserMethod = getRemoveUserMethod = 
              io.grpc.MethodDescriptor.<com.orosoft.grpc.RemoveUserRequest, com.orosoft.grpc.RemoveUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CachingService", "removeUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.RemoveUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.RemoveUserResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CachingServiceMethodDescriptorSupplier("removeUser"))
                  .build();
          }
        }
     }
     return getRemoveUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.orosoft.grpc.StoreOTP,
      com.orosoft.grpc.StoreOTPResponse> getStoreOTPMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "storeOTP",
      requestType = com.orosoft.grpc.StoreOTP.class,
      responseType = com.orosoft.grpc.StoreOTPResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.orosoft.grpc.StoreOTP,
      com.orosoft.grpc.StoreOTPResponse> getStoreOTPMethod() {
    io.grpc.MethodDescriptor<com.orosoft.grpc.StoreOTP, com.orosoft.grpc.StoreOTPResponse> getStoreOTPMethod;
    if ((getStoreOTPMethod = CachingServiceGrpc.getStoreOTPMethod) == null) {
      synchronized (CachingServiceGrpc.class) {
        if ((getStoreOTPMethod = CachingServiceGrpc.getStoreOTPMethod) == null) {
          CachingServiceGrpc.getStoreOTPMethod = getStoreOTPMethod = 
              io.grpc.MethodDescriptor.<com.orosoft.grpc.StoreOTP, com.orosoft.grpc.StoreOTPResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CachingService", "storeOTP"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.StoreOTP.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.StoreOTPResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CachingServiceMethodDescriptorSupplier("storeOTP"))
                  .build();
          }
        }
     }
     return getStoreOTPMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.orosoft.grpc.ValidateOTPRequest,
      com.orosoft.grpc.ValidateOTPResponse> getValidateOTPMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "validateOTP",
      requestType = com.orosoft.grpc.ValidateOTPRequest.class,
      responseType = com.orosoft.grpc.ValidateOTPResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.orosoft.grpc.ValidateOTPRequest,
      com.orosoft.grpc.ValidateOTPResponse> getValidateOTPMethod() {
    io.grpc.MethodDescriptor<com.orosoft.grpc.ValidateOTPRequest, com.orosoft.grpc.ValidateOTPResponse> getValidateOTPMethod;
    if ((getValidateOTPMethod = CachingServiceGrpc.getValidateOTPMethod) == null) {
      synchronized (CachingServiceGrpc.class) {
        if ((getValidateOTPMethod = CachingServiceGrpc.getValidateOTPMethod) == null) {
          CachingServiceGrpc.getValidateOTPMethod = getValidateOTPMethod = 
              io.grpc.MethodDescriptor.<com.orosoft.grpc.ValidateOTPRequest, com.orosoft.grpc.ValidateOTPResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CachingService", "validateOTP"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.ValidateOTPRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.ValidateOTPResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CachingServiceMethodDescriptorSupplier("validateOTP"))
                  .build();
          }
        }
     }
     return getValidateOTPMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.orosoft.grpc.RemoveOTPRequest,
      com.orosoft.grpc.RemoveOTPResponse> getRemoveOTPMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "removeOTP",
      requestType = com.orosoft.grpc.RemoveOTPRequest.class,
      responseType = com.orosoft.grpc.RemoveOTPResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.orosoft.grpc.RemoveOTPRequest,
      com.orosoft.grpc.RemoveOTPResponse> getRemoveOTPMethod() {
    io.grpc.MethodDescriptor<com.orosoft.grpc.RemoveOTPRequest, com.orosoft.grpc.RemoveOTPResponse> getRemoveOTPMethod;
    if ((getRemoveOTPMethod = CachingServiceGrpc.getRemoveOTPMethod) == null) {
      synchronized (CachingServiceGrpc.class) {
        if ((getRemoveOTPMethod = CachingServiceGrpc.getRemoveOTPMethod) == null) {
          CachingServiceGrpc.getRemoveOTPMethod = getRemoveOTPMethod = 
              io.grpc.MethodDescriptor.<com.orosoft.grpc.RemoveOTPRequest, com.orosoft.grpc.RemoveOTPResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CachingService", "removeOTP"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.RemoveOTPRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.RemoveOTPResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CachingServiceMethodDescriptorSupplier("removeOTP"))
                  .build();
          }
        }
     }
     return getRemoveOTPMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.orosoft.grpc.GetLoginAttemptsRequest,
      com.orosoft.grpc.GetLoginAttemptsResponse> getGetLoginAttemptsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLoginAttempts",
      requestType = com.orosoft.grpc.GetLoginAttemptsRequest.class,
      responseType = com.orosoft.grpc.GetLoginAttemptsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.orosoft.grpc.GetLoginAttemptsRequest,
      com.orosoft.grpc.GetLoginAttemptsResponse> getGetLoginAttemptsMethod() {
    io.grpc.MethodDescriptor<com.orosoft.grpc.GetLoginAttemptsRequest, com.orosoft.grpc.GetLoginAttemptsResponse> getGetLoginAttemptsMethod;
    if ((getGetLoginAttemptsMethod = CachingServiceGrpc.getGetLoginAttemptsMethod) == null) {
      synchronized (CachingServiceGrpc.class) {
        if ((getGetLoginAttemptsMethod = CachingServiceGrpc.getGetLoginAttemptsMethod) == null) {
          CachingServiceGrpc.getGetLoginAttemptsMethod = getGetLoginAttemptsMethod = 
              io.grpc.MethodDescriptor.<com.orosoft.grpc.GetLoginAttemptsRequest, com.orosoft.grpc.GetLoginAttemptsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CachingService", "GetLoginAttempts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.GetLoginAttemptsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.GetLoginAttemptsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CachingServiceMethodDescriptorSupplier("GetLoginAttempts"))
                  .build();
          }
        }
     }
     return getGetLoginAttemptsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CachingServiceStub newStub(io.grpc.Channel channel) {
    return new CachingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CachingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CachingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CachingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CachingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CachingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUser(com.orosoft.grpc.UserRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.UserData> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }

    /**
     */
    public void storeUser(com.orosoft.grpc.UserData request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.StoreUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStoreUserMethod(), responseObserver);
    }

    /**
     */
    public void removeUser(com.orosoft.grpc.RemoveUserRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.RemoveUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveUserMethod(), responseObserver);
    }

    /**
     */
    public void storeOTP(com.orosoft.grpc.StoreOTP request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.StoreOTPResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStoreOTPMethod(), responseObserver);
    }

    /**
     */
    public void validateOTP(com.orosoft.grpc.ValidateOTPRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.ValidateOTPResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getValidateOTPMethod(), responseObserver);
    }

    /**
     */
    public void removeOTP(com.orosoft.grpc.RemoveOTPRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.RemoveOTPResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveOTPMethod(), responseObserver);
    }

    /**
     */
    public void getLoginAttempts(com.orosoft.grpc.GetLoginAttemptsRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.GetLoginAttemptsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLoginAttemptsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.orosoft.grpc.UserRequest,
                com.orosoft.grpc.UserData>(
                  this, METHODID_GET_USER)))
          .addMethod(
            getStoreUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.orosoft.grpc.UserData,
                com.orosoft.grpc.StoreUserResponse>(
                  this, METHODID_STORE_USER)))
          .addMethod(
            getRemoveUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.orosoft.grpc.RemoveUserRequest,
                com.orosoft.grpc.RemoveUserResponse>(
                  this, METHODID_REMOVE_USER)))
          .addMethod(
            getStoreOTPMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.orosoft.grpc.StoreOTP,
                com.orosoft.grpc.StoreOTPResponse>(
                  this, METHODID_STORE_OTP)))
          .addMethod(
            getValidateOTPMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.orosoft.grpc.ValidateOTPRequest,
                com.orosoft.grpc.ValidateOTPResponse>(
                  this, METHODID_VALIDATE_OTP)))
          .addMethod(
            getRemoveOTPMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.orosoft.grpc.RemoveOTPRequest,
                com.orosoft.grpc.RemoveOTPResponse>(
                  this, METHODID_REMOVE_OTP)))
          .addMethod(
            getGetLoginAttemptsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.orosoft.grpc.GetLoginAttemptsRequest,
                com.orosoft.grpc.GetLoginAttemptsResponse>(
                  this, METHODID_GET_LOGIN_ATTEMPTS)))
          .build();
    }
  }

  /**
   */
  public static final class CachingServiceStub extends io.grpc.stub.AbstractStub<CachingServiceStub> {
    private CachingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CachingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CachingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CachingServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUser(com.orosoft.grpc.UserRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.UserData> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void storeUser(com.orosoft.grpc.UserData request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.StoreUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStoreUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeUser(com.orosoft.grpc.RemoveUserRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.RemoveUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void storeOTP(com.orosoft.grpc.StoreOTP request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.StoreOTPResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStoreOTPMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateOTP(com.orosoft.grpc.ValidateOTPRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.ValidateOTPResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getValidateOTPMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeOTP(com.orosoft.grpc.RemoveOTPRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.RemoveOTPResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveOTPMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLoginAttempts(com.orosoft.grpc.GetLoginAttemptsRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.GetLoginAttemptsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLoginAttemptsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CachingServiceBlockingStub extends io.grpc.stub.AbstractStub<CachingServiceBlockingStub> {
    private CachingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CachingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CachingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CachingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.orosoft.grpc.UserData getUser(com.orosoft.grpc.UserRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.orosoft.grpc.StoreUserResponse storeUser(com.orosoft.grpc.UserData request) {
      return blockingUnaryCall(
          getChannel(), getStoreUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.orosoft.grpc.RemoveUserResponse removeUser(com.orosoft.grpc.RemoveUserRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoveUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.orosoft.grpc.StoreOTPResponse storeOTP(com.orosoft.grpc.StoreOTP request) {
      return blockingUnaryCall(
          getChannel(), getStoreOTPMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.orosoft.grpc.ValidateOTPResponse validateOTP(com.orosoft.grpc.ValidateOTPRequest request) {
      return blockingUnaryCall(
          getChannel(), getValidateOTPMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.orosoft.grpc.RemoveOTPResponse removeOTP(com.orosoft.grpc.RemoveOTPRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoveOTPMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.orosoft.grpc.GetLoginAttemptsResponse getLoginAttempts(com.orosoft.grpc.GetLoginAttemptsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetLoginAttemptsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CachingServiceFutureStub extends io.grpc.stub.AbstractStub<CachingServiceFutureStub> {
    private CachingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CachingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CachingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CachingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.orosoft.grpc.UserData> getUser(
        com.orosoft.grpc.UserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.orosoft.grpc.StoreUserResponse> storeUser(
        com.orosoft.grpc.UserData request) {
      return futureUnaryCall(
          getChannel().newCall(getStoreUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.orosoft.grpc.RemoveUserResponse> removeUser(
        com.orosoft.grpc.RemoveUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.orosoft.grpc.StoreOTPResponse> storeOTP(
        com.orosoft.grpc.StoreOTP request) {
      return futureUnaryCall(
          getChannel().newCall(getStoreOTPMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.orosoft.grpc.ValidateOTPResponse> validateOTP(
        com.orosoft.grpc.ValidateOTPRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getValidateOTPMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.orosoft.grpc.RemoveOTPResponse> removeOTP(
        com.orosoft.grpc.RemoveOTPRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveOTPMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.orosoft.grpc.GetLoginAttemptsResponse> getLoginAttempts(
        com.orosoft.grpc.GetLoginAttemptsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetLoginAttemptsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER = 0;
  private static final int METHODID_STORE_USER = 1;
  private static final int METHODID_REMOVE_USER = 2;
  private static final int METHODID_STORE_OTP = 3;
  private static final int METHODID_VALIDATE_OTP = 4;
  private static final int METHODID_REMOVE_OTP = 5;
  private static final int METHODID_GET_LOGIN_ATTEMPTS = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CachingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CachingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER:
          serviceImpl.getUser((com.orosoft.grpc.UserRequest) request,
              (io.grpc.stub.StreamObserver<com.orosoft.grpc.UserData>) responseObserver);
          break;
        case METHODID_STORE_USER:
          serviceImpl.storeUser((com.orosoft.grpc.UserData) request,
              (io.grpc.stub.StreamObserver<com.orosoft.grpc.StoreUserResponse>) responseObserver);
          break;
        case METHODID_REMOVE_USER:
          serviceImpl.removeUser((com.orosoft.grpc.RemoveUserRequest) request,
              (io.grpc.stub.StreamObserver<com.orosoft.grpc.RemoveUserResponse>) responseObserver);
          break;
        case METHODID_STORE_OTP:
          serviceImpl.storeOTP((com.orosoft.grpc.StoreOTP) request,
              (io.grpc.stub.StreamObserver<com.orosoft.grpc.StoreOTPResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_OTP:
          serviceImpl.validateOTP((com.orosoft.grpc.ValidateOTPRequest) request,
              (io.grpc.stub.StreamObserver<com.orosoft.grpc.ValidateOTPResponse>) responseObserver);
          break;
        case METHODID_REMOVE_OTP:
          serviceImpl.removeOTP((com.orosoft.grpc.RemoveOTPRequest) request,
              (io.grpc.stub.StreamObserver<com.orosoft.grpc.RemoveOTPResponse>) responseObserver);
          break;
        case METHODID_GET_LOGIN_ATTEMPTS:
          serviceImpl.getLoginAttempts((com.orosoft.grpc.GetLoginAttemptsRequest) request,
              (io.grpc.stub.StreamObserver<com.orosoft.grpc.GetLoginAttemptsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CachingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CachingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.orosoft.grpc.Cache.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CachingService");
    }
  }

  private static final class CachingServiceFileDescriptorSupplier
      extends CachingServiceBaseDescriptorSupplier {
    CachingServiceFileDescriptorSupplier() {}
  }

  private static final class CachingServiceMethodDescriptorSupplier
      extends CachingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CachingServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CachingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CachingServiceFileDescriptorSupplier())
              .addMethod(getGetUserMethod())
              .addMethod(getStoreUserMethod())
              .addMethod(getRemoveUserMethod())
              .addMethod(getStoreOTPMethod())
              .addMethod(getValidateOTPMethod())
              .addMethod(getRemoveOTPMethod())
              .addMethod(getGetLoginAttemptsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
