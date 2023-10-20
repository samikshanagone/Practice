package com.orosoft.grpc.history;

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
    comments = "Source: History.proto")
public final class HistoryCachingServiceGrpc {

  private HistoryCachingServiceGrpc() {}

  public static final String SERVICE_NAME = "HistoryCachingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.orosoft.grpc.history.ProductsHistoryDataRequest,
      com.orosoft.grpc.history.ProductsHistoryData> getGetProductsHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProductsHistory",
      requestType = com.orosoft.grpc.history.ProductsHistoryDataRequest.class,
      responseType = com.orosoft.grpc.history.ProductsHistoryData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.orosoft.grpc.history.ProductsHistoryDataRequest,
      com.orosoft.grpc.history.ProductsHistoryData> getGetProductsHistoryMethod() {
    io.grpc.MethodDescriptor<com.orosoft.grpc.history.ProductsHistoryDataRequest, com.orosoft.grpc.history.ProductsHistoryData> getGetProductsHistoryMethod;
    if ((getGetProductsHistoryMethod = HistoryCachingServiceGrpc.getGetProductsHistoryMethod) == null) {
      synchronized (HistoryCachingServiceGrpc.class) {
        if ((getGetProductsHistoryMethod = HistoryCachingServiceGrpc.getGetProductsHistoryMethod) == null) {
          HistoryCachingServiceGrpc.getGetProductsHistoryMethod = getGetProductsHistoryMethod = 
              io.grpc.MethodDescriptor.<com.orosoft.grpc.history.ProductsHistoryDataRequest, com.orosoft.grpc.history.ProductsHistoryData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HistoryCachingService", "getProductsHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.history.ProductsHistoryDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.history.ProductsHistoryData.getDefaultInstance()))
                  .setSchemaDescriptor(new HistoryCachingServiceMethodDescriptorSupplier("getProductsHistory"))
                  .build();
          }
        }
     }
     return getGetProductsHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.orosoft.grpc.history.ProductsHistoryData,
      com.orosoft.grpc.history.StoreProductsResponse> getStoreProductsHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "storeProductsHistory",
      requestType = com.orosoft.grpc.history.ProductsHistoryData.class,
      responseType = com.orosoft.grpc.history.StoreProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.orosoft.grpc.history.ProductsHistoryData,
      com.orosoft.grpc.history.StoreProductsResponse> getStoreProductsHistoryMethod() {
    io.grpc.MethodDescriptor<com.orosoft.grpc.history.ProductsHistoryData, com.orosoft.grpc.history.StoreProductsResponse> getStoreProductsHistoryMethod;
    if ((getStoreProductsHistoryMethod = HistoryCachingServiceGrpc.getStoreProductsHistoryMethod) == null) {
      synchronized (HistoryCachingServiceGrpc.class) {
        if ((getStoreProductsHistoryMethod = HistoryCachingServiceGrpc.getStoreProductsHistoryMethod) == null) {
          HistoryCachingServiceGrpc.getStoreProductsHistoryMethod = getStoreProductsHistoryMethod = 
              io.grpc.MethodDescriptor.<com.orosoft.grpc.history.ProductsHistoryData, com.orosoft.grpc.history.StoreProductsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HistoryCachingService", "storeProductsHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.history.ProductsHistoryData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.history.StoreProductsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HistoryCachingServiceMethodDescriptorSupplier("storeProductsHistory"))
                  .build();
          }
        }
     }
     return getStoreProductsHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.orosoft.grpc.history.RemoveProductsHistoryData,
      com.orosoft.grpc.history.RemoveProductsResponse> getRemoveProductsHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "removeProductsHistory",
      requestType = com.orosoft.grpc.history.RemoveProductsHistoryData.class,
      responseType = com.orosoft.grpc.history.RemoveProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.orosoft.grpc.history.RemoveProductsHistoryData,
      com.orosoft.grpc.history.RemoveProductsResponse> getRemoveProductsHistoryMethod() {
    io.grpc.MethodDescriptor<com.orosoft.grpc.history.RemoveProductsHistoryData, com.orosoft.grpc.history.RemoveProductsResponse> getRemoveProductsHistoryMethod;
    if ((getRemoveProductsHistoryMethod = HistoryCachingServiceGrpc.getRemoveProductsHistoryMethod) == null) {
      synchronized (HistoryCachingServiceGrpc.class) {
        if ((getRemoveProductsHistoryMethod = HistoryCachingServiceGrpc.getRemoveProductsHistoryMethod) == null) {
          HistoryCachingServiceGrpc.getRemoveProductsHistoryMethod = getRemoveProductsHistoryMethod = 
              io.grpc.MethodDescriptor.<com.orosoft.grpc.history.RemoveProductsHistoryData, com.orosoft.grpc.history.RemoveProductsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HistoryCachingService", "removeProductsHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.history.RemoveProductsHistoryData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.history.RemoveProductsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HistoryCachingServiceMethodDescriptorSupplier("removeProductsHistory"))
                  .build();
          }
        }
     }
     return getRemoveProductsHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.orosoft.grpc.history.CategoriesHistoryDataRequest,
      com.orosoft.grpc.history.CategoriesHistoryData> getGetCategoriesHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCategoriesHistory",
      requestType = com.orosoft.grpc.history.CategoriesHistoryDataRequest.class,
      responseType = com.orosoft.grpc.history.CategoriesHistoryData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.orosoft.grpc.history.CategoriesHistoryDataRequest,
      com.orosoft.grpc.history.CategoriesHistoryData> getGetCategoriesHistoryMethod() {
    io.grpc.MethodDescriptor<com.orosoft.grpc.history.CategoriesHistoryDataRequest, com.orosoft.grpc.history.CategoriesHistoryData> getGetCategoriesHistoryMethod;
    if ((getGetCategoriesHistoryMethod = HistoryCachingServiceGrpc.getGetCategoriesHistoryMethod) == null) {
      synchronized (HistoryCachingServiceGrpc.class) {
        if ((getGetCategoriesHistoryMethod = HistoryCachingServiceGrpc.getGetCategoriesHistoryMethod) == null) {
          HistoryCachingServiceGrpc.getGetCategoriesHistoryMethod = getGetCategoriesHistoryMethod = 
              io.grpc.MethodDescriptor.<com.orosoft.grpc.history.CategoriesHistoryDataRequest, com.orosoft.grpc.history.CategoriesHistoryData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HistoryCachingService", "getCategoriesHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.history.CategoriesHistoryDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.history.CategoriesHistoryData.getDefaultInstance()))
                  .setSchemaDescriptor(new HistoryCachingServiceMethodDescriptorSupplier("getCategoriesHistory"))
                  .build();
          }
        }
     }
     return getGetCategoriesHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.orosoft.grpc.history.CategoriesHistoryData,
      com.orosoft.grpc.history.StoreCategoriesResponse> getStoreCategoriesHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "storeCategoriesHistory",
      requestType = com.orosoft.grpc.history.CategoriesHistoryData.class,
      responseType = com.orosoft.grpc.history.StoreCategoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.orosoft.grpc.history.CategoriesHistoryData,
      com.orosoft.grpc.history.StoreCategoriesResponse> getStoreCategoriesHistoryMethod() {
    io.grpc.MethodDescriptor<com.orosoft.grpc.history.CategoriesHistoryData, com.orosoft.grpc.history.StoreCategoriesResponse> getStoreCategoriesHistoryMethod;
    if ((getStoreCategoriesHistoryMethod = HistoryCachingServiceGrpc.getStoreCategoriesHistoryMethod) == null) {
      synchronized (HistoryCachingServiceGrpc.class) {
        if ((getStoreCategoriesHistoryMethod = HistoryCachingServiceGrpc.getStoreCategoriesHistoryMethod) == null) {
          HistoryCachingServiceGrpc.getStoreCategoriesHistoryMethod = getStoreCategoriesHistoryMethod = 
              io.grpc.MethodDescriptor.<com.orosoft.grpc.history.CategoriesHistoryData, com.orosoft.grpc.history.StoreCategoriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HistoryCachingService", "storeCategoriesHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.history.CategoriesHistoryData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.history.StoreCategoriesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HistoryCachingServiceMethodDescriptorSupplier("storeCategoriesHistory"))
                  .build();
          }
        }
     }
     return getStoreCategoriesHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.orosoft.grpc.history.RemoveCategoriesHistoryData,
      com.orosoft.grpc.history.RemoveCategoriesResponse> getRemoveCategoriesHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "removeCategoriesHistory",
      requestType = com.orosoft.grpc.history.RemoveCategoriesHistoryData.class,
      responseType = com.orosoft.grpc.history.RemoveCategoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.orosoft.grpc.history.RemoveCategoriesHistoryData,
      com.orosoft.grpc.history.RemoveCategoriesResponse> getRemoveCategoriesHistoryMethod() {
    io.grpc.MethodDescriptor<com.orosoft.grpc.history.RemoveCategoriesHistoryData, com.orosoft.grpc.history.RemoveCategoriesResponse> getRemoveCategoriesHistoryMethod;
    if ((getRemoveCategoriesHistoryMethod = HistoryCachingServiceGrpc.getRemoveCategoriesHistoryMethod) == null) {
      synchronized (HistoryCachingServiceGrpc.class) {
        if ((getRemoveCategoriesHistoryMethod = HistoryCachingServiceGrpc.getRemoveCategoriesHistoryMethod) == null) {
          HistoryCachingServiceGrpc.getRemoveCategoriesHistoryMethod = getRemoveCategoriesHistoryMethod = 
              io.grpc.MethodDescriptor.<com.orosoft.grpc.history.RemoveCategoriesHistoryData, com.orosoft.grpc.history.RemoveCategoriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HistoryCachingService", "removeCategoriesHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.history.RemoveCategoriesHistoryData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.orosoft.grpc.history.RemoveCategoriesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HistoryCachingServiceMethodDescriptorSupplier("removeCategoriesHistory"))
                  .build();
          }
        }
     }
     return getRemoveCategoriesHistoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HistoryCachingServiceStub newStub(io.grpc.Channel channel) {
    return new HistoryCachingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HistoryCachingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HistoryCachingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HistoryCachingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HistoryCachingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HistoryCachingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getProductsHistory(com.orosoft.grpc.history.ProductsHistoryDataRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.history.ProductsHistoryData> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProductsHistoryMethod(), responseObserver);
    }

    /**
     */
    public void storeProductsHistory(com.orosoft.grpc.history.ProductsHistoryData request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.history.StoreProductsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStoreProductsHistoryMethod(), responseObserver);
    }

    /**
     */
    public void removeProductsHistory(com.orosoft.grpc.history.RemoveProductsHistoryData request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.history.RemoveProductsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveProductsHistoryMethod(), responseObserver);
    }

    /**
     */
    public void getCategoriesHistory(com.orosoft.grpc.history.CategoriesHistoryDataRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.history.CategoriesHistoryData> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCategoriesHistoryMethod(), responseObserver);
    }

    /**
     */
    public void storeCategoriesHistory(com.orosoft.grpc.history.CategoriesHistoryData request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.history.StoreCategoriesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStoreCategoriesHistoryMethod(), responseObserver);
    }

    /**
     */
    public void removeCategoriesHistory(com.orosoft.grpc.history.RemoveCategoriesHistoryData request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.history.RemoveCategoriesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveCategoriesHistoryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetProductsHistoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.orosoft.grpc.history.ProductsHistoryDataRequest,
                com.orosoft.grpc.history.ProductsHistoryData>(
                  this, METHODID_GET_PRODUCTS_HISTORY)))
          .addMethod(
            getStoreProductsHistoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.orosoft.grpc.history.ProductsHistoryData,
                com.orosoft.grpc.history.StoreProductsResponse>(
                  this, METHODID_STORE_PRODUCTS_HISTORY)))
          .addMethod(
            getRemoveProductsHistoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.orosoft.grpc.history.RemoveProductsHistoryData,
                com.orosoft.grpc.history.RemoveProductsResponse>(
                  this, METHODID_REMOVE_PRODUCTS_HISTORY)))
          .addMethod(
            getGetCategoriesHistoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.orosoft.grpc.history.CategoriesHistoryDataRequest,
                com.orosoft.grpc.history.CategoriesHistoryData>(
                  this, METHODID_GET_CATEGORIES_HISTORY)))
          .addMethod(
            getStoreCategoriesHistoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.orosoft.grpc.history.CategoriesHistoryData,
                com.orosoft.grpc.history.StoreCategoriesResponse>(
                  this, METHODID_STORE_CATEGORIES_HISTORY)))
          .addMethod(
            getRemoveCategoriesHistoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.orosoft.grpc.history.RemoveCategoriesHistoryData,
                com.orosoft.grpc.history.RemoveCategoriesResponse>(
                  this, METHODID_REMOVE_CATEGORIES_HISTORY)))
          .build();
    }
  }

  /**
   */
  public static final class HistoryCachingServiceStub extends io.grpc.stub.AbstractStub<HistoryCachingServiceStub> {
    private HistoryCachingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HistoryCachingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HistoryCachingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HistoryCachingServiceStub(channel, callOptions);
    }

    /**
     */
    public void getProductsHistory(com.orosoft.grpc.history.ProductsHistoryDataRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.history.ProductsHistoryData> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProductsHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void storeProductsHistory(com.orosoft.grpc.history.ProductsHistoryData request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.history.StoreProductsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStoreProductsHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeProductsHistory(com.orosoft.grpc.history.RemoveProductsHistoryData request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.history.RemoveProductsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveProductsHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCategoriesHistory(com.orosoft.grpc.history.CategoriesHistoryDataRequest request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.history.CategoriesHistoryData> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCategoriesHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void storeCategoriesHistory(com.orosoft.grpc.history.CategoriesHistoryData request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.history.StoreCategoriesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStoreCategoriesHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeCategoriesHistory(com.orosoft.grpc.history.RemoveCategoriesHistoryData request,
        io.grpc.stub.StreamObserver<com.orosoft.grpc.history.RemoveCategoriesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveCategoriesHistoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HistoryCachingServiceBlockingStub extends io.grpc.stub.AbstractStub<HistoryCachingServiceBlockingStub> {
    private HistoryCachingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HistoryCachingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HistoryCachingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HistoryCachingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.orosoft.grpc.history.ProductsHistoryData getProductsHistory(com.orosoft.grpc.history.ProductsHistoryDataRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetProductsHistoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.orosoft.grpc.history.StoreProductsResponse storeProductsHistory(com.orosoft.grpc.history.ProductsHistoryData request) {
      return blockingUnaryCall(
          getChannel(), getStoreProductsHistoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.orosoft.grpc.history.RemoveProductsResponse removeProductsHistory(com.orosoft.grpc.history.RemoveProductsHistoryData request) {
      return blockingUnaryCall(
          getChannel(), getRemoveProductsHistoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.orosoft.grpc.history.CategoriesHistoryData getCategoriesHistory(com.orosoft.grpc.history.CategoriesHistoryDataRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCategoriesHistoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.orosoft.grpc.history.StoreCategoriesResponse storeCategoriesHistory(com.orosoft.grpc.history.CategoriesHistoryData request) {
      return blockingUnaryCall(
          getChannel(), getStoreCategoriesHistoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.orosoft.grpc.history.RemoveCategoriesResponse removeCategoriesHistory(com.orosoft.grpc.history.RemoveCategoriesHistoryData request) {
      return blockingUnaryCall(
          getChannel(), getRemoveCategoriesHistoryMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HistoryCachingServiceFutureStub extends io.grpc.stub.AbstractStub<HistoryCachingServiceFutureStub> {
    private HistoryCachingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HistoryCachingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HistoryCachingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HistoryCachingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.orosoft.grpc.history.ProductsHistoryData> getProductsHistory(
        com.orosoft.grpc.history.ProductsHistoryDataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProductsHistoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.orosoft.grpc.history.StoreProductsResponse> storeProductsHistory(
        com.orosoft.grpc.history.ProductsHistoryData request) {
      return futureUnaryCall(
          getChannel().newCall(getStoreProductsHistoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.orosoft.grpc.history.RemoveProductsResponse> removeProductsHistory(
        com.orosoft.grpc.history.RemoveProductsHistoryData request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveProductsHistoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.orosoft.grpc.history.CategoriesHistoryData> getCategoriesHistory(
        com.orosoft.grpc.history.CategoriesHistoryDataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCategoriesHistoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.orosoft.grpc.history.StoreCategoriesResponse> storeCategoriesHistory(
        com.orosoft.grpc.history.CategoriesHistoryData request) {
      return futureUnaryCall(
          getChannel().newCall(getStoreCategoriesHistoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.orosoft.grpc.history.RemoveCategoriesResponse> removeCategoriesHistory(
        com.orosoft.grpc.history.RemoveCategoriesHistoryData request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveCategoriesHistoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PRODUCTS_HISTORY = 0;
  private static final int METHODID_STORE_PRODUCTS_HISTORY = 1;
  private static final int METHODID_REMOVE_PRODUCTS_HISTORY = 2;
  private static final int METHODID_GET_CATEGORIES_HISTORY = 3;
  private static final int METHODID_STORE_CATEGORIES_HISTORY = 4;
  private static final int METHODID_REMOVE_CATEGORIES_HISTORY = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HistoryCachingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HistoryCachingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PRODUCTS_HISTORY:
          serviceImpl.getProductsHistory((com.orosoft.grpc.history.ProductsHistoryDataRequest) request,
              (io.grpc.stub.StreamObserver<com.orosoft.grpc.history.ProductsHistoryData>) responseObserver);
          break;
        case METHODID_STORE_PRODUCTS_HISTORY:
          serviceImpl.storeProductsHistory((com.orosoft.grpc.history.ProductsHistoryData) request,
              (io.grpc.stub.StreamObserver<com.orosoft.grpc.history.StoreProductsResponse>) responseObserver);
          break;
        case METHODID_REMOVE_PRODUCTS_HISTORY:
          serviceImpl.removeProductsHistory((com.orosoft.grpc.history.RemoveProductsHistoryData) request,
              (io.grpc.stub.StreamObserver<com.orosoft.grpc.history.RemoveProductsResponse>) responseObserver);
          break;
        case METHODID_GET_CATEGORIES_HISTORY:
          serviceImpl.getCategoriesHistory((com.orosoft.grpc.history.CategoriesHistoryDataRequest) request,
              (io.grpc.stub.StreamObserver<com.orosoft.grpc.history.CategoriesHistoryData>) responseObserver);
          break;
        case METHODID_STORE_CATEGORIES_HISTORY:
          serviceImpl.storeCategoriesHistory((com.orosoft.grpc.history.CategoriesHistoryData) request,
              (io.grpc.stub.StreamObserver<com.orosoft.grpc.history.StoreCategoriesResponse>) responseObserver);
          break;
        case METHODID_REMOVE_CATEGORIES_HISTORY:
          serviceImpl.removeCategoriesHistory((com.orosoft.grpc.history.RemoveCategoriesHistoryData) request,
              (io.grpc.stub.StreamObserver<com.orosoft.grpc.history.RemoveCategoriesResponse>) responseObserver);
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

  private static abstract class HistoryCachingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HistoryCachingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.orosoft.grpc.history.History.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HistoryCachingService");
    }
  }

  private static final class HistoryCachingServiceFileDescriptorSupplier
      extends HistoryCachingServiceBaseDescriptorSupplier {
    HistoryCachingServiceFileDescriptorSupplier() {}
  }

  private static final class HistoryCachingServiceMethodDescriptorSupplier
      extends HistoryCachingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HistoryCachingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HistoryCachingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HistoryCachingServiceFileDescriptorSupplier())
              .addMethod(getGetProductsHistoryMethod())
              .addMethod(getStoreProductsHistoryMethod())
              .addMethod(getRemoveProductsHistoryMethod())
              .addMethod(getGetCategoriesHistoryMethod())
              .addMethod(getStoreCategoriesHistoryMethod())
              .addMethod(getRemoveCategoriesHistoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
