# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: message-service.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x15message-service.proto\x12 com.as.grpc.message.adapters.api\"\x1e\n\x0eMessageRequest\x12\x0c\n\x04text\x18\x01 \x01(\t\"+\n\x0fMessageResponse\x12\x0c\n\x04text\x18\x01 \x01(\t\x12\n\n\x02id\x18\x02 \x01(\x03\x32\x84\x01\n\x0eMessageService\x12r\n\x0b\x45\x63hoMessage\x12\x30.com.as.grpc.message.adapters.api.MessageRequest\x1a\x31.com.as.grpc.message.adapters.api.MessageResponseB$\n com.as.grpc.message.adapters.apiP\x01\x62\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'message_service_pb2', _globals)
if _descriptor._USE_C_DESCRIPTORS == False:
  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'\n com.as.grpc.message.adapters.apiP\001'
  _globals['_MESSAGEREQUEST']._serialized_start=59
  _globals['_MESSAGEREQUEST']._serialized_end=89
  _globals['_MESSAGERESPONSE']._serialized_start=91
  _globals['_MESSAGERESPONSE']._serialized_end=134
  _globals['_MESSAGESERVICE']._serialized_start=137
  _globals['_MESSAGESERVICE']._serialized_end=269
# @@protoc_insertion_point(module_scope)
