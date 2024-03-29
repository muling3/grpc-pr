// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: laptop.message.proto

package com.github.muling3.grpc;

public interface LaptopOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Laptop)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

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
   * <code>string name = 3;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 3;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>.CPU cpu = 4;</code>
   * @return Whether the cpu field is set.
   */
  boolean hasCpu();
  /**
   * <code>.CPU cpu = 4;</code>
   * @return The cpu.
   */
  com.github.muling3.grpc.CPU getCpu();
  /**
   * <code>.CPU cpu = 4;</code>
   */
  com.github.muling3.grpc.CPUOrBuilder getCpuOrBuilder();

  /**
   * <code>.Memory ram = 5;</code>
   * @return Whether the ram field is set.
   */
  boolean hasRam();
  /**
   * <code>.Memory ram = 5;</code>
   * @return The ram.
   */
  com.github.muling3.grpc.Memory getRam();
  /**
   * <code>.Memory ram = 5;</code>
   */
  com.github.muling3.grpc.MemoryOrBuilder getRamOrBuilder();

  /**
   * <code>repeated .GPU gpus = 6;</code>
   */
  java.util.List<com.github.muling3.grpc.GPU> 
      getGpusList();
  /**
   * <code>repeated .GPU gpus = 6;</code>
   */
  com.github.muling3.grpc.GPU getGpus(int index);
  /**
   * <code>repeated .GPU gpus = 6;</code>
   */
  int getGpusCount();
  /**
   * <code>repeated .GPU gpus = 6;</code>
   */
  java.util.List<? extends com.github.muling3.grpc.GPUOrBuilder> 
      getGpusOrBuilderList();
  /**
   * <code>repeated .GPU gpus = 6;</code>
   */
  com.github.muling3.grpc.GPUOrBuilder getGpusOrBuilder(
      int index);

  /**
   * <code>repeated .Storage storages = 7;</code>
   */
  java.util.List<com.github.muling3.grpc.Storage> 
      getStoragesList();
  /**
   * <code>repeated .Storage storages = 7;</code>
   */
  com.github.muling3.grpc.Storage getStorages(int index);
  /**
   * <code>repeated .Storage storages = 7;</code>
   */
  int getStoragesCount();
  /**
   * <code>repeated .Storage storages = 7;</code>
   */
  java.util.List<? extends com.github.muling3.grpc.StorageOrBuilder> 
      getStoragesOrBuilderList();
  /**
   * <code>repeated .Storage storages = 7;</code>
   */
  com.github.muling3.grpc.StorageOrBuilder getStoragesOrBuilder(
      int index);

  /**
   * <code>.Screen screen = 8;</code>
   * @return Whether the screen field is set.
   */
  boolean hasScreen();
  /**
   * <code>.Screen screen = 8;</code>
   * @return The screen.
   */
  com.github.muling3.grpc.Screen getScreen();
  /**
   * <code>.Screen screen = 8;</code>
   */
  com.github.muling3.grpc.ScreenOrBuilder getScreenOrBuilder();

  /**
   * <code>.Keyboard keyboard = 9;</code>
   * @return Whether the keyboard field is set.
   */
  boolean hasKeyboard();
  /**
   * <code>.Keyboard keyboard = 9;</code>
   * @return The keyboard.
   */
  com.github.muling3.grpc.Keyboard getKeyboard();
  /**
   * <code>.Keyboard keyboard = 9;</code>
   */
  com.github.muling3.grpc.KeyboardOrBuilder getKeyboardOrBuilder();

  /**
   * <code>double weight_kg = 10;</code>
   * @return The weightKg.
   */
  double getWeightKg();

  /**
   * <code>double weight_g = 11;</code>
   * @return The weightG.
   */
  double getWeightG();

  /**
   * <code>double price_usd = 12;</code>
   * @return The priceUsd.
   */
  double getPriceUsd();

  /**
   * <code>uint32 release_year = 13;</code>
   * @return The releaseYear.
   */
  int getReleaseYear();

  /**
   * <code>.google.protobuf.Timestamp updated_at = 14;</code>
   * @return Whether the updatedAt field is set.
   */
  boolean hasUpdatedAt();
  /**
   * <code>.google.protobuf.Timestamp updated_at = 14;</code>
   * @return The updatedAt.
   */
  com.google.protobuf.Timestamp getUpdatedAt();
  /**
   * <code>.google.protobuf.Timestamp updated_at = 14;</code>
   */
  com.google.protobuf.TimestampOrBuilder getUpdatedAtOrBuilder();

  public com.github.muling3.grpc.Laptop.WeightCase getWeightCase();
}
