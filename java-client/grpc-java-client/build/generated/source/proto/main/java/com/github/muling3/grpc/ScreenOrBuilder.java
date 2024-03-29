// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: screen_message.proto

package com.github.muling3.grpc;

public interface ScreenOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Screen)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>float size_inch = 1;</code>
   * @return The sizeInch.
   */
  float getSizeInch();

  /**
   * <code>.Screen.Resolution resolution = 2;</code>
   * @return Whether the resolution field is set.
   */
  boolean hasResolution();
  /**
   * <code>.Screen.Resolution resolution = 2;</code>
   * @return The resolution.
   */
  com.github.muling3.grpc.Screen.Resolution getResolution();
  /**
   * <code>.Screen.Resolution resolution = 2;</code>
   */
  com.github.muling3.grpc.Screen.ResolutionOrBuilder getResolutionOrBuilder();

  /**
   * <code>.Screen.Panel panel = 3;</code>
   * @return The enum numeric value on the wire for panel.
   */
  int getPanelValue();
  /**
   * <code>.Screen.Panel panel = 3;</code>
   * @return The panel.
   */
  com.github.muling3.grpc.Screen.Panel getPanel();

  /**
   * <code>bool multitouch = 4;</code>
   * @return The multitouch.
   */
  boolean getMultitouch();
}
