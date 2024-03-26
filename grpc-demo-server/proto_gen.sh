export PROTO_ROOT=/Users/Aleh_Stsiapanau/works/ext/grpc-demo-server
export PROTO_FILE=src/main/proto/message-service.proto
export PROTO_OUT_FOLDER=/Users/Aleh_Stsiapanau/works/ext/grpc-demo-server/src/main/generated
export PROTOC_PLUGIN=/Users/Aleh_Stsiapanau/works/ext/grpc-demo-server/protoc-gen-grpc-java-1.59.0-osx-aarch_64.exe

protoc --proto_path=$PROTO_ROOT --plugin=protoc-gen-grpc-java=$PROTOC_PLUGIN --grpc-java_out=$PROTO_OUT_FOLDER --java_out=$PROTO_OUT_FOLDER $PROTO_ROOT/$PROTO_FILE

