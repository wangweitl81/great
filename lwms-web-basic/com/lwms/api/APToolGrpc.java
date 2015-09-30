package com.lwms.api;

import static io.grpc.stub.ClientCalls.createMethodDescriptor;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.duplexStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.unaryFutureCall;
import static io.grpc.stub.ServerCalls.createMethodDefinition;
import static io.grpc.stub.ServerCalls.asyncUnaryRequestCall;
import static io.grpc.stub.ServerCalls.asyncStreamingRequestCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class APToolGrpc {

  private static final io.grpc.stub.Method<com.lwms.api.APListProtos.QueryList,
      com.lwms.api.APListProtos.APList> METHOD_FILTER_AP =
      io.grpc.stub.Method.create(
          io.grpc.MethodType.UNARY, "FilterAP",
          io.grpc.protobuf.ProtoUtils.marshaller(com.lwms.api.APListProtos.QueryList.PARSER),
          io.grpc.protobuf.ProtoUtils.marshaller(com.lwms.api.APListProtos.APList.PARSER));

  public static APToolStub newStub(io.grpc.Channel channel) {
    return new APToolStub(channel, CONFIG);
  }

  public static APToolBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new APToolBlockingStub(channel, CONFIG);
  }

  public static APToolFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new APToolFutureStub(channel, CONFIG);
  }

  public static final APToolServiceDescriptor CONFIG =
      new APToolServiceDescriptor();

  @javax.annotation.concurrent.Immutable
  public static class APToolServiceDescriptor extends
      io.grpc.stub.AbstractServiceDescriptor<APToolServiceDescriptor> {
    public final io.grpc.MethodDescriptor<com.lwms.api.APListProtos.QueryList,
        com.lwms.api.APListProtos.APList> filterAP;

    private APToolServiceDescriptor() {
      filterAP = createMethodDescriptor(
          "com.lwms.APTool", METHOD_FILTER_AP);
    }

    @SuppressWarnings("unchecked")
    private APToolServiceDescriptor(
        java.util.Map<java.lang.String, io.grpc.MethodDescriptor<?, ?>> methodMap) {
      filterAP = (io.grpc.MethodDescriptor<com.lwms.api.APListProtos.QueryList,
          com.lwms.api.APListProtos.APList>) methodMap.get(
          CONFIG.filterAP.getName());
    }

    @java.lang.Override
    protected APToolServiceDescriptor build(
        java.util.Map<java.lang.String, io.grpc.MethodDescriptor<?, ?>> methodMap) {
      return new APToolServiceDescriptor(methodMap);
    }

    @java.lang.Override
    public com.google.common.collect.ImmutableList<io.grpc.MethodDescriptor<?, ?>> methods() {
      return com.google.common.collect.ImmutableList.<io.grpc.MethodDescriptor<?, ?>>of(
          filterAP);
    }
  }

  public static interface APTool {

    public void filterAP(com.lwms.api.APListProtos.QueryList request,
        io.grpc.stub.StreamObserver<com.lwms.api.APListProtos.APList> responseObserver);
  }

  public static interface APToolBlockingClient {

    public com.lwms.api.APListProtos.APList filterAP(com.lwms.api.APListProtos.QueryList request);
  }

  public static interface APToolFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<com.lwms.api.APListProtos.APList> filterAP(
        com.lwms.api.APListProtos.QueryList request);
  }

  public static class APToolStub extends
      io.grpc.stub.AbstractStub<APToolStub, APToolServiceDescriptor>
      implements APTool {
    private APToolStub(io.grpc.Channel channel,
        APToolServiceDescriptor config) {
      super(channel, config);
    }

    @java.lang.Override
    protected APToolStub build(io.grpc.Channel channel,
        APToolServiceDescriptor config) {
      return new APToolStub(channel, config);
    }

    @java.lang.Override
    public void filterAP(com.lwms.api.APListProtos.QueryList request,
        io.grpc.stub.StreamObserver<com.lwms.api.APListProtos.APList> responseObserver) {
      asyncUnaryCall(
          channel.newCall(config.filterAP), request, responseObserver);
    }
  }

  public static class APToolBlockingStub extends
      io.grpc.stub.AbstractStub<APToolBlockingStub, APToolServiceDescriptor>
      implements APToolBlockingClient {
    private APToolBlockingStub(io.grpc.Channel channel,
        APToolServiceDescriptor config) {
      super(channel, config);
    }

    @java.lang.Override
    protected APToolBlockingStub build(io.grpc.Channel channel,
        APToolServiceDescriptor config) {
      return new APToolBlockingStub(channel, config);
    }

    @java.lang.Override
    public com.lwms.api.APListProtos.APList filterAP(com.lwms.api.APListProtos.QueryList request) {
      return blockingUnaryCall(
          channel.newCall(config.filterAP), request);
    }
  }

  public static class APToolFutureStub extends
      io.grpc.stub.AbstractStub<APToolFutureStub, APToolServiceDescriptor>
      implements APToolFutureClient {
    private APToolFutureStub(io.grpc.Channel channel,
        APToolServiceDescriptor config) {
      super(channel, config);
    }

    @java.lang.Override
    protected APToolFutureStub build(io.grpc.Channel channel,
        APToolServiceDescriptor config) {
      return new APToolFutureStub(channel, config);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.lwms.api.APListProtos.APList> filterAP(
        com.lwms.api.APListProtos.QueryList request) {
      return unaryFutureCall(
          channel.newCall(config.filterAP), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final APTool serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder("com.lwms.APTool")
      .addMethod(createMethodDefinition(
          METHOD_FILTER_AP,
          asyncUnaryRequestCall(
            new io.grpc.stub.ServerCalls.UnaryRequestMethod<
                com.lwms.api.APListProtos.QueryList,
                com.lwms.api.APListProtos.APList>() {
              @java.lang.Override
              public void invoke(
                  com.lwms.api.APListProtos.QueryList request,
                  io.grpc.stub.StreamObserver<com.lwms.api.APListProtos.APList> responseObserver) {
                serviceImpl.filterAP(request, responseObserver);
              }
            }))).build();
  }
}
