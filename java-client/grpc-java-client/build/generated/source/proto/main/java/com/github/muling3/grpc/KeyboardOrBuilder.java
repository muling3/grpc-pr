// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: keyboard_message.proto

package com.github.muling3.grpc;

public interface KeyboardOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Keyboard)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Keyboard.Layout layout = 1;</code>
   * @return The enum numeric value on the wire for layout.
   */
  int getLayoutValue();
  /**
   * <code>.Keyboard.Layout layout = 1;</code>
   * @return The layout.
   */
  com.github.muling3.grpc.Keyboard.Layout getLayout();

  /**
   * <code>bool backlit = 2;</code>
   * @return The backlit.
   */
  boolean getBacklit();
}