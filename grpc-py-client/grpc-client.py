import grpc
import message_service_pb2
import message_service_pb2_grpc

def run():
    with (grpc.insecure_channel('localhost:50051') as channel):
        print("--------------")
        stub = message_service_pb2_grpc.MessageServiceStub(channel)
        response = stub.EchoMessage(message_service_pb2.MessageRequest(text='hello'))
        print("Greeter client received: " + response.text)
        response = stub.EchoMessage(message_service_pb2.MessageRequest(text='another message'))
        print("Greeter client received: " + response.text)

run();
