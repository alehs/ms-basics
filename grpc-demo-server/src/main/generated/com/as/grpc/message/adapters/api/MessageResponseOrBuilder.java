// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/proto/message-service.proto

package com.as.grpc.message.adapters.api;

public interface MessageResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.as.grpc.message.adapters.api.MessageResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string text = 1;</code>
   * @return The text.
   */
  java.lang.String getText();
  /**
   * <code>string text = 1;</code>
   * @return The bytes for text.
   */
  com.google.protobuf.ByteString
      getTextBytes();

  /**
   * <code>int64 id = 2;</code>
   * @return The id.
   */
  long getId();
}
