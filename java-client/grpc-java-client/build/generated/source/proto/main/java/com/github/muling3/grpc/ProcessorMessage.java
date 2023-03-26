// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: processor_message.proto

package com.github.muling3.grpc;

public final class ProcessorMessage {
  private ProcessorMessage() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CPU_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CPU_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GPU_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GPU_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027processor_message.proto\032\024memory_messag" +
      "e.proto\"r\n\003CPU\022\014\n\004name\030\001 \001(\t\022\r\n\005brand\030\002 " +
      "\001(\t\022\024\n\014number_cores\030\003 \001(\r\022\026\n\016number_thre" +
      "ads\030\004 \001(\r\022\017\n\007min_ghz\030\005 \001(\001\022\017\n\007max_ghz\030\006 " +
      "\001(\001\"]\n\003GPU\022\014\n\004name\030\001 \001(\t\022\r\n\005brand\030\002 \001(\t\022" +
      "\017\n\007min_ghz\030\003 \001(\001\022\017\n\007max_ghz\030\004 \001(\001\022\027\n\006mem" +
      "ory\030\005 \001(\0132\007.MemoryB!\n\027com.github.muling3" +
      ".grpcP\001Z\004./pbb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.github.muling3.grpc.MemoryMessage.getDescriptor(),
        });
    internal_static_CPU_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_CPU_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CPU_descriptor,
        new java.lang.String[] { "Name", "Brand", "NumberCores", "NumberThreads", "MinGhz", "MaxGhz", });
    internal_static_GPU_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_GPU_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GPU_descriptor,
        new java.lang.String[] { "Name", "Brand", "MinGhz", "MaxGhz", "Memory", });
    com.github.muling3.grpc.MemoryMessage.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}