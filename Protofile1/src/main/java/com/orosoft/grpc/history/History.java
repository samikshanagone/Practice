// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: History.proto

package com.orosoft.grpc.history;

public final class History {
  private History() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ProductsHistoryDataRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ProductsHistoryDataRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ProductsHistoryData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ProductsHistoryData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StoreProductsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StoreProductsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RemoveProductsHistoryData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RemoveProductsHistoryData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RemoveProductsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RemoveProductsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CategoriesHistoryDataRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CategoriesHistoryDataRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CategoriesHistoryData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CategoriesHistoryData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StoreCategoriesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StoreCategoriesResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RemoveCategoriesHistoryData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RemoveCategoriesHistoryData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RemoveCategoriesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RemoveCategoriesResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rHistory.proto\",\n\032ProductsHistoryDataRe" +
      "quest\022\016\n\006userId\030\001 \001(\t\"\274\001\n\023ProductsHistor" +
      "yData\022\016\n\006userId\030\001 \001(\t\022\021\n\tproductId\030\002 \001(\t" +
      "\022\022\n\ncategoryId\030\003 \001(\t\022\021\n\timagePath\030\004 \001(\t\022" +
      "\035\n\025productionDescription\030\005 \001(\t\022\023\n\013produc" +
      "tName\030\006 \001(\t\022\024\n\014productPrice\030\007 \001(\t\022\021\n\tvie" +
      "wCount\030\010 \001(\005\"(\n\025StoreProductsResponse\022\017\n" +
      "\007success\030\001 \001(\010\"+\n\031RemoveProductsHistoryD" +
      "ata\022\016\n\006userId\030\001 \001(\t\")\n\026RemoveProductsRes" +
      "ponse\022\017\n\007success\030\001 \001(\010\".\n\034CategoriesHist" +
      "oryDataRequest\022\016\n\006userId\030\001 \001(\t\"d\n\025Catego" +
      "riesHistoryData\022\016\n\006userId\030\001 \001(\t\022\022\n\ncateg" +
      "oryId\030\002 \001(\t\022\024\n\014categoryName\030\003 \001(\t\022\021\n\tima" +
      "gePath\030\004 \001(\t\"*\n\027StoreCategoriesResponse\022" +
      "\017\n\007success\030\001 \001(\010\"-\n\033RemoveCategoriesHist" +
      "oryData\022\016\n\006userId\030\001 \001(\t\"+\n\030RemoveCategor" +
      "iesResponse\022\017\n\007success\030\001 \001(\0102\343\003\n\025History" +
      "CachingService\022G\n\022getProductsHistory\022\033.P" +
      "roductsHistoryDataRequest\032\024.ProductsHist" +
      "oryData\022D\n\024storeProductsHistory\022\024.Produc" +
      "tsHistoryData\032\026.StoreProductsResponse\022L\n" +
      "\025removeProductsHistory\022\032.RemoveProductsH" +
      "istoryData\032\027.RemoveProductsResponse\022M\n\024g" +
      "etCategoriesHistory\022\035.CategoriesHistoryD" +
      "ataRequest\032\026.CategoriesHistoryData\022J\n\026st" +
      "oreCategoriesHistory\022\026.CategoriesHistory" +
      "Data\032\030.StoreCategoriesResponse\022R\n\027remove" +
      "CategoriesHistory\022\034.RemoveCategoriesHist" +
      "oryData\032\031.RemoveCategoriesResponseB\034\n\030co" +
      "m.orosoft.grpc.historyP\001b\006proto3"
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
    internal_static_ProductsHistoryDataRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ProductsHistoryDataRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ProductsHistoryDataRequest_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_ProductsHistoryData_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ProductsHistoryData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ProductsHistoryData_descriptor,
        new java.lang.String[] { "UserId", "ProductId", "CategoryId", "ImagePath", "ProductionDescription", "ProductName", "ProductPrice", "ViewCount", });
    internal_static_StoreProductsResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_StoreProductsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StoreProductsResponse_descriptor,
        new java.lang.String[] { "Success", });
    internal_static_RemoveProductsHistoryData_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_RemoveProductsHistoryData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RemoveProductsHistoryData_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_RemoveProductsResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_RemoveProductsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RemoveProductsResponse_descriptor,
        new java.lang.String[] { "Success", });
    internal_static_CategoriesHistoryDataRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_CategoriesHistoryDataRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CategoriesHistoryDataRequest_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_CategoriesHistoryData_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_CategoriesHistoryData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CategoriesHistoryData_descriptor,
        new java.lang.String[] { "UserId", "CategoryId", "CategoryName", "ImagePath", });
    internal_static_StoreCategoriesResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_StoreCategoriesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StoreCategoriesResponse_descriptor,
        new java.lang.String[] { "Success", });
    internal_static_RemoveCategoriesHistoryData_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_RemoveCategoriesHistoryData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RemoveCategoriesHistoryData_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_RemoveCategoriesResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_RemoveCategoriesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RemoveCategoriesResponse_descriptor,
        new java.lang.String[] { "Success", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
