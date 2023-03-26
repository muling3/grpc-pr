// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: processor_message.proto

package com.github.muling3.grpc;

public interface CPUOrBuilder extends
    // @@protoc_insertion_point(interface_extends:CPU)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string brand = 2;</code>
   * @return The brand.
   */
  java.lang.String getBrand();
  /**
   * <code>string brand = 2;</code>
   * @return The bytes for brand.
   */
  com.google.protobuf.ByteString
      getBrandBytes();

  /**
   * <code>uint32 number_cores = 3;</code>
   * @return The numberCores.
   */
  int getNumberCores();

  /**
   * <code>uint32 number_threads = 4;</code>
   * @return The numberThreads.
   */
  int getNumberThreads();

  /**
   * <code>double min_ghz = 5;</code>
   * @return The minGhz.
   */
  double getMinGhz();

  /**
   * <code>double max_ghz = 6;</code>
   * @return The maxGhz.
   */
  double getMaxGhz();
}
